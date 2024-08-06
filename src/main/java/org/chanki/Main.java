package org.chanki;

import java.net.URL;

public class Main {

  public static void main(String[] args) throws Exception {
    Json2Sheet json2Sheet = Json2Sheet.fromJSON(new URL("https://jsonplaceholder.typicode.com/comments"));
    json2Sheet.saveExcel("hello.xlsx");

    Json2Sheet json2Sheet1 = Json2Sheet.fromJSON("./test.json");
    json2Sheet1.saveExcel("hello1.xlsx");
  }
}
