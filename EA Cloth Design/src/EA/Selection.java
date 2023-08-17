package EA;

import java.util.Random;

public class Selection {
	
	private int sum, rnd;
	private int a;
	private int[] parents = new int[2];
	int[] mp;
	Random ran = new Random(); 
	
	// mating pool selection
	public int[] select(int[] ev) {
		
		a = 0;
		
		//sum the fitness of every individual 
		for(int i = 0; i < ev.length; i++) {
			
			sum = sum + ev[i];
			
		}
		
		//create a pool with copies equal to the fitness for each individual
		mp = new int[sum];
		
		try {			
			do {
				
				for(int i = 0; i < ev[a]; i++) {
					
					mp[sum - 1] = a;
					sum--;
				}
				
				a++;
				
			}while(sum > 0);
			
		}catch(Exception e) {
			
			System.out.println("EvaluationCatch" + e);
		}
		
		//pick first parent at random from the pool
		rnd = new Random().nextInt(mp.length - 1);
		parents[0] = mp[rnd];
		
		//check if all other parents have zero fitness
		if( a > 1 ) {
			
			//pick one at random
			do {
				
				rnd = new Random().nextInt(mp.length - 1);
				parents[1] = mp[rnd];
		
			}while(parents[0] == parents[1]);
						
		}else {
			
			//pick one at random 			
			do {
				
				parents[1] = new Random().nextInt(ev.length - 1); 
		
			}while(parents[0] == parents[1]);		
		
		}
		
		//print parents number of cell
		System.out.println("parents: " + parents[0] + "/" + parents[1]);
		
		return parents;
	}
}


