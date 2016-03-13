public class Tree<Key extends Comparable,Value> 
{
    private class node<Key,Value>
	{
        private int count;
		Key key;
		Value value;
        node<Key,Value> left, right;
		node()
		{
		}
		node(Key key,Value value)
		{
			this.key = key;
			this.value = value;
			this.left = null; 
			this.right = null;
            this.count = 1;             
		}
    }
    private node<Key,Value> root = null;

    public void insert(Key key, Value value)
	{
        root = insert(root,new node<Key,Value>(key,value));
    }

    private node<Key,Value> insert(node<Key,Value> x, node<Key,Value> s)
	{	    
        if(x == null)
		{
            return s;
        }
		
		int cmp = x.key.compareTo(s.key);
		
        if(cmp > 0) x.left = insert(x.left,s);
        else if(cmp < 0) x.right = insert(x.right,s);
        else
          x.value = s.value;

       x.count = 1 + size(x.left) + size(x.right);
       return x; 
    }

    private int size(node<Key,Value> x)
    {
        if(x == null) return 0;
        return x.count;
    }

    public void inOrder(){
         inorder(root);
    }
    private void inorder(node<Key,Value> x){
       if(x == null) return;
       inorder(x.left);
       System.out.println("key = "+ x.key + " value = "+ x.value+" count = "+x.count);
       inorder(x.right);
    }

    public void preOrder(){
        preorder(root);
    }
	
    private void preorder(node<Key,Value> x){
       if(x == null) return;
       System.out.println("key = "+ x.key + " value = "+ x.value+" count = "+x.count);
       preorder(x.left);       
       preorder(x.right);
    }
	
	
	public void levelOrder(){
		levelOrder(root);
	}
	
	private void levelOrder(node<Key,Value> root)
	{
	    Queue<node> q = new Queue<node>();
		
		q.insert(root);		
		
		while(!q.isEmpty())
		{
		    node<Key,Value> t = q.delete();
			
			System.out.println("key = "+ t.key + " value = "+ t.value+" count = "+ t.count);
			
			if(t.left != null)
			    q.insert(t.left);
		    if(t.right != null)
			    q.insert(t.right);
			
		}
	}
	
	public void spiralOrder()
	{
	    spiralOrder(root);
    }
	
	private void spiralOrder(node<Key, Value> root)
	{
	    Queue<node> q = new Queue<node>();
		Stack<node> s = new Stack<node>();
		
		q.insert(root);
		
		while(!q.isEmpty() || !s.isEmpty())
		{
		    if(!q.isEmpty())
			{
			    node<Key,Value> t = q.delete();
				
				System.out.println("key = "+ t.key + " value = "+ t.value+" count = "+ t.count);
				
				if(t.left != null)
			        s.push(t.left);
		        if(t.right != null)
			        s.push(t.right);
			}
			
			else
			{
			    node<Key,Value> t = s.pop();
				
				System.out.println("key = "+ t.key + " value = "+ t.value+" count = "+ t.count);
				
				if(t.left != null)
			        q.insert(t.left);
		        if(t.right != null)
			        q.insert(t.right);
			}
		}
    }
    private node<Key,Value> min( node<Key,Value> x){
        if(x.left == null) return x;
        return min(x.left);
    }
    private node<Key,Value> delMin(node<Key,Value> x){
        if(x.left == null) return x.right;
        x.left = delMin(x.left);
        x.count = 1 + size(x.left) + size(x.right);
        return x;
    }

    void delete(Key key){
        root = delete(root,key); 
    }

    private node<Key,Value> delete(node<Key,Value> x, Key key)
	{
	    int cmp = x.key.compareTo(key);
		
        if(x == null) return null;		
		
        else if(cmp > 0) x.left = delete(x.left, key);
        else if(cmp < 0) x.right = delete(x.right, key);
        else{
            if(x.left == null) return x.right;
            else if(x.right == null) return x.left;

            node<Key,Value> t = x;
            x = min(x.right);
            x.right = delMin(t.right);
            x.left = t.left;
        }
            x.count = 1 + size(x.left) + size(x.right);
            return x;         
    }
}