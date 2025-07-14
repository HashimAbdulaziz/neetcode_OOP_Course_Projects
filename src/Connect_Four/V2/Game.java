package Connect_Four.V2;

public class Game {

    public void play() {
        ConsoleInputService console = new ConsoleInputService();

        // Ask user for custom grid dimensions
        int rows = console.askForNumber("Enter number of rows:");
        int columns = console.askForNumber("Enter number of columns:");
        int connectN = console.askForNumber("Enter how many in a row to win (e.g., 4):");
        int targetScore = console.askForNumber("Enter the target score to win the game:");

        Grid grid = new Grid(rows, columns);
        Player[] players = {
                new Player("Player 1", GridPosition.YELLOW),
                new Player("Player 2", GridPosition.RED)
        };
        ScoreBoard scoreBoard = new ScoreBoard(players);

        GameController controller = new GameController(
                grid, players, connectN, targetScore, scoreBoard, console
        );
        controller.startGame();
    }
}
