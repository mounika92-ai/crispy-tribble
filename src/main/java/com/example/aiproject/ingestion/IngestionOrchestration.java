package com.example.aiproject.ingestion;

import com.example.aiproject.ingestion.database.DatabaseIngestionService;
import com.example.aiproject.ingestion.pdf.PdfIngestionService;
import com.example.aiproject.ingestion.wiki.WikiIngestionService;
import com.example.aiproject.model.IngestedDocument;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class IngestionOrchestration {
    private final PdfIngestionService pdfIngestionService;
    private final WikiIngestionService wikiIngestionService;
    private final DatabaseIngestionService databaseIngestionService;

    public List<IngestedDocument> ingestAll() throws  Exception {
        List<IngestedDocument> docs = new ArrayList<>();
        docs.addAll(pdfIngestionService.ingestPdfs());
        docs.addAll(wikiIngestionService.ingestWikiFiles());
        docs.addAll(databaseIngestionService.ingestDatabaseContent());
        return docs;
    }
}
