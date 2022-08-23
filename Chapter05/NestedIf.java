import java.util.Scanner;
public class NestedIf{

	public static void main(String[] args){
		
		int price;
		Scanner myScanner = new Scanner(System.in);
		System.out.println("输入月份：");
		int month = myScanner.nextInt();
		System.out.println("输入游客年龄：");
		int age = myScanner.nextInt();
		if(month >= 4 && month <= 10){
		
			price = 60;
			if(age < 18){
			
				System.out.println("儿童票价：" + price / 2);
			
			}else if(age > 60){
			
				System.out.println("老人票价：" + price / 3);
			
			}else{
			
				System.out.println("成人票价：" + price);
				
			}
		
		}else{
			
			price = 40;
			if(age >= 18 && age <= 60){
			
				System.out.println("成人票价：" + price);
			
			}else{
			
				System.out.println("票价：" + price / 2);
			
			}
		
		}
		
	}

}