package demo;

public class User {

    private String name;

    private String userName;

    private String phoneNumber;

    User(String name, String userName, String phoneNumber) {
        this.name = name;
        this.userName = userName;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }
}
