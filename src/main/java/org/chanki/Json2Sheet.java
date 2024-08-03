package org.chanki;

import com.fasterxml.jackson.databind.JsonNode;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Json2Sheet {

  public OutputStream convertJsonToExcelWithKeyListReturnStream(File file, List<String> keyList) throws Exception {
    JsonParser jsonParser = new JsonParser().builder().file(file).build().initialize();

    JsonNode jsonNode = jsonParser.getRootNode();

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
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    workbook.write(outputStream);
    return outputStream;
  }

  public void convertJsonToExcelWithKeyToSaveFile(File file, String filePath, List<String> keyList) throws Exception {
    JsonParser jsonParser = new JsonParser().builder().file(file).build().initialize();

    JsonNode jsonNode = jsonParser.getRootNode();

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
        FileOutputStream fileOut = new FileOutputStream(filePath)) {
      workbook.write(fileOut);
    } workbook.close();
  }

  // Header 가 될 키를 전체 Json 순회 후 Key를 계산 후 Excel 헤더 만듬.
  public void convertJsonToExcelToFilePath(File file, String filePath) throws Exception{
    JsonParser jsonParser = new JsonParser().builder().file(file).build().initialize();

    JsonNode jsonNode = jsonParser.getRootNode();
    List<String> keyList = jsonParser.getJsonObjectKeyList();

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
        FileOutputStream fileOut = new FileOutputStream(filePath)) {
      workbook.write(fileOut);
    } workbook.close();
  }

  public void convertJsonToExcelToFilePath(String jsonPath, String filePath) throws Exception{
    JsonParser jsonParser = new JsonParser().builder().path(jsonPath).build().initialize();

    JsonNode jsonNode = jsonParser.getRootNode();
    List<String> keyList = jsonParser.getJsonObjectKeyList();

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
        FileOutputStream fileOut = new FileOutputStream(filePath)) {
      workbook.write(fileOut);
    } workbook.close();
  }

  public void convertJsonToExcelToFilePath(InputStream stream, String filePath) throws Exception{
    JsonParser jsonParser = new JsonParser().builder().inputStream(stream).build().initialize();
    JsonNode jsonNode = jsonParser.getRootNode();
    List<String> keyList = jsonParser.getJsonObjectKeyList();

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
        FileOutputStream fileOut = new FileOutputStream(filePath)) {
      workbook.write(fileOut);
    } workbook.close();
  }

  public void convertHttpResponseJsonToExcelToFilePath(String url, String filePath) throws Exception{
    JsonParser jsonParser = new JsonParser().builder().url(url).build().initialize();
    JsonNode jsonNode = jsonParser.getRootNode();
    List<String> keyList = jsonParser.getJsonObjectKeyList();

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
        FileOutputStream fileOut = new FileOutputStream(filePath)) {
      workbook.write(fileOut);
    } workbook.close();
  }

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

  public void convertJsonFileToExcel(JsonNode jsonNode, List<String> keyList, String fileName)
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
