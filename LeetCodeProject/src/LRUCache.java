import java.util.HashMap;


public class LRUCache {
	private HashMap<Integer,LRUNode> cacheMap;
	private int capacity;
	private int currentUsed;
	private LRUNode head;
	private LRUNode tail;
	
    public LRUCache(int capacity) {
        this.capacity = capacity;
        currentUsed = 0;
        cacheMap = new HashMap<Integer,LRUNode>();
        head = null;
        tail = null;
    }
    
    public int get(int key) {
    	if (cacheMap.containsKey(key)){
    		LRUNode node = cacheMap.get(key);
    		shiftNodeToHead(node);
    		return node.value;
    	}else{
    		return -1;
    	}
    }
    
    public void set(int key, int value) {
    	if (key == 5){
    		key = 5;
    	}
    	if (cacheMap.containsKey(key)){
    		LRUNode node = cacheMap.get(key);
    		shiftNodeToHead(node);
    		node.value = value;
    	}else{
    		if (currentUsed >= capacity){
    			cacheMap.remove(tail.key);
    			cacheMap.put(key, tail);
    			tail.key = key;
    			tail.value = value;
    			shiftNodeToHead(tail);
    		}else{
    			currentUsed++;
    			LRUNode newNode = new LRUNode(key, value);
    			cacheMap.put(key, newNode);
    			if (head == null){
    				head = newNode;
    				tail = head;
    			}else{
    				head.pre = newNode;
    				newNode.next = head;
    				head = newNode;
    			}
    		}
    	}
    }
    
    public void shiftNodeToHead(LRUNode node){
    	if (!node.equals(head)){
			node.pre.next = node.next;
			if (!node.equals(tail)){
				node.next.pre = node.pre;
			}else{
				tail = node.pre;
				tail.next = null;
			}
			head.pre = node;
			node.next = head;
			node.pre = null;
			head = node;
		}
    }
    
    public class LRUNode{
    	public int key;
    	public int value;
    	public LRUNode next;
    	public LRUNode pre;
    	
    	public LRUNode(int key, int value){
    		this.key = key;
    		this.value = value;
    	}
    }
    
    
    /*public static void main(String[] args){
    	LRUCache cache = new LRUCache(3);
    	cache.set(1, 1);
    	cache.printCacheMap();
    	cache.set(2, 2);
    	cache.printCacheMap();
    	cache.set(3, 3);
    	cache.printCacheMap();
    	cache.set(4, 4);
    	cache.printCacheMap();
    	System.out.println(""+cache.get(4));
    	cache.printCacheMap();
    	System.out.println(""+cache.get(3));
    	cache.printCacheMap();
    	System.out.println(""+cache.get(2));
    	cache.printCacheMap();
    	System.out.println(""+cache.get(1));
    	cache.printCacheMap();
    	cache.set(5, 5);
    	cache.printCacheMap();
    	System.out.println(""+cache.get(1));
    	cache.printCacheMap();
    	System.out.println(""+cache.get(2));
    	cache.printCacheMap();
    	System.out.println(""+cache.get(3));
    	cache.printCacheMap();
    	System.out.println(""+cache.get(4));
    	cache.printCacheMap();
    	System.out.println(""+cache.get(5));
    	cache.printCacheMap();
    }

	private void printCacheMap() {
		for (int key : cacheMap.keySet()){
			System.out.print(key+"="+cacheMap.get(key).value+" ");
		}
    	System.out.println("with head="+head.key+" and tail="+tail.key);
	}*/

}
