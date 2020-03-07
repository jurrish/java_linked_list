package trees;

import java.util.Iterator;

public class BinarySearchTrees<T extends Comparable<T>> implements Iterable<T>
{
    //fields
    private Node root;
    private int size;

    public BinarySearchTrees()
    {
        //do nothing
    }
    //basic methods
    public void add(T element)
    {
        //empty tree?
        if(root == null)
        {
            root = new Node(element);
            size++;
        }
        else
        {
            //we need to recursively find the position of our new element
            //as we move down the tree, we will return each node as we encounter it and
            // reassign our pointer/root as the result of our add method
            root = add(element, root);
        }
    }

    //this is a helper method - we need to keep track of where we're at! (current node as an argument)
    private Node add(T element, Node current)
    {
        //if we have an empty null current node, we have an open spot
        //base case
        if(current == null)
        {
            size++;
            return new Node(element);
        }

        //use comparable - are we looking to the left and right?
        int compare = current.data.compareTo(element);  //returns negative, positive, or zero

        if(compare < 0) //current is smaller - look to the right
        {
            current.right = add(element, current.right);
        }
        else if(compare > 0) //current is larger - look to the left
        {
            current.left = add(element, current.left);
        }
        //in all cases
        return current;
    }

    //returns TRUE if the element is found and removed, otherwise returns FALSE
    public boolean remove(T element)
    {
        return true;
    }

    public boolean contains(T element)
    {
        return true;
    }

    public int size()
    {
        return 0;
    }

    public boolean isEmpty()
    {
        return true;
    }

    public void clear()
    {

    }

    @Override
    public Iterator<T> iterator()
    {
        //auto generated method stub
        return null;
    }

    //binary tree node
    private class Node
    {
        private T data;
        private Node left;
        private Node right;

        public Node(T data)
        {
            this.data = data;
        }

        public String toString()
        {
            //ternary operator
            //if data ==null, dataString = "null", or it equals data.toString() if it's not null
            String dataString = (data == null) ? "null" : data.toString(); //prevents null pointer because if it's null, it prints string "null"
            String leftChild = (left == null) ? "null" : left.data.toString();
            String rightChild = (right == null) ? "null" : right.data.toString();

            return leftChild + " <-- " + dataString + " --> " + rightChild;
        }
    }
}
