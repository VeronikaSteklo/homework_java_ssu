package Task17;

public class User {
    @NotNull
    private String name;

    @MaxLength(10)
    private String username;

    @Min(18)
    private int age;

    @Range(min = 1, max = 100)
    private int level;

    public User(String name, String username, int age, int level) {
        this.name = name;
        this.username = username;
        this.age = age;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public int getAge() {
        return age;
    }

    public int getLevel() {
        return level;
    }
}
