package org.chanki.dataSource;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.chanki.ExcelDataForm;

public class PojoDataSource implements DataSource {
  private final List<?> data;

  public PojoDataSource(List<?> data) {
    this.data = data;
  }

  @Override
  public ExcelDataForm parseToList() {
    List<Map<String, Object>> result = new ArrayList<>();
    List<String> keyList;

    Object firstObject = data.get(0);
    if(firstObject == null) throw new Error("Pojo list doesn't have any values");
    Field[] fieldNameList = firstObject.getClass().getDeclaredFields();
    keyList = Arrays.stream(fieldNameList).map(Field::getName).toList();

    for (Object item : data) {
      Map<String, Object> map = new HashMap<>();
      Field[] fields = item.getClass().getDeclaredFields();

      for (Field field : fields) {
        field.setAccessible(true);
        try {
          map.put(field.getName(), field.get(item).toString());
        } catch (IllegalAccessException e) {
          e.printStackTrace();
        }
      }

      result.add(map);
    }

    return ExcelDataForm.builder().rowData(result).keyList(keyList).build();
  }
}
