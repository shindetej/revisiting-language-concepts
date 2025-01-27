package com.tejas.day074;

import java.util.HashMap;
import java.util.Map;

class LRUCache {
    // Constructor for initializing the cache capacity with the given value.
    private int capacity;
    private Map<Integer,Node> map;
    private Node head;
    private Node tail;
    
    
    LRUCache(int cap) {
        this.capacity= cap;
        this.map = new HashMap<>();
        this.head = new Node(-1,-1);
        this.tail = new Node(-1,-1);
        this.head.next = this.tail;
        this.tail.next = this.head;
    }

    // Function to return value corresponding to the key.
    public  int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        
        Node node = map.get(key);
        remove(node);
        
        add(node);
        return node.value;
    }

    // Function for storing key-value pair.
    public  void put(int key, int value) {
       if(map.containsKey(key)){
           Node old = map.get(key);
           remove(old);
       }
       
       Node node = new Node(key,value);
       
       map.put(key,node);
       add(node);
       
       if(map.size() > capacity){
           Node lr = tail.prev;
           remove(lr) ;
           map.remove(lr.key);
       }
      
    }
    
    private void add(Node node){
        Node nextNode = head.next;
        head.next =node;
        node.prev= head;
        node.next = nextNode;
        nextNode.prev = node;
    }
    
    private void remove(Node node){
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }
}
