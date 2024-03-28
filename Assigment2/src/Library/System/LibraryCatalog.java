package Library.System;



import Library.Catalog.CatalogItem;

import java.util.ArrayList;
import java.util.List;

public class LibraryCatalog {
    public List<CatalogItem> items;

    public LibraryCatalog() {
        this.items = new ArrayList<>();
    }
    public void addItem(CatalogItem item) {
        items.add(item);
    }
    public List<CatalogItem> getItems(){
        return items;
    }
}
