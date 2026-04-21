package com.demo.langchain4j.service;

import ai.djl.nn.core.Embedding;
import dev.langchain4j.store.embedding.EmbeddingSearchRequest;
import dev.langchain4j.store.embedding.EmbeddingSearchResult;

import java.util.List;

public interface EmbeddingStore<Embedded> {
    String add(Embedding embedding);

    void add(String text, Embedding embedding);

    String add(Embedding embedding, Embedded embedded);

    List<String> addAll(List<Embedding> embeddings);

    EmbeddingSearchResult<Embedded> search(EmbeddingSearchRequest request);
}

