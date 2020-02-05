import org.w3c.dom.Node;

public class Queue {
    QNode front, rear ;
    class QNode{
        int key;
        QNode next;
        public QNode(int key){
            this.key = key;
            this.next= null;

        }
    }


    public Queue()
    { this.front=this.rear=null;


    }
     void push(int key){
        QNode temp = new QNode(key);
        if(this.rear==null){
            this.front=this.rear= temp;
            return;
        }
        this.rear.next = temp;      // reserve space in memory for data inserted
        this.rear = temp;
    }
    void pop(){
        if(this.front==null){
            return;

        }
        QNode temp = this.front;
        this.front = this.front.next;
        if(this.front==null){
            this.rear=null;
        }
    }

}
