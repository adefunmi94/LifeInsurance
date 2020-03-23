package com.oldmutualnigeria.lifeinsurance.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

//@SpringBootTest
class ReadExcelFileServiceTest {

//    @Autowired
    ReadExcelFileService readExcelFileService;

    @BeforeEach
    void setUp() {

        readExcelFileService = new ReadExcelFileService();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void readDataFromExecelTest() throws IOException {

        Map<Integer, List<String>> excelData = new HashMap<>();

        excelData = readExcelFileService.readJExcel("src/main/resources/TermAssuranceModel.xlsx");


        for(int i = 0; i < excelData.size(); i++)
             System.out.print(excelData.get(i)) ;

//        readExcelFileService.printSingleCellValue("src/main/resources/TermAssuranceModel.xlsx", "C12");

    }

}