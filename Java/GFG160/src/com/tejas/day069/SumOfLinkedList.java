package com.tejas.day069;

import com.tejas.day068.*;
public class SumOfLinkedList {

	
	public static void main(String[] args) {
		SLL list = new SLL(1);

		list.addLast(2);
		list.addLast(3);
		list.addLast(4);
		list.addLast(3);
		
		SLL list2 = new SLL(0);
	
		list2.addLast(2);
		list2.addLast(3);
		System.out.println("List 1");
		ReverseGroup.show(list.getHead());
		System.out.println("\nList 2");
		ReverseGroup.show(list2.getHead());
		System.out.println("\nSUM : ");
		ReverseGroup.show(addTwoLists(list.getHead(), list2.getHead()));
	}
	
	
	static Node addTwoLists(Node num1, Node num2) {
	     
	       int carry = 0;
	       
	       num1 = removeZeroAtLeft(num1);
	       num2 = removeZeroAtLeft(num2);
	       
	      int cnt1 = countNodes(num1);
	      int cnt2 = countNodes(num2);
	      
	      if(cnt1 < cnt2){
	          return addTwoLists(num2 ,num1);
	      }
	       
	     num1 =  reverse(num1);
	     num2 = reverse(num2);
	      
	      Node resultList = num1;
	      while( num2 != null || carry != 0){
	           
	           // take sum assigned to carry if any
	             num1.data+=carry ;  
	            
	        
	           // same for num2.data
	            if(num2 != null){
	               num1.data+=num2.data;
	               num2 = num2.next;
	           }
	           
	      
	           
	           // get carry if any
	           carry = num1.data / 10;
	        // get new node to add in result list
	           num1.data = num1.data%10;
	           
	          if(num1.next == null && carry != 0){
	              num1.next = new Node(0);
	          }
	          
	          num1 = num1.next;
	       }
	       
	       return reverse(resultList);
	    }
	    
	    
	    static int countNodes(Node head){
	        int cnt = 0;
	        Node trav = head;
	        while(trav != null){
	            cnt+=1;
	            trav=trav.next;
	        }
	        
	        return cnt;
	    }
	    
	    static Node reverse(Node head){
	        Node prev = null;
	        Node run = head;
	        Node nxt;
	        
	        while(run != null){
	            nxt = run.next;
	            run.next =prev;
	            prev = run;
	            run = nxt; // next to reverse 
	        }
	        
	        return prev;
	    }
	    
	    static Node removeZeroAtLeft(Node head){
	        Node run = head;
	        
	        while(run != null & run.data == 0){
	            run = run.next;
	        }
	        return run;
	    }
}
