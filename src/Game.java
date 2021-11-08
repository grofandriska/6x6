import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {

    private int width;

    private boolean[][] grid;

    private boolean[][] copy;

    private long minSteps;

    private List<int[]> steps;

    private List<int[]> bestSteps;

    public Game(int size) {
        init(size);
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

    public boolean isSolved() {
        for (int i = 0; i < copy.length; i++) {
            for (int j = 0; j < copy[i].length; j++) {
                if (copy[i][j]) {
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

    public void toggleCell(int x, int y) {
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
        steps.add(new int[] { x, y });
    }

    public void chasingTheLights() {
        for (int i = 1; i < copy.length; i++) {
            for (int j = 0; j < copy[i].length; j++) {
                if (copy[i - 1][j] == true) {
                    toggleCell(i, j);
                }
            }
        }
    }

    public void calculateSteps() {
        int indexMarker = 0; // --> ez volt az "xx" 🙂
        int[] counters = new int[width];

        // setting counters acc to width
        for (int i = 0; i < counters.length; i++) {
            counters[i] = i;
        }

        int currentIndex = 0;
        do {
            steps.clear();
            copyBoard();
            for (int i = 0; i <= indexMarker; i++) { // toggle bottom lights per current variation of counters
                toggleCell(0, counters[i]);
            }
            chasingTheLights();
            // checking state after Chasing of Ligths and if it is correct state
            // and this is a best move then store the steps
            if (isSolved()) {
                if (steps.size() < minSteps) {
                    minSteps = steps.size();
                    bestSteps = List.copyOf(steps);
                }
            }

            // stepping the counters
            boolean successed = false;
            do {
                if (currentIndex == indexMarker) {
                    if (counters[currentIndex] < this.width - 1) {
                        counters[currentIndex]++;
                        successed = true;
                        currentIndex = 0;
                    } else {
                        counters[currentIndex] = currentIndex;
                        for (int i = 0; i < indexMarker; i++) {
                            counters[i] = i;
                        }
                        currentIndex = 0;
                        indexMarker++;
                        successed = true;
                    }
                } else if (counters[currentIndex] + 1 < counters[currentIndex + 1]) {
                    counters[currentIndex]++;
                    successed = true;
                    currentIndex = 0;
                } else {
                    counters[currentIndex] = currentIndex;
                    currentIndex++;
                    successed = false;
                }
            } while (!successed);

        } while (indexMarker < width);

    }

    public List<int[]> getBestSteps() {
        return bestSteps;
    }

    @Override
    public String toString() {
        String s = "";
        for (int y = 0; y < copy.length; y++) {
            for (int x = 0; x < copy[y].length; x++) {
                if (copy[y][x]) {
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