public class FindMiddleTwoPointer{
    static Node head = null;
    static class Node{
        int data;
        Node next;
        Node(int d){
            this.data = d;
        }
    }

    public static void main(String args[]){
        System.out.println("Linked list");
        head = new Node(10);
        Node first = new Node(5);
        Node second = new Node(20);
        Node third = new Node(15);
        Node fourth = new Node(25);
        Node fifth = new Node(30);
        head.next = first;
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;

        System.out.println("List:");
        printList(head);

        int middle = findMiddle(head);
        System.out.println("middle: " + middle);
    }

    public static int findMiddle(Node head){
        Node slow = head;
        Node fast = head;
        while(slow !=null && fast !=null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.data;
    }

    public static void printList(Node head){
        Node temp = head;
        while(temp !=null){
            System.out.println(temp.data);
            temp = temp.next;
        }
        
    }
}
