package Black_Jack;

import java.util.List;

public abstract class Player {
    protected String name;
    protected Hand hand;

    public Player(String name) {
        this.name = name;
        this.hand = new Hand();
    }

    // This method will be overridden by HumanPlayer or Dealer
    //  as they have different logic.
    public abstract void takeTurn(Deck deck);

    public String getName() {
        return name;
    }

    public void addCard(Card card) {
        hand.addCard(card);
    }

    public int getScore() {
        return hand.getScore();
    }

    public boolean isBust() {
        return hand.isBust();
    }

    public void resetHand() {
        hand.resetHand();
    }

    public List<Card> getHandCards() {
        return hand.getCards();
    }

    public int handSize() {
        return hand.size();
    }

    @Override
    public String toString() {
        return name + "'s hand: " + hand;
    }
}
