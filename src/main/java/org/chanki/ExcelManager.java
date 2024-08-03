package org.chanki;

import com.fasterxml.jackson.databind.JsonNode;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelManager {

  public void convertJsonToExcel(JsonNode jsonNode, List<String> keyList, String fileName)
      throws IOException {
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

    for (JsonNode node : jsonNode) {
      Row row = sheet.createRow(rowNum++);
      int _cellNum = 0;
      for(String key: keyList) {
        Cell cell = row.createCell(_cellNum++);
        cell.setCellValue(String.valueOf(node.get(key)));
      }
    }

    // 엑셀 파일로 저장
    try (
        FileOutputStream fileOut = new FileOutputStream(fileName)) {
      workbook.write(fileOut);
    } workbook.close();
  }
}
