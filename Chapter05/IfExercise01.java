import java.util.Scanner;
public class IfExercise01{

	public static void main(String[] args){
	
		//�ж����������Ƿ�Ϊ����
		Scanner myScanner = new Scanner(System.in);
		System.out.println("����һ����ݣ�");
		int year = myScanner.nextInt();
		if((year % 4 == 0 && year % 100 != 0) || year % 400 == 0){
			
			System.out.println(year + "������");
			
		}else{
			System.out.println(year + "��������");
		}
	}
	
}