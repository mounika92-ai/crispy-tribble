package com.example.aiproject.chunking;

import com.example.aiproject.chunking.model.Chunk;
import com.example.aiproject.model.IngestedDocument;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class DatabaseChunker {

    public List<Chunk> chunk(IngestedDocument document) {
        return List.of(
                new Chunk(
                        document.getSource(),
                        document.getContent(),
                        document.getMetadata(),
                        0
                ));
    }
}
