import java.util.LinkedHashMap;
import java.util.Map;

class LRUCacheLHM<K, V> extends LinkedHashMap<K, V> {
    private final int capacity;

    public LRUCacheLHM(int capacity) {
        super(capacity, 0.75f, true); // true for access-order
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity;
    }

    public V get(K key) {
        return super.getOrDefault(key, null);
    }

    public void put(K key, V value) {
        super.put(key, value);
    }

    public static void main(String[] args) {
        LRUCacheLHM<Integer, String> cache = new LRUCacheLHM<>(3);
        cache.put(1, "one");
        cache.put(2, "two");
        cache.put(3, "three");
        System.out.println(cache); // Output: {1=one, 2=two, 3=three}

        cache.get(1); // Access key 1
        cache.put(4, "four"); // Add key 4, should remove key 2
        System.out.println(cache); // Output: {3=three, 1=one, 4=four}
    }
