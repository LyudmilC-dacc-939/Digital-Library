package org.digitallibrary.service.Impl;

import lombok.extern.slf4j.Slf4j;
import org.digitallibrary.service.CsvReaderService;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class CsvReaderServiceServiceImpl implements CsvReaderService {

    @Override
    public List<String[]> readAdminDetailsFromCsv(String filePath) throws IOException {
        List<String[]> admin = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new ClassPathResource(filePath).getInputStream()))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] adminData = line.split(",");
                admin.add(adminData);
            }
        } catch (Exception e) {
            log.error("Try-catch method readAdminDetailsFromCsv in CsvReaderServiceImpl has failed to execute properly");
            e.printStackTrace();
        }
        return admin;
    }
}

