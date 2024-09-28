class Node{
    public int val;
    public Node next;
    public Node prev;

    public Node(int val, Node next, Node prev){
        this.val = val;
        this.next = next;
        this.prev = prev;
    }
}

class MyCircularDeque {
    Node head;
    Node rear;
    int size;
    int capacity;
    public MyCircularDeque(int k) {
        size=0;
        capacity = k;
    }
    
    public boolean insertFront(int value) {
        if(isFull()) return false;
        if(head == null){
            head = new Node(value,null,null);
            rear = head;
        } else {
            Node newHead = new Node(value,head,null);
            head.prev = newHead;
            head = newHead;
        }
        size++;
        return true;
    }
    
    public boolean insertLast(int value) {
        if(isFull()) return false;
        if(head == null){
            head = new Node(value,null,null);
            rear = head;
        } else {
            rear.next = new Node(value,null,rear);
            rear = rear.next;
        }
        size++;
        return true;
    }
    
    public boolean deleteFront() {
        if(isEmpty()) return false;
        if(size == 1){
            head = null;
            rear = null;
        }else {
            head = head.next;
        }
        size--;
        return true;
    }
    
    public boolean deleteLast() {
        if(isEmpty()) return false;
        if(size == 1){
            head = null;
            rear = null;
        } else {
            rear = rear.prev;
        }
        size--;
        return true;
    }
    
    public int getFront() {
        if(isEmpty()) return -1;
        return head.val;
    }
    
    public int getRear() {
        if(isEmpty()) return -1;
        return rear.val;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == capacity;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */