import org.w3c.dom.Node;

import java.util.LinkedList;

public class LinkedLists {
    Node head;

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public static LinkedLists insertNode(LinkedLists list, int data) {
        Node newNode = new Node(data);
        newNode.next = null;
        if (list.head == null) {
            list.head = newNode;
        } else {
            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = newNode;
        }
        return list;
    }
    public static void printList(LinkedLists lists){
        Node curNode = lists.head;
        System.out.println("Linked list :");
        while(curNode!= null){
            System.out.println(curNode.data + " ");
            curNode = curNode.next;
        }

    }
    public static LinkedLists deletebyKey(LinkedLists list, int key ){
        Node curNode = list.head, prev = null;

        if(curNode!=null && curNode.data==key){
            list.head = curNode.next;
            System.out.println("The found and key deleted " + key);
            return list;
        }
        while (curNode!=null && curNode.data!= key){
            prev = curNode;
            curNode = curNode.next;
        }
        if(curNode!=null){
            prev.next = curNode.next;
            System.out.println("The found and key deleted " + key);
        }
        if(curNode==null){
            System.out.println(key + " not found");
        }
        return list;

    }
}