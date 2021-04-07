package com.example.elsearch.access;

import com.example.elsearch.data.EsSearchResult;

import java.io.IOException;

/**
 * Elasticsearch access service
 */
public interface ESAccessService {
    /**
     *
     * @param query Space separated key words
     * @return Search result
     * @throws IOException if failed
     */
    EsSearchResult fetch(String query) throws IOException;
}
