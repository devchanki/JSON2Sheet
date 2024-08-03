package org.chanki;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import lombok.Builder;


public class JsonParser {
  JsonNode rootNode;
  File file;
  String path;
  InputStream inputStream;
  String url;

  @Builder
  public JsonParser JsonParser(File file, String path, InputStream inputStream, String url) {
    this.file = file;
    this.path = path;
    this.inputStream = inputStream;
    this.url = url;

    return this;
  }

  public JsonParser initialize() throws Exception{
    if(this.rootNode == null) {
      ObjectMapper objectMapper = new ObjectMapper();
      if(this.file != null) {
        this.rootNode = objectMapper.readTree(this.file);
      } else if (this.path != null) {
        File jsonFile = new File(this.path);
        this.rootNode = objectMapper.readTree(jsonFile);
      } else if (this.inputStream != null) {
        this.rootNode = objectMapper.readTree(this.inputStream);
      } else if (this.url != null) {
        try(InputStream is = new URL(url).openStream()) {
          this.rootNode = objectMapper.readTree(is);
        }
      }
    } else {
      throw new IOException("Cannot Found Json Info");
    }

    return this;
  }

  public JsonNode getRootNode() {
    return this.rootNode;
  }

  public ArrayList<String> getJsonObjectKeyList() {
    if(rootNode == null) throw new Error("No Json Data Set");

    Set<String> keyList = new LinkedHashSet<String>();
    collectKeyList(this.rootNode, keyList);
    return new ArrayList<>(keyList);
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
