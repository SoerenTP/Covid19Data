import comparators.*;
import covid19.CovidData;
import covid19.DataReader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DataReader dataReader = new DataReader();
        ArrayList<CovidData> dataList = dataReader.read();

        try (Scanner scanner = new Scanner(System.in)) {
            int choice = 0;
            while (choice != 8) {
                System.out.println("""
                        1. * Sort by Region
                        2. * Sort by Age Group
                        3. * Sort by Confirmed Cases
                        4. * Sort by Deaths
                        5. * Sort by Intensive Care Cases
                        6. * Sort by Hospitalised
                        7. * Sort by Region & Confirmed Cases
                        8. * Close Program""");
                choice = scanner.nextInt();
                switch (choice) {
                    case 1 -> Collections.sort(dataList, new RegionComparator());
                    case 2 -> Collections.sort(dataList, new AgeGroupComparator());
                    case 3 -> Collections.sort(dataList, new ConfirmedCasesComparator().reversed());
                    case 4 -> Collections.sort(dataList, new DeathsComparator().reversed());
                    case 5 -> Collections.sort(dataList, new IntensiveCarePatientsComparator().reversed());
                    case 6 -> Collections.sort(dataList, new HospitalisedComparator().reversed());
                    case 7 -> Collections.sort(dataList, new RegionComparator().
                            thenComparing(new ConfirmedCasesComparator().reversed()));
                }
                print(dataList);
            }

        }
    }

    public static void spacing() {
        System.out.printf("*%12s*%9s*%15s*%6s*%14s*%12s*\n",
                "-".repeat(12), "-".repeat(9), "-".repeat(15), "-".repeat(6),
                "-".repeat(14), "-".repeat(12));
    }

    public static void print(ArrayList<CovidData> datalist) {
        spacing();
        System.out.printf("""
                        |%12s|%9s|%15s|%6s|%14s|%12s|
                        """, "---Region---", "Age Group", "Confirmed Cases", "Deaths",
                "Intensive Care", "Hospitalised");
        spacing();

        for (CovidData data : datalist) {
            System.out.printf("""
                            |%12s|%9s|%15s|%6s|%14s|%12s|
                            """, data.getRegion(), data.getAgeGroup(), data.getConfirmedCases(), data.getDeaths(),
                    data.getIntensiveCarePatients(), data.getHospitalised());

        }
        spacing();
    }
}