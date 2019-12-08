package com.bridgelabz;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class StateCensusAnalyserTest {
    private static final String CSV_STATE_CENSUS_DATA_PATH = "/home/admin141/IdeaProjects/IndianStateAnalysis-2/src/main/resources/StateCensusData.csv";

    @Test
    public void givenTheStatesCSV_fileCheckToEnsure_TheNumberOfRecord_matches() {
        try {
            List<CSVStateCensus> result = StateCensusAnalyser.findStateCount(CSV_STATE_CENSUS_DATA_PATH);
            Assert.assertEquals(29, result.size());
        } catch (StateCensusAnalyserException e) {
        }
    }

    @Test
    public void givenState_CSVFileIfIncorrect_Returns_CustomException() {
        try {
            List<CSVStateCensus> result = StateCensusAnalyser.findStateCount(CSV_STATE_CENSUS_DATA_PATH);
        } catch (StateCensusAnalyserException e) {
            Assert.assertEquals("Please Enter Valid File", e.getMessage());
        }
    }

    @Test
    public void GivenTheState_CSVFileWhenCorrect_ButTypeIncorrect_ReturnsCustomException() {
        try {
            List<CSVStateCensus> result = StateCensusAnalyser.findStateCount(CSV_STATE_CENSUS_DATA_PATH);
        } catch (StateCensusAnalyserException e) {
            Assert.assertEquals(StateCensusAnalyserException.ExceptionType.NO_SUCH_FILE, e.type);
        }
    }

    @Test
    public void GivenTheStateCSVFile_WhenCorrectBut_DelimiterIncorrect_ReturnsCustomException() {
        try {
            List<CSVStateCensus> result = StateCensusAnalyser.findStateCount(CSV_STATE_CENSUS_DATA_PATH);
            Assert.assertEquals(29, result.size());
        } catch (StateCensusAnalyserException e) {
        }
    }

    @Test
    public void GivenTheStateCSVFile_WhenCorrectButCsvHeader_IncorrectReturns_CustomException() {
        try {
            List<CSVStateCensus> result = StateCensusAnalyser.findStateCount(CSV_STATE_CENSUS_DATA_PATH);
            Assert.assertEquals(29, result.size());
        } catch (StateCensusAnalyserException e) {
        }
    }

    @Test
    public void GivenStateCSV_FileForSortStateAlphabetical_ShouldReturnLowestAlphabetState() {
        try {
            List<CSVStateCensus> result = StateCensusAnalyser.bubbleSort("getState", CSV_STATE_CENSUS_DATA_PATH);
            Assert.assertEquals("Andhra Pradesh", result.get(0).getState());
        } catch (StateCensusAnalyserException | IOException | NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
        }
    }

    @Test
    public void GivenStateCSV_FileForSortStateAlphabetical_ShouldReturnHighestAlphabetState() {
        try {
            List<CSVStateCensus> result = StateCensusAnalyser.bubbleSort("getState", CSV_STATE_CENSUS_DATA_PATH);
            Assert.assertEquals("West Bengal", result.get(result.size() - 1).getState());
        } catch (StateCensusAnalyserException | IOException | NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
        }
    }

    @Test
    public void GivenStateCSV_FileForSortPopulation_ShouldReturnLowestPopulatedState() {
        try {
            List<CSVStateCensus> result = StateCensusAnalyser.bubbleSort("getPopulation", CSV_STATE_CENSUS_DATA_PATH);
            Assert.assertEquals("Uttarakhand", result.get(0).getState());
        } catch (StateCensusAnalyserException | IOException | NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
        }
    }

    @Test
    public void GivenStateCSV_FileForSortPopulation_ShouldReturnHighestPopulatedState() {
        try {
            List<CSVStateCensus> result = StateCensusAnalyser.bubbleSort("getPopulation", CSV_STATE_CENSUS_DATA_PATH);
            Assert.assertEquals("West Bengal", result.get(result.size() - 1).getState());
        } catch (StateCensusAnalyserException | IOException | NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
        }
    }

    //-----------------refactor
    @Test
    public void GivenStateCSV_FileFor_RefactorSortStateAlphabetical_ShouldReturnLowestAlphabetState() {
        try {
            List<CSVStateCensus> result = StateCensusAnalyser.bubbleSort("getState", CSV_STATE_CENSUS_DATA_PATH);
            Assert.assertEquals("Andhra Pradesh", result.get(0).getState());
        } catch (StateCensusAnalyserException | IOException | NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
        }
    }

    @Test
    public void GivenStateCSV_FileFor_RefactorSortStateAlphabetical_ShouldReturnHighestAlphabetState() {
        try {
            List<CSVStateCensus> result = StateCensusAnalyser.bubbleSort("getState", CSV_STATE_CENSUS_DATA_PATH);
            Assert.assertEquals("West Bengal", result.get(result.size() - 1).getState());
        } catch (StateCensusAnalyserException | IOException | NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
        }
    }

    @Test
    public void GivenStateCSV_FileFor_RefactorSortPopulation_ShouldReturnLowestPopulatedState() {
        try {
            List<CSVStateCensus> result = StateCensusAnalyser.bubbleSort("getPopulation", CSV_STATE_CENSUS_DATA_PATH);
            Assert.assertEquals("Uttarakhand", result.get(0).getState());
        } catch (StateCensusAnalyserException | IOException | NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
        }
    }

    @Test
    public void GivenStateCSV_FileFor_RefactorSortPopulation_ShouldReturnHighestPopulatedState() {
        try {
            List<CSVStateCensus> result = StateCensusAnalyser.bubbleSort("getPopulation", CSV_STATE_CENSUS_DATA_PATH);
            Assert.assertEquals("West Bengal", result.get(result.size() - 1).getState());
        } catch (StateCensusAnalyserException | IOException | NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
        }
    }

    //----------density
    @Test
    public void GivenStateCSV_FileFor_RefactorSortDensity_ShouldReturnLowestState() {
        try {
            List<CSVStateCensus> result = StateCensusAnalyser.bubbleSort("getDensityPerSqKm", CSV_STATE_CENSUS_DATA_PATH);
            Assert.assertEquals("Arunachal Pradesh", result.get(0).getState());
        } catch (StateCensusAnalyserException | IOException | NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
        }
    }

    @Test
    public void GivenStateCSV_FileFor_RefactorSortDensity_ShouldReturnHighestState() {
        try {
            List<CSVStateCensus> result = StateCensusAnalyser.bubbleSort("getDensityPerSqKm", CSV_STATE_CENSUS_DATA_PATH);
            Assert.assertEquals("Sikkim", result.get(result.size() - 1).getState());
        } catch (StateCensusAnalyserException | IOException | NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
        }
    }
}
