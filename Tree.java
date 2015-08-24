public class Tree{

    private class node{

        private int key,value, count;
        node left, right;
    };
    private node root = null;

    public void insert(int key, int value){
        root = insert(root, key,value);
    }

    private node insert(node x, int key, int value){
        if(x == null){
             node s = new node();
             s.key = key;
             s.value = value;
             s.count = 1;
             s.left = null; s.right = null;
             return s;
        }
        else if(x.key > key) x.left = insert(x.left, key, value);
        else if(x.key < key) x.right = insert(x.right, key, value);
        else
          x.value = value;

       x.count = 1 + size(x.left) + size(x.right);
       return x; 
    }

    private int size(node x){
        if(x == null) return 0;
        return x.count;
    }

    public void inOrder(){
         inorder(root);
    }
    private void inorder(node x){
       if(x == null) return;
       inorder(x.left);
       System.out.println("key = "+ x.key + " value = "+ x.value+" count = "+x.count);
       inorder(x.right);
    }

    public void preOrder(){
        preorder(root);
    }
    private void preorder(node x){
       if(x == null) return;
       System.out.println("key = "+ x.key + " value = "+ x.value+" count = "+x.count);
       preorder(x.left);       
       preorder(x.right);
    }
    
    private node min( node x){
        if(x.left == null) return x;
        return min(x.left);
    }
    private node delMin(node x){
        if(x.left == null) return x.right;
        x.left = delMin(x.left);
        x.count = 1 + size(x.left) + size(x.right);
        return x;
    }

    void delete(int key){
        root = delete(root,key); 
    }

    private node delete(node x, int key){
        if(x == null) return null;
        else if(key < x.key) x.left = delete(x.left, key);
        else if(key > x.key) x.right = delete(x.right, key);
        else{
            if(x.left == null) return x.right;
            else if(x.right == null) return x.left;

            node t = x;
            x = min(x.right);
            x.right = delMin(t.right);
            x.left = t.left;
        }
            x.count = 1 + size(x.left) + size(x.right);
            return x;         
    }
}