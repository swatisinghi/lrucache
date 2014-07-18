package lrucache;

public class Node {
  int value;
  int key;
  Node prev;
  Node next;
  
  public Node(int key, int val) {
    this.key = key;
    this.value = val;
    this.prev = null;
    this.next = null;
  }
}
