package org.chanki.dataSource;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class DataSourceFactory {

  // 한번에 알 수 있게 하려 했으나, String 등 명시적으로 유저가 고를 수 있게 함.(csv, json, url, 파일 경로 등은 String 이므로).
  public static DataSource fromJson(String filePath) throws Exception {
    return new JsonDataSource(filePath);
  }

  public static DataSource fromJson(File file) throws Exception {
    return new JsonDataSource(file);
  }

  public static DataSource fromJson(InputStream inputStream) throws Exception {
    return new JsonDataSource(inputStream);
  }

  public static DataSource fromJson(URL url) throws Exception {
    return new JsonDataSource(url);
  }
  public static DataSource fromPojo(List<?> pojoList) {
    return new PojoDataSource(pojoList);
  }
}
