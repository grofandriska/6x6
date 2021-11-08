import java.util.ArrayList;
import java.util.List;

public class Game {

    private int width;

    private boolean [][] grid;

    private boolean [][] copy;

    private long calculatedMoves = 0;

    private long minSteps;

    private List<int[]> steps;

    private List<int[]> bestSteps;

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

    public void calculateSteps(){
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
            }
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
        s+="\n";
        s+="\n";

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

        copy[2][0] = !copy[2][0];
        System.out.println(grid.length);
        return s;
    }

    public boolean[][] getGrid() {
        return grid;
    }

    public void setGrid(boolean[][] grid) {
        this.grid = grid;
    }

    public boolean[][] getCopy() {
        return copy;
    }

    public void setCopy(boolean[][] copy) {
        this.copy = copy;
    }

    public long getCalculatedMoves() {
        return calculatedMoves;
    }

    public void setCalculatedMoves(long calculatedMoves) {
        this.calculatedMoves = calculatedMoves;
    }

    public long getMinSteps() {
        return minSteps;
    }

    public void setMinSteps(long minSteps) {
        this.minSteps = minSteps;
    }

    public List<int[]> getSteps() {
        return steps;
    }

    public void setSteps(List<int[]> steps) {
        this.steps = steps;

    }
}
