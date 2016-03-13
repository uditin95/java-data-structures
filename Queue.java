import java.util.*;

public class Queue<Item> implements Iterable<Item> {
    private class node<Item>{
        Item data;
        node<Item> link;

        node(Item k){ 
            data = k;
            link = null;
        }
    }
    private node<Item> front = null, rear = null;
	
	public QueueIterator<Item> iterator()
	{
		return new QueueIterator<Item>(front);
		
	}
	private class QueueIterator<Item> implements Iterator<Item>
	{
		private node<Item> current;
		QueueIterator(node<Item> front)
		{
			current = front;
		}
		public boolean hasNext()
		{
			return current != null;
		}
		public void remove()
		{
		}
		public Item next()
		{
			if(!hasNext()) return null;
			node<Item> x = current;
			current = current.link;
			return x.data;
		}
	}

    public void insert(Item info){
        node<Item> s = new node<Item>(info);
        if(isEmpty()){
            front = rear = s;
        }
        else{
            rear.link = s;
            rear = s;
        }
    }
	
	public boolean isEmpty()
	{
	    return front == null;
	}

    public Item delete(){
	     
		 if(isEmpty()) return null;
		 
         Item temp = front.data;
         front = front.link;
         return temp;
    }

    public void view(){
        node<Item> ptr = front;
        while(ptr != null){ System.out.print(ptr.data + " "); ptr = ptr.link; }
        System.out.println();
    }

}