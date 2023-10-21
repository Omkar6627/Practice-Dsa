import java.io.*;
import java.util.*;
class Node{
    int val ;
    Node next;
    Node(int val){
        this.val= val;
    }
    Node(int val,Node next){
        this.val= val;
        this.next= next;
    }
    Node(){};
}
class linkedlist{
    Node head;
    Node tail;
    linkedlist(Node h,Node t){
        this.head=h;
        this.tail=t;
    }
    linkedlist(){};
    void addnode(Node node){
        if(head== null){
            head  = node;
            tail=node;
        }
        else{
            tail.next= node;
            tail= node;
        }
    }
    void display (){
        Node temp = new Node();
        temp= head;
        while(temp!=null){
            System.out.print(temp.val+" ");
            temp = temp.next;
        }
    }


}

public class Q16 {

    public static void main(String[] args) {
        linkedlist ll = new linkedlist();
        Scanner s = new Scanner (System.in);
        int n = s.nextInt();
        for(int i =0;i<n;i++){
            int val = s.nextInt();
            Node newNode = new Node(val);
            ll.addnode(newNode);
        }
        ll.display();
    }
}