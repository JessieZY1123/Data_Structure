package doubleLinkedList;
//合并两个双链表
public class DLL {
	// Object of class Node to store the head
	// of the LinkedList
	Node head;
	// Object of class Node to store the tail
	// of the LinkedList
	Node tail;

	// inner class Node to create nodes of the
	// Doubly Linked List
	class Node {
		// variable to store the data in the node
		int data;
		// Node variable to point to the next Node of the list
		Node prev;
		Node next;

		// Constructor of the node class to pass data to the node
		// Ex: Node node1 = new Node(4)
		// stores 4 to node1.data
		// next and prev is by default initialized as null
		Node(int d) {
			data = d;
		}
	}

	// Instance Method to insert a new node at the start of the list
	public void push(int new_data) {
		// Create a new node object with given data
		Node new_Node = new Node(new_data);
		// Point the next attribute of the new_node to the head of
		// the list (to add the node in the start)
		// Ex: dll = null<-3<->5<->1<->7->null and push(4)
		// dll = null<-4<->3<->5<->1<->7->null
		// set previous of new_node as NULL */
		new_Node.next = head;
		new_Node.prev = null;
		// if head is not null, then point the prev attribute of head
		// to the new node
		if (head != null)
			head.prev = new_Node;
		// set the new node as head of the list as it in the start
		head = new_Node;
	}

	// Add a node at the end of the list
	public void append(int new_data) {
		// Create a new node object with given data
		Node new_node = new Node(new_data);
		// Point the next attribute of the node to null, because
		// it is the last node
		// Ex: Node node1 = new Node(4)
		// node1.next = null => 4->null
		new_node.next = null;
		// Check if the head and tail of the DLL is null
		// If it is null, this means that the List is empty and
		// the node to be inserted will be the head and tail node
		if (head == null && tail == null) {
			// set the prev attribute to null because the new node
			// will be head of the list
			new_node.prev = null;
			head = new_node;
			tail = new_node;
			return;
		}
		// If the list is not empty, set the next element of the
		// tail to the new node(because it will be in the last)
		// and also set the prev attribute of the new node to tail
		tail.next = new_node;
		new_node.prev = tail;
		// Now set the tail to the new node as it is the last node
		tail = new_node;
	}

	// Method to print data of nodes of the LinkedList in
	// forward direction
	public void printList() {
		// dummy variable to traverse the list
		// Initially set it to the head of the list
		Node currNode = head;
		System.out.print("LinkedList elements are : ");
		// Ex: list = null<-3<->1<->5<->11<->6->null
		// iter = 1, currNode = 3, display(3)
		// currNode = currNode.next = 1
		// iter = 2, currNode = 1, display(1)
		// currNode = currNode.next = 5
		// iter = 3, currNode = 5, display(5)
		// currNode = currNode.next = 11
		// iter = 4, currNode = 11, display(11)
		// currNode = currNode.next = 6
		// iter = 5, currNode = 6, display(6)
		// currNode = currNode.next = null (end)
		while (currNode != null) {
			// Print the data at current node
			System.out.print(currNode.data + " ");
			// Set the dummy node to the next node
			currNode = currNode.next;
		}
		// Display a new line
		System.out.println();
	}

	// method to merge list2 with the list object
	public void merge(DLL list2) {
		// point the next attribute of the tail node of the list
		// object to the head of the second list
		tail.next = list2.head;
		// point the prev attribute of the head node of the list2
		// to the tail node of the list object
		list2.head.prev = tail;
		// set the tail node of the list object to the tail node
		// of list2
		tail = list2.tail;
	}

	// Driver method
	public static void main(String[] args) {
		// Create an empty list
		DLL dll = new DLL();
		// Insert 6 at the end
		// So DLL becomes NULL<-6->NULL
		dll.append(6);
		// Insert 7 at the beginning.
		// So DLL becomes NULL<-7->6->NULL
		dll.push(7);
		// Insert 1 at the beginning.
		// So DLL becomes NULL<-1->7->6->NULL
		dll.push(1);
		// Insert 4 at the end.
		// So DLL becomes NULL<-1->7->6->4->NULL
		dll.append(4);

		/* Create another empty list */
		DLL dll2 = new DLL();
		// Insert 4 at the end
		// So DLL becomes NULL<-4->NULL
		dll2.append(4);
		// Insert 2 at the beginning.
		// So DLL becomes NULL<-2->4->NULL
		dll2.push(2);
		// Insert 9 at the beginning.
		// So DLL becomes NULL<-9->2->4->NULL
		dll2.push(9);
		// Insert 12 at the end.
		// So DLL becomes NULL<-9->2->4->12->NULL
		dll2.append(12);
		// merge the object of list1 with list2
		dll.merge(dll2);
		// Print the elements of the merged list
		dll.printList();
	}
}
