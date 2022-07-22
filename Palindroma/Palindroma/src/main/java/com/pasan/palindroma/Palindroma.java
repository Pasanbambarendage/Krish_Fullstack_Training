/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.pasan.palindroma;

import java.util.Stack;

/**
 *
 * @author pasan
 */
public class Palindroma {

    public static void main(String[] args) {
        Node one = new Node(10);
        Node two = new Node(22);
        Node three = new Node(30);
        Node four = new Node(41);
        Node five = new Node(30);
        Node six = new Node(22);
        Node seven = new Node(10);
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;
        six. next = seven;
        
        boolean b = isPalindroma(one);
        System.out.println("IsPalindroma : "+ b);
        
    }
    
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
    static boolean isPalindroma(Node node)
    {
        Node slow= node;
        boolean ispalin = true;
        Stack<Integer> stack = new Stack<Integer>();
        
        while(slow !=null){
            stack.push(slow.x);
            slow = slow.next;
        }
        
        while(node != null)
        {
            int i = stack.pop();
            if(node.x ==i)
            {
                ispalin= true;
            }
            else
            {
                ispalin=false;
                break;
            }
            node = node.next;
        }
        return ispalin;
    }
}
