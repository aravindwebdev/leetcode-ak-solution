public class SortedInsertion{
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
        head = SortedInsertNew(head, 5);
        printList(head);

    }
    public static Node SortedInsertNew(Node head, int data){
        Node new_node = new Node(data);
        if(head == null || head.data >= data ){
            new_node.next = head;
            return new_node;
        }
        Node curr = head;
        while(curr.next.data < data && curr.next != null){
            curr = curr.next;
        }
        new_node.next = curr.next;
        curr.next = new_node;
        return head;
    }

    public static Node SortedInsert(Node head, int data){
        Node new_node = new Node(data);
        if(head == null || head.next == null) return new_node = head;
        Node curr = head;
        int length = lengthNode(head);
        for(int i=0; i<length; i++){

            if(data < curr.data && data < curr.next.data){
                new_node.next = head;
                head = new_node;
                return head;
            }
            if(curr.next == null){
                curr.next = new_node;
                new_node.next = null;
                return head;
            } 
            if(curr.next.data < data && curr.next != null){
                curr = curr.next;
            }
            else{
                if(curr.next != null){
                new_node.next = curr.next;
                }
                curr.next = new_node;
                return head;
            }
        }
        return head;
    }

    public static int lengthNode(Node head){
        Node temp = head;
        int count = 0;
        while(temp != null){
            count++;
            temp = temp.next;
        }
        return count;
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
