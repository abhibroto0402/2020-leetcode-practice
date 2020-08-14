import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ExpiringMap<K, V> {

    class MyObject<K, V> {
        K key;
        V value;
        long ttl;
        long createdtime;
        long exptime;

        public MyObject(K key, V value, long ttl, long createdtime) {
            this.key = key;
            this.value = value;
            this.ttl = ttl;
            this.createdtime = createdtime;
            this.exptime = createdtime + ttl;
        }
    }

    Map<K, MyObject<K, V>> mapStore = new HashMap<>();

    PriorityQueue<MyObject> min_heap = new PriorityQueue<>(10, (x, y) -> (int) (x.exptime - y.exptime));


    public void put(final K key, final V value, final long durationMs) {
        long curr = System.currentTimeMillis();
        MyObject obj = new MyObject(key, value, durationMs, curr);
        mapStore.put(key, obj);
        min_heap.add(obj);
    }

    public V get(final K key) {
        if (!mapStore.containsKey(key))
            return null;
        MyObject obj = mapStore.get(key);
        long curr = System.currentTimeMillis();
        if (Math.abs(curr - obj.createdtime) > obj.ttl) {
            mapStore.remove(key);
            return null;

        }
        return (V) obj.value;
    }

    public void expire() {
        long curr = System.currentTimeMillis();
        while (min_heap.peek().exptime > curr) {
            MyObject obj = min_heap.poll();
            if (mapStore.get(obj.key).equals(obj))
                mapStore.remove(obj.key);
        }
    }
}
