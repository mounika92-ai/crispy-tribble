package com.example.aiproject.embedding.model;

import com.example.aiproject.chunking.model.Chunk;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class EmbeddedChunk {
    private final Chunk chunk;
    private final float[] vector;
}
