package Black_Jack;

import java.util.ArrayList;
import java.util.List;

public class Deck {

    private final List<Card> cards;
    private final Shuffler shuffler;

    public Deck(Shuffler shuffler) {
        this.cards = new ArrayList<>();
        this.shuffler = shuffler;
        initDeck();
    }

    private void initDeck() {
        cards.clear();
        for (CardSuit suit : CardSuit.values()) {
            for (CardRank rank : CardRank.values()) {
                cards.add(new Card(suit, rank));
            }
        }
        shuffleDeck();
    }

    public void shuffleDeck() {
        shuffler.shuffle(cards);
    }

    public Card drawCard() {
        if (cards.isEmpty()) {
            throw new IllegalStateException("Cannot draw from an empty deck.");
        }
        return cards.remove(cards.size() - 1);
    }

    public void resetDeck() {
        initDeck();
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }

    public int size() {
        return cards.size();
    }

    public List<Card> getCardsView() {
        return List.copyOf(cards);  // unmodifiable
    }

}
