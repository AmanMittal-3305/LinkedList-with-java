import java.util.*;
public class LinkedList {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;
    public void addFirst(int data){

        //step 1 create a new node
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }

        //step 2 new node next = head
        newNode.next = head;

        //step 3 head = newNode
        head = newNode;

    }
    public void addLast(int data){

        //step 1 - create a node
        Node newNode = new Node(data);
        size ++;
        if(head == null){
            head = tail = newNode;
            return;
        }

        //step 2 tail creation
        tail.next = newNode;

        //step 3 set tail
        tail = newNode;
    }
    public void add (int index, int data){
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i =0;
        while(i < index - 1){
            temp = temp.next;
            i++;
        }
        newNode.next =temp.next;
        temp.next = newNode;
    }
    public int removeFirst(){
        if(size == 0){
            System.out.println("LL is empty");
            return Integer.MAX_VALUE;
        }
        if(size == 1){
            int value = head.data;
            head =tail= null;
            size = 0;
            return value;
        }
        int value = head.data;
        head = head.next;
        size --;
        return value;
    }
    public int removeLast(){
        if(size == 0){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }else if(size == 1){
            int value = head.data;
            head = tail = null;
            size =0;
            return size;
        }
        Node prev = head;
        for(int i = 0; i < size-2; i++){
            prev= prev.next;
        }
        int value = prev.next.data;
        prev.next = null;
        tail= prev;
        size -- ;
        return value;
    }
    public int itrSearch(int key){
        Node temp = head;
        int i = 0;
        while(temp != null){
            if(temp.data == key){
                return i;
            }
            temp = temp.next;
            i++;
        }
        //key not found
        return -1;
    }

    public int helper(Node head, int key){
        if(head == null){
            return -1;
        }
        if(head.data == key){
            return 0;
        }
        int idx = helper(head.next,key);
        if(idx == -1){
            return -1;
        }
        return idx+1;
    }

    public int recSearch(int key){
        return helper(head,key);
    }

    public void reverse(){
        Node prev = null;
        Node curr = tail= head;
        Node next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev= curr;
            curr = next;
        }
        head = prev;
    }
    public void deleteNthfromEnd(int n){
        //calculate size
        int sz = 0;
        Node temp = head;
        while(temp != null){
            temp = temp.next;
            sz++;
        }
        if(n == sz){
            head = head.next;
            return;
        }
        //sz-n
        int i =1;
        int iTOFind = sz-n;
        Node prev = head;
        while(i < iTOFind){
            prev = prev.next;
            i++;
        }
        prev.next= prev.next.next;
        return;
    }
    public void Print(){
        if(head == null){
            System.out.println("LL is empty");
            return;
        }
        Node temp = head;
        while (temp != null){
            System.out.print(temp.data + " --> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(6);
        ll.addLast(7);
        ll.add(2,3);
        ll.add(3,4);
        ll.add(4,5);
//        ll.removeFirst();
//        ll.removeLast();
        ll.Print();
//        System.out.println(ll.itrSearch(5));
//        System.out.println(ll.recSearch(7));
//        ll.reverse();
//        ll.Print();
        ll.deleteNthfromEnd(3);
        ll.Print();
    }
}