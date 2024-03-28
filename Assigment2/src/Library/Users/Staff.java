package Library.Users;

public class Staff implements User {
    private int id;
    private String name;
    private String type;

    public Staff(int id, String name, String role) {
        this.id = id;
        this.name = name;
        this.type = type;
    }


    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getType() {
        return type;
    }
}
