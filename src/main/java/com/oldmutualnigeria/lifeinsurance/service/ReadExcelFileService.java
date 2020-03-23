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



//@Component
public class ReadExcelFileService {

//    private String fileLocation;
//
//    public ReadExcelFileService(){
//
//    }
//
    public Map<Integer, List<String>> readJExcel(String fileLocation)
            throws IOException {

        Map<Integer, List<String>> data = new HashMap<>();

        FileInputStream file = new FileInputStream(new File(fileLocation));

        Workbook workbook = new XSSFWorkbook(file);

        Sheet sheet = workbook.getSheetAt(0);

        int i = 0;

        for (Row row : sheet) {

            for (Cell cell : row) {

                data.put(i, new ArrayList<String>());

                if (cell.getCellType() == CellType.FORMULA) {

                    switch (cell.getCachedFormulaResultType()) {
                        case BOOLEAN:
                            System.out.println(cell.getBooleanCellValue());
                            break;
                        case NUMERIC:
                            System.out.println(cell.getNumericCellValue());
                            break;
                        case STRING:
                            System.out.println(cell.getRichStringCellValue());
                            break;
                    }
                }
                else{
                        switch (cell.getCellType()) {
                            case STRING:
                                data.get((i)).add(cell.getRichStringCellValue().getString());
                                break;
                            case NUMERIC:
                                data.get(i).add(cell.getNumericCellValue() + "\n");
                                break;
                            case BOOLEAN:
                                data.get(i).add(cell.getBooleanCellValue() + "\n");
                                break;
                            case FORMULA:
                                data.get(i).add(cell.getCellFormula() + "\n");
                                break;
                            default:
                                data.get((i)).add(" ");
                        }

                    }
//                System.out.println();
                i++;
            }

        }
        return data;
    }

    public void printSingleCellValue(String fileLocation, String cellStringAddress) throws IOException {

        FileInputStream file = new FileInputStream(new File(fileLocation));

        Workbook workbook = new XSSFWorkbook(file);

        Sheet sheet = workbook.getSheetAt(0);

        CellAddress cellAddress = new CellAddress(cellStringAddress);

        Row row = sheet.getRow(cellAddress.getRow());

        Cell cell = row.getCell(cellAddress.getColumn());

        if (cell.getCellType() == CellType.FORMULA) {
            switch (cell.getCachedFormulaResultType()) {
                case BOOLEAN:
                    System.out.println(cell.getBooleanCellValue());
                    break;
                case NUMERIC:
                    System.out.println(cell.getNumericCellValue());
                    break;
                case STRING:
                    System.out.println(cell.getRichStringCellValue());
                    break;
            }
        }
        else{
            switch (cell.getCellType()) {
                case STRING:
                    System.out.println(cell.getRichStringCellValue().getString());
                    break;
                case NUMERIC:
                    System.out.println(cell.getNumericCellValue() + "");
                    break;
                case BOOLEAN:
                    System.out.println(cell.getBooleanCellValue() + "");
                    break;
                case FORMULA:
                    System.out.println(cell.getCellFormula() + "");
                    break;
//                default: data.get((i)).add(" ");
            }
        }
    }
}

