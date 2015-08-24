public class Queue{
    private class node{
        int data;
        node link;

        node(int k){ 
            data = k;
            link = null;
        }
    }
    private node front = null, rear = null;

    public void insert(int info){
        node s = new node(info);
        if(front == null && rear == null){
            front = rear = s;
        }
        else{
            rear.link = s;
            rear = s;
        }
    }

    public int delete(){
         node temp = front;
         front = front.link;
         return temp.data;
    }

    public void view(){
        node ptr = front;
        while(ptr != null){ System.out.print(ptr.data + " "); ptr = ptr.link; }
        System.out.println();
    }

}