package Connect_Four.V2;


import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ScoreBoard {
    private Map<String, Integer> scores;

    public ScoreBoard(Player[] players) {
        scores = new HashMap<>();
        for (Player player : players) {
            scores.put(player.getName(), 0);
        }
    }

    public void incrementScore(String playerName) {
        scores.put(playerName, scores.getOrDefault(playerName, 0) + 1);
    }

    public int getScore(String playerName) {
        return scores.getOrDefault(playerName, 0);
    }

    public void resetScores() {
        scores.replaceAll((k, v) -> 0);
    }

    public void printScores() {
        System.out.println("Current Scores:");
        for (Map.Entry<String, Integer> entry : scores.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}


