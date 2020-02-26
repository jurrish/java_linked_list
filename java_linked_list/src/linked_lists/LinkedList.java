package linked_lists;

public class LinkedList
{
    //todo :      [head]->[data|node.next]->[data|node.next]->null

    //store head directly w.linkedlist
    private Node head;
    private int size = 0;

    public LinkedList()
    {

    }

    //add
    public void add(Object newElement)
    {
        //what does list look like empty? (only head and next is null)
        if(head == null)
        {
            //assign to new node object
            head = new Node(newElement, null);
        }
        else
        {
            //todo IMPORTANT!!!! - dont want to reassign my head pointer
            //all im doing is making sure i dont lose reference to head using current
            //just putting pointer at "back" of LL
            Node current = head;

            //continue looping until i find a node with a null next pointer/reference
            while(current.next != null)
            {
                //move current variable to next node
                //it keeps moving to the last node and then we can assign our variables
                current = current.next;
            }
            //add a new node to end of the list
            current.next = new Node(newElement, null);
        }
        size++;

    }

    public int size()
    {
        return size;
    }

    public boolean isEmpty()
    {
        return size == 0;
    }

    public void clear()
    {
        //garbage collector finds the old head object and reclaim, then the others
        head = null;
        size = 0;
    }

    public boolean remove(Object newElement)
    {
        //returns true if element was found and removed

        //what if list is empty?
        if(head == null)
        {
            return false;
        }
        else if (head.data.equals(newElement))
        {
            //the head is a special case because we cant lose our head pointer
            //poiint head
            head = head.next;
            return true;
        }
        else //we have at least 1 element
        {
            //we need to search fo the node ebfore the deleted node
            Node current = head;

            //case a - we reach the node before the one we are trying to remove
            //case b - we reach the end of the list
            while(current.next != null && !current.next.data.equals(newElement))
            {
                //move to next node
                current = current.next;
            }

            //did we not find our element?
            if(current.next == null)
            {
                return false;
            }
            else
            {
                //remove the element
                current.next = current.next.next;
                return true;
            }
        }
    }

    public String toString()
    {
        //print out entire list
        String result = "";

        //show the list A-->B-->C-->D-->null
        //loop over collection
        Node current = head;

        while(current != null)
        {
            result += current.data + "---> ";
            current = current.next;
        }

        result += "null";

        return result;
    }

    private static class Node
    {
        private Object data;
        private Node next; //reference to another node

        //an instance of Node stores a reference to another Node
        public Node(Object data, Node next)
        {
            this.data = data;
            this.next = next;
        }

        public String toString()
        {
            String nextElement = "null";
            if(next != null)
            {
                nextElement = next.data.toString();
            }
            return data + "----> " + nextElement;
        }
    }


}
