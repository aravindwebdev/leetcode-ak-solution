
class CircularLinkedList{
    static Node head;
    static class Node{
        int data;
        Node next;
        Node(int d){
            this.data = d;
        }
    }

    public static void main(String args[]){
        System.out.println("Circular Linked List");
         Node head = new Node(10); //head.next = head;
        Node first = new Node(20);
        Node second = new Node(30);
        head.next = first;
        first.next = second;
        second.next = head;

        System.out.println("List:");
        printList(head);

        System.out.println("Insertion at Begin");
        head = insertBegin(head,5);
        System.out.println("Successfully inserted at Begin");
        printList(head);


        System.out.println("Insertion at Last");
        head = insertLast(head,35);
        System.out.println("Successfully inserted at Last");

        printList(head);

       // System.out.println("Deletion at First");
       // head = deleteFirst(head);
       // System.out.println("Successfully Deleted at First");

        System.out.println("Delete Kth Node");
        head = deleteK(head,4);
        System.out.println("Deleted kth Node");
        printList(head);

    }

    static Node insertBegin(Node head, int data){
        //Method 2 - 0(1) - insert at head.next and swap it
        Node new_node = new Node(data);
        if(head == null) return new_node.next = new_node;

        new_node.next = head.next; 
        head.next = new_node;
        int t = head.data;
        head.data = new_node.data;
        new_node.data = t;
        return head;

       /* Node new_node = new Node(data);
        if(head == null) return new_node.next = new_node;

        Node curr = head;
        while(curr.next != head){
            curr = curr.next;
        }
        curr.next = new_node;
        new_node.next = head; */

        // return new_node;
    }

    static Node insertLast(Node head, int data){
      /*  Node new_node = new Node(data);
        if(head == null) return new_node.next = new_node;
        Node curr = head;
        while(curr.next != head){
            curr = curr.next;
        }
        new_node.next = head;
        curr.next = new_node;

        return head; */

        //O(1)
        Node new_node = new Node(data);
        if(head == null) return new_node.next = new_node;
        new_node.next = head.next;
        head.next = new_node;
        int t = head.data;
        head.data = new_node.data;
        new_node.data = t;
        return new_node;

    }

    static Node deleteFirst(Node head){
        if(head == null || head.next == head) return head;
        //Node curr = head;
        // while(curr.next != head){
        //     curr = curr.next;
        // }
        // curr.next = head.next;
        // head = curr.next;
        // return head;
        head.data = head.next.data;
        head.next = head.next.next;

        return head;

    }

    static Node deleteK(Node head, int k){
        if(k==0) return head;
        if(k == 1){
            System.out.println("k=1");
            head.data = head.next.data;
            head.next = head.next.next;
            return head;
        }
        Node curr = head;
        for(int i=1; i<k-1 && curr!=null; i++){
            curr = curr.next;
        }
        curr.next = curr.next.next;
        return head;

    }

    static void printList(Node head){    
        //Method -1 by me
        Node temp = head;
        if(head == null) return;
        do{
            System.out.println(temp.data);
            temp = temp.next;
        }
        while(temp != null && temp != head);

        // Method -2
        // if (head == null) return;
        // System.out.println(head.data);
        // for(Node curr = head.next; curr != head; curr = curr.next){
        //     System.out.println(curr.data);
        // }
    }
}
