package org.digitallibrary.service;

import java.io.IOException;
import java.util.List;

public interface CsvReaderService {

    List<String[]> readAdminDetailsFromCsv(String filePath) throws IOException;
}
