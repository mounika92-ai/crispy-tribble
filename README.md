# Spring AI – HR Knowledge Assistant (RAG)

## Project Overview

A Java-based Retrieval-Augmented Generation (RAG) application built using Spring Boot and Spring AI. The application explores retrieving relevant information from multiple knowledge sources, including PDF documents, internal wiki content, and relational database files, to provide context-aware responses using LLMs.

## Technology Stack

- Java 21
- Spring Boot 4
- Spring AI
- OpenAI
- Apache PDFBox
- Redis Vector Store
- PostgreSQL
- Spring JDBC
- Gradle

## RAG Workflow

The project focuses on implementing an end-to-end RAG pipeline:

1. **Data Ingestion:** Ingest information from multiple sources, including PDF documents, wiki content, and database records.
2. **Content Extraction:** Extract and normalize textual content from different sources into a common document representation.
3. **Chunking:** Split extracted content into smaller, meaningful chunks to improve retrieval accuracy.
4. **Embedding Generation:** Generate vector embeddings for document chunks using an embedding model.
5. **Vector Storage:** Store embeddings, document content, and associated metadata in Redis Vector Store.
6. **Retrieval:** Convert user queries into embeddings and perform semantic similarity searches to retrieve relevant document chunks.
7. **Response Generation:** Pass retrieved context along with the user query to the LLM through Spring AI to generate context-aware responses.

## High-Level Architecture

```text
 PDF Documents    Wiki Content    Database Records
      |                |                 |
      +----------------+-----------------+
                       |
                Data Ingestion
                       |
              Content Extraction
                       |
                   Chunking
                       |
              Embedding Model
                       |
               Redis Vector Store
                       |
                 User Query
                       |
              Query Embedding
                       |
               Similarity Search
                       |
              Retrieved Context
                       |
               Spring AI ChatClient
                       |
                  LLM Response
```

## Project Objective

Explore and implement RAG concepts within the Java ecosystem, integrating enterprise knowledge sources with LLMs to build context-aware AI applications.
