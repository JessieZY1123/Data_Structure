package SingleLinkedList;
/*
 * Describe an algorithm for concatenating two singly linked lists L and M,
 *  into a single list L′ that contains all the nodes of L followed by all the nodes of M.
 *  合并两个单链表
 */
//Java class to create a Singly Linked List 
public class LinkedList<T> {
	Node<T> head;
	public LinkedList() {
		head = null;
	}
	 // Method to insert a new node at the end of the list 
	public LinkedList<T> insert(LinkedList<T> list, T data) {
		Node<T> newNode = new Node<T>(data,null);
		if(list.head==null) { list.head = newNode;}
		else {
			Node<T> temp = list.head;
			while(temp.getNext()!=null) {
				temp = temp.getNext();//指针后移，找到最后
			}
			temp.setNext(newNode);
		}
		return list;
	}
	public  static void printList(LinkedList<Integer> list) {
		Node temp = list.head;
		System.out.println("LinkedList elements are : "); 
		while(temp!=null) {
				System.out.println(temp.getData());
				temp =temp.getNext();
			}
		System.out.println();
		}


//	public LinkedList<T> merge(LinkedList<T> list1,LinkedList<T> list2) {
//		if(list1.head ==null) {
//			return list2;
//		}
//		if(list2.head ==null) {
//			return list1;
//		}
//		LinkedList<T> newHead = new LinkedList<T>();
//		LinkedList<T> temp = newHead;
//		
//		
//	}
	 public static void main(String[] args){
	        // Create an empty list (list1)
	        LinkedList<Integer> L = new LinkedList<Integer>(); 
	        // insert nodes to list1
	        // list1 = 10->3->5->7->null
	        L.insert(L, 1); 
	        L.insert(L, 3); 
	        L.insert(L, 5); 
	        L.insert(L, 7); 
	        printList(L);
	        // Create an empty list (list2)
	        LinkedList<Integer> M = new LinkedList<Integer>();
	        // insert nodes to list2
	        // list2 = 9->11->13->15->null
	        M.insert(M, 9); 
	        M.insert(M, 11); 
	        M.insert(M, 13); 
	        M.insert(M, 15); 
	        printList(M);
	        // Create an empty list to store the merged list
	        LinkedList<Integer> new_list = new LinkedList<Integer>();
	        // merge list1 and list2
	        // new_list = 1->3->5->7->9->11->13->15->null
	   //    new_list.merge(L, M);
	        // print the elements of the list
	        printList(new_list); 
	    } 
	 }