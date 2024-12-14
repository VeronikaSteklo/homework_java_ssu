package Task13;

import java.io.Serial;
import java.io.Serializable;

class User implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private final String name;
    private final int age;
    private final String email;

    public User(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Имя: " + name + ", Возраст: " + age + ", Email: " + email;
    }
}
