package Black_Jack;

public class BlackjackRound {

    private final Deck deck;
    private final HumanPlayer player;
    private final Dealer dealer;

    public BlackjackRound(HumanPlayer player, Dealer dealer, Deck deck) {
        this.player = player;
        this.dealer = dealer;
        this.deck = deck;
    }

    public void play() {
        System.out.println("\n--- New Blackjack Round ---");

        // Reset everything
        deck.resetDeck();
        player.resetHand();
        dealer.resetHand();

        // Place bet
        int bet = player.placeBet();
        System.out.println(player.getName() + " placed a bet of $" + bet);
        System.out.println("Current balance: $" + player.getBalance());

        // Deal 2 cards to each
        for (int i = 0; i < 2; i++) {
            player.addCard(deck.drawCard());
            dealer.addCard(deck.drawCard());
        }

        // Show initial hands
        System.out.println("\n" + player);
        System.out.println("Dealer shows: " + dealer.getHandCards().get(0).getDisplayName() + " and [hidden]");


        // Player's turn
        player.takeTurn(deck);

        if (player.isBust()) {
            player.lose();
            return;
        }

        // Dealer's turn
        dealer.takeTurn(deck);

        // Determine outcome
        int playerScore = player.getScore();
        int dealerScore = dealer.getScore();

        System.out.println("\nFinal Results:");
        System.out.println(player);
        System.out.println(dealer);

        if (dealer.isBust() || playerScore > dealerScore) {
            player.win(bet);
        } else if (playerScore < dealerScore) {
            player.lose();
        } else {
            player.push(bet);
        }

        System.out.println("New balance: $" + player.getBalance());
    }
}
