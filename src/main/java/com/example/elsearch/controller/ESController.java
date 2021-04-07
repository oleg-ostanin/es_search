package com.example.elsearch.controller;

import com.example.elsearch.access.ESAccessService;
import com.example.elsearch.data.EsSearchResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class ESController {
    @Autowired
    private ESAccessService esAccessService;

    @GetMapping("/search")
    public EsSearchResult search(@RequestParam(value = "query", defaultValue = "") String query) throws IOException {
        return esAccessService.fetch(query);
    }
}
