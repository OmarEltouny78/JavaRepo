public class Main {
    public static void main(String[]args){
        LinkedBinaryTree<Integer> integers=new LinkedBinaryTree<>();
        Positions<Integer>p=integers.addRoot(5);
        integers.addLeft(p,2);
        integers.addRight(p,7);
        for (int e:integers
             ) {
            System.out.println(e);

        }
    }
}
