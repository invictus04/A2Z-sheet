class Task{
    int time;
    int count;
    Task(int time, int count){
        this.time = time;
        this.count= count;
    }
}
class Solution {
    public int leastInterval(char[] tasks, int n) {
        if(n == 0) return tasks.length;
        int time =0;
        int[] freq = new int[26];
        PriorityQueue<Task> pq = new PriorityQueue<>(
            new Comparator<Task>(){
                public int compare(Task t1, Task t2){
                    return -Integer.compare(t1.count,t2.count);
                }
            });
        for(char ch : tasks){
            freq[ch - 'A']++;
        }

        for(int i=0; i<26; i++){
            if(freq[i]>=1){
                pq.add(new Task(0,freq[i]));
            }
        }
        Queue<Task> q = new LinkedList<>();
        while(!pq.isEmpty() || !q.isEmpty()){
            if(!q.isEmpty() && time-q.peek().time>n){
                pq.add(q.remove());
            }

            if(!pq.isEmpty()){
                Task t = pq.remove();
                t.count--;
                t.time = time;
                if(t.count >0){
                    q.add(t);
                }
            }
            time++;
        }
    return time;
    }
}