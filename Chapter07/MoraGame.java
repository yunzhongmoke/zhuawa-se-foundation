import java.util.Random;
import java.util.Scanner;
public class MoraGame{

	//����
	public static void main(String[] args){
	
		//����һ����Ҷ���
		Person t = new Person();
		//������¼�����Ӯ�Ĵ���
		int isWinCount = 0;
		
		//����һ����ά���飬�������վ�����Tom��ȭ����Լ����Գ�ȭ���
		int[][] arr1 = new int[3][3];
		int j = 0;
		
		//����һ��һά���飬����������Ӯ���
		String[] arr2 = new String[3];
		
		Scanner scanner = new Scanner(System.in);
		//��������������
		for(int i = 0; i < 3; i++){
		
			//��ȡ��ҳ���ȭ
			System.out.println("��������Ҫ����ȭ��0-ȭͷ��1-������2-������");
			int num = scanner.nextInt();
			t.setPersonGuessNum(num);
			int personGuess = t.getPersonGuessNum();
			arr1[i][j+1] = personGuess;
			
			//��ȡ���Գ���ȭ
			int comGuess = t.computerNum();
			arr1[i][j+2] = comGuess;
			
			//����Ҳµ�ȭ����Խ��бȽ�
			String isWin = t.vsComputer();
			arr2[i] = isWin;
			
			//��¼��ǰ����
			//arr1[i][j] = t.count;
			arr1[i][j] = i+1;
			
			//��ÿһ�ֵ�����������
			System.out.println("================================================");
			System.out.println("����\t��ҵĳ�ȭ\t���Եĳ�ȭ\t��Ӯ�����");
			System.out.println((i+1) + "\t" + personGuess + "\t\t" + comGuess + "\t\t" + isWin);
			System.out.println("================================================");
			System.out.println("\n\n");
			
			//��¼Ӯ�Ĵ���
			isWinCount = t.winCount(isWin);
			
		}
		
		//����Ϸ�����ս���������
		System.out.println("����\t\t��ҵĳ�ȭ\t���Եĳ�ȭ\t��Ӯ�����");
		for(int a = 0; a < arr1.length; a++){
		
			for(int b = 0; b < arr1[a].length; b++){
			
				System.out.print(arr1[a][b] + "\t\t");
			
			}
			
			System.out.print(arr2[a]);
			System.out.println();
		
		}
		
		System.out.println("��Ӯ��" + isWinCount + "��");
		
	}

}

//Person��
class Person{

	//��ҳ�ȭ������
	int personGuessNum; //0,1,2
	//���Գ�ȭ������
	int comGuessNum; //0,1,2
	//���Ӯ�Ĵ���
	int winCountNum; //Ĭ��ֵΪ0
	//�����Ĵ���
	//int count = 1;
	
	public void showInfo(){
		
	}
	
	//����������ɲ�ȭ�ķ���
	public int computerNum(){
	
		Random r = new Random();
		comGuessNum = r.nextInt(3); //����0-2�������
		return comGuessNum;
	
	}
	
	//������Ҳ�ȭ�����ֵķ���
	public void setPersonGuessNum(int personGuessNum){
	
		if(personGuessNum > 2 || personGuessNum < 0){
		
			//�׳�һ���쳣
			throw new IllegalArgumentException("������������");
			
		}
		
		this.personGuessNum = personGuessNum;
	
	}
	
	public int getPersonGuessNum(){
	
		return personGuessNum;
	
	}
	
	//�Ƚϲ�ȭ�Ľ��
	//���Ӯ����true�����򷵻�false
	public String vsComputer(){
	
		//
		if(personGuessNum == 0 && comGuessNum == 1){
			return "��Ӯ��";
		}else if(personGuessNum == 1 && comGuessNum == 2){
			return "��Ӯ��";
		}else if(personGuessNum == 2 && comGuessNum == 0){
			return "��Ӯ��";
		}else if(personGuessNum == comGuessNum){
			return "ƽ��";
		}else{
			return "������";
		}
	
	}
	
	//��¼���Ӯ�Ĵ���
	public int winCount(String s){
	
		//count++;   //��¼��Ϸ����
		//ͳ��Ӯ�Ĵ���
		if(s.equals("��Ӯ��")){
		
			winCountNum++;
		
		}
		
		return winCountNum;
	
	}

}