package Library.System;

import Library.Catalog.CatalogItem;
import Library.Users.User;

public class BorrowItem {
    private static int nextId = 0;
    private int id;
    private int userId;
    private int catalogItemId;
    private int numberOfCopies;
    private String releaseDate;
    private String dueDate;

    public BorrowItem(int userId, int catalogItemId, int numberOfCopies, String releaseDate, String dueDate) {
        this.id = nextId++;
        this.userId = userId;
        this.catalogItemId = catalogItemId;
        this.numberOfCopies = numberOfCopies;
        this.releaseDate = releaseDate;
        this.dueDate = dueDate;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        BorrowItem.nextId = nextId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCatalogItemId() {
        return catalogItemId;
    }

    public void setCatalogItemId(int catalogItemId) {
        this.catalogItemId = catalogItemId;
    }

    public int getNumberOfCopies() {
        return numberOfCopies;
    }

    public void setNumberOfCopies(int numberOfCopies) {
        this.numberOfCopies = numberOfCopies;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }
}
