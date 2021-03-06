package com.example.elsearch.controller;

import com.example.elsearch.access.ESAccessService;
import com.example.elsearch.data.EsSearchResult;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@AllArgsConstructor
@RestController
public class ESController {
    private final ESAccessService esAccessService;

    @GetMapping("/search")
    public ResponseEntity<EsSearchResult> search(@RequestParam(value = "query", defaultValue = "") String query) throws IOException {
        return ResponseEntity.status(HttpStatus.OK).body(esAccessService.fetch(query));
    }
}
