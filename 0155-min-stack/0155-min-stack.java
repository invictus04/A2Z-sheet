class MinStack {

    private class Node {
        int val;
        int min;
        Node next;

        Node(int val, int min, Node next){
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }

    private Node head;

    public MinStack() {
        
    }
    
    public void push(int value) {
        if(head == null){
            head = new Node(value, value ,null);
        } else {
            head = new Node(value, Math.min(value,head.min),head);
        }
    }
    
    public void pop() {
        head = head.next;

    }
    
    public int top() {
        
        return head.val;
    }
    
    public int getMin() {
        return head.min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */