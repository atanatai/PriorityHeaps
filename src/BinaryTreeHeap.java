//Kai Rahm
//CS3240

/**
 * Binary Tree priority heap
 * @author Kai
 *
 * @param <E>
 */
public class BinaryTreeHeap<E>{
		private E data;
		private BinaryTreeHeap<E> rootNode;
		private BinaryTreeHeap<E> leftNode;
		private BinaryTreeHeap<E> rightNode;
		
		public BinaryTreeHeap(){
			super();
		}
		public BinaryTreeHeap(E data){
			super();
			this.data = data;
			leftNode=null;
			rightNode=null;
		}
		
		
		public BinaryTreeHeap<E> insertNode(E[] list, int index){  //index should normally be set to 0, start of list, but can be different 
	    	BinaryTreeHeap<E> newNode = new BinaryTreeHeap<E>();
	    	try{
	    	newNode.data = list[index];
			if(index < list.length && list.length != 0){
	        	newNode.data = list[index];
	        	
	        	//print("The Data : "+list[index]+" was inserted from index "+index+" in the list.");
	        	if((2*index + 1)<list.length)
	        		newNode.leftNode = insertNode(list, (2*index + 1)); //inserts index 1 from list, then index 3 and 4 as it's children, etc
	        	if((2*index + 2)<list.length)
	        		newNode.rightNode = insertNode(list, (2*index + 2)); //inserts index 2 from list, then index 5 and 6 as it's children, and so on 
			}
			else{
				print("Insertion could not occur.");
			}
	    	}catch(NullPointerException e){
	    		print("Null Pointer Exception occurred.");
	    	}
	    	if(index == 0){
	    		rootNode = newNode;
	    		//print("Tree Insertion Completed.");
	    	}
	        return newNode;
	    }//end insertNode(E[], int)
		
		
		public E peekRoot(){
			E data = null;
			try{
			data = rootNode.data;
			}catch(NullPointerException e){
	    		print("Null Pointer Exception occurred.");
	    	}
			return data;
		}
		public BinaryTreeHeap<E> getRoot(){
			BinaryTreeHeap<E> data = null;
			try{
			data = rootNode;
			}catch(NullPointerException e){
	    		print("Null Pointer Exception occurred.");
	    	}
			return data;
		}
		public void setRoot(BinaryTreeHeap<E> newRoot){
			rootNode = newRoot;
		}
		public void printPreOrder(BinaryTreeHeap<E> tempNode) {
			if (tempNode != null) {
				print(tempNode.data);
				
				if(tempNode.leftNode != null){
					print("Left child of "+tempNode.data+":");
					//print("Null");
				printPreOrder(tempNode.leftNode);}
				
				if(tempNode.rightNode != null){
					print("Right child of "+tempNode.data+":");
					//print("Null");
				printPreOrder(tempNode.rightNode);}
			}
		}
		public void printPostOrder(BinaryTreeHeap<E> tempNode) {
			if (tempNode != null) {
				printPostOrder(tempNode.leftNode);
				printPostOrder(tempNode.rightNode);
				print(tempNode.data);
			}
		}

		public void printInOrder(BinaryTreeHeap<E> tempNode) {
			if (tempNode != null) {
				printInOrder(tempNode.leftNode);
				print(tempNode.data);
				printInOrder(tempNode.rightNode);
			}
		}
		public void printLevelOrder(BinaryTreeHeap<E> tempNode, int height) {
			try{
			if (height == 0){ //height will decrement until it reaches this condition
				print(tempNode.data);
			}
			else if (height > 0){ //while height is not at root level, it will print current node then children of said node.
				print(tempNode.data);
				print("Left child of "+tempNode.data+":");
				printLevelOrder(tempNode.leftNode, (height-1));
				print("Right child of "+tempNode.data+":");
				printLevelOrder(tempNode.rightNode, (height-1));	
			}
			}catch(NullPointerException e){
				//return;
				print (null); //when the child of an element in the tree is null it prints null
			}
		}
		public static void print(Object line) {
		    System.out.println(line);
		}
	}//end BST

	