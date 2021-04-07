package com.example.elsearch.data;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class EsSearchResult {
    private final List<Item> items = new ArrayList<>();
}
