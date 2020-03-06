import java.util.Hashtable;

public class LRUCache {
    class DLinkedList{
        private int key;
        private int value;
        private DLinkedList pre;
        private DLinkedList next;
        public DLinkedList(int key,int value){
            this.key = key;
            this.value = value;
            pre = null;
            next = null;
        }
    }

    private void add(DLinkedList node){
        node.next = head.next;
        node.next.pre = node;
        head.next = node;
        node.pre = head;

    }
    private void delete(DLinkedList node){
        DLinkedList pre = node.pre;
        DLinkedList next = node.next;

        pre.next = next;
        next.pre = pre;

    }
    private DLinkedList popTail(){
        DLinkedList node = tail.pre;
        delete(node);
        return node;

    }
    private void toHead(DLinkedList node){
        delete(node);
        add(node);
    }

    DLinkedList head,tail;
    int size;
    int capacity;
    Hashtable<Integer,DLinkedList> table ;
    public LRUCache(int capacity) {
        head = new DLinkedList(0,0);
        tail = new DLinkedList(0,0);
        size = 0;
        this.capacity = capacity;
        table = new Hashtable<>();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        DLinkedList node = table.get(key);
        if(node == null) return -1;
        else {
            toHead(node);
            return node.value;
}
    }

    public void put(int key, int value) {
        DLinkedList node = table.get(key);
        if(node == null){
            DLinkedList new_node = new DLinkedList(key,value);
            add(new_node);
            size++;
            table.put(key,new_node);
            if(size>capacity){
                DLinkedList toDelete = popTail();
                table.remove(toDelete.key);
                size--;
            }
        }else{
            node.value = value;
            toHead(node);
        }
    }

    public static void main(String[] args) {
        LRUCache test = new LRUCache(2);
        test.put(1,1);
        test.put(2,2);
        System.out.println(test.get(1));
        test.put(3,3);
        System.out.println(test.get(2));
    }
}
