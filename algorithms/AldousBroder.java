import java.util.*;
import java.lang.Math;

public class AldousBroder extends Maze {
    private Random rand;

    public AldousBroder() {
        super();
        rand = new Random();
    }

    public AldousBroder(int a, int b) {
        super(a, b);
        rand = new Random();
    }

    public void generateMaze() {
        ICell[][] maze = getMaze();
        rand = new Random();
        int row = 0;
        int col = 0;
        while (!this.allVisited()){
            ICell[] cell = maze[row][col].getAdj();
            int dir = rand.nextInt(4);

            if(cell[dir] != null && (!cell[dir].getVisited())){
                cell[dir].setVisited();
                createLink(maze[row][col], cell[dir]);
            }

            if(dir == 0 && row != maze.length - 1) row += 1;
            if(dir == 1 && col != maze[0].length - 1) col += 1;
            if(dir == 2 && row != 0) row -= 1;
            if(dir == 3 && col != 0) col -= 1;

        }

    }
}