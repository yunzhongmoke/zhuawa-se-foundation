public class HanoiTower{

	public static void main(String[] args){
	
		Tower tower = new Tower();
		tower.move(2, 'A', 'B', 'C');
	
	}

}
class Tower{

	public void move(int num, char a, char b, char c){
	
	
		if(num == 1){
		
			System.out.println(a + "->" + c);
		
		}else{
		
			//��������֣������������������
			//(1)�ϰ벿�֣����� c �� a �ϵ��ƶ��� b
			move(num-1, a, c, b);
			//(2)�����棺a �ƶ��� c
			System.out.println(a + "->" + c);
			//(3)�ϰ벿�֣����� a �� b�ϵ��ƶ��� c
			move(num-1, b, a, c);
		
		}
	
	}

}