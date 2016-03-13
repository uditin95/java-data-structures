public class Stack<Item>
{
    private class node<Item>
	{
	    Item data;
		node<Item> next;
		
		node(Item data)
		{
		    this.data = data;
			next = null;
		}
    }
	
	private node<Item> top = null;
	
	public Item pop()
	{
		if(isEmpty())
		{
		    return null;
		}
		
		node<Item> t = top;
		
        top = top.next;
		
		return t.data;
		
	}
	public void push(Item x)
	{
		if(isEmpty())
		    top = new node<Item>(x);
		else{
		    node<Item> t = new node<Item>(x);
			
			t.next = top;
			top = t;
		}
		    
	}
	
	public void seek()
	{
		System.out.println(top.data);
	}
	
	public boolean isEmpty()
	{
		return top == null;
	}
}
