package model;

import api.Docs;

import java.util.List;

public class Book {
    private Integer numFound;
    private Integer start;
    private Boolean numFoundExact;
    private List<Docs> docs;
    private Integer num_found;
    private String q;
    private Integer offset = null;
}
