package api;

public class GeneralSearchResponse {
    private Integer numFound;
    private Integer start;
    private boolean numFoundExact;
    private Docs docs;
    private Integer num_found;
    private String q;
    private Integer offset;

    public GeneralSearchResponse() {
    }

    public GeneralSearchResponse(Integer numFound, Integer start, boolean numFoundExact, Docs docs, Integer num_found, String q, Integer offset) {
        this.numFound = numFound;
        this.start = start;
        this.numFoundExact = numFoundExact;
        this.docs = docs;
        this.num_found = num_found;
        this.q = q;
        this.offset = offset;
    }

    public Integer getNumFound() {
        return numFound;
    }

    public GeneralSearchResponse setNumFound(Integer numFound) {
        this.numFound = numFound;
        return this;
    }

    public Integer getStart() {
        return start;
    }

    public GeneralSearchResponse setStart(Integer start) {
        this.start = start;
        return this;
    }

    public boolean isNumFoundExact() {
        return numFoundExact;
    }

    public GeneralSearchResponse setNumFoundExact(boolean numFoundExact) {
        this.numFoundExact = numFoundExact;
        return this;
    }

    public Docs getDocs() {
        return docs;
    }

    public GeneralSearchResponse setDocs(Docs docs) {
        this.docs = docs;
        return this;
    }

    public Integer getNum_found() {
        return num_found;
    }

    public GeneralSearchResponse setNum_found(Integer num_found) {
        this.num_found = num_found;
        return this;
    }

    public String getQ() {
        return q;
    }

    public GeneralSearchResponse setQ(String q) {
        this.q = q;
        return this;
    }

    public Integer getOffset() {
        return offset;
    }

    public GeneralSearchResponse setOffset(Integer offset) {
        this.offset = offset;
        return this;
    }
}

