import java.util.Scanner;
public class IfExercise01{

	public static void main(String[] args){
	
		//判断输入的年份是否为闰年
		Scanner myScanner = new Scanner(System.in);
		System.out.println("输入一个年份：");
		int year = myScanner.nextInt();
		if((year % 4 == 0 && year % 100 != 0) || year % 400 == 0){
			
			System.out.println(year + "是闰年");
			
		}else{
			System.out.println(year + "不是闰年");
		}
	}
	
}