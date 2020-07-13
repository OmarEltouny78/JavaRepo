import java.util.Stack;

public class ExpressionTrees {
    public class Node{
        char value;
        Node left,right;

        public Node(char value) {
            this.value = value;
            left=right=null;
        }
    }
   public boolean checkOp(char c){
        if(c=='+'||c=='-'||c=='*'||c=='/')
            return true;
        return false;
    }
    public void inOrder(Node t){
        if(t!=null){
            inOrder(t.left);
            System.out.print(t.value + " ");
            inOrder(t.right);
        }
    }
    public Node createTree(char post[]){
        Stack<Node>stack=new Stack<>();
        Node t = null,t1,t2;
        for (int i = 0; i <post.length ; i++) {
            if(!checkOp(post[i])){
                t=new Node(post[i]);
                stack.push(t);
            }else{
                t1=stack.pop();
                t2=stack.pop();
                t.right=t1;
                t.left=t2;
                stack.push(t);

            }

        }
        t=stack.peek();
        stack.pop();
        return t;
    }
}
