package api;

import java.util.List;

public class Docs {
    private String key;
    private String redirects;
    private String title;
    private String subtitle;
    private String alternative_title;
    private String alternative_subtitle;
    private Integer cover_i;
    private String ebook_access;
    private Integer edition_count;
    private List<String> edition_key;
    private List<String> format;
    private String by_statement;
    private List<String> publish_date;
    private List<String> lccn;
    private List<String> ia;
    private List<String> oclc;
    private List<String> isbn;
    private List<String>  contributor;
    private List<String> publish_place;
    private List<String> publisher;
    private String first_sentence;
    private String author_key;
    private String author_name;
    private List<String> author_alternative_name;
    private List<String> id_goodreads;
    private List<String> id_librarything;
    private List<String> id_dnb;
    private List<String> id_amazon;
    private List<String> id_alibris_id;
    private List<String> id_google;
    private List<String> id_paperback_swap;
    private List<String> id_wikidata;
    private List<String> id_better_world_books;
    private List<String> id_overdrive;
    private String id_canadian_national_library_archive;
    private List<String> subject;
    private List<String> place;
    private String time;
    private List<String> person;
    private Boolean has_fulltext;
    private String title_suggest;
    private List<Integer> publish_year;
    private List<String> language;
    private Integer number_of_pages_median;
    private String ia_count;
    private String publisher_facet;
    private String author_facet;
    private List<String> ia_loaded_id;
    private List<String> ia_box_id;
    private Integer first_publish_year;
    private Integer ratings_average;
    private Integer ratings_sortable;
    private Integer ratings_count;
    private Integer readinglog_count;
    private Integer want_to_read_count;
    private Integer currently_reading_count;
    private Integer already_read_count;
    //Subjects
    private String subject_key;
    private String person_key;
    private String place_key;
    private String time_key;
    //Classifications
    private List<String> lcc;
    private List<String> ddc;
    private String lcc_sort;
    private String ddc_sort;

