public class StackTester {
    public static void main(String[]args){
        Stacks stacks = new Stacks();
        stacks.push(11);
        stacks.push(22);
        stacks.push(33);
        stacks.push(44);
        System.out.println("Before using pop");
        stacks.display();
        stacks.pop();
        System.out.println("After using pop ");
        stacks.display();
    }
}
