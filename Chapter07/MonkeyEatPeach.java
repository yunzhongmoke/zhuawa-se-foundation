public class MonkeyEatPeach{
	//���ӳ�������
	public static void main(String[] args){
	
		Tool T = new Tool();
		int day = 8;
		int peachNum = T.peach(day);
		System.out.println("��" + day + "�����ʼ����������" + peachNum);
	
	}

}
class Tool{

	public int peach(int day){
	
		if(day == 10){
		
			return 1;
		
		}else{
			
			//�����ݹ�
			return (peach((day + 1)) + 1) * 2;
		
		}
	
	}

}