    public Docs() {
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getRedirects() {
        return redirects;
    }

    public void setRedirects(String redirects) {
        this.redirects = redirects;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getAlternative_title() {
        return alternative_title;
    }

    public void setAlternative_title(String alternative_title) {
        this.alternative_title = alternative_title;
    }

    public String getAlternative_subtitle() {
        return alternative_subtitle;
    }

    public void setAlternative_subtitle(String alternative_subtitle) {
        this.alternative_subtitle = alternative_subtitle;
    }

    public Integer getCover_i() {
        return cover_i;
    }

    public void setCover_i(Integer cover_i) {
        this.cover_i = cover_i;
    }

    public String getEbook_access() {
        return ebook_access;
    }

    public void setEbook_access(String ebook_access) {
        this.ebook_access = ebook_access;
    }

    public Integer getEdition_count() {
        return edition_count;
    }

    public void setEdition_count(Integer edition_count) {
        this.edition_count = edition_count;
    }

    public List<String> getEdition_key() {
        return edition_key;
    }

    public void setEdition_key(List<String> edition_key) {
        this.edition_key = edition_key;
    }

    public List<String> getFormat() {
        return format;
    }

    public void setFormat(List<String> format) {
        this.format = format;
    }

    public String getBy_statement() {
        return by_statement;
    }

    public void setBy_statement(String by_statement) {
        this.by_statement = by_statement;
    }

    public List<String> getPublish_date() {
        return publish_date;
    }

    public void setPublish_date(List<String> publish_date) {
        this.publish_date = publish_date;
    }

    public List<String> getLccn() {
        return lccn;
    }

    public void setLccn(List<String> lccn) {
        this.lccn = lccn;
    }

    public List<String> getIa() {
        return ia;
    }

    public void setIa(List<String> ia) {
        this.ia = ia;
    }

    public List<String> getOclc() {
        return oclc;
    }

    public void setOclc(List<String> oclc) {
        this.oclc = oclc;
    }

    public List<String> getIsbn() {
        return isbn;
    }

    public void setIsbn(List<String> isbn) {
        this.isbn = isbn;
    }

    public List<String> getContributor() {
        return contributor;
    }

    public void setContributor(List<String> contributor) {
        this.contributor = contributor;
    }

    public List<String> getPublish_place() {
        return publish_place;
    }

    public void setPublish_place(List<String> publish_place) {
        this.publish_place = publish_place;
    }

    public List<String> getPublisher() {
        return publisher;
    }

    public void setPublisher(List<String> publisher) {
        this.publisher = publisher;
    }

    public String getFirst_sentence() {
        return first_sentence;
    }

    public void setFirst_sentence(String first_sentence) {
        this.first_sentence = first_sentence;
    }

    public String getAuthor_key() {
        return author_key;
    }

    public void setAuthor_key(String author_key) {
        this.author_key = author_key;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public List<String> getAuthor_alternative_name() {
        return author_alternative_name;
    }

    public void setAuthor_alternative_name(List<String> author_alternative_name) {
        this.author_alternative_name = author_alternative_name;
    }

    public List<String> getId_goodreads() {
        return id_goodreads;
    }

    public void setId_goodreads(List<String> id_goodreads) {
        this.id_goodreads = id_goodreads;
    }

    public List<String> getId_librarything() {
        return id_librarything;
    }

    public void setId_librarything(List<String> id_librarything) {
        this.id_librarything = id_librarything;
    }

    public List<String> getId_dnb() {
        return id_dnb;
    }

    public void setId_dnb(List<String> id_dnb) {
        this.id_dnb = id_dnb;
    }

    public List<String> getId_amazon() {
        return id_amazon;
    }

    public void setId_amazon(List<String> id_amazon) {
        this.id_amazon = id_amazon;
    }

    public List<String> getId_alibris_id() {
        return id_alibris_id;
    }

    public void setId_alibris_id(List<String> id_alibris_id) {
        this.id_alibris_id = id_alibris_id;
    }

    public List<String> getId_google() {
        return id_google;
    }

    public void setId_google(List<String> id_google) {
        this.id_google = id_google;
    }

    public List<String> getId_paperback_swap() {
        return id_paperback_swap;
    }

    public void setId_paperback_swap(List<String> id_paperback_swap) {
        this.id_paperback_swap = id_paperback_swap;
    }

    public List<String> getId_wikidata() {
        return id_wikidata;
    }

    public void setId_wikidata(List<String> id_wikidata) {
        this.id_wikidata = id_wikidata;
    }

    public List<String> getId_better_world_books() {
        return id_better_world_books;
    }

    public void setId_better_world_books(List<String> id_better_world_books) {
        this.id_better_world_books = id_better_world_books;
    }

    public List<String> getId_overdrive() {
        return id_overdrive;
    }

    public void setId_overdrive(List<String> id_overdrive) {
        this.id_overdrive = id_overdrive;
    }

    public String getId_canadian_national_library_archive() {
        return id_canadian_national_library_archive;
    }

    public void setId_canadian_national_library_archive(String id_canadian_national_library_archive) {
        this.id_canadian_national_library_archive = id_canadian_national_library_archive;
    }

    public List<String> getSubject() {
        return subject;
    }

    public void setSubject(List<String> subject) {
        this.subject = subject;
    }

    public List<String> getPlace() {
        return place;
    }

    public void setPlace(List<String> place) {
        this.place = place;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public List<String> getPerson() {
        return person;
    }

    public void setPerson(List<String> person) {
        this.person = person;
    }

    public Boolean getHas_fulltext() {
        return has_fulltext;
    }

    public void setHas_fulltext(Boolean has_fulltext) {
        this.has_fulltext = has_fulltext;
    }

    public String getTitle_suggest() {
        return title_suggest;
    }

    public void setTitle_suggest(String title_suggest) {
        this.title_suggest = title_suggest;
    }

    public List<Integer> getPublish_year() {
        return publish_year;
    }

    public void setPublish_year(List<Integer> publish_year) {
        this.publish_year = publish_year;
    }

    public List<String> getLanguage() {
        return language;
    }

    public void setLanguage(List<String> language) {
        this.language = language;
    }

    public Integer getNumber_of_pages_median() {
        return number_of_pages_median;
    }

    public void setNumber_of_pages_median(Integer number_of_pages_median) {
        this.number_of_pages_median = number_of_pages_median;
    }

    public String getIa_count() {
        return ia_count;
    }

    public void setIa_count(String ia_count) {
        this.ia_count = ia_count;
    }

    public String getPublisher_facet() {
        return publisher_facet;
    }

    public void setPublisher_facet(String publisher_facet) {
        this.publisher_facet = publisher_facet;
    }

    public String getAuthor_facet() {
        return author_facet;
    }

    public void setAuthor_facet(String author_facet) {
        this.author_facet = author_facet;
    }

    public List<String> getIa_loaded_id() {
        return ia_loaded_id;
    }

    public void setIa_loaded_id(List<String> ia_loaded_id) {
        this.ia_loaded_id = ia_loaded_id;
    }

    public List<String> getIa_box_id() {
        return ia_box_id;
    }

    public void setIa_box_id(List<String> ia_box_id) {
        this.ia_box_id = ia_box_id;
    }

    public Integer getFirst_publish_year() {
        return first_publish_year;
    }

    public void setFirst_publish_year(Integer first_publish_year) {
        this.first_publish_year = first_publish_year;
    }

    public Integer getRatings_average() {
        return ratings_average;
    }

    public void setRatings_average(Integer ratings_average) {
        this.ratings_average = ratings_average;
    }

    public Integer getRatings_sortable() {
        return ratings_sortable;
    }

    public void setRatings_sortable(Integer ratings_sortable) {
        this.ratings_sortable = ratings_sortable;
    }

    public Integer getRatings_count() {
        return ratings_count;
    }

    public void setRatings_count(Integer ratings_count) {
        this.ratings_count = ratings_count;
    }

    public Integer getReadinglog_count() {
        return readinglog_count;
    }

    public void setReadinglog_count(Integer readinglog_count) {
        this.readinglog_count = readinglog_count;
    }

    public Integer getWant_to_read_count() {
        return want_to_read_count;
    }

    public void setWant_to_read_count(Integer want_to_read_count) {
        this.want_to_read_count = want_to_read_count;
    }

    public Integer getCurrently_reading_count() {
        return currently_reading_count;
    }

    public void setCurrently_reading_count(Integer currently_reading_count) {
        this.currently_reading_count = currently_reading_count;
    }

    public Integer getAlready_read_count() {
        return already_read_count;
    }

    public void setAlready_read_count(Integer already_read_count) {
        this.already_read_count = already_read_count;
    }

    public String getSubject_key() {
        return subject_key;
    }

    public void setSubject_key(String subject_key) {
        this.subject_key = subject_key;
    }

    public String getPerson_key() {
        return person_key;
    }

    public void setPerson_key(String person_key) {
        this.person_key = person_key;
    }

    public String getPlace_key() {
        return place_key;
    }

    public void setPlace_key(String place_key) {
        this.place_key = place_key;
    }

    public String getTime_key() {
        return time_key;
    }

    public void setTime_key(String time_key) {
        this.time_key = time_key;
    }

    public List<String> getLcc() {
        return lcc;
    }

    public void setLcc(List<String> lcc) {
        this.lcc = lcc;
    }

    public List<String> getDdc() {
        return ddc;
    }

    public void setDdc(List<String> ddc) {
        this.ddc = ddc;
    }

    public String getLcc_sort() {
        return lcc_sort;
    }

    public void setLcc_sort(String lcc_sort) {
        this.lcc_sort = lcc_sort;
    }

    public String getDdc_sort() {
        return ddc_sort;
    }

    public void setDdc_sort(String ddc_sort) {
        this.ddc_sort = ddc_sort;
    }
}
