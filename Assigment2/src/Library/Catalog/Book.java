package Library.Catalog;


public class Book implements CatalogItem {
    private int id;
    private String title;
    private String author;
    private String edition;

    public Book(int id, String title, String author, String edition) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.edition = edition;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getType() {
        return "Book";
    }

    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }
}
