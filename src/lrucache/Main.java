package lrucache;

import java.util.Scanner;

public class Main {
  
  private Scanner in;
  private LRUCache lruCache;
  
  Main(int size) {
    this.in = new Scanner(System.in);
    this.lruCache = new LRUCache(size);
  }
  
  private void get(int key) {
    this.lruCache.get(key);
  }
  
  private void set(int key, int val) {
    this.lruCache.set(key, val);
  }
  
  public void ask() {
    
    System.out.println("Menu");
    System.out.println("1. Get");
    System.out.println("2. Set");
    System.out.println("3. Display");
    System.out.println("Q. Quit");
    System.out.println("Enter choice: ");
    
    String input = in.next();
    
    if (input.equals("1")) {
      System.out.println("Enter the key: ");
      int key = in.nextInt();
      get(key);
    } else if (input.equals("2")) {
      System.out.println("Enter the key and value: ");
      int key = in.nextInt();
      int val = in.nextInt();
      set(key, val);
    } else if (input.equals("3")) {
      this.lruCache.display();
    } else if (input.equals("Q")) {
      System.exit(0);
    } else {
      ask();
    }
    ask();
  }

public static void main(String[] args) {
    
    System.out.println("Enter the cache size: ");
    Scanner in = new Scanner(System.in);
    int size = in.nextInt();
    
    Main m = new Main(size);
    m.ask();
    
  }


}
