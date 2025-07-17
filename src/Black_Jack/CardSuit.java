package Black_Jack;

public enum CardSuit {
    CLUBS("♣", "clubs"),
    DIAMONDS("♦", "diamonds"),
    HEARTS("♥", "hearts"),
    SPADES("♠", "spades");

    private final String symbol;
    private final String displayName;

    CardSuit(String symbol, String displayName) {
        this.symbol = symbol;
        this.displayName = displayName;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getDisplayName() {
        return displayName;
    }
}
