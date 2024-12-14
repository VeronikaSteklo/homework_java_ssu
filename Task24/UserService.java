package Task24;

import java.sql.SQLException;
import java.util.List;
import java.util.regex.Pattern;

// Сервис для работы с пользователями
class UserService {
    private final UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void registerUser(String name, String email) throws SQLException {
        validateName(name);
        validateEmail(email);

        if (userDAO.emailExists(email)) {
            throw new EmailAlreadyExistsException("Email already exists.");
        }
        userDAO.create(new User(0, name, email));
    }

    public List<User> listAllUsers() throws SQLException {
        return userDAO.findAll();
    }

    public void deleteUser(int id) throws SQLException {
        User user = userDAO.findById(id);
        if (user == null) {
            throw new UserNotFoundException("User not found.");
        }
        userDAO.delete(id);
    }

    public void updateUser(int id, String newName, String newEmail) throws SQLException {
        validateName(newName);
        validateEmail(newEmail);

        User user = userDAO.findById(id);
        if (user == null) {
            throw new UserNotFoundException("User not found.");
        }
        if (!user.getEmail().equals(newEmail) && userDAO.emailExists(newEmail)) {
            throw new EmailAlreadyExistsException("Email already exists.");
        }
        user.setName(newName);
        user.setEmail(newEmail);
        userDAO.update(user);
    }

    private void validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty.");
        }
    }

    private void validateEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email cannot be null or empty.");
        }
        String emailRegex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        if (!email.matches(emailRegex)) {
            throw new IllegalArgumentException("Invalid email format.");
        }
    }
}
