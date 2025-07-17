package Black_Jack;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class FisherYatesShuffler implements Shuffler {
    @Override
    public void shuffle(List<Card> cards) {
        for (int i = cards.size() - 1; i > 0; i--) {
            int j = ThreadLocalRandom.current().nextInt(0, i + 1);
            Collections.swap(cards, i, j);
        }

        // Equivalent to this:
        //Collections.shuffle(cards);
    }
}
