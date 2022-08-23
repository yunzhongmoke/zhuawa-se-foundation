public class BubbleSort{

	public static void main(String[] args){
	
		int[] arr = {24, 69, 80, 57, 13, 9};
		
		for(int i = 0; i < arr.length-1; i++){
			
			int temp = 0;
			for(int j = 0; j < arr.length-1-i; j++){
				
				if(arr[j] > arr[j+1]){
				
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				
				}
			
			}
			
			System.out.println("\n第" + (i+1) + "轮排序的结果：");
			for(int k = 0; k < arr.length; k++){
			
				System.out.print(arr[k] + "\t");
			
			}
			//对算法进行优化
			if(temp == 0){
			
				break;
			
			}
		
		}
		
		System.out.println("\n冒泡排序后的结果：");
		for(int i = 0; i < arr.length; i++){
		
			System.out.print(arr[i] + "\t");
		
		}
		
	}

}