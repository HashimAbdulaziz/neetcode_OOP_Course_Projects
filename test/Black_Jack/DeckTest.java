package Black_Jack;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DeckTest {

    @Test
    public void testDrawCardWithMockShuffler() {
        Shuffler mockShuffler = new MockShuffler();
        Deck deck = new Deck(mockShuffler);

        // Because mock shuffler does not shuffle, the last card drawn is always the last added one
        Card drawn = deck.drawCard();

        assertNotNull(drawn);
        assertEquals(CardRank.ACE, drawn.getRank());
        assertEquals(CardSuit.SPADES, drawn.getSuit());
    }

    @Test
    public void testDeckSizeAfterDraw() {
        Deck deck = new Deck(new MockShuffler());
        int initialSize = deck.size();
        deck.drawCard();
        assertEquals(initialSize - 1, deck.size());
    }

    @Test
    public void testResetDeckRestoresFullSize() {
        Deck deck = new Deck(new MockShuffler());
        deck.drawCard();
        deck.resetDeck();
        assertEquals(52, deck.size());
    }

    @Test
    public void testDrawFromEmptyDeckThrowsException() {
        Deck deck = new Deck(new MockShuffler());
        // Draw all cards
        for (int i = 0; i < 52; i++) deck.drawCard();
        assertThrows(IllegalStateException.class, deck::drawCard);
    }
}
