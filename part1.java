package comp361_assignment_3;


//part1


class Knapsack { 
	  
	
	
	public static int randomNumber(int min, int max) {
		return (int) (min + Math.random() * max);
	}
	
	static void testCaseGenerator() {
	
		//loop though like 10 and create random instances 
		
		//call knapSack with the instacnes
		
		//instance consists of a value array and a weight array of the same length, a weight and the length number
		//there all ints
		
		int loopNum = 10;
		for(int i = 0; i < loopNum; i++){
			int length = randomNumber(1, 20);
			
			int val[] = new int[length]; 
	        int wt[] = new int[length]; 
	        int W = randomNumber(20, 100);
			
			//create val array 
			int a,b;
			for(a = 0; a < length; a++){
				val[a] = randomNumber(10, 100);
				
			}
			//create weight array
			for(b = 0; b < length; b++){
				wt[b] = randomNumber(1,10);
						
			}
			knapSackO1(W, wt, val, length);
		}
	}
  
 
  

    static void knapSackO1(int weightC, int weights[], int values[], int lenght){ 
  	  long start = System.nanoTime();
  	  //variable used to count number of operations
    	int barCount = 0;
        
        int valueTable[][] = new int[lenght + 1][weightC + 1]; 
  
        		for (int i = 0; i <= lenght; i++) { 
            
        	
        		for (int w = 0; w <= weightC; w++) { 
            	
            	//make the first row and colunm cells equal to zero
                if (i == 0 || w == 0) {
                	valueTable[i][w] = 0; 
                }
                //check the weigth isnt heavyer than the capasity
                else if (weights[i - 1] <= w) {
                	barCount++;
                	//take the max of the new value and the old
                	valueTable[i][w] = maxValue( values[i - 1] + valueTable[i - 1][w - weights[i - 1]],  (valueTable[i - 1][w])); 
                }  
                else {
                	valueTable[i][w] = valueTable[i - 1][w]; 
                  
                    barCount++;
                }
            } 
        } 
        
        long end = System.nanoTime();
    	
  	  double totalTime = end - start;

  	  System.out.println(barCount + " ---	operations preformed");
        
        System.out.println();
        System.out.println( valueTable[lenght][weightC] + "		best value acheved"); 
        System.out.println(lenght * weightC  + "	max expected complexity (n * W )" + lenght + " "+  weightC);
        System.out.println();
        System.out.println( totalTime+"	time taken in nanoseconds");
        
        System.out.println("======================================");
    }  
  
    static int maxValue(int a, int b){ 
    	if(a>b){
    		return a;
    	}
        return  b; 
    }  
    
    public static void main(String args[]){ 
       
      //  testCaseGenerator();
    	
    	int val[] = new int[] { 60, 100, 120}; 
        int wt[] = new int[] { 10, 20, 30}; 
        int W = 600; 
        int n = val.length; 
        knapSackO1(W, wt, val, n); 
  
    } 
} 