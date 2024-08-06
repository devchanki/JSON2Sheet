package org.chanki.dataSource;

import org.chanki.ExcelDataForm;

public interface DataSource {

  ExcelDataForm parseToList() throws Exception;

}
