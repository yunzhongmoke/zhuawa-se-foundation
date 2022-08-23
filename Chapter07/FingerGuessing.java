
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
	//猜拳 0表示 石头，1表示 剪刀，2表示 布
	public void fingerGuessing(int action){
		
		//生成一个随机数
		int guess = (int)(Math.random()*3);
		System.out.println("电脑出拳：" + guess);
		//使用switch语句
		//switch(guess){
		
		//	case 0:
		//		if(action == 2){
		//			System.out.println(name + "赢");
		//		}else if(action == 0){
		//			System.out.println("平手");
		//		}else{
		//			System.out.println(name + "输");
		//		}
		//		break;
		//	case 1:
		//		if(action == 0){
		//			System.out.println(name + "赢");
		//		}else if(action == 1){
		//			System.out.println("平手");
		//		}else{
		//			System.out.println(name + "输");
		//		}
		//		break;
		//	case 2:
		//		if(action == 1){
		//			System.out.println(name + "赢");
		//		}else if(action == 2){
		//			System.out.println("平手");
		//		}else{
		//			System.out.println(name + "输");
		//		}
		//		break;
		
		//}
		
		//直接使用if elseif else语句
		//if(guess == 0){
		
		//	if(action == 2){
		//		System.out.println(name + "赢");
		//	}else if(action == 0){
		//		System.out.println("平手");
		//	}else{
		//		System.out.println(name + "输");
		//	}
			
		//}else if(guess == 1){
		
		//	if(action == 0){
		//		System.out.println(name + "赢");
		//	}else if(action == 1){
		//		System.out.println("平手");
		//	}else{
		//		System.out.println(name + "输");
		//	}
			
		//}else{
		
		//	if(action == 1){
		//		System.out.println(name + "赢");
		//	}else if(action == 2){
		//		System.out.println("平手");
		//	}else{
		//		System.out.println(name + "输");
		//	}
			
		//}
		if(action == 0 && guess == 1){
			System.out.println(name + "赢");
		}else if(action == 1 && guess == 2){
			System.out.println(name + "赢");
		}else if(action == 2 && guess == 0){
			System.out.println(name + "赢");
		}else if(action == guess){
			System.out.println("平手");
		}else{
			System.out.println(name + "输");
		}
	
	}

}
