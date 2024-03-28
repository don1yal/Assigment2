package Library.Catalog;

public class Magazine implements CatalogItem {
    private int id;
    private String title;
    private String edition;

    public Magazine(int id, String title, String edition) {
        this.id = id;
        this.title = title;
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
        return "Magazine";
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }
}
