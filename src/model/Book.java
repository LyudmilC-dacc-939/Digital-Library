package model;

import java.util.List;

public class Book {
    private int start;
    private int numFound;
    private List<Doc> docs;

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getNumFound() {
        return numFound;
    }

    public void setNumFound(int numFound) {
        this.numFound = numFound;
    }

    public List<Doc> getDocs() {
        return docs;
    }

    public void setDocs(List<Doc> docs) {
        this.docs = docs;
    }

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

        // Getters and Setters
        public int getCover_i() {
            return cover_i;
        }

        public void setCover_i(int cover_i) {
            this.cover_i = cover_i;
        }

        public boolean isHas_fulltext() {
            return has_fulltext;
        }

        public void setHas_fulltext(boolean has_fulltext) {
            this.has_fulltext = has_fulltext;
        }

        public int getEdition_count() {
            return edition_count;
        }

        public void setEdition_count(int edition_count) {
            this.edition_count = edition_count;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<String> getAuthor_name() {
            return author_name;
        }

        public void setAuthor_name(List<String> author_name) {
            this.author_name = author_name;
        }

        public int getFirst_publish_year() {
            return first_publish_year;
        }

        public void setFirst_publish_year(int first_publish_year) {
            this.first_publish_year = first_publish_year;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public List<String> getIa() {
            return ia;
        }

        public void setIa(List<String> ia) {
            this.ia = ia;
        }

        public List<String> getAuthor_key() {
            return author_key;
        }

        public void setAuthor_key(List<String> author_key) {
            this.author_key = author_key;
        }

        public boolean isPublic_scan_b() {
            return public_scan_b;
        }

        public void setPublic_scan_b(boolean public_scan_b) {
            this.public_scan_b = public_scan_b;
        }
    }

}
