package com.example.aiproject.ingestion;

import com.example.aiproject.model.IngestedDocument;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

import java.util.List;

@SpringBootTest
public class IngestionOrchestrationTest {

    @Autowired
    IngestionOrchestration ingestionOrchestrator;

    @Test
    void ingestAll() throws Exception{
        List<IngestedDocument> docs = ingestionOrchestrator.ingestAll();
        System.out.println("Total docs = " + docs.size());

        docs.forEach(doc -> {
            System.out.println("SOURCE = " + doc.getSource());
            System.out.println(doc.getContent());
            System.out.println("----");
        });
    }
}
