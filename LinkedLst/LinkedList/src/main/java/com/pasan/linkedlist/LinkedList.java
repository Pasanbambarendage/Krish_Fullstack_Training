
package com.pasan.linkedlist;

import java.util.Stack;

/**
 *
 * @author pasan
 */
public class LinkedList {
    
    static Node head;
    static class Node
    {
        int x;
        Node next;
        
        Node(int y)
        {
            x=y;
            next = null;
        }
    }
    
    Node reverse (Node node)
    {
        Node previous = null;
        Node current= node;
        Node next= null;
        
        while(current != null)
        {
            next= current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        node=previous;
        return node;
    }
    void Print(Node node)
    {
        while(node != null)
        {
            System.out.println(node.x + " ");
            node=node.next;
        }
    }
    
    

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.head = new Node(85);
        linkedList.head.next=new Node(15);
        linkedList.head.next.next =new Node(45);
        linkedList.head.next.next.next=new Node(14);
          
        System.out.println("Before Reverse : ");
        linkedList.Print(head);
        head = linkedList.reverse(head);
        System.err.println(" ");
        System.out.println("After Reverse : ");
        linkedList.Print(head);
    }
}
