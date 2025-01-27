package com.tejas.day074;

class Node{
    int key;
    int value;
    Node next;
    Node prev;
    
    Node(int key,int value){
        this.key = key;
        this.value = value;
        this.next = null;
        this.prev = null;
    }
}
