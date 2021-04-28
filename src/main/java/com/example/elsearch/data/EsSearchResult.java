package com.example.elsearch.data;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class EsSearchResult {
    private final List<Item> items = new ArrayList<>();
}
