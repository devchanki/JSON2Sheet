package org.chanki;

import java.util.List;
import java.util.Map;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ExcelDataForm {

  List<Map<String, Object>> rowData;
  List<String> keyList;
}
