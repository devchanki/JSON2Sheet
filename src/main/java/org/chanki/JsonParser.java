package org.chanki;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.chanki.dataSource.JsonDataSource;

public class JsonParser {

  JsonNode jsonNode;

  public JsonParser(JsonNode jsonNode) {
    this.jsonNode = jsonNode;
  }

  public JsonParser(String path) throws Exception {
    this.jsonNode = new JsonDataSource(path).getJsonNode();
  }

  public JsonParser(URL url) throws Exception {
    this.jsonNode = new JsonDataSource(url).getJsonNode();
  }

  public ArrayList<String> getJsonObjectKeyList() {
    if (this.jsonNode == null) {
      throw new Error("No Json Data Set");
    }

    Set<String> keyList = new LinkedHashSet<>();
    collectKeyList(this.jsonNode, keyList);
    return new ArrayList<>(keyList);
  }

  public List<Map<String, Object>> getJsonListMap() throws Exception {
    return new ObjectMapper().readValue(this.jsonNode.traverse(),
        new TypeReference<>() {
        });
  }

  private void collectKeyList(JsonNode node, Set<String> keyList) {
    if (node.isObject()) {
      node.fieldNames().forEachRemaining(keyList::add);
    }
    if (node.isArray()) {
      for (JsonNode subNode : node) {
        collectKeyList(subNode, keyList);
      }
    }
  }
}
