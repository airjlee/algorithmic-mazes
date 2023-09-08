public class TextClient extends Dijkstra {
    public static void main(String[] args){
       //Text Binary Tree
       IMaze m = new Wilson();
       //System.out.println(m);
       m = new Wilson(5, 8);
       dijkstra(m);
       System.out.println(m);
    }
}