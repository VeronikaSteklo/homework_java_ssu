package Task8;
import java.util.*;


public class TestData {
    public static void main(String[] args) {
        String[] names = {"книга", "ручка", "линейка", "пенал"};
        double[] prices = {100.0, 200.0, 300.0, 400.0};
        int[] counts = {5, 10, 15, 20};
        Random random = new Random();

        ShopItem[] items = new ShopItem[100];
        for (int i = 0; i < items.length; i++) {
            String name = names[random.nextInt(names.length)];

            double price = random.nextBoolean() ? prices[random.nextInt(prices.length)] : 50 + random.nextDouble() * 450;
            int count = random.nextBoolean() ? counts[random.nextInt(counts.length)] : 1 + random.nextInt(10);

            items[i] = new ShopItem(name, price, count);
        }

        Arrays.sort(items, Comparator.comparing(ShopItem::getName));

        System.out.println("Отсортированные объекты ShopItem:");
        for (ShopItem item : items) {
            System.out.println(item);
        }

        Map<ShopItem, Integer> itemCount = new HashMap<>();
        for (ShopItem item : items) {
            itemCount.put(item, itemCount.getOrDefault(item, 0) + 1);
        }

        System.out.println("\nКоличество одинаковых ShopItem:");
        for (Map.Entry<ShopItem, Integer> entry : itemCount.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey() + " - количество: " + entry.getValue());
            }
        }
    }
}
