import Library.CLI;
import Library.Catalog.Book;
import Library.Catalog.CD;
import Library.Catalog.CatalogItem;
import Library.Catalog.Magazine;
import Library.System.LibraryCatalog;
import Library.Users.*;
import java.util.Scanner;

public class Main {
    static Scanner scanner;
    static LibraryCatalog catalog;
    static CLI cli;

    public static void main(String[] args) {
        catalog = new LibraryCatalog();
        cli = new CLI(catalog);
        scanner = new Scanner(System.in);

        boolean exit = false;
        while (!exit) {
            System.out.println("Welcome to our library");
            display();

            int selectNum = scanner.nextInt();
            switch (selectNum) {
                case 1:
                    addUser();
                    break;
                case 2:
                    addCatalogItem();
                    break;
                case 3:
                    borrowBook();
                    break;
                case 4:
                    returnBook();
                    break;
                case 5:
                    displayUsers();
                    break;
                case 6:
                    displayCatalog();
                    break;
                case 7:
                    exit = true;
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private static void display() {
        System.out.println("Choose a service :)");
        System.out.println("To add a user:    --> 1");
        System.out.println("To add a book:    --> 2");
        System.out.println("To borrow a book: --> 3");
        System.out.println("To return a book: --> 4");
        System.out.println("To display all users --> 5");
        System.out.println("To display all catalog items --> 6");
        System.out.println("To exit --> 7");
    }
    private static void addUser() {
        System.out.println("User ID: ");
        int userId = scanner.nextInt();
        scanner.nextLine();

        System.out.println("User Name: ");
        String userName = scanner.nextLine();

        System.out.println("User type: ");
        String userType = scanner.nextLine();

        User user = null;
        switch (userType.toUpperCase()) {
            case "ADMINISTRATOR":
                user = new Administrator(userId,userName);
                break;
            case "CLERK":
                user = new Clerk(userId,userName);
                break;
            case "LIBRARIAN":
                user = new Librarian(userId,userName);
                break;
            case "SECURITY":
                user = new Security(userId,userName);
                break;
            case "VOLUNTEER":
                user = new Volunteer(userId,userName);
                break;
            default:
                System.out.println("Invalid user type!!!");
                return;
        }
        cli.addUser(user);

    }
    private static void addCatalogItem() {
        System.out.println("Item ID: ");
        int itemId = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Item title: ");
        String itemTitle = scanner.nextLine();

        System.out.println("Item type: ");
        String itemType = scanner.nextLine();

        CatalogItem catalogItem = null;
        switch (itemType.toUpperCase()) {
            case "BOOK":
                System.out.println("Book author: ");
                String author = scanner.nextLine();
                System.out.println("Book edition: ");
                String edition = scanner.nextLine();

                catalogItem = new Book(itemId,itemTitle,author,edition);
                break;
            case "CD":
                System.out.println("CD artist: ");
                String artist = scanner.nextLine();

                catalogItem = new CD(itemId,itemTitle,artist);
                break;
            case "Magazine":
                System.out.println("Magazine edition: ");
                String editionMag = scanner.nextLine();

                catalogItem = new Magazine(itemId,itemTitle,editionMag);
                break;
            default:
                System.out.println("Invalid item type!!!");
                return;
        }
        cli.addCatalogItem(catalogItem);
    }
    private static void borrowBook() {
        System.out.println("User ID:");
        int userId = scanner.nextInt();

        System.out.println("CatalogItem item ID:");
        int catalogId = scanner.nextInt();

        System.out.println("Number of copies: ");
        int numberOfCopies = scanner.nextInt();

        System.out.println("Release date: ");
        String releaseDate = scanner.next();

        System.out.println("Due date: ");
        String dueDate = scanner.next();

        cli.borrowItems(userId,catalogId,numberOfCopies,releaseDate,dueDate);

        System.out.println("Borrow Complete");
    }
    private static void returnBook() {
        System.out.println("User ID: ");
        int userID = scanner.nextInt();
        scanner.nextLine();

        System.out.println("CatalogItem item ID: ");
        int catalogItemId = scanner.nextInt();

        System.out.println("Number of copies: ");
        int numberOfCopies = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Return Date: ");
        String returnDate = scanner.nextLine();

        cli.returnItems(userID,catalogItemId,numberOfCopies,returnDate);
    }
    private static void displayUsers() {
        System.out.println("List of Users:");
        for (User user : cli.getUsers()) {
            System.out.println("User ID: " + user.getId() + ", Name: " + user.getName() + ", Type: " + user.getType());
        }
    }

    private static void displayCatalog() {
        System.out.println("List of Catalog Items:");
        for (CatalogItem item : cli.getCatalogItems()) {
            System.out.println("Item ID: " + item.getId() + ", Title: " + item.getTitle() + ", Type: " + item.getType());
        }
    }
}