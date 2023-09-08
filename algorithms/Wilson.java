import java.util.*;
public class Wilson extends Maze {
    public Wilson(){
        super();
    }

    public Wilson(int a, int b){
        super(a, b);
    }

    public void generateMaze(){
        ICell start = getRandomCell();
        start.setVisited();
        while(!allVisited()){
            start = getRandomCell();
            Stack<ICell> path = new Stack<>();
            ICell cell = null;
            while(cell == null){
                int rand = (int) (4 * Math.random());
                cell = start.getAdj()[rand];
            }
            while(!cell.getVisited()){
                if(path.contains(cell)){
                    while(path.peek() != cell){
                        path.pop();
                    }
                } else {
                    path.push(cell);
                }
                ICell last = cell;
                cell = null;
                while(cell == null){
                    int temp = (int) (4 * Math.random());
                    cell = last.getAdj()[temp];
                }
            }
            while(!path.isEmpty()){
                ICell temp = path.pop();
                temp.setVisited();
                createLink(cell, temp);
                cell = temp;
            }
        }
    }
}