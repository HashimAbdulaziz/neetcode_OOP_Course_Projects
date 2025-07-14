package Connect_Four.V2;

public class GameController {
    private Grid grid;
    private Player[] players;
    private int connectN;
    private int targetScore;
    private ScoreBoard scoreBoard;
    private ConsoleInputService console;


    public GameController(Grid grid, Player[] players, int connectN, int targetScore,
                          ScoreBoard scoreBoard, ConsoleInputService console) {
        this.grid = grid;
        this.players = players;
        this.connectN = connectN;
        this.targetScore = targetScore;
        this.scoreBoard = scoreBoard;
        this.console = console;
    }

    // Handles playRound which Handles playMove
    public void startGame() {
        int maxScore = 0;
        Player roundWinner = null;

        while (maxScore < targetScore) {
            roundWinner = playRound();
            System.out.println(roundWinner.getName() + " won the round");

            int score = scoreBoard.getScore(roundWinner.getName());
            maxScore = Math.max(score, maxScore);

            grid.initGrid(); // reset for next round
        }

        System.out.println(roundWinner.getName() + " won the game!");
    }

    // handle the whole Round (Loop of calling playMove)
    private Player playRound() {
        while (true) {
            for (Player player : this.players) {
                int[] pos = playMove(player);
                int row = pos[0];
                int col = pos[1];
                GridPosition pieceColor = player.getPieceColor();
                WinChecker checker = new WinChecker(this.grid.getGrid());
                if (checker.checkWin(this.connectN, row, col, pieceColor)) {
                    scoreBoard.incrementScore(player.getName());
                    return player;
                }
            }
        }
    }

    // handle playing single move
    private int[] playMove(Player player) {
        console.printBoard(this.grid.getGrid());    // Prints Board and
        // Prints player's turn and return the chosen column
        int moveColumn = console.askForMove(player, this.grid.getColumnCount());
        int moveRow = this.grid.placePiece(moveColumn, player.getPieceColor());
        return new int[] { moveRow, moveColumn };
    }
}
