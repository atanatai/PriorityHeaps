//Kai Rahm
//CS3240

import java.util.Scanner;

public class PriorityQueueStudents {
	public static void main(String[] args){
		ArrayHeap array = new ArrayHeap(6); //creates array to hold up to 6 students.
		int insertPosition=0; //this keeps track of what order each element will be inserted at
		
		System.out.println("*****************************************************************");
		System.out.println("\nINSERTING INITIAL VALUES INTO ARRAY AND BINARY TREE:");
		array.insertElement(new PriorityQNode<String>("Harleen",2,insertPosition));
		insertPosition++;
		array.insertElement(new PriorityQNode<String>("Dick",3,insertPosition));
		insertPosition++;
		array.insertElement(new PriorityQNode<String>("Bruce",3,insertPosition));
		insertPosition++;
		array.insertElement(new PriorityQNode<String>("Tim",4,insertPosition));
		insertPosition++;
		
		BinaryTreeHeap<PriorityQNode<String>> tree = new BinaryTreeHeap<PriorityQNode<String>>();
		tree.insertNode(array.getStudentArray(), 0); // this creates the binary tree from the pre-sorted array of students
		
		
		Scanner in = new Scanner(System.in);
		int choice = 0;
		while(choice!=8){
			print("\n*******************************************************");
	    	print("A priority queue of students using arrays / binary trees to implement heaps:");
	    	print("*******************************************************");
	    	print("Press 1 to see an array of the priority queue.");
			print("Press 2 to insert a student into the heap.");
			print("Press 3 to delete a student from the heap.");
			print("Press 4 to peek the top item on the priority queue.");
			print("Press 5 to see a PreOrder traversal of the binary tree.");
			print("Press 6 to see an InOrder traversal of the binary tree.");
			print("Press 7 to see a PostOrder traversal of the binary tree.");
			print("Press 8 to exit the program.");
			
			choice = Integer.parseInt(in.nextLine());
			
			if(choice == 1){
				System.out.println("The priority queue of students (highest->lowest priority)");
				System.out.println(array.toString());
				choice = 0;
			}
			if(choice == 2){
				System.out.println("\nINSERTING INTO THE HEAP:");
				print("Name of new student:");
	        	String name = in.nextLine();
				print("Enter the student's priority number: ");
				int priority = Integer.parseInt(in.nextLine());
				array.insertElement(new PriorityQNode<String>(name,priority,insertPosition));
				insertPosition++;
				tree.insertNode(array.getStudentArray(), 0);
				choice = 0;
			}
			if(choice == 3){
				System.out.println("\nDELETING FROM THE HEAP: (student with most priority)");
				array.deleteElement();	//deletes top element of array heap, since priority is kept on insertion reheaping is not needed
				while (insertPosition>0){
					insertPosition--;
				}
				tree.insertNode(array.getStudentArray(), 0);
				choice = 0;
			}
			if(choice == 4){
				System.out.println("Peeking the top item of the heap: "+tree.peekRoot());
				choice = 0;
			}
			if(choice == 5){
				System.out.println("\nTRAVERSING TREE (PRE-ORER):");
				tree.printPreOrder(tree.getRoot());
				choice = 0;
			}
			if(choice == 6){
				System.out.println("\nTRAVERSING TREE (IN-ORER):");
				tree.printInOrder(tree.getRoot());
				choice = 0;
			}
			if(choice == 7){
				System.out.println("\nTRAVERSING TREE (POST-ORER):");
				tree.printPostOrder(tree.getRoot());
				choice = 0;
			}
		}
		print("Thank you for testing. Have a good day!");
		in.close();
	}
	
	public static void print(Object line) {
	    System.out.println(line);
	}

}
