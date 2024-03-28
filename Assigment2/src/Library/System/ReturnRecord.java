package Library.System;

import Library.Catalog.CatalogItem;
import Library.Users.User;

public class ReturnRecord {
    private static int nextId = 0;
    private int id;
    private User user;
    private CatalogItem item;
    private int numberOfCopies;
    private String returnDate;

    public ReturnRecord(User user, CatalogItem item, int numberOfCopies, String returnDate) {
        this.id = nextId++;
        this.user = user;
        this.item = item;
        this.numberOfCopies = numberOfCopies;
        this.returnDate = returnDate;
    }
}
