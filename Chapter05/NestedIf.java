import java.util.Scanner;
public class NestedIf{

	public static void main(String[] args){
		
		int price;
		Scanner myScanner = new Scanner(System.in);
		System.out.println("�����·ݣ�");
		int month = myScanner.nextInt();
		System.out.println("�����ο����䣺");
		int age = myScanner.nextInt();
		if(month >= 4 && month <= 10){
		
			price = 60;
			if(age < 18){
			
				System.out.println("��ͯƱ�ۣ�" + price / 2);
			
			}else if(age > 60){
			
				System.out.println("����Ʊ�ۣ�" + price / 3);
			
			}else{
			
				System.out.println("����Ʊ�ۣ�" + price);
				
			}
		
		}else{
			
			price = 40;
			if(age >= 18 && age <= 60){
			
				System.out.println("����Ʊ�ۣ�" + price);
			
			}else{
			
				System.out.println("Ʊ�ۣ�" + price / 2);
			
			}
		
		}
		
	}

}