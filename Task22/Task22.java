package Task22;

public class Task22 {
    public static void main(String[] args) {
        Dictionary<String, Integer> dictionary = new Dictionary();
        dictionary.put("Alice", 25);
        dictionary.put("Bob", 30);
        System.out.println(dictionary.get("Alice")); // 25
        System.out.println(dictionary.keys());
        System.out.println(dictionary.values());
    }
}
