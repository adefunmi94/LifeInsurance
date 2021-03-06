package com.oldmutualnigeria.lifeinsurance.service;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellAddress;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.jupiter.api.Assertions.*;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class ReadExcelFileServiceTest {

//    @Autowired
    ReadExcelFileService readExcelFileService;

    @BeforeEach
    public void setUp() throws IOException {

        readExcelFileService = new ReadExcelFileService();
        readExcelFileService.setWorkBook("src/main/resources/TermAssuranceModel.xlsx");

    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void readSingleCellValueTest() throws IOException {

        assertThat(readExcelFileService.getWorkbook()).isNotNull();

        Object result = readExcelFileService.getSingleCellValue("C4",0);

        assertThat(result).isEqualTo(5000000.0);

        System.out.println(result);
    }

    @Test
    public void readRowCellsDataTest() throws IOException {

        assertThat(readExcelFileService.getWorkbook()).isNotNull();

        Map<CellAddress, Object> result = readExcelFileService.readRowCellValues(1, 5);

        assertThat(result).isNotNull();

        displayMap(result);


    }

    @Test
    public void readLookUpDetailsFromExcel() throws IOException {

        assertThat(readExcelFileService.getWorkbook()).isNotNull();

        Object result = readExcelFileService.getSingleCellValue("G4",1);

        assertThat(result).isEqualTo("UntestedEscalationCash BackMale20");

        System.out.println(result);
    }

    @Test
    public void readCellInMultipleRows() throws IOException {

        assertThat(readExcelFileService.getWorkbook()).isNotNull();

        Sheet sheet = readExcelFileService.getWorkbook().getSheetAt(1);

//        for(Row row : sheet){
//
//            System.out.println(row.getCell(6).getAddress());
//
//            System.out.println(row.getCell(6).getRichStringCellValue());
//        }

       Object result = readExcelFileService.findValueInRows(1,6,"UntestedEscalationCash BackMale57");

       assertThat(result.toString()).isEqualTo("41");

//       Object cellValue = readExcelFileService.getSingleCellValue(result.toString(), 1);

//       assertThat(cellValue.toString()).isEqualTo("UntestedEscalationCash BackMale57");
//
//       System.out.println(result + " "+cellValue);
    }

    @Test
    public void getCellLocation() throws IOException {

        assertThat(readExcelFileService.getWorkbook()).isNotNull();

        Object result = readExcelFileService.getCellValueByRowNum(45, 9, 1);

        assertThat((Double) result).isEqualTo(3.95);

        System.out.println(result);

//        for(Cell cell : row){
//            System.out.println(readExcelFileService.getSingleCellValue(cell.getAddress().toString(),1 ));
//        }
    }

    private void displayMap(Map<CellAddress, Object> mapData){

        Set<CellAddress> keys = mapData.keySet();

        System.out.printf("%nMap contains:%nKey\t\tValue%n");

        // generate output for each key in map
        for (CellAddress key : keys)
            System.out.printf("%-10s%10s%n", key, mapData.get(key));

    }


}