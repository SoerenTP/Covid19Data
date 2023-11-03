package comparators;

import covid19.CovidData;

import java.util.Comparator;

public class AgeGroupComparator implements Comparator<CovidData> {
    public int compare(CovidData covidData1, CovidData covidData2) {
        int value1, value2;
        String ageGroup1 = covidData1.getAgeGroup().replaceAll("[^0-9\\-]","");
        String ageGroup2 = covidData2.getAgeGroup().replaceAll("[^0-9\\-]","");

        if(ageGroup1.contains("-")) {
            value1 = Integer.parseInt(covidData1.getAgeGroup().split("-")[0]);
        }else value1 = Integer.parseInt(ageGroup1);

        if(ageGroup2.contains("-")) {
            value2 = Integer.parseInt(covidData2.getAgeGroup().split("-")[0]);
        }else value2 = Integer.parseInt(ageGroup2);

        return Integer.compare(value1,value2);
    }

}