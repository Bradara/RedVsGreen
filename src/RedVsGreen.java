import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RedVsGreen {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(", ");
        int x = Integer.parseInt(input[0]);
        int y = Integer.parseInt(input[1]);
        Grid grid = new Grid(x, y);
        input = br.readLine().split(", ");
        int targetX = Integer.parseInt(input[0]);
        int targetY = Integer.parseInt(input[1]);
        int turns = Integer.parseInt(input[2]);

        for (int i = 0; i < turns; i++) {
            grid.turn();
        }

        System.out.println(grid.getCellAt(targetX, targetY).getCounter());
    }
}
