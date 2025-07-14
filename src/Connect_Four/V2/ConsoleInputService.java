package Connect_Four.V2;

import java.util.Scanner;

public class ConsoleInputService {
    private Scanner input = new Scanner(System.in);


    // for getting (connectN & rows & columns & maxScore) from user
    public int askForNumber(String prompt) {
        System.out.print(prompt + " ");
        return input.nextInt();
    }

    public int askForMove(Player player, int maxColumn) {
        System.out.println(player.getName() + "'s turn");
        System.out.print("Enter column between 0 and " + (maxColumn - 1) + " to add piece: ");
        return input.nextInt();
    }

    public void printBoard(int[][] grid) {
        System.out.println("Board:");
        for (int[] row : grid) {
            for (int cell : row) {
                if (cell == GridPosition.EMPTY.ordinal()) System.out.print("0 ");
                else if (cell == GridPosition.YELLOW.ordinal()) System.out.print("Y ");
                else if (cell == GridPosition.RED.ordinal()) System.out.print("R ");
            }
            System.out.println();
        }
        System.out.println();
    }
}