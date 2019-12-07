package com.bridgelabz;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.Iterator;

public class StateCensusAnalyser {
    public static int findStateCount(String filePath) throws StateCensusAnalyserException {
        int count = 0;
        try {
            Reader reader = Files.newBufferedReader(Paths.get(filePath));
            CsvToBean<CSVStateCensus> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(CSVStateCensus.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            Iterator<CSVStateCensus> csvStateIterator = csvToBean.iterator();

            while (csvStateIterator.hasNext()) {
                CSVStateCensus csvState = csvStateIterator.next();
                System.out.println("State : " + csvState.getState());
                System.out.println("Population : " + csvState.getPopulation());
                System.out.println("AreaInSqKm : " + csvState.getAreaInSqKm());
                System.out.println("DensityPerSqKm : " + csvState.getDensityPerSqKm());
                System.out.println("==========================");
                count++;
            }
        } catch (NoSuchFileException e) {
            throw new StateCensusAnalyserException("Please Enter Valid File");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (RuntimeException e) {
            throw new StateCensusAnalyserException("Please Enter Valid File path", StateCensusAnalyserException.ExceptionType.NO_SUCH_FILE);
        }
        return count;
    }
}
