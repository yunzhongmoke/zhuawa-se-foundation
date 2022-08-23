import java.util.Scanner;
public class ArrayReduce{
	
	//编写一个main方法
	public static void main(String[] args){
	
		int[] arr = {1, 2, 3, 4, 5};
		Scanner myScanner = new Scanner(System.in);
		char keyword;
		do{
		
			int[] arrNew = new int[arr.length-1];
			for(int i = 0; i < arrNew.length; i++){
			
				arrNew[i] = arr[i];
			
			}
			System.out.println("====arr缩减后元素情况====");
			arr = arrNew;
			for(int i = 0; i < arr.length; i++){
			
				System.out.print(arr[i] + "\t");
			
			}
			System.out.println("\n是否继续删除一个元素（y/n）");
			keyword = myScanner.next().charAt(0);//charAt(0)读取第一个字符
			if(keyword == 'n'){
			
				break;
			
			}
			if(arrNew.length <= 1){
			
				System.out.println("不能再缩减了！");
				break;
			
			}
		
		}while(true);
		
		System.out.println("你退出了缩减");
		
	}

}