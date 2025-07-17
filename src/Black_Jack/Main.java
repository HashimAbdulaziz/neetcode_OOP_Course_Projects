package Black_Jack;

public class Main {
    public static void main(String[] args) {
        Deck deck = new Deck(new FisherYatesShuffler());
        HumanPlayer player = new HumanPlayer("Hashim", 100);
        Dealer dealer = new Dealer();

        BlackjackRound round = new BlackjackRound(player, dealer, deck);

        while (player.getBalance() >= 10) {
            round.play();

            System.out.print("\nPlay another round? (Y/N): ");
            String choice = new java.util.Scanner(System.in).nextLine().trim().toUpperCase();
            if (!choice.equals("Y")) break;
        }

        System.out.println("Game over. Final balance: $" + player.getBalance());
    }
}
