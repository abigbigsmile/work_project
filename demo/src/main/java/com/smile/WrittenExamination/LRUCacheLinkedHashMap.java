package com.smile.WrittenExamination;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheLinkedHashMap<K, V> extends LinkedHashMap<K, V> {

    private static final float DEFAULT_LOAD_FACTOR = 0.75f;
    private final int maxCapacity;


    // 下面两个方法是关键

    public LRUCacheLinkedHashMap(int maxCapacity){
        super(maxCapacity, DEFAULT_LOAD_FACTOR, true);
        this.maxCapacity = maxCapacity;
    }

    /**
     * LinkedHashMap有一个removeEldestEntry(Map.Entry eldest)方法，通过覆盖这个方法，加入一定的条件，满足条件返回true。当put进新的值方法返回true时，便移除该map中最老的键和值。
     * @param eldest
     * @return
     */
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > maxCapacity;
    }

    @Override
    public V get(Object key) {
        return super.get(key);
    }

    @Override
    public V put(K key, V value) {
        return super.put(key, value);
    }

    @Override
    public void clear() {
        super.clear();
    }

    @Override
    public int size() {
        return super.size();
    }

    public static void main(String[] args) {
        LRUCacheLinkedHashMap cache = new LRUCacheLinkedHashMap(3);
        cache.put(1, "one");
        cache.put(2, "two");
        cache.put(3, "three");
        cache.put(10, "ten");
        System.out.println(cache);
        System.out.println("test->"+cache.get(2));
        System.out.println(cache);
        cache.put(4, "four");
        System.out.println(cache);
        cache.put(1, "first");
        System.out.println(cache);
        cache.remove(3);
        System.out.println(cache);
    }


}
