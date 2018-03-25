package Tools;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;

import Model.TestCase;

import java.util.*;

public final class ExcelReader {

    private static XSSFWorkbook file2wb(File file) {
        XSSFWorkbook wb = null;
        try {
            wb = new XSSFWorkbook(OPCPackage.openOrCreate(file));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }
        return wb;
    }

    public static List<TestCase> getTextCaseByFile(File file) {
        XSSFWorkbook wb = file2wb(file);
        List<TestCase> testCases = new ArrayList<TestCase>();
        for (int i = 0; i < wb.getNumberOfSheets(); i++) {
            XSSFSheet sheet = (XSSFSheet) wb.getSheetAt(i);
            if (sheet == null)
                return testCases;
            int beginRowNum = -1;
            for (int rowNum = sheet.getFirstRowNum(); rowNum < sheet.getLastRowNum(); rowNum++) {
                XSSFCell cell = sheet.getRow(rowNum).getCell(0);
                if (cell != null) {
                    cell.setCellType(Cell.CELL_TYPE_STRING);
                    if ("测试工程".equals(cell.getStringCellValue())) {
                        beginRowNum = rowNum;
                        break;
                    }
                }

            }
            if (beginRowNum == -1)
                continue;
            for (int rowNum = beginRowNum + 1; rowNum < sheet.getLastRowNum(); rowNum++) {
                XSSFRow row = sheet.getRow(rowNum);
                if (row == null)
                    continue;
                TestCase testCase = new TestCase();
                XSSFCell cell = row.getCell(0);
                if (cell == null || cell.getRawValue() == null)
                    continue;
                if (cell != null) {
                    cell.setCellType(Cell.CELL_TYPE_STRING);
                    testCase.testEngineering = cell.getStringCellValue();
                }
                if ((cell = row.getCell(1)) != null) {
                    cell.setCellType(Cell.CELL_TYPE_STRING);
                    testCase.reqId = cell.getStringCellValue();
                }
                if ((cell = row.getCell(2)) != null) {
                    cell.setCellType(Cell.CELL_TYPE_STRING);
                    testCase.testCaseId = cell.getStringCellValue();
                }
                if ((cell = row.getCell(3)) != null) {
                    cell.setCellType(Cell.CELL_TYPE_STRING);
                    testCase.reqReference = cell.getStringCellValue();
                }
                if ((cell = row.getCell(4)) != null) {
                    cell.setCellType(Cell.CELL_TYPE_STRING);
                    testCase.specialCondition = cell.getStringCellValue();
                }

                if ((cell = row.getCell(5)) != null) {
                    cell.setCellType(Cell.CELL_TYPE_STRING);
                    testCase.testGoal = cell.getStringCellValue();
                }

                if ((cell = row.getCell(6)) != null) {
                    cell.setCellType(Cell.CELL_TYPE_STRING);
                    testCase.stepDes = cell.getStringCellValue();
                }

                if ((cell = row.getCell(7)) != null) {
                    cell.setCellType(Cell.CELL_TYPE_STRING);
                    testCase.caseDes = cell.getStringCellValue();
                }

                if ((cell = row.getCell(8)) != null) {
                    cell.setCellType(Cell.CELL_TYPE_STRING);
                    testCase.checkPoint = cell.getStringCellValue();
                }

                if ((cell = row.getCell(9)) != null) {
                    cell.setCellType(Cell.CELL_TYPE_STRING);
                    testCase.Priority = cell.getStringCellValue();
                }

                if ((cell = row.getCell(10)) != null) {
                    cell.setCellType(Cell.CELL_TYPE_STRING);
                    testCase.caseNature = cell.getStringCellValue();
                }

                if ((cell = row.getCell(11)) != null) {
                    cell.setCellType(Cell.CELL_TYPE_STRING);
                    testCase.caseState = cell.getStringCellValue();
                }

                if ((cell = row.getCell(12)) != null) {
                    cell.setCellType(Cell.CELL_TYPE_STRING);
                    testCase.aurthor = cell.getStringCellValue();
                }

                if ((cell = row.getCell(13)) != null) {
                    cell.setCellType(Cell.CELL_TYPE_STRING);
                    testCase.remark = cell.getStringCellValue();
                }

                if ((cell = row.getCell(14)) != null) {
                    cell.setCellType(Cell.CELL_TYPE_STRING);
                    testCase.QCId = cell.getStringCellValue();
                }
                testCases.add(testCase);
            }
        }
        return testCases;
    }

    public static Map<String, List<TestCase>> getTestCaseByFolder(String path) {
        //String path="E:/bank/测试案例库数据/01测试案例";
        Map ret = new HashMap();
        try {
            File folder = new File(path);
            for (File file : folder.listFiles()) {
                List<TestCase> pitem = getTextCaseByFile(file);
                for(TestCase item:pitem){
                    if(item.toString().contains("凭证种类") && item.toString().contains("36") && item.toString().contains("个人通知")){
                        System.out.println("FILE : ");
                        System.out.println(file.getName());
                        System.out.println(item.toString());
                    }
                }
                ret.put(file.getName(), pitem);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }
}

