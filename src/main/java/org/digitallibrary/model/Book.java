package org.digitallibrary.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Book {

    private int start;
    private int numFound;
    private List<Doc> docs;


    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Doc {
        private int cover_i;
        private boolean has_fulltext;
        private int edition_count;
        private String title;
        private List<String> author_name;
        private int first_publish_year;
        private String key;
        private List<String> ia;
        private List<String> author_key;
        private boolean public_scan_b;

    }
}
