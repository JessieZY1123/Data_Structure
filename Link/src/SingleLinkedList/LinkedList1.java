package SingleLinkedList;

public class LinkedList1{ 
    // Object of class Node to store the head
    // of the LinkedList
    Node head; 
    // inner class Node to create nodes of the
    // Singly Linked List 
    // This inner class is made static 
    // so that main() can access it 
    static class Node{ 
        // variable to store the data in the node
        int data; 
        // Node variable to point to the next Node of the list
        Node next; 
        // Constructor of the node class to pass data to the node
        // Ex: Node node1 = new Node(4)
        //     stores 4 to node1.data 
        Node(int d){ 
            data = d; 
            next = null; 
        } 
    } 
    // Method to insert a new node at the end of the list 
    public static LinkedList1 insert(LinkedList1 list, int data) 
    { 
        // Create a new node object with given data 
        Node new_node = new Node(data);
        // Initially point the next attribute of the node to null
        // Ex: Node node1 = new Node(4)
        //     node1.next = null  =>   4->null
        new_node.next = null; 
        // Check if the head of the Linkedlist is null
        // If it is null, this means that the LinkedList is empty
        // and the node to be inserted will be the head node
        if (list.head == null) { 
            list.head = new_node; 
        } 
        // If the LinkedList is not empty, i.e. it has atleast one
        // node, then insert the new node at the end of list
        // by traversing the list to the end
        else{ 
            // create a dummy node last to traverse the list
            // and initially point it towards the head of list
            Node last = list.head; 
            // Traverse the list using a loop to find the end
            // of list and insert the new node there
            // Ex: list = 3->1->5->11->null and insert 6 at the end
            //     iter = 1, last.next = 1(not null) (last = head)
            //              last = last.next = 1
            //     iter = 2, last.next = 5(not null)
            //              last = last.next = 5
            //     iter = 3, last.next = 11(not null)
            //              last = last.next = 11
            //     iter = 4, last.next = null (end)
            while (last.next != null) { 
                last = last.next; 
            } 
            // Set the next element of the last node to the new node 
            // From above, list = 3->1->5->11->6
            last.next = new_node; 
        } 
        // Return the modified list 
        return list; 
    } 
    
    // Method to print data of nodes of the LinkedList. 
    public static void printList(LinkedList1 list) 
    { 
        // dummy variable to traverse the list
        // Initially set it to the head of the list
        Node currNode = list.head; 
        System.out.print("LinkedList elements are : "); 
        // Ex: list = 3->1->5->11->6->null
        // iter = 1, currNode = 3, display(3)
        //           currNode = currNode.next = 1
        // iter = 2, currNode = 1, display(1)
        //           currNode = currNode.next = 5
        // iter = 3, currNode = 5, display(5)
        //           currNode = currNode.next = 11
        // iter = 4, currNode = 11, display(11)
        //           currNode = currNode.next = 6
        // iter = 5, currNode = 6, display(6)
        //           currNode = currNode.next = null (end)
        while (currNode != null){ 
            // Print the data at current node 
            System.out.print(currNode.data + " "); 
            // Set the dummy node to the next node
            currNode = currNode.next; 
        } 
        // Display a new line        
        System.out.println(); 
    } 
    // Class method to merge two Linkedlists
    public static LinkedList1 merge(LinkedList1 list1, LinkedList1 list2){
        // If the first list is empty i.e. the head node in the first 
        // list is null, then return the second list as the merged list
        if(list1.head == null){
            return list2;
        }
        // dummy variable to traverse the list
        // Initially set it to the head of the list
        Node last = list1.head;
        // Traverse the first list using a loop to find the end
        // of first list and set the next attribute of the last node
        // to the head of the new list there
        // Ex: list1 = 3->1->5->11->null and list2 = 13->23->null
        //     iter = 1, last.next = 1(not null) (last = head)
        //              last = last.next = 1
        //     iter = 2, last.next = 5(not null)
        //              last = last.next = 5
        //     iter = 3, last.next = 11(not null)
        //              last = last.next = 11
        //     iter = 4, last.next = null (end)
        while(last.next != null){
            last = last.next;
        }
        // when the last node of the first list is found, set the
        // next attribute of the last node to the head of the 2nd list
        // Ex: list1 = 3->1->5->11(last)->null and list2 = 13->23->null
        //     last.next = 13(head of list2)
        //     list1 = 3->1->5->11->13->23->null
        last.next = list2.head;
        // return the modified list
        return list1;
    }
    // Driver method to create two Singly linked list with nodes and 
    // merge them 
    public static void main(String[] args){
        // Create an empty list (list1)
        LinkedList1 L = new LinkedList1(); 
        // insert nodes to list1
        // list1 = 10->3->5->7->null
        L = insert(L, 1); 
        L = insert(L, 3); 
        L = insert(L, 5); 
        L = insert(L, 7); 

        // Create an empty list (list2)
        LinkedList1 M = new LinkedList1();
        // insert nodes to list2
        // list2 = 9->11->13->15->null
        M = insert(M, 9); 
        M = insert(M, 11); 
        M = insert(M, 13); 
        M = insert(M, 15); 

        // Create an empty list to store the merged list
        LinkedList1 new_list = new LinkedList1();
        // merge list1 and list2
        // new_list = 1->3->5->7->9->11->13->15->null
        new_list = merge(L, M);
        // print the elements of the list
        printList(new_list); 
    } 
}
