package com.example.aiproject.embedding;

import com.example.aiproject.chunking.model.Chunk;
import com.example.aiproject.embedding.model.EmbeddedChunk;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChunkEmbeddingService {

    private final EmbeddingModel embeddingModel;

    public EmbeddedChunk embed(Chunk chunk){
        float[] vector=embeddingModel.embed(chunk.getContent());
        return new EmbeddedChunk(chunk,vector);
    }
}
