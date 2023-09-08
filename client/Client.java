public class Client {
    public static void main(String[] args){
       IMaze m = new BinaryTree();
       System.out.println(m);
       m = new BinaryTree(5, 8);
       System.out.println(m);
    }
}