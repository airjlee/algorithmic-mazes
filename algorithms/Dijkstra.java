 import java.util.*;
import java.lang.Math;

public class Dijkstra {
    public static void dijkstra(IMaze maze){
        setAllUnvisited(maze);
        dijkstra(maze, maze.getMaze()[0][0]);
    }

    public static void dijkstra(IMaze maze, ICell start){
        ((Cell) start).setDistance(0);
        ICell[] adj = start.getAdj();
        start.setVisited();
        for(int i = 0; i<4; i++){
            dijkstra(adj[i], 0, start.getOpenArray()[i]);
        }
    }

    public static void dijkstra(ICell current, int level, boolean open){
        if(current == null || !open || ((Cell) current).getDistance() > 0 || current.getVisited())return;
        ((Cell) current).setDistance(level + 1);
        for(int i = 0; i<4; i++){
            dijkstra(current.getAdj()[i], level + 1, current.getOpenArray()[i]);
        }
    }

    public static void resetDistances(IMaze[][] maze){
        for(int row = 0; row<maze.length; row++){
            for(int col = 0; col<maze[0].length; col++){
                if(maze[row][col] != null){
                    ((Cell) maze[row][col]).setDistance(-1);
                }
            }
        }
    }
    
    
    private static void setAllUnvisited(IMaze maze){
        ICell[][] temp = maze.getMaze();
        for(int row = 0; row<temp.length; row++){
            for (int col = 0; col<temp[0].length; col++){
                temp[row][col].setUnvisited();
            }
        }
    }
    
     

}