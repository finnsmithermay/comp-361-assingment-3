import java.util.ArrayList;

//Part 2

// O-N knapsack problem 
//COMP 361
//Finn Smither-May 3004161075



class BruteKnapsack { 
		
	static int weightConstraint = randomNumber(3, 12);
	static ArrayList<Integer> Best = new ArrayList<>();
	static int bestValue = 0;
	static ArrayList<item> itemsUsed = new ArrayList<>();
	static int itemsNum = 0;
	
	
  

	static void knapsack(int target,int temp[], item items[], int index, int last, int first) { 
      
        if (index == target) { 
        	
        	int totalWeight = 0;
        	int totalValue = 0;
        	
        	ArrayList<Integer> itemList = new ArrayList<>();

        	for (int i = 0; i < target; i++) { 
                totalWeight += items[temp[i]].weight;
                totalValue += items[temp[i]].value;
                itemList.add(items[temp[i]].getID());
           
            } 
           

            if(totalWeight <= weightConstraint) {
            	if(totalValue > bestValue) {
            		bestValue = totalValue;
            		Best = itemList;
            		
            	}
           	
            }
           return; 
        } 
  
  
        for (int i = first; i <= last; i++) { 
            temp[index] = i; 
            int newIndex = index+1;
            knapsack(target,temp, items, newIndex,  last, i ); 
        } 
        return; 
    } 
  
 
    static void knapsackRun(item items[], int i, int current) { 
        int temp[] = new int[current + 1]; 
        int index  =0;
        int last =0;
        int j = i-1;
        
        knapsack(current,temp, items, index,  last, j); 
    } 
  
    
	public static int randomNumber(int min, int max) {
		return (int) (min + Math.random() * max);
	}
    
//method that creates a random number if items
	public static item[] createItems(int ranNum) {
	
		
	item[] itemList = new item[ranNum];
		int i;
		for(i =0; i < ranNum; i++) {
			
			int id = i;
			int weight = randomNumber(2, 5);
			int value  = randomNumber(10, 50);
			
			item newItem = new item(id, weight , value);
			itemList[i] = newItem;
		}
	
		return itemList;
	
}
    public static void main(String[] args) { 
    	
    	  long start = System.nanoTime();
    	  run();
    	  
    	  long last = System.nanoTime();
    	
    	  double totalTime = last - start;
    	  System.out.println();

    	  System.out.println("time taken in nanoseconds");
    	  System.out.println();
    	  System.out.println("number of items  "+itemsNum);
    	  System.out.println();
    	  System.out.println(totalTime);
    	  System.out.println();
    	
    	
    	
    	 
    	 System.out.println("weight Constraint: " + weightConstraint);
    	 
    	 System.out.println();
    	 System.out.println(" best value obtained " + bestValue);
    	 System.out.println("items used in best combimation:");
    	 System.out.println();
    	 for(int i : Best) {
    		 System.out.print(" Item " + i);
    	 }
    	 System.out.println();
    	 System.out.println();
    	 System.out.println("List of all items used:");
    	 System.out.println();
    	 for(item i : itemsUsed){
    			
    		 System.out.println(" item " + i.id + " ID " + " item weight "+ i.weight + " item value " + i.value);
    		}
    		
    	 
    }

    
//set up this run of the program    
public static void run() {

	int numberOfItems = randomNumber(1, 10);
	//int numberOfItems = 1;

	item[] items = createItems(numberOfItems);
	itemsNum = items.length;
	for(item i : items){
		itemsUsed.add(i);
	}
	
    int num = items.length; 
    int iNum = items.length; 
    
    for(int i =0; i <= iNum; i++){
    	knapsackRun(items, num, i); 

    }
	
} 
} 

//class to represet the items in the knapsack
 class item{
	
	 int weight;
	 int value;
	 int id;
	 
	 public item(int id, int weight, int value) {
		 
		 this.id = id;
		 this.value = value;
		 this.weight = weight;
		 
	 }
	 
	 public int getValue() {
		 return this.value;
	 }
	 public int getWeight() {
		 return this.weight;
	 }
	 public int getID() {
		 return this.id;
	 }

}







