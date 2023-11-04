package datastructures;

public class LinkedList {


    private Node head;
    private Node tail;
    private int length;

    class Node{
        int value;
        Node next;

        Node(int value){
            this.value = value;
        }


    }

    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    /**
     * Print Linked List by iterating from head until next node is null;
     **/
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }
    /**
     * Return  head node
     **/
    public void getHead() {
        if (head == null) {
            System.out.println("Head: null");
        } else {
            System.out.println("Head: " + head.value);
        }
    }
    /**
     * Return  Tail node
     **/
    public void getTail() {
        if (head == null) {
            System.out.println("Tail: null");
        } else {
            System.out.println("Tail: " + tail.value);
        }
    }
    /**
     * Return  Length of  Linked list
     **/
    public void getLength() {
        System.out.println("Length: " + length);
    }
    /**
     * Append Data at the end
     **/
    public void appendNode(int value){
        Node newNode = new Node(value);
        if(length==0){
            head = newNode;
            tail = newNode;
        }
        else{
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }
    /**
     * Remove data from the end
     **/
    public void removeFromEnd(){
        Node temp= head, pre = head;
        while (temp.next!=null){
            pre = temp;
            temp = temp.next;

        }

        tail = pre;
        tail.next = null;
        length--;
        if(length==0){
            head=null;
            tail = null;
        }

    }
    /**
     * Add data to front
     **/
    public void prependNode(int value){
        Node newValue = new Node(value);
        Node temp = head;
        if(length!=0){
            head=newValue;
            head.next = temp;
        }
        else{
            head = newValue;
            tail = newValue;
        }
        length++;

    }

    /**
     * Remove first
     **/
    public void removeFirst(){
        if(length!=0){
            Node temp = head;
            head = head.next;
            temp.next = null;
            length --;
            if(length==0){
                tail=null;
            }
        }
        else{
            System.out.println("Nothing to remove");
        }


    }

    /**
     * Get by index
     **/
    public Node getNode(int index){
        if(index<0||index>length) return null;
        else{
            Node temp = head;
            for(int i=0; i<index; i++){
                temp=temp.next;
            }
            return temp;
        }

    }

    /**
     * set node by index
     **/
    public boolean setNode(int index, int value){
        Node temp = getNode(index);
        if(temp!=null){
            temp.value = value;
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * insert Node at index
     **/
    public boolean insertNode(int index, int value){
        if(index<0||index>length) return false;
        else{
            if(index==0){
                prependNode(value);
                return true;
            }
            if(index==length){
                appendNode(value);
                return true;

            }
            Node temp1 = getNode(index-1);
            Node temp2 = getNode(index);
            Node newNode = new Node(value);
            temp1.next = newNode;
            newNode.next = temp2;
            length++;
            return true;

        }
    }

    /**
     * remove Node at index
     **/
    public boolean removeNodeAtIndex(int index){
        if(index<0||index>length) return false;
        else {
            if(index==0){
                removeFirst();
                return true;

            } else if (index==length) {
                removeFromEnd();
                return true;
            }
            else{
                Node temp1 = getNode(index-1);
                Node temp2 = getNode(index);
                temp1.next = temp2.next;
                temp2.next = null;
                length--;
                return true;

            }
        }
    }

    /**
     * remove Node at index
     **/
    public void reverse() {
        Node temp = head;
        head = tail;
        tail = temp;
        Node after = temp.next;
        Node before = null;
        for (int i = 0; i < length; i++) {
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
    }


    public static void main(String[] args) {

        LinkedList myLinkedList = new LinkedList(4);

        //Initial
        myLinkedList.getHead();
        myLinkedList.getTail();
        myLinkedList.getLength();

        System.out.println("\nLinked List:");
        myLinkedList.printList();
        /** Output
            Head: 4
            Tail: 4
            Length: 1

            Linked List:
            4

        **/
        //Append
        System.out.println("\nAppend 5 to Linked List:");
        myLinkedList.appendNode(5);
        myLinkedList.printList();
        myLinkedList.getHead();
        myLinkedList.getTail();
        myLinkedList.getLength();
        /** Output
         Append 5 to Linked List:
         4
         5
         Head: 4
         Tail: 5
         Length: 2

         **/

        //Remove from end
        System.out.println("\nRemove from end of Linked List:");
        myLinkedList.removeFromEnd();
        myLinkedList.printList();
        myLinkedList.getHead();
        myLinkedList.getTail();
        myLinkedList.getLength();
        /** Output
         Remove from end of Linked List:
         4
         Head: 4
         Tail: 4
         Length: 1
         **/


        //Prepend from end
        System.out.println("\nPrepend Linked List:");
        myLinkedList.prependNode(10);
        myLinkedList.prependNode(20);
        myLinkedList.printList();
        myLinkedList.getHead();
        myLinkedList.getTail();
        myLinkedList.getLength();
        /** Output
         Prepend Linked List:
         20
         10
         4
         Head: 20
         Tail: 4
         Length: 1

         **/
        //Remove from first
        System.out.println("\nRemove from first:");
        myLinkedList.removeFirst();
        myLinkedList.printList();
        myLinkedList.getHead();
        myLinkedList.getTail();
        myLinkedList.getLength();
        /** Output
         Remove from end of Linked List:
         4
         Head: 4
         Tail: 4
         Length: 1
         **/

        //Get by index
        System.out.println("\nGet by index");
        myLinkedList.printList();
        System.out.println(myLinkedList.getNode(1).value);
        myLinkedList.printList();

        //Set by index
        System.out.println("\nSet by index");
        myLinkedList.printList();
        System.out.println(myLinkedList.setNode(1, 100));
        myLinkedList.printList();

        //Set by index
        System.out.println("\nSet by index");
        myLinkedList.printList();
        System.out.println(myLinkedList.insertNode(1, 200));
        System.out.println(myLinkedList.insertNode(1, 400));
        myLinkedList.printList();

        //Remove by index
        System.out.println("\nRemove node by index");
        myLinkedList.printList();
        System.out.println(myLinkedList.removeNodeAtIndex(1));
        myLinkedList.printList();
        myLinkedList.getLength();

        //Reverse the list
        myLinkedList.reverse();
        myLinkedList.printList();
        myLinkedList.getLength();


    }

}

