
public class FingerGuessing{

	public static void main(String[] args){
	
		Person p = new Person("Tom");
		p.fingerGuessing(1);
	
	}

}
class Person{

	String name;
	int age;
	public Person(String name){
	
		this.name = name;
	
	}
	//��ȭ 0��ʾ ʯͷ��1��ʾ ������2��ʾ ��
	public void fingerGuessing(int action){
		
		//����һ�������
		int guess = (int)(Math.random()*3);
		System.out.println("���Գ�ȭ��" + guess);
		//ʹ��switch���
		//switch(guess){
		
		//	case 0:
		//		if(action == 2){
		//			System.out.println(name + "Ӯ");
		//		}else if(action == 0){
		//			System.out.println("ƽ��");
		//		}else{
		//			System.out.println(name + "��");
		//		}
		//		break;
		//	case 1:
		//		if(action == 0){
		//			System.out.println(name + "Ӯ");
		//		}else if(action == 1){
		//			System.out.println("ƽ��");
		//		}else{
		//			System.out.println(name + "��");
		//		}
		//		break;
		//	case 2:
		//		if(action == 1){
		//			System.out.println(name + "Ӯ");
		//		}else if(action == 2){
		//			System.out.println("ƽ��");
		//		}else{
		//			System.out.println(name + "��");
		//		}
		//		break;
		
		//}
		
		//ֱ��ʹ��if elseif else���
		//if(guess == 0){
		
		//	if(action == 2){
		//		System.out.println(name + "Ӯ");
		//	}else if(action == 0){
		//		System.out.println("ƽ��");
		//	}else{
		//		System.out.println(name + "��");
		//	}
			
		//}else if(guess == 1){
		
		//	if(action == 0){
		//		System.out.println(name + "Ӯ");
		//	}else if(action == 1){
		//		System.out.println("ƽ��");
		//	}else{
		//		System.out.println(name + "��");
		//	}
			
		//}else{
		
		//	if(action == 1){
		//		System.out.println(name + "Ӯ");
		//	}else if(action == 2){
		//		System.out.println("ƽ��");
		//	}else{
		//		System.out.println(name + "��");
		//	}
			
		//}
		if(action == 0 && guess == 1){
			System.out.println(name + "Ӯ");
		}else if(action == 1 && guess == 2){
			System.out.println(name + "Ӯ");
		}else if(action == 2 && guess == 0){
			System.out.println(name + "Ӯ");
		}else if(action == guess){
			System.out.println("ƽ��");
		}else{
			System.out.println(name + "��");
		}
	
	}

}
