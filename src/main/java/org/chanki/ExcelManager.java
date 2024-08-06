package org.chanki;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelManager {

  public void saveWorkBook(ExcelDataForm excelDataForm, String fileName) throws IOException {
    List<Map<String, Object>> rowData = excelDataForm.getRowData();
    List<String> keyList = excelDataForm.getKeyList();


    Workbook workbook = new XSSFWorkbook();
    Sheet sheet = workbook.createSheet("data");

    // 주어진 리스트로 헤더 생성
    Row headerRow = sheet.createRow(0);
    int cellNum = 0;
    for (String header : keyList) {
      Cell cell = headerRow.createCell(cellNum++);
      cell.setCellValue(header);
    }

    int rowNum = 1;
    for (Map<String, Object> rowItem : rowData) {
      Row row = sheet.createRow(rowNum++);
      int _cellNum = 0;
      for(var key: keyList) {
        Cell cell = row.createCell(_cellNum++);
        cell.setCellValue(rowItem.get(key).toString());
      }
    }

    // 엑셀 파일로 저장
    try (
        FileOutputStream fileOut = new FileOutputStream(fileName)) {
      workbook.write(fileOut);
    } workbook.close();
  }
}
