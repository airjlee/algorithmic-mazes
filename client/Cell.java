public class Cell implements ICell {
    private boolean[] open;
    private boolean visted;
    private ICell[] adj;
    private int distanceFromStart;

    public Cell(){
        visted = false;
        open = new boolean[4];
        distanceFromStart = -1;
    }
    
    public void setDistance(int d){
        distanceFromStart = d;
    }
    
    public int getDistance(){
        return distanceFromStart;
    }

    //Letting the generated know if a cell had been visited or not
    public void setUnvisited(){
        visted = false;
    }
    public void setVisited(){
        visted = true;
    }
    public boolean getVisited(){
        return visted;
    }
    //changes a direction from a barrier (default) to a non barrier
    public void setOpen(Direction d){
        open[convDir(d)] = true;
    }
    //checking if a direction is a barrier or not
    public boolean canMove(Direction d){
        return open[convDir(d)];
    }
    //get an array of booleans indicating if the ordinal directions are open
    //NESW is what is intended
    public boolean[] getOpenArray(){
        return open;
    }
    //Sets the adjacent cells.
    //NESW is what is intended
    public void setAdj(ICell[] adj){
        this.adj = adj;
    }
    public ICell[] getAdj(){
        return adj;
    } 
    private int convDir(Direction d){
        return d == Direction.NORTH ? 0 : d ==  Direction.EAST ? 1 : d == Direction.SOUTH ? 2 : d == Direction.WEST ? 3 : -1;

    }
}