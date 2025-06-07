public class SortedInsertionOptimized{
    static Node head = null;
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }
    public static void main(String[] args){
        System.out.println("Sorted Insertion");
        head = new Node(10);
        Node first = new Node(20);
        Node second = new Node(30);
        Node third = new Node(40);
        Node fourth = new Node(50);
        head.next = first;
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = null;

        System.out.println("Linked List:");
        printList(head);
        
        System.out.println("Sorted Insertion List:");
        head = SortedInsert(head, 55);
        printList(head);

    }

    public static Node SortedInsert(Node head, int data){
       
    }

    public static void printList(Node head){
        if(head == null) return;
        Node temp = head;
        while(temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}
