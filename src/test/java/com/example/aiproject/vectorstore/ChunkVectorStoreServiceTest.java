package com.example.aiproject.vectorstore;

import com.example.aiproject.chunking.ChunkingOrchestrator;
import com.example.aiproject.chunking.model.Chunk;
import com.example.aiproject.ingestion.IngestionOrchestration;
import com.example.aiproject.model.IngestedDocument;
import com.example.aiproject.vectorStore.ChunkVectorStoreService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
@SpringBootTest
public class ChunkVectorStoreServiceTest {
    @Autowired
    private IngestionOrchestration ingestionOrchestrator;

    @Autowired
    private ChunkingOrchestrator chunkingOrchestrator;

    @Autowired
    private ChunkVectorStoreService vectorStoreService;

    @Test
    void testVectorStore() throws Exception {
        List<IngestedDocument> documents = ingestionOrchestrator.ingestAll();

        List<Chunk> chunksToStore = new ArrayList<>();
        for (IngestedDocument document : documents) {
            List<Chunk> chunks = chunkingOrchestrator.chunk(document);
            chunksToStore.addAll(chunks);
        }
        vectorStoreService.store(chunksToStore);
    }
}
