package org.digitallibrary.service;

import java.io.IOException;
import java.util.List;

public interface CsvReader {

    List<String[]> readAdminDetailsFromCsv(String filePath) throws IOException;
}
