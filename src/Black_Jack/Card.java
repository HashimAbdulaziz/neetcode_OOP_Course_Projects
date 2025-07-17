package Black_Jack;

public class Card {
    private final CardSuit suit;
    private final CardRank rank;

    public Card(CardSuit suit, CardRank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public CardSuit getSuit() {
        return suit;
    }

    public CardRank getRank() {
        return rank;
    }

    public int getValue() {
        return rank.getValue();
    }


    /******  Some methods for future Works adding graphics  *****/

    public String getDisplayName() {
        // Example: "A♠", "10♥", "K♦"
        return rank.getLabel() + suit.getSymbol();
    }

    public String getImageFileName() {
        // Example: "AS.png" or "10H.png"
        return rank.getLabel() + suit.getDisplayName().charAt(0) + ".png";
    }

    // For Returns a readable string representation of the Card object.
    // when System.out.println(card) --> "QUEEN of HEARTS"
    @Override
    public String toString() {
        return rank.name() + " of " + suit.name();
    }

    // Defines what makes two Card objects "equal" (same suit and rank).
    // when card1.equals(card2) --> true if same suit and rank
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Card)) return false;

        Card card = (Card) o;
        return rank == card.rank && suit == card.suit;
    }

    // Generates a unique-ish integer based on suit and rank.
    // any time you override equals(), you must override hashCode(), or your object won’t work correctly
    @Override
    public int hashCode() {
        return 31 * suit.hashCode() + rank.hashCode();
    }
}

