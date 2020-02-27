package linked_list;

public class LinkedListPractice
{
    //only store (directly) a siingle node in our list
    private Node head;
    private int size;

    public LinkedListPractice()
    {

    }

    private static class Node
    {
        private Object data;
        private Node next; //reference to another node object //circular logic

        //inside our Node class, we are saving an instance of another node in our next field.
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
            return data + " -----> " + nextElement;
        }
    }

    public void add(Object newElement)
    {
    //1st case:  hat does an empty list look like?
        if(head == null)
        {
            head = new Node(newElement, null);
        }
        else {
            //second case : list not full - traverse until .next == null
            Node current = head; //dont want to reassign my head pointer (may lose elements)
            head = current;

            //continue looping until i find a node with a null next pointer/reference
            while(current.next != null)
            {
                //move my current variable to next variable
                current = current.next;
            }
            current.next = new Node(newElement, null);
        }
    }

    public boolean remove(Object newElement)
    {
        //what happens if it's empty?
        if(head == null)
        {
            return false;
        }
        else if(head.data.equals(newElement))
        {
            head = head.next;
            size++;
            return true;
        }
        else
        {
            //what happens if head is being removed
            Node current = head;
            while(current.next != null && !current.next.data.equals(newElement))
            {
                current = current.next;
            }
            if(current.next == null)
            {
                return false;
            }
            current.next = current.next.next;
            size--;
            return true;
        }
    }

}
