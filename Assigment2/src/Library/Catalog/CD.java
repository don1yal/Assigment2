package Library.Catalog;

public class CD implements CatalogItem {
    private int id;
    private String title;
    private String artist;

    public CD(int id, String title, String artist) {
        this.id = id;
        this.title = title;
        this.artist = artist;
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
        return "CD";
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }
}
