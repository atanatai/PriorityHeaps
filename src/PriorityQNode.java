//Kai Rahm
//CS3240


public class PriorityQNode<T> {
	private T data;
	private int priorityNum;
	private int insertedAt;
	private int insertionIndex = 0;
	
	public PriorityQNode(T data, int priority){
		this.data = data;
		priorityNum = priority;
		insertedAt = insertionIndex;
		insertionIndex++;
	}
	public PriorityQNode(T data, int priority, int order){
		this.data = data;
		priorityNum = priority;
		insertedAt = order;
	}
	
	public T getElement(){
		return data;
	}
	public int getPriority(){
		return priorityNum;
	}
	public int getInsertionOrder(){
		return insertedAt;
	}
	
	public String toString(){
		//String label = "Priority: "+priorityNum+" - Insertion Order#: "+insertedAt+" - Data: "+data;
		String label = data.toString();
		return label;
	}
	
	public int comparePriority(PriorityQNode<T> otherNode){
		//-1 means current node's priority is smaller than compared node
			//	this can mean either compared node has higher priority, or 
			//	was inserted before current node if priority is the same
		//1 means current node's priority is larger than compared node
		//0 means the comparison could not be completed
		int compared = 0;
		if(priorityNum < otherNode.getPriority())
			compared = -1;
		else if(priorityNum > otherNode.getPriority())
			compared = 1;
		else if(priorityNum == otherNode.getPriority()){
			if(insertedAt < otherNode.getInsertionOrder())
				compared = 1;
			else if (insertedAt > otherNode.getInsertionOrder())
				compared = -1;
		}
		return compared;
	}

}
