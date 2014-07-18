package lrucache;

import java.util.HashMap;

public class LRUCache implements CacheInterface {
  
  private HashMap<Integer, Node> keyHash;
  private int size;
  private Node head;
  private Node tail;
  
  public LRUCache(int size) {
    this.size = size;
    this.keyHash = new HashMap<Integer, Node>();
    this.head = null;
    this.tail = null;
  }
  
  private void insertEnd(Node node) {
    if (head == null) {
      this.head = node;
      this.tail = node;
      return;
    }
    
    node.prev = tail;
    tail.next = node;
    this.tail = node;
  }
  
  private void deleteBeg() {
    if (head == null)
        return;
    
    if (head.next == null) {
      keyHash.remove(head.key);
      this.head = null;
      return;
    }
    
    Node node = head;
    node.next.prev = null;
    this.head = node.next;
    node.next = null;
    keyHash.remove(node.key);
  }
  
  private void deleteNode(Node node) {
    if (node == head)
      deleteBeg();
    else {
      node.next.prev = node.prev;
      node.prev.next = node.next;
      node.next = null;
      node.prev = null;
      keyHash.remove(node.key);
    }
    
  }
  
  public void display() {
    Node node = head;
    if (node == null) {
      System.out.println("Empty!!");
    }
    while (node != null) {
      System.out.println(node.value);
      node = node.next;
    }
  }
  
  public void get(int key) {
    if (keyHash.size() == 0) {
      System.out.println("Empty cache");
      return;
    } 
    
    if (keyHash.containsKey(key)) {
      Node node = keyHash.get(key);
      System.out.println("Valus is: " + node.value);
      if (node != tail) {
        deleteNode(node);
        insertEnd(node);
        keyHash.put(key, node);
      }
    } else {
      System.out.println("Key not found");
    }
  }
  
  public void set(int key, int val) {
    Node hashNode = keyHash.get(key);
    Node node = new Node(key, val);
    if (hashNode != null) {
      deleteNode(hashNode);
    }
    if (keyHash.size() == size) {
      deleteBeg();
    }
    insertEnd(node);
    keyHash.put(key, node);
  }

}
