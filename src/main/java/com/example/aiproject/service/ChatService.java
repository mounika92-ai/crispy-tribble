package com.example.aiproject.service;


import com.example.aiproject.chunking.model.Chunk;
import com.example.aiproject.dto.ChatRequest;
import com.example.aiproject.dto.ChatResponse;
import com.example.aiproject.retrieval.RetrievalService;
import com.example.aiproject.retrieval.model.RetrievalResult;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatService {

    private final ChatClient chatClient;
    private final RetrievalService retrievalService;

    public ChatResponse chat(ChatRequest request) {
        String userMessage = request.getMessage();

        RetrievalResult retrievalResult = retrievalService.retrieve(userMessage);
        String context = buildContext(retrievalResult);

        String aiResponse = chatClient.prompt()
                .system(context)
                .user(request.getMessage())
                .call().content();

        return new ChatResponse(aiResponse);
    }

    private String buildContext(RetrievalResult retrievalResult) {
        StringBuilder contextBuilder = new StringBuilder();
        for (Chunk chunk : retrievalResult.getChunks()) {
            contextBuilder.append(chunk.getContent()).append("\n\n");
        }

        return contextBuilder.toString();
    }
}
