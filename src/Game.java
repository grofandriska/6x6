public class Game {

    public boolean[][] grid;

    public Game(int size) {
        this.grid = new boolean[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = false;
            }
        }
    }

    public void randomize() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (Math.random() > 0.53) {
                    grid[i][j] = true;
                }
            }
        }
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j]) {
                    s += "#";
                } else {
                    s += ".";
                }
            }
            s += "\n";
        }
        return s;
    }

    public void toggle(int x, int y) {
        grid[x][y] = !grid[x][y];
    }



}
