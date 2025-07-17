package Black_Jack;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
    responsibilities: tracking cards, scoring, checking bust.
 */

public class Hand {
    private final List<Card> cards = new ArrayList<>();


    public void addCard(Card card) {
        cards.add(card);
    }

    public int getScore() {
        int total = 0;
        int aceCount = 0;

        for (Card card : cards) {
            int value = card.getValue(); // usually 11 for Ace
            total += value;

            if (card.getRank() == CardRank.ACE) {
                aceCount++;
            }
        }

        // Reduce total by 10 for each Ace if we're over 21
        while (total > 21 && aceCount > 0) {
            total -= 10;
            aceCount--;
        }

        return total;
    }

    public boolean isBust() {
        return getScore() > 21;
    }

    public void resetHand() {
        cards.clear();
    }

    public List<Card> getCards() {
        return List.copyOf(cards);
    }

    public int size() {
        return cards.size();
    }

    @Override
    public String toString() {
        return cards.stream()
                .map(Card::getDisplayName)
                .collect(java.util.stream.Collectors.joining(", ")) +
                " (Score: " + getScore() + ")";
    }


    /*
        FOR FUTURE ENHANCEMENT:
        Will help Ai bot for calculation
     */
    public Map<CardRank, Long> getCardCounts() {
        return cards.stream()
                .collect(Collectors.groupingBy(Card::getRank, Collectors.counting()));
    }
}
