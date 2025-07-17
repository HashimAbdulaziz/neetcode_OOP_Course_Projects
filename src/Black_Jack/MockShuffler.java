package Black_Jack;

import java.util.List;

public class MockShuffler implements Shuffler {
    @Override
    public void shuffle(List<Card> cards) {
        // No shuffle (used for deterministic tests)
    }
}