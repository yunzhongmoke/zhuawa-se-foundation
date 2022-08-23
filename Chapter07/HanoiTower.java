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
		
			//拆成两部分，最下面和上面两部分
			//(1)上半部分：借助 c 将 a 上的移动到 b
			move(num-1, a, c, b);
			//(2)最下面：a 移动到 c
			System.out.println(a + "->" + c);
			//(3)上半部分：借助 a 将 b上的移动到 c
			move(num-1, b, a, c);
		
		}
	
	}

}