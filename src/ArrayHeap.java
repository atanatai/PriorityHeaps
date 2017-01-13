//Kai Rahm
//CS3240

/**
 * Priority heap created with an Array
 * @author Kai
 *
 */
public class ArrayHeap{ 
	private PriorityQNode<String>[] studentList;
	private int maxStudents = 1000;
	private int currentStudents = 0; //essentially the index of how many elements are currently inserted (last inserted value in the list)
	
	public ArrayHeap(){
		studentList = new PriorityQNode[maxStudents];
	}
	public ArrayHeap(int totalStudents){
		maxStudents = totalStudents;
		studentList = new PriorityQNode[maxStudents];
	}
	public int getCurrentStudents(){
		return currentStudents;
	}
	public PriorityQNode<String>[] getStudentArray(){ //this will return the correctly ordered/heaped version of the list
		return studentList;
	}
	public PriorityQNode<String> peek(){
		return studentList[0];
	}
	
	public void insertElement(PriorityQNode<String> node){
		if (currentStudents >= maxStudents){
			print("There was not enough room left in the array to insert "+node.getElement());
			return;
		}
		studentList[currentStudents] = node;
	
		print("Inserted the element: "+node.getElement()+" at index location: "+node.getInsertionOrder());
		print("Before Reheaping: ");
		printList(studentList);
		reHeap(currentStudents); // Reheaps the node that was just inserted
		System.out.println("\nAfter Reheaping: ");
		printList(studentList);
		print("--------------------------------------");
		currentStudents++;
	}
	
	public void reHeap(int endingIndex){
	    int previousIndex = (endingIndex-1);
	    PriorityQNode<String> movingElement = studentList[endingIndex];

	    //while the index of item being reheaped(movingElement) is not 0 [the first index], and the preceding elements in the list are smaller  
	    //	in priority than the current element(movingElement), move the item towards the beginning of the list.
	    while(endingIndex > 0 && studentList[previousIndex].comparePriority(movingElement) < 0){
	       studentList[endingIndex] = studentList[previousIndex];  //swaps positions with the number before it if it is smaller than movingElement
	       endingIndex = previousIndex;
	       previousIndex--; // / 2;
	       } 
	    studentList[endingIndex] = movingElement;
	    }//end reHeap(int)
	
	
	public void deleteElement(){
		System.out.println("List before deleting top of heap: ");
		System.out.println(this.toString());
		if(currentStudents == 0){
			print("There are no students to delete.");
			return;
		}
		System.out.println("Removing first student: "+studentList[0].getElement()+" from the priority queue (heap).");
		if(currentStudents == 1){ //only 1 student in the list makes studentList an empty list
			print("Deleting only item in the list.");
			studentList = new PriorityQNode[studentList.length];
			currentStudents = 0;
			System.out.println("List after deleting: "+this.toString());
			return;
		}
		PriorityQNode<String>[] tempList = new PriorityQNode[studentList.length]; //even though item is deleted, list can hold same # of items
		for(int i=1; i<studentList.length; i++){ //i starts at 1 because we are excluding (or deleting) the first/top element of the queue
			tempList[i-1] = studentList[i]; //tempList will hold this new list of elements, after the top priority was removed.
		}
		studentList = tempList; //studentList is now set to this temp list, minus the top element that was removed.
		currentStudents--; //because we removed a student, current students must be decremented to show this as well.
		print("List after deleting: "+this.toString());
	}//end deleteElement()
	
	public void deleteElement(int deleteIndex){
		System.out.println("List before deleting element at index "+deleteIndex+": ");
		System.out.println(this.toString());
		if(currentStudents == 1){
			print("Deleting only item in the list.");
			studentList = new PriorityQNode[0];
			currentStudents = 0;
			System.out.println("List after deleting: "+this.toString());
			return;
		}
		PriorityQNode<String>[] tempList = new PriorityQNode[studentList.length-1];
		
		System.out.println("Deleting student: "+studentList[deleteIndex].getElement()+" from the priority queue.");
		for(int i=0; i<deleteIndex; i++){
			tempList[i] = studentList[i];
		}
		for(int i=(deleteIndex+1); i<studentList.length; i++){
			tempList[i-1] = studentList[i];
		}
		studentList = tempList;
		currentStudents--;
		print("List after deleting: "+this.toString());
	}// end deleteElement(int)
	
	public static void printList(PriorityQNode<String>[] list){
		int i = 0;
		try{
		for(i=0; i<list.length; i++){
			String label = "Index: "+i+" - Priority: "+list[i].getPriority()+" - Inserted at Index#: "+list[i].getInsertionOrder()+" - DATA: "+list[i].getElement();
			print(label);
		}
		}catch(NullPointerException e){
			//print(list[i]); //prints the null value waiting to next be assigned (as long as there is still space in list)
			return; //won't print anything for next value waiting to be printed.
			//print("Empty Index: "+i);
		}
	}
	
	public static void print(Object line) {
	    System.out.println(line);
	}
	
	public void printExample(){
		String[] students = {"Bilbo","Voldemort","Captain Vane","Lyra","Yuna","Arthur Curry"};
		int[] priorities = {1,3,2,1,5,3};
		
		ArrayHeap heap = new ArrayHeap(students.length); //an array heap with 6 empty positions for students, will be priority organized
		for(int i=0; i<students.length; i++){
			heap.insertElement(new PriorityQNode<String>(students[i],priorities[i],i));
		}
		print("Peeking at top priority student returns: ");
		print(heap.peek());
		print("--------------------------------------");
		heap.deleteElement();
		print("\n----------------End of Example----------------\n");
	}
	
	public String toString(){
		String output = "[ ";
		if (currentStudents == 0){
			output = "[ ]";
		}
		if (currentStudents == 1){
			//output = "hello";
			output = ("[ "+studentList[0].getElement()+" ]");
		}
		else if (currentStudents > 1){
			for(int i=0; i<(currentStudents-1); i++){
				String element = studentList[i].getElement();
				output = output+element+", ";
			}
			output = output+studentList[(currentStudents-1)].getElement()+" ]";
		}
		return output;
		
	}
	
	
	
}
