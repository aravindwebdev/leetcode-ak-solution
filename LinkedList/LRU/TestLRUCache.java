public class TestLRUCache{
    public static void main(String[] args) {
        System.out.println("LRU Cache");
        int size = 2;
        LRUCache cache = new LRUCache(size);
        
        cache.set(1,2);
        cache.set(2,3);
        cache.set(1,5);

        System.out.println("Cache value of 2: "+ cache.get(2));
        cache.set(3,4);
        cache.set(2,4);
        cache.set(4,5);
        System.out.println("Cache value of 2: "+ cache.get(2));

    }

}
