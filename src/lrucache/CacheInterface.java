package lrucache;

interface CacheInterface {
  
  public void get(int key);
  public void set(int key, int val);
  public void display();

}
