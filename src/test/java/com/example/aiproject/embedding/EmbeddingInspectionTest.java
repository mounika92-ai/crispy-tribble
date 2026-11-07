package com.example.aiproject.embedding;

import com.example.aiproject.chunking.ChunkingOrchestrator;
import com.example.aiproject.chunking.model.Chunk;
import com.example.aiproject.embedding.model.EmbeddedChunk;
import com.example.aiproject.ingestion.IngestionOrchestration;
import com.example.aiproject.model.IngestedDocument;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
@SpringBootTest
public class EmbeddingInspectionTest {
    private static final Logger log = LoggerFactory.getLogger(EmbeddingInspectionTest.class);

    @Autowired
    private IngestionOrchestration ingestionOrchestrator;

    @Autowired
    private ChunkingOrchestrator chunkingOrchestrator;

    @Autowired
    private ChunkEmbeddingService chunkEmbeddingService;

    @Test
    void testEmbedding() throws Exception {
        List<IngestedDocument> documents = ingestionOrchestrator.ingestAll();
        IngestedDocument document = documents.get(0);

        List<Chunk> chunks = chunkingOrchestrator.chunk(document);
        for (Chunk chunk : chunks) {
            EmbeddedChunk embedded = chunkEmbeddingService.embed(chunk);

            log.info("Metadata    : {}", chunk.getMetadata());
            log.info("Content     : {}", chunk.getContent());
            log.info("Embedding length : {}", embedded.getVector().length );
        }
    }
}
