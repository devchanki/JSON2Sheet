package org.chanki;

public class Main {

  public static void main(String[] args) throws Exception {
    Json2Sheet json2Sheet = new Json2Sheet();
    json2Sheet.convertHttpResponseJsonToExcelToFilePath("https://jsonplaceholder.typicode.com/comments", "test.xlsx");
  }
}
