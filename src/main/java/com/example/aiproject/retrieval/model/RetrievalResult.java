package com.example.aiproject.retrieval.model;

import com.example.aiproject.chunking.model.Chunk;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RetrievalResult {

    private List<Chunk> chunks;
}
