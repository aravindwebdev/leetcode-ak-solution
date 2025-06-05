class FindKthPosition{
        int getKthFromLast(Node head, int k) {
        // Your code here - Reversing list method-1
        if(head == null) return -1;
        if (head.next == null && k == 1) return head.data;
        else if(head.next == null && k > 1) return -1;
        
        Node node = null;
        while(head != null){
            Node temp = head.next;
            head.next = node;
            node = head;
            head = temp;
        }
        Node curr = node;
        
       for(int i=1; i<k && curr!=null; ++i){
           curr = curr.next;
       }
       if(curr!=null) return curr.data;
       return -1;
        
    }

    //method 2 - N-length
        int getKthFromLast(Node head, int k) {
        // Your code here
        int len = 0;
        
        Node temp = head;
        while(temp != null){
            len++;
            temp = temp.next;
        }
        
        if(len < k) return -1;
        temp = head;
        
        for(int i=1; i<(len-k+1); i++){
            temp = temp.next;
        }
        return temp.data;
    }

    //Method 3 - two pointer Optimized
    int getKthFromLast(Node head, int k) {
        if(head == null) return -1;
        Node first = head;
        Node second = head;
        
        for(int i=0; i<k; i++){
            if(first == null){
                return -1;
            }
            first = first.next;
        }
    
        while(first != null){
            first = first.next;
            second = second.next;
        }
        return second.data;
    }

    //Method 3 - two pointer Optimized solution 2 by ninja
    int getKthFromLast(Node head, int k) {
        Node res = new Node(0,head);
        Node dummy = res;
        
        for(int i=0; i<k; i++){
            if(first == null){
                return -1;
            }
            first = first.next;
        }
    
        while(first != null){
            first = first.next;
            second = second.next;
        }
        return second.data;
    }
}
