package com.smile.WrittenExamination;

import java.util.HashMap;

public class LRUCache<K, V> {

    class LRUNode{
        LRUNode pre;
        LRUNode next;
        Object key;
        Object value;

        public LRUNode(){};
        public LRUNode(Object key, Object value){
            this.key = key;
            this.value = value;
        }
    }

    private HashMap<K, LRUNode> hashMap;
    private int capacity;
    LRUNode head;
    LRUNode tail;

    public LRUCache(int capacity){
        this.capacity = capacity;
        this.hashMap = new HashMap<>(capacity);
    }

    public Object get(K key){
        LRUNode node = hashMap.get(key);
        if(node == null) return null;
        moveToHead(node);
        return node.value;
    }

    public void put(K key, V value){
        LRUNode node = this.hashMap.get(key); //判断是否已经存在key
        if(node == null){
            if(hashMap.size() >= this.capacity){
                hashMap.remove(tail.key);
                removeLastNode();
            }
            node = new LRUNode();
            node.key = key;
        }
        node.value = value;
        this.hashMap.put(key, node);
        moveToHead(node);
    }

    public Object remove(K key){
        LRUNode node = hashMap.get(key);
        if(node != null){
            if(node.next != null) node.next.pre = node.pre;
            if(node.pre != null) node.pre.next = node.next;

            if(node == head) head.next = node.next;
            if(node == tail) tail.pre = node.pre;

        }
        return this.hashMap.remove(key);
    }

    private void moveToHead(LRUNode node) {
        if(head==node) return; //原本就在表头
        //删除当前结点
        if(node.next != null) node.next.pre = node.pre;
        if(node.pre != null) node.pre.next = node.next;

        if(node == tail) tail = tail.pre;

        if(head == null || tail == null) {
            head = tail = node;
            return;
        }
        node.next = head;
        head.pre = node;
        head = node;
        head.pre = null;
    }

    public void removeLastNode(){
        if(tail != null){
            tail = tail.pre;
            if(tail != null) tail.next = null; //还存在结点
            else head = null;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        LRUNode pos = head;
        while(pos!= null){
            sb.append(pos.key + ":" + pos.value + "   ");
            pos = pos.next;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(16);
        cache.put(1, "one");
        cache.put(2, "two");
        cache.put(3, "three");
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




