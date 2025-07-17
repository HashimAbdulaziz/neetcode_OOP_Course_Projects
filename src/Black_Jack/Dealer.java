package Black_Jack;

public class Dealer extends Player {

    public Dealer() {
        super("Dealer");
    }

    @Override
    public void takeTurn(Deck deck) {
        System.out.println("Dealer's turn begins.");
        System.out.println("Dealer starting hand: " + getHandCards() + " | Score: " + getScore());

        while (getScore() < 17) {
            Card card = deck.drawCard();
            addCard(card);
            System.out.println("Dealer hits and draws: " + card);
            System.out.println("Dealer hand: " + getHandCards() + " | Score: " + getScore());

            if (isBust()) {
                System.out.println("Dealer busts with score: " + getScore());
                return;
            }
        }

        System.out.println("Dealer stands at score: " + getScore());
    }
}
