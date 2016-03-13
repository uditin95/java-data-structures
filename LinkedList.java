class LinkedList<Item>
{
    private class node<Item>
	{
        Item info;
        node<Item> link;

        node(Item data){
            info = data;
            link = null;
        }
    }
    node<Item> start = null;

    public void insert(Item data)
	{
        node<Item> s = new node<Item>(data);
		
        if(start == null)
		{
            start = s;
        }
        else
		{
            node<Item> ptr = start;
			
            while(ptr.link != null)
                 ptr = ptr.link;
				 
            ptr.link = s;
        } 
    }

    public void insert(Item data, int pos)
	{
        int i = 1;
        node<Item> ptr = start;
        node<Item> s = new node<Item>(data);
		
        while(i++ != pos-1 && ptr.link != null)
            ptr = ptr.link;
			
        s.link = ptr.link;
        ptr.link = s;
    }

    public void delete(Item data)
	{
	
	    if(start.info == data)
		{
		    start = start.link;
			return;
		}
		
        node<Item> prev = null, ptr = start;
		
        while(ptr != null){
            if(ptr.info == data) break;
            else
			{
                prev = ptr;
				ptr = ptr.link;
            }
        }
        if(ptr != null){
           prev.link = ptr.link;
        }
        
    }

    public void reverse(){
        start = reverse(start);
    }

    private node<Item> reverse(node<Item> x){
	
        if(x == null || x.link ==  null) return x;

        node<Item> newStart = reverse(x.link);

        node<Item> t = x.link;
        t.link = x;
        x.link = null;

        return newStart;
    }
	
	public void display()
	{
	    display(start);
	}
	
	private void display(node<Item> x)
	{
	    if(x == null)
		    return;
		
		System.out.println(x.info);
		
		display(x.link);
	}
}