package com.example.elsearch.data;

import lombok.Data;

@Data
public class Item {
    private String title;
    private String link;
    private String description;
    private String pubDate;
    private String comments;
    private Float score;
}
