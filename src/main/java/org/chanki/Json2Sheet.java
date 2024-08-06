package org.chanki;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import lombok.NoArgsConstructor;
import org.chanki.dataSource.DataSource;
import org.chanki.dataSource.DataSourceFactory;

@NoArgsConstructor
public class Json2Sheet {

  private DataSource dataSource;

  private Json2Sheet(DataSource dataSource) {
    this.dataSource = dataSource;
  }

  public static Json2Sheet fromJSON(String filePath) throws Exception {
    DataSource dataSource = DataSourceFactory.fromJson(filePath);
    return new Json2Sheet(dataSource);
  }

  public static Json2Sheet fromJSON(File file) throws Exception {
    DataSource dataSource = DataSourceFactory.fromJson(file);
    return new Json2Sheet(dataSource);
  }

  public static Json2Sheet fromJSON(InputStream inputStream) throws Exception {
    DataSource dataSource = DataSourceFactory.fromJson(inputStream);
    return new Json2Sheet(dataSource);
  }

  public static Json2Sheet fromJSON(URL url) throws Exception {
    DataSource dataSource = DataSourceFactory.fromJson(url);
    return new Json2Sheet(dataSource);
  }
  public static Json2Sheet fromPOJO(List<?> pojoList) throws Exception {
    DataSource dataSource = DataSourceFactory.fromPojo(pojoList);
    return new Json2Sheet(dataSource);
  }

  public void saveExcel(String filePath) throws Exception {
    ExcelManager excelManager = new ExcelManager();
    ExcelDataForm data = this.dataSource.parseToList();
    excelManager.saveWorkBook(data, filePath != null ? filePath : "default.xlsx");
  }



}
