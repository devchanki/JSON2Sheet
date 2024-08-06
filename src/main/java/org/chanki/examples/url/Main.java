package org.chanki.examples.url;

import java.net.URL;
import org.chanki.Json2Sheet;

public class Main {
  public static void main(String[] args) throws Exception {
    Json2Sheet json2Sheet = Json2Sheet.fromJSON(new URL("https://jsonplaceholder.typicode.com/comments"));
    json2Sheet.saveExcel("listByUrl.xlsx");
  }
}
