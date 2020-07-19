import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Grid{
    private int x;
    private int y;
    private Cell[][] matrix;
    private Cell[][] matrixClone;
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final ArrayList<Integer> changeConditionRed = new ArrayList<>(List.of(3, 6));
    private static final ArrayList<Integer> changeConditionGreen = new ArrayList<>(List.of(0, 1, 4, 5, 7, 8));

    public Grid(int x, int y) throws IOException {
        setX(x);
        setY(y);
        this.matrix = new Cell[x][y];
        this.initialize();
    }

    private void initialize() throws IOException {
        String line;
        int val;
        for (int i = 0; i < this.y; i++) {
            line = br.readLine();
            for (int j = 0; j < this.x; j++) {
                val = Integer.parseInt(String.valueOf(line.charAt(j)));
                matrix[j][i] = new Cell(j, i, val);
            }
        }
    }

    public boolean isGreenCell(int x, int y){
        return this.matrix[x][y].isGreen();
    }



//    Just for validation x in range < 1000 and > 0
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }


    public void turn(){
        this.matrixClone = new Cell[this.x][];
        for (int i = 0; i < this.x; i++) matrixClone[i] = Arrays.stream(matrix[i]).map(cell -> {
            try {
                return (Cell) cell.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            return cell;
        }).toArray(Cell[]::new);

        for (int i = 0; i < this.x; i++) {
            for (int j = 0; j < this.y; j++){
                this.nextGeneration(i, j);
            }
        }

        this.matrix = this.matrixClone;
    }

    private void nextGeneration(int x1, int y1){
        int countGreen = 0;

        for (int i = x1-1; i <= x1 + 1; i++) {
            if (i < 0 || i >= this.x) continue;
            for (int j = y1-1; j <= y1 +1; j++) {
                if (j < 0 || j >= this.y || (j == y1 && i == x1)) continue;
                if (this.matrix[i][j].isGreen()) countGreen++;
            }
        }

        if (this.isGreenCell(x1, y1)) {
            if (changeConditionGreen.contains(countGreen)) {
                this.matrixClone[x1][y1].changeColor();
            }
        } else if (changeConditionRed.contains(countGreen)) {
            this.matrixClone[x1][y1].changeColor();
        }

        if (matrixClone[x1][y1].isGreen()) matrixClone[x1][y1].getGreenCounter().increaseCounter();

    }

    public Cell getCellAt(int targetX, int targetY) {
        return this.matrix[targetX][targetY];
    }
}
