import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {

    private int width;

    private boolean[][] grid;

    private boolean[][] copy;

    private long calculatedMoves = 0;

    private long minSteps;

    private List<int[]> steps;

    private List<int[]> bestSteps;

    public void chasingTheLights() {
        for (int i = 1; i < copy.length; i++) {
            for (int j = 0; j < copy[i].length; j++) {
                if (copy[i - 1][j] = true) {
                    toggleAi(i, j);
                    calculatedMoves++;
                }
            }
        }
    }

    public void calculateSteps() {
        calculatedMoves = 0;

    }

    public Game(int size) {
        init(size);
    }

    public void init(int size) {
        this.width = size;
        this.minSteps = Long.MAX_VALUE;
        this.steps = new ArrayList<>();
        this.bestSteps = new ArrayList<>();
        this.grid = new boolean[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = false;
            }
        }
        randomize();
        this.copy = new boolean[size][];
        copyBoard();
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

    public void toggleAi(int x, int y) {
        copy[x][y] = !copy[x][y];
        if (x < copy.length - 1) {
            copy[x + 1][y] = !copy[x + 1][y];
        }
        if (x > 0) {
            copy[x - 1][y] = !copy[x - 1][y];
        }
        if (y < copy.length - 1) {
            copy[x][y + 1] = !copy[x][y + 1];
        }
        if (y > 0) {
            copy[x][y - 1] = !copy[x][y - 1];
        }
    }

    public void toggle(int x, int y) {
        grid[x][y] = !grid[x][y];
        if (x < grid.length - 1) {
            grid[x + 1][y] = !grid[x + 1][y];
        }
        if (x > 0) {
            grid[x - 1][y] = !grid[x - 1][y];
        }

        if (y < grid.length - 1) {
            grid[x][y + 1] = !grid[x][y + 1];
        }
        if (y > 0) {
            grid[x][y - 1] = !grid[x][y - 1];
        }
    }

    public boolean isSolved() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    private void copyBoard() {
        int step = 0;
        for (boolean[] row : grid) {
            copy[step] = Arrays.copyOf(row, row.length);
            step++;
        }
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < copy.length; i++) {
            for (int j = 0; j < copy[i].length; j++) {
                if (copy[i][j]) {
                    s += "#";
                } else {
                    s += ".";
                }
            }
            s += "\n";
        }
        return s;
    }

    public boolean[][] getGrid() {
        return grid;
    }
}

