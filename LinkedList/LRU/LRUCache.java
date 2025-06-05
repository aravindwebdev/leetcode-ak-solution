
import java.util.HashMap;

public class LRUCache{
    private HashMap<Integer, Node> map;
    private int capacity, count;
    Node head, tail;

    //Create object to initalize the values
    public LRUCache(int capacity){
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(0,0);
        tail = new Node(0,0);

        head.next = tail;
        tail.prev = head;
        head.prev = null;
        tail.next = null;
        count = 0;
    }

    public void addToHead(Node node){
        node.next = head.next;
        node.next.prev = node;
        node.prev = head;
        head.next = node;

    }
    public void deleteNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public int get(int key){
        if(map.get(key) != null){
            Node node = map.get(key);
            int value = node.value;
            deleteNode(node);
            addToHead(node);
            System.out.println("Key: "+key+" Value: "+value);
            return value;
        }else{
            System.out.println("Value not found for given key "+key);
        return -1;
        }
    }

    public void set(int key, int value){
        System.out.println("Set into key: "+key+" value: "+value);
        if(map.get(key) != null){
            System.out.println("HIT");
            Node node = map.get(key);
            node.value = value;
            deleteNode(node);
            addToHead(node);
        }else{
            Node node = new Node(key, value);
            map.put(key, node);
            if(count < capacity){
                count++;
                addToHead(node);
            }else{
                map.remove(tail.prev.key);
                deleteNode(tail.prev);
                addToHead(node);

            }
        }

    }

}
