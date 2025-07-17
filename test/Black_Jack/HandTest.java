package Black_Jack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HandTest {

    private Hand hand;

    @BeforeEach
    void setUp() {
        hand = new Hand();
    }

    @Test
    void handShouldStartEmpty() {
        assertEquals(0, hand.getCards().size());
    }

    @Test
    void addCardShouldIncreaseHandSize() {
        hand.addCard(new Card(CardSuit.HEARTS, CardRank.TWO));
        assertEquals(1, hand.size());
    }

    @Test
    void getScoreShouldReturnCorrectSumWithoutAces() {
        hand.addCard(new Card(CardSuit.SPADES, CardRank.EIGHT)); // 8
        hand.addCard(new Card(CardSuit.DIAMONDS, CardRank.KING)); // 10
        assertEquals(18, hand.getScore());
    }

    @Test
    void getScoreShouldHandleAceAs11WhenUnder21() {
        hand.addCard(new Card(CardSuit.CLUBS, CardRank.ACE));   // 11
        hand.addCard(new Card(CardSuit.HEARTS, CardRank.SIX));  // 6
        assertEquals(17, hand.getScore());
    }

    @Test
    void getScoreShouldConvertAceTo1WhenOver21() {
        hand.addCard(new Card(CardSuit.CLUBS, CardRank.ACE));   // 11 → becomes 1
        hand.addCard(new Card(CardSuit.HEARTS, CardRank.NINE)); // 9
        hand.addCard(new Card(CardSuit.SPADES, CardRank.FIVE)); // 5
        assertEquals(15, hand.getScore()); // 1 + 9 + 5
    }

    @Test
    void handIsBustShouldReturnTrueWhenScoreOver21() {
        hand.addCard(new Card(CardSuit.HEARTS, CardRank.KING)); // 10
        hand.addCard(new Card(CardSuit.DIAMONDS, CardRank.QUEEN)); // 10
        hand.addCard(new Card(CardSuit.CLUBS, CardRank.THREE)); // 3
        assertTrue(hand.isBust());
    }

    @Test
    void handIsBustShouldReturnFalseWhenScoreIs21OrLess() {
        hand.addCard(new Card(CardSuit.HEARTS, CardRank.KING)); // 10
        hand.addCard(new Card(CardSuit.DIAMONDS, CardRank.SEVEN)); // 7
        assertFalse(hand.isBust());
    }

    @Test
    void resetHandShouldClearAllCards() {
        hand.addCard(new Card(CardSuit.HEARTS, CardRank.FOUR));
        hand.resetHand();
        assertEquals(0, hand.size());
    }

    @Test
    void getCardCountsShouldReturnCorrectFrequencies() {
        hand.addCard(new Card(CardSuit.HEARTS, CardRank.ACE));
        hand.addCard(new Card(CardSuit.SPADES, CardRank.ACE));
        hand.addCard(new Card(CardSuit.CLUBS, CardRank.KING));

        assertEquals(2, hand.getCardCounts().get(CardRank.ACE));
        assertEquals(1, hand.getCardCounts().get(CardRank.KING));
    }
}
