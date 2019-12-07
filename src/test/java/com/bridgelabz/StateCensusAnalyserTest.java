package com.bridgelabz;

import org.junit.Assert;
import org.junit.Test;

public class StateCensusAnalyserTest {
    private static final String CSV_STATE_CENSUS_DATA_PATH = "/home/admin141/IdeaProjects/IndianStateAnalysis-2/src/main/resources/StateCensusData.csv";

    @Test
    public void givenTheStatesCSV_fileCheckToEnsure_TheNumberOfRecord_matches() {

        try {
            boolean result = StateCensusAnalyser.findStateCount(29,CSV_STATE_CENSUS_DATA_PATH);
            Assert.assertTrue(result);
        } catch (StateCensusAnalyserException e) {
        }
    }
}
