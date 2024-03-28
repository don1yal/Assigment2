package Library;

import Library.Catalog.CatalogItem;
import Library.System.BorrowItem;
import Library.System.LibraryCatalog;
import Library.System.ReturnRecord;
import Library.Users.User;

import java.util.ArrayList;
import java.util.List;

public class CLI {
    private LibraryCatalog catalog;
    private List<User> users;
    private List<BorrowItem> borrowItems;
    private List<ReturnRecord> returnRecords;


    public CLI(LibraryCatalog catalog) {
        this.catalog = catalog;
        this.users = new ArrayList<>();
        this.borrowItems = new ArrayList<>();
        this.returnRecords = new ArrayList<>();
    }
    public void addCatalogItem(CatalogItem item) {
        catalog.addItem(item);
    }
    public void addUser(User user){
        users.add(user);
        System.out.println("Successfully added");
    }
    public void borrowItems(int userId, int catalogId, int numberOfCopies, String releaseDate, String dueDate) {
        BorrowItem borrowItem = new BorrowItem(userId,catalogId,numberOfCopies,releaseDate,dueDate);
        borrowItems.add(borrowItem);
        System.out.println("Successful borrow");
    }
    public void returnItems(int userId, int catalogId, int numberNumberOfCopies, String returnDate) {
        for (BorrowItem borrowItem: borrowItems) {
            if (borrowItem.getUserId() == userId && borrowItem.getCatalogItemId() == catalogId) {
                ReturnRecord returnRecord = new ReturnRecord(getUser(userId),getCatalog(catalogId),numberNumberOfCopies,returnDate);
                System.out.println("Successfully return!!");
                borrowItems.remove(borrowItem);
                return;
            }
            System.out.println("Borrow not found");
        }
    }
    private User getUser(int id) {
        for (User user: users) {
            if(user.getId() == id) return user;
        }
        return null;
    }
    private CatalogItem getCatalog(int id) {
        for (CatalogItem catalogItem: catalog.items) {
            if (catalogItem.getId() == id) return catalogItem;
        }
        return null;
    }
    public List<User> getUsers() {
        return users;
    }

    public List<CatalogItem> getCatalogItems() {
        return catalog.getItems();
    }
}
