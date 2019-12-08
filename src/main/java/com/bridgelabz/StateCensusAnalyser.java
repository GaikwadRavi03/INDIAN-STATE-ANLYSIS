package com.bridgelabz;

import com.google.gson.Gson;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.List;

public class StateCensusAnalyser<T extends Comparable<T>> {
    public static <T> List<CSVStateCensus> findStateCount(String filePath) throws StateCensusAnalyserException {
        List<CSVStateCensus> list = null;
        int count = 0;
        try {
            Reader reader = Files.newBufferedReader(Paths.get(filePath));
            CsvToBean<CSVStateCensus> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(CSVStateCensus.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .withSeparator(',')
                    .build();
            list = csvToBean.parse();
        } catch (NoSuchFileException e) {
            throw new StateCensusAnalyserException("Please Enter Valid File");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (RuntimeException e) {
            throw new StateCensusAnalyserException("Please Enter Valid File path", StateCensusAnalyserException.ExceptionType.NO_SUCH_FILE);
        }
        return list;
    }

    public static <T> List<CSVStateCensus> bubbleSort( String methodName,String filepath) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, IOException, StateCensusAnalyserException {
        List<CSVStateCensus> csvCensusList = findStateCount(filepath);
        for (int i = 0; i < csvCensusList.size() - 1; i++) {
            for (int j = 0; j < csvCensusList.size() - i - 1; j++) {
                Class class1 = csvCensusList.get(j).getClass();
                Method methodCall = class1.getDeclaredMethod(methodName);
                T value1 = (T) methodCall.invoke(csvCensusList.get(j));
                Class class2 = csvCensusList.get(j + 1).getClass();
                Method methodCall1 = class2.getDeclaredMethod(methodName);
                T value2 = (T) methodCall1.invoke(csvCensusList.get(j + 1));
                if (value1.toString().compareTo(value2.toString()) > 0) {
                    CSVStateCensus tempObj = csvCensusList.get(j);
                    csvCensusList.set(j, csvCensusList.get(j + 1));
                    csvCensusList.set(j + 1, tempObj);
                }
            }
        }
        writeInGson(csvCensusList);
        return csvCensusList;
    }

    private static void writeInGson(List<CSVStateCensus> csvCensusList) throws IOException {
        Gson gson = new Gson();
        String json = gson.toJson(csvCensusList);
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("/home/admin141/IdeaProjects/IndianStateAnalysis-2/src/main/resources/Sample.json");
            fileWriter.write(json);
        } finally {
            fileWriter.close();
        }
    }
}
