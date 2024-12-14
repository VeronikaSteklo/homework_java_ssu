package Task23;

public class Type {
    public static <T> void printType(T obj) {
        if (obj == null) {
            System.out.println("null"); // Для случая, если объект равен null
        } else {
            System.out.println(obj.getClass().getName());
        }
    }
}
