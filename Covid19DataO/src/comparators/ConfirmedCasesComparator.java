package comparators;

import covid19.CovidData;

import java.util.Comparator;

public class ConfirmedCasesComparator implements Comparator<CovidData> {
    @Override
    public int compare(CovidData covidData1, CovidData covidData2) {
        return Integer.compare(covidData1.getConfirmedCases(), covidData2.getConfirmedCases());
    }
}
