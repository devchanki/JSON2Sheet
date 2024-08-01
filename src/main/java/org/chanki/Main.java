package org.chanki;

import java.io.File;

public class Main {

  public static void main(String[] args) throws Exception {
    File file = new File("./test.json");
    String jsonPath = file.getAbsolutePath();

    JsonParser jsonParser = new JsonParser().builder().path(jsonPath).build();
    Json2Sheet json2Sheet = new Json2Sheet();

    json2Sheet.convertJsonToExcel(jsonParser.getRootNode(), jsonParser.getJsonObjectKeyList(), "test.xlsx");

  }
}
