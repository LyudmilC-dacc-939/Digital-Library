package api;

import java.util.List;

public class GeneralSearchResponse {
    private Integer numFound;
    private Integer start;
    private Boolean numFoundExact;
    private List<Docs> docs;
    private Integer num_found;
    private String q;
    private Integer offset = null;

    public GeneralSearchResponse() {
    }

    public Integer getNumFound() {
        return numFound;
    }

    public void setNumFound(Integer numFound) {
        this.numFound = numFound;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Boolean getNumFoundExact() {
        return numFoundExact;
    }

    public void setNumFoundExact(Boolean numFoundExact) {
        this.numFoundExact = numFoundExact;
    }

    public List<Docs> getDocs() {
        return docs;
    }

    public void setDocs(List<Docs> docs) {
        this.docs = docs;
    }

    public Integer getNum_found() {
        return num_found;
    }

    public void setNum_found(Integer num_found) {
        this.num_found = num_found;
    }

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }
}

