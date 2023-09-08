
import java.util.*;
import java.lang.Math;

public class Sidewinder extends Maze {
    
    //private List<ICell> list;
    //private Random rand;
    
    public Sidewinder() {
        super();
        //rand = new Random(); 
        //list = new ArrayList<ICell>();
    }
    
    public Sidewinder(int a, int b) {
        super(a, b);
        //rand = new Random(); 
        //list = new ArrayList<ICell>();
    }
    
 
    public void generateMaze() {
        ICell[][] maze = getMaze();
        
        for (int row = 0; row < maze.length-1; row++) {
            List<ICell> temp = new ArrayList<>();
            temp.add(maze[row][0]);
            for (int col = 1; col < maze[0].length; col++) {
                if (Math.random() < 0.5) {
                    
                    ICell cell = temp.get((int)Math.floor(Math.random() * temp.size()));
                    createLink(cell, cell.getAdj()[2]);
                    temp.clear();
                    // create link to previous
                    // add to group
                } else {
                    // note: no link (wall)
                    // extend group downwards from a random cell in the group
                    // clear the group
                    // add the current cell to the new group (current cell isn't part of the old group)
                    
                    
                    createLink(maze[row][col-1], maze[row][col]);
                }
                temp.add(maze[row][col]);
            }
            
            ICell cell = temp.get((int)Math.floor(Math.random() * temp.size()));
            createLink(cell, cell.getAdj()[2]);
            temp.clear();
            // extend last group downwards
            
            
            /*for (int col = 0; col < maze[row].length; col++) {
            *temp.add(maze[row][col]);
                ICell current = maze[row][col];
                if (Math.random() < 0.5) {
                    if (col < maze[row].length - 1) {
                        createLink(current, maze[row][col + 1]);
                    } else {
                        createLink(current, temp.get((int)Math.floor(Math.random() * temp.size())));
                        temp.clear();
                    }
                } else {
                    if (row < maze.length - 1) {
                        createLink(current, maze[row + 1][col]);
                        temp.clear();
                    }
                }
            }
            temp.clear();*/
        }
        
        int nr = maze.length;
        for (int col = 1; col < maze[0].length; col++) {  // link bottom row
            createLink(maze[nr-1][col-1], maze[nr-1][col]);
        }
        
       

    }
}