package Task17;

public class Task17 {
    public static void main(String[] args) {
        User user = new User("fdjhs", "LongUsernameHere", 16, 150);

        try {
            Validator.validate(user);
        } catch (ValidationException | IllegalAccessException e) {
            System.out.println(e.getMessage());
        }
    }
}

