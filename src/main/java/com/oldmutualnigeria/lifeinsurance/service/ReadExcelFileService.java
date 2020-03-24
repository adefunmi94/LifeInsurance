package com.oldmutualnigeria.lifeinsurance.service;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



@Component
public class ReadExcelFileService {

    private Workbook workbook;

    public void setWorkBook(String fileLocation) throws IOException {

        FileInputStream file = new FileInputStream(new File(fileLocation));

        this.workbook = new XSSFWorkbook(file);
    }

    public Workbook getWorkbook(){

        return this.workbook;
    }


    public Object getSingleCellValue(String cellIndex, int sheetIndex) throws IOException {

        //cell value
        Object cellValue = null;

        Sheet sheet = workbook.getSheetAt(sheetIndex);

        CellAddress cellAddress = new CellAddress(cellIndex);

        Row row = sheet.getRow(cellAddress.getRow());

        Cell cell = row.getCell(cellAddress.getColumn());

        if (cell.getCellType() == CellType.FORMULA) {

            switch (cell.getCachedFormulaResultType()) {

                case BOOLEAN:
                    cellValue = cell.getBooleanCellValue();
                    break;
                case NUMERIC:
                    cellValue = cell.getNumericCellValue();
                    break;
                case STRING:
                    cellValue = cell.getRichStringCellValue();
                    break;
            }
        }
        else{
            switch (cell.getCellType()) {
                case STRING:
                    cellValue = cell.getRichStringCellValue().getString();
                    break;
                case NUMERIC:
                    cellValue = cell.getNumericCellValue();
                    break;
                case BOOLEAN:
                    cellValue = cell.getBooleanCellValue();
                    break;

            }
        }

        return  cellValue;
    }

    public Map<CellAddress, Object> readRowCellValues(int sheetIndex, int rowIdex){

        Sheet sheet = getWorkbook().getSheetAt(sheetIndex);

        Map<CellAddress, Object> data = new HashMap<>();

        Row row = sheet.getRow(rowIdex);

            for (Cell cell : row){

                switch (cell.getCellType()) {

                    case STRING:

                        data.put(cell.getAddress(), cell.getStringCellValue());
                        break;
                    case NUMERIC:

                        data.put(cell.getAddress(), cell.getNumericCellValue());
                        break;
                    case BOOLEAN:

                        data.put(cell.getAddress(), cell.getBooleanCellValue());
                        break;
                    case FORMULA:
                        switch (cell.getCachedFormulaResultType()) {
                            case BOOLEAN:

                                data.put(cell.getAddress(), cell.getBooleanCellValue());
                                break;
                            case NUMERIC:

                                data.put(cell.getAddress(), cell.getNumericCellValue());
                                break;
                            case STRING:

                                data.put(cell.getAddress(), cell.getStringCellValue());
                                break;
                        }
                    default:
                }


            }
//        System.out.println(row.getCell(cellAddress.getColumn()));
        return data;
    }
}
