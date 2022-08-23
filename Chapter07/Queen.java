public class Queen{

	public static void main(String[] args){
	
		int[][] arr = new int[8][8];
		Tool tool = new Tool();
		tool.put(arr, 0, 0);
	
	}

}
class Tool{

	public void put(int[][] arr, int i, int j){
		
		System.out.println("ÐÐ£º" + i + "£¬ÁÐ£º" + j);
		int count = 0;
		for(int k = 0; k < arr[i].length; k++){
			count++;
			if((k != j+k || k != j-k) && k != j){
			
				if((i+1) < arr.length){
				
					put(arr, i+1, k);
					
				}
			
			}
		
		}
	
	}

}