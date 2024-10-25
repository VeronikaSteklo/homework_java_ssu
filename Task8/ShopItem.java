package Task8;
import java.util.*;

class ShopItem {
    private String name;
    private double price;
    private int count;

    public ShopItem(String name, double price, int count) {
        this.name = name;
        this.price = price;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "ShopItem{name='" + name + "', price=" + price + ", count=" + count + "}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ShopItem shopItem = (ShopItem) obj;
        return Double.compare(shopItem.price, price) == 0 &&
                count == shopItem.count &&
                Objects.equals(name, shopItem.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, count);
    }
}
