public class YangHui{

	public static void main(String[] args){
		
		//创建一个二维数组
		int[][] yangHui = new int[10][];//确定了行，可以不确定列
		//遍历数组的每个元素
		for(int i = 0; i < yangHui.length; i++){
		
			//为每个元素开辟空间，相当于新建一个一维数组
			yangHui[i] = new int[i+1];
			//遍历元素内的值
			for(int j = 0; j < yangHui[i].length; j++){
			
				if(j == 0 || j == yangHui[i].length-1){
				
					yangHui[i][j] = 1;
				
				}else{
				
					yangHui[i][j] = yangHui[i-1][j] + yangHui[i-1][j-1];
				
				}
			
			}
		
		}
		
		//遍历数组
		for(int i = 0; i < yangHui.length; i++){
		
			for(int j = 0; j < yangHui[i].length; j++){
			
				System.out.print(yangHui[i][j] + "\t");
			
			}
			
			System.out.println();
		
		}
	
	}

}