package com.example.aiproject.ingestion.database;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

@SpringBootTest
public class DatabaseIngestionServiceTest {

    @Autowired
    DatabaseIngestionService databaseIngestionService;

    @Test
    public void testDatabaseIngestionService() {
        databaseIngestionService.ingestFaqs();
        databaseIngestionService.ingestReleaseNotes();
        databaseIngestionService.ingestAnnouncements();
    }
}
