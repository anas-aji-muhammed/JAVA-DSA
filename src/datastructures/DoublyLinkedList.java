package datastructures;

public class DoublyLinkedList {
    class Node{
        int value;
        Node next;
        Node prev;
        Node(int value){this.value = value;}
    }

    Node head;
    Node tail;
    int length;

    public DoublyLinkedList(int value) {
        Node newValue = new Node(value);
        this.head = newValue;
        this.tail = newValue;
        this.length = 1;
    }

    /**
     * Print Linked List by iterating from head until next node is null;
     **/
    public void printList() {
        DoublyLinkedList.Node temp = head;
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
        if(!(length<1)){
            tail.next = newNode;
            newNode.next = null;
            newNode.prev = tail;
            tail = newNode;
        }

        else{
            head = newNode;
            tail=newNode;
        }
        length++;

    }

    /**
     * Remove data from the end
     **/
    public Node removeFromEnd(){
        if(length == 0) return null;
        Node temp = tail;
        if(length==1){
            head = null;
            tail = null;
        }
        else{
            tail = tail.prev;
            tail.next = null;
            temp.prev = null;
        }
        length --;
        return temp;


    }

    /**
     * Add data to front
     **/
    public void prependNode(int value){
        Node newNode = new Node(value);
        if(length==0){
            head = newNode;
            tail = newNode;
        }
        else{
            newNode.next = head;
            head.prev = newNode;
            head = newNode;

        }
        length++;

    }

    /**
     * Remove first
     **/
    public void removeFirst(){
        if(length<=1){
            head = null;
            tail = null;
        }
        else{
            Node temp = head;
            head = head.next;
            head.prev = null;
            temp.next = null;
        }
        length--;
    }

    /**
     * Get by index
     **/
    public Node getNode(int index){
        if(index<0||index>length) return null;
        else{
            Node temp = head;
            if(index<=length/2){
                for(int i=0; i<index; i++){
                    temp=temp.next;
                }
            }
            else{
                temp = tail;
                for(int i=length-1; i>index; i++){
                    temp=temp.prev;
                }
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
            Node before = getNode(index-1);
            Node after = before.next;
            Node newNode = new Node(value);
            before.next = newNode;
            newNode.next = after;
            newNode.prev = before;
            after.prev = newNode;
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
                Node temp = getNode(index);
                temp.next.prev = temp.prev;
                temp.prev.next = temp.next;
                temp.next = null;
                temp.prev = null;
                length--;
                return true;

            }
        }
    }

    /**
     * Swap head and tail
     **/
    public void swapFirstLast(){
        if(length<2){
            return;
        }
        else{
            int temp = head.value;
            head.value = tail.value;
            tail.value = temp;
        }
    }



    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList(7);

        doublyLinkedList.appendNode(8);
        doublyLinkedList.appendNode(9);


//        doublyLinkedList.removeFromEnd();

        doublyLinkedList.prependNode(6);
        doublyLinkedList.printList();
        doublyLinkedList.removeFirst();

        doublyLinkedList.getHead();
        doublyLinkedList.getTail();
        doublyLinkedList.getLength();

        doublyLinkedList.insertNode(1, 777);
        doublyLinkedList.printList();
        doublyLinkedList.swapFirstLast();
        doublyLinkedList.getHead();
        doublyLinkedList.getTail();
        doublyLinkedList.getLength();
        doublyLinkedList.printList();

    }

}
