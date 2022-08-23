public class Diamond{

	public static void main(String[] args){
	
		/*
			*   	1   2*i-1 
		   ***      3	2*i-1	
		  *****     5	2*i-1
		   ***		3	2*(n-i)+1	
		    *		1	
		    5	
		*/
		int n = 21;//总行数
		for(int i = 1; i <= n; i++){
		
			//上半部分的形状
			if(i <= n/2){
			
				//打印前面的空格
				//判断总行数的奇偶性
				if(n % 2 == 0){
				
					for(int k = 1;k <= n/2-i; k++){
					
						System.out.print(" ");
					
					}
				
				}else{
				
					for(int k = 1;k <= n/2+1-i; k++){
					
						System.out.print(" ");
					
					}
				
				}
				
				//打印出*
				for(int j = 1; j <= 2*i-1; j++){
					
					if(j == 1 || j == 2*i-1){
					
						System.out.print("*");
					
					}else{
					
						System.out.print(" ");
					
					}
				
				}
				
			}else{//下半部分的形状
				
				//打印前面的空格
				for(int k = i-(n/2+1); k >= 1; k--){
				
					System.out.print(" ");
				
				}
				
				//打印*
				for(int j = 2*(n-i)+1; j >= 1; j--){
				
					if(j == 1 || j == 2*(n-i)+1){
					
						System.out.print("*");
					
					}else{
					
						System.out.print(" ");
					
					}
				
				}
			
			}	
			
			//换行
			System.out.println();
				
		}
	
	}

}