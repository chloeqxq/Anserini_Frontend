package com.example.application.services;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.anserini.search.ScoredDoc;
import io.anserini.search.SimpleSearcher;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SearchService {
    
    static final private String INDEX_DIR = "indexes/msmarco-passage/lucene-index-msmarco";
    static final private float k1 = 0.82f;
    static final private float b = 0.68f;

    public static List<String> search(String query, int hits) {
        try {
            // index, k1, b, hits
            SimpleSearcher searcher = new SimpleSearcher(INDEX_DIR);
            searcher.set_bm25(k1, b);
            ScoredDoc[] results = searcher.search(query, hits);
            List<String> resultStrings = List.of(results).stream().map(result -> {
                try {
                    String jsonString = searcher.doc_raw(result.lucene_docid);
                    ObjectMapper mapper = new ObjectMapper();
                    JsonNode jsonNode = mapper.readTree(jsonString);
                    return jsonNode.get("contents").asText();
                } catch (Exception e) {
                    e.printStackTrace();
                    return "";
                }
            }).collect(Collectors.toList());
            searcher.close();
            return resultStrings;
        } catch (Exception e) {
            // Consume exception and return empty list
            e.printStackTrace();
            return List.of();
        }
    }
}