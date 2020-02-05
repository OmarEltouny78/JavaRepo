public class Stacks {
    class Node{
        int data;
        Node link;
    }
    Node top;

    public Stacks() {
        this.top = null;
    }
    public void push(int x){
        Node temp = new Node();
        if(temp==null){
            return;
        }
        temp.data = x;
        temp.link = top;
        top = temp;

    }
    public void pop(){
        if(top==null){
            return;
        }
        top = (top).link;
    }
    public void display(){
        if(top==null){
            return;
        }
        else{
            Node temp = top;
            while(temp!=null){
                System.out.println(temp.data);
                temp = temp.link;
            }
        }
    }
}
