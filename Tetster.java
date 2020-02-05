public class Tetster {
    public static void main(String[]args){
        LinkedLists linkedLists = new LinkedLists();
        linkedLists = LinkedLists.insertNode(linkedLists,1);
        linkedLists = LinkedLists.insertNode(linkedLists,2);
        linkedLists = LinkedLists.insertNode(linkedLists,3);
        linkedLists = LinkedLists.insertNode(linkedLists,4);
        linkedLists = LinkedLists.insertNode(linkedLists,5);
        linkedLists = LinkedLists.insertNode(linkedLists,6);
        linkedLists = LinkedLists.insertNode(linkedLists,7);
        linkedLists = LinkedLists.insertNode(linkedLists,8);
        LinkedLists.deletebyKey(linkedLists,6);
        LinkedLists.printList(linkedLists);
    }
}
