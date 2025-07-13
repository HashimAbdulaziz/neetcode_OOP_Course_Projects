package Connect_Four.V1;

class Main {
    public static void main(String[] args) {
        Grid grid = new Grid(6, 7);
        Game game = new Game(grid, 4, 3);
        game.play();
    }
}