package com.example.aiproject.retrieval;

import com.example.aiproject.chunking.model.Chunk;
import com.example.aiproject.retrieval.model.RetrievalResult;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RetrievalServiceTest {
    private static final Logger log = LoggerFactory.getLogger(RetrievalServiceTest.class);

    @Autowired
    private RetrievalService retrievalService;

    @Test
    void retrieve_test() {
        RetrievalResult result = retrievalService.retrieve("What is the leave carry forward policy?");

        log.info("Retrieval result - chunks found: {}" , result.getChunks().size());
        for(Chunk chunk : result.getChunks()) {
            log.info("Metadata    : {}", chunk.getMetadata());
            log.info("Content     : {}", chunk.getContent());
        }
    }
}
