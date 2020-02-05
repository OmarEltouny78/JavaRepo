public class QueueTester {
    public static void main(String[] args)
    {
        Queue q = new Queue();
        q.push(10);
        q.push(20);
        q.pop();
        q.pop();
        q.push(30);
        q.push(40);
        q.push(50);
        q.pop();
        System.out.println("Queue Front : " + q.front.key);
        System.out.println("Queue Rear : " + q.rear.key);
    }
}
