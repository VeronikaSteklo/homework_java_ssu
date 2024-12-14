package Task16;

public class Task16 {
    public static void main(String[] args){
        System.out.println("Колода");
        for (Suit suit : Suit.values()){
            for (Rank rank : Rank.values()){
                System.out.println(rank.getValue() + " " + suit.getSuit());
            }
            System.out.println();
        }
    }
}
