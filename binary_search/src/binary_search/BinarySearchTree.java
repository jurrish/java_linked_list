package binary_search;

import java.util.Comparator;
import java.util.Iterator;

public class BinarySearchTree<T extends Comparable<T>> implements Iterable<T>
{
    //fields
    private Node root;
    private int size;

    public BinarySearchTree()
    {

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
            root = add(element, root);

        }
    }

    private Node add(T element, Node current)
    {
        //if we have a null current node, then we found an open spot
        if(current == null)
        {
            size++;
            return new Node(element);
        }

        //are we looking to the left and right
        int compare = current.data.compareTo(element);
        if(compare < 0) //current is smaller
        {
            current.right = add(element, current.right);
        }
        else if(compare > 0) //current is larger
        {
            current.left = add(element, current.left);
        }
        //current is equal
        return current;
    }

    //returns true if the element is found and removed otherwise returns false
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
    public Iterator<T> iterator() {
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
            //use the ternary operator  //avoid null pointer
            String dataString = (data == null) ? "null" : data.toString();
            String leftChild = (left == null) ? "null" : left.data.toString();
            String rightChild = (right == null) ? "null" : right.data.toString();

            return leftChild + "<----" + dataString + "----->" + rightChild;
        }
    }
}
