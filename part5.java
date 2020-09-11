import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Comparator;
//part 5
public class IMPROVE {

	static node root;
	static int weightCapasity = 200;
	static int bestValue;
	static int	bestWeight;
	static String best;
	//method to build the graph
	public static void build(node n) {
		
		if(n.getWeight() >= weightCapasity) {
		
			//System.out.println(n.getWeight());
			
		}else {
		//crete the children nodes
		node left = new node(n.getS()+1, n.getR(), n.getP());
		node middle = new node(n.getS(), n.getR()+1, n.getP());
		node right = new node(n.getS(), n.getR(), n.getP()+1);

		//set the childen
		n.setLeft(left);
		n.setMiddle(middle);
		n.setRight(right);
		
		//recurcive calls
		build(left);
		build(middle);
		build(right);
		
		
		}
		
	}
	
	public static void search(node root){
       // Queue<node> queue = new LinkedList<node>(); 
		
		Comparator<node> comparator = new nodeCompare();
        PriorityQueue<node> queue = new PriorityQueue<node>(10000, comparator);
		
        queue.add(root); 
        while (!queue.isEmpty()) { 
          
        	
        node tempNode = queue.poll(); 
        
        if(tempNode.getWeight() > weightCapasity){
        	tempNode = null;
        }
        
        if(tempNode != null) {
         // System.out.println(tempNode.getWeight());

        
        if(tempNode.getWeight() < weightCapasity && tempNode.getValue() > bestValue) {
        	bestWeight = tempNode.getWeight();
        	bestValue = tempNode.getValue();
        	best = tempNode.toString();
        }
        //add the children to the queue
        if(tempNode.getLeft() != null){
            queue.add(tempNode.getLeft()); 

        }
        if(tempNode.getMiddle() != null){
            queue.add(tempNode.getMiddle()); 

        }
        if(tempNode.getRight() != null){
            queue.add(tempNode.getRight()); 

        }
        
      
        }
        }
	}
	
	
	
	
	
	
	//main 
    public static void main(String[] args) { 
		
    	
    	
    	node rootNode = new node(0,0,0);
		root = rootNode;
		build(rootNode);
		search(rootNode);
		System.out.println("best combination "+ best );
		System.out.println("best value "+bestValue );
		System.out.println("best weight "+bestWeight );
    	int i;
//    	for(i =0; i < 5; i++) {
//    	weightCapasity = weightCapasity + 50;
//    	
//    	long start = System.nanoTime();
//	  
//    	
//    	
//  	  
//	  
//		
//	
//	  	  
//  	  
//	  long end = System.nanoTime();
//	
//	  double totalTime = end - start;
//	  System.out.println();
//
//	  System.out.println("time taken in nanoseconds");
//	  System.out.println();
//	  System.out.println();
//	  System.out.println(totalTime);
//	  System.out.println(weightCapasity);
//	  System.out.println();
//	  System.out.println("========================================");
//    	
//    	}
	}
	
}




  class nodeCompare implements Comparator<node> {
	 
	 public int compare(node x, node y) {
      
        if (x.getValue() < y.getValue()) {
            return -1;
        }
        if (x.getValue() > y.getValue()) {
            return 1;
        }
        return 0;
    }




}



//class for the nodes reprecenting parital soutions

class node{
	
	 int weight;
	 int value;
	 int s;
	 int r;
	 int p;
	 int sVal = 10;
	 int rVal =5;
	 int pVal = 7;
	 int sW = 20;
	 int rW =30;
	 int pW = 40;
	 
	 //children nodes
	 node left;
	 node middle;
	 node right;
	 
	 public  node(int s, int r, int p) {
		 
		 this.s = s;
		 this.r = r;
		 this.p = p;
		 
		 
		 this.value = (this.s * this.sVal) +  (this.r * this.rVal) + (this.p * this.pVal);
		 this.weight = (this.s * this.sW) +  (this.r * this.rW) + (this.p * this.pW);
		 
	 }
	 
	 public int getValue() {
		 return this.value;
	 }
	 public int getWeight() {
		 return this.weight;
	 }
	 public int getS() {
		 return this.s;
	 }
	 public int getR() {
		 return this.r;
	 }
	 public int getP() {
		 return this.p;
	 }
	 //setters for children
	 public void setLeft(node ln) {
		 this.left = ln;
	 }
	 public void setMiddle(node mn) {
		 this.middle = mn;
	 }
	 public void setRight(node rn) {
		 this.right = rn;
	 }
	 
	 //getters for children
	 public node getLeft() {
		return this.left;
	 }
	 public node getMiddle() {
		return this.middle;
	 }
	 public node getRight() {
		 return this.right;
	 }
	 
	 
	 public String toString() {
		 String a = s +" "+ r +" " + p;
		 return a;
	 }
	 
	 
}