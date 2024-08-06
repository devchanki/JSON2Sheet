package org.chanki.dataSource;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Map;
import org.chanki.ExcelDataForm;
import org.chanki.JsonParser;

public class JsonDataSource implements DataSource {

  private final JsonNode  jsonNode;

  public JsonDataSource(String filePath) throws Exception {
    try (InputStream inputStream = new FileInputStream(filePath)) {
      this.jsonNode = getJsonNode(inputStream);
    }
  }

  public JsonDataSource(File file) throws Exception {
    try (InputStream inputStream = new FileInputStream(file)) {
      this.jsonNode = getJsonNode(inputStream);
    }
  }

  public JsonDataSource(URL url) throws Exception {
    this.jsonNode = getJsonNode(url.openStream());
  }

  public JsonDataSource(InputStream inputStream) throws Exception {
    this.jsonNode = getJsonNode(inputStream);
  }

  public JsonNode getJsonNode() {
    return this.jsonNode;
  }

  private JsonNode getJsonNode(InputStream inputStream) throws Exception {
    ObjectMapper objectMapper = new ObjectMapper();
    return objectMapper.readTree(inputStream);
  }


  @Override
  public ExcelDataForm parseToList() throws Exception {
    JsonParser jsonParser = new JsonParser(this.jsonNode);
    List<String> keyList = jsonParser.getJsonObjectKeyList();
    List<Map<String, Object>> jsonList = jsonParser.getJsonListMap();

    return ExcelDataForm.builder().keyList(keyList).rowData(jsonList).build();
  }
}
