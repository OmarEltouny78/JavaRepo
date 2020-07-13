public class TraversalExample {
    public static <E> void printPreOrder(AbstractTree<E> tree){
        if(tree.root()==null)return;
        System.out.println(tree.root().getElement());
    }
    public static <E> void printPreorderIndent(AbstractTree<E>T,Positions<E>p,int n){
        printPreOrder(T);
        spaces(n);

    }
    public static String spaces(int n){
            StringBuilder stringBuilder=new StringBuilder();
            for(int j=0;j<n;j++){
                stringBuilder.append(' ');
            }
            return stringBuilder.toString();
    }
}
