package Task16;

public enum Suit {
    SPADES("Пики"),
    HEARTS("Черви"),
    DIAMONDS("Бубны"),
    CLUBS("Трефы");

    private final String suit;
    Suit(String suit){
        this.suit = suit;
    }

    public String getSuit() {
        return suit;
    }
}
