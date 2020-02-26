package linked_lists;

public class LinkedListTest
{
    public static void main(String[] args)
    {
        LinkedList myList = new LinkedList();

        myList.add("a");
        myList.add("b");
        System.out.println("size(): " + myList.size());
        System.out.println(myList.toString());

        myList.add("c");
        myList.add("d");

        System.out.println("size(): " + myList.size());
        System.out.println(myList.toString());

        myList.add("e");
        myList.add("f");

        myList.remove("a");
        myList.remove("d");
        myList.remove("f");
    }
}
