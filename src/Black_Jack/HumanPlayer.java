package Black_Jack;

import java.util.Scanner;

public class HumanPlayer extends Player {

    private int balance;

    public HumanPlayer(String name, int startingBalance) {
        super(name);
        this.balance = startingBalance;
    }

    public int getBalance() {
        return balance;
    }

    public void adjustBalance(int amount) {
        balance += amount;
    }

    public int placeBet() {
        // For now, fixed bet for simplicity
        int bet = 10;
        if (balance < bet) {
            throw new IllegalStateException(name + " does not have enough balance to bet.");
        }
        balance -= bet;
        return bet;
    }

    @Override
    public void takeTurn(Deck deck) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println(name + "'s current hand: " + hand);
            System.out.print("Do you want to Hit or Stand? (H/S): ");
            String choice = scanner.nextLine().trim().toUpperCase();

            if (choice.equals("H")) {
                Card card = deck.drawCard();
                addCard(card);
                System.out.println("You drew: " + card);
                if (isBust()) {
                    System.out.println("Busted! Final score: " + getScore());
                    break;
                }
            } else if (choice.equals("S")) {
                System.out.println("You chose to stand at score: " + getScore());
                break;
            } else {
                System.out.println("Invalid input. Please type H or S.");
            }
        }
    }

    public void win(int bet) {
        System.out.println(name + " wins!");
        adjustBalance(bet * 2);
    }

    public void push(int bet) {
        System.out.println(name + " pushes.");
        adjustBalance(bet); // return original bet
    }

    public void lose() {
        System.out.println(name + " loses.");
        // bet already deducted earlier
    }
}
