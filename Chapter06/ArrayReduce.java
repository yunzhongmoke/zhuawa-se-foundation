import java.util.Scanner;
public class ArrayReduce{
	
	//��дһ��main����
	public static void main(String[] args){
	
		int[] arr = {1, 2, 3, 4, 5};
		Scanner myScanner = new Scanner(System.in);
		char keyword;
		do{
		
			int[] arrNew = new int[arr.length-1];
			for(int i = 0; i < arrNew.length; i++){
			
				arrNew[i] = arr[i];
			
			}
			System.out.println("====arr������Ԫ�����====");
			arr = arrNew;
			for(int i = 0; i < arr.length; i++){
			
				System.out.print(arr[i] + "\t");
			
			}
			System.out.println("\n�Ƿ����ɾ��һ��Ԫ�أ�y/n��");
			keyword = myScanner.next().charAt(0);//charAt(0)��ȡ��һ���ַ�
			if(keyword == 'n'){
			
				break;
			
			}
			if(arrNew.length <= 1){
			
				System.out.println("�����������ˣ�");
				break;
			
			}
		
		}while(true);
		
		System.out.println("���˳�������");
		
	}

}