import java.util.Random;
import java.util.Scanner;
public class MoraGame{

	//测试
	public static void main(String[] args){
	
		//创建一个玩家对象
		Person t = new Person();
		//用来记录最后输赢的次数
		int isWinCount = 0;
		
		//创建一个二维数组，用来接收局数，Tom出拳情况以及电脑出拳情况
		int[][] arr1 = new int[3][3];
		int j = 0;
		
		//创建一个一维数组，用来接收输赢情况
		String[] arr2 = new String[3];
		
		Scanner scanner = new Scanner(System.in);
		//比赛次数，三次
		for(int i = 0; i < 3; i++){
		
			//获取玩家出的拳
			System.out.println("请输入你要出的拳（0-拳头，1-剪刀，2-布）：");
			int num = scanner.nextInt();
			t.setPersonGuessNum(num);
			int personGuess = t.getPersonGuessNum();
			arr1[i][j+1] = personGuess;
			
			//获取电脑出的拳
			int comGuess = t.computerNum();
			arr1[i][j+2] = comGuess;
			
			//将玩家猜的拳与电脑进行比较
			String isWin = t.vsComputer();
			arr2[i] = isWin;
			
			//记录当前局数
			//arr1[i][j] = t.count;
			arr1[i][j] = i+1;
			
			//对每一局的情况进行输出
			System.out.println("================================================");
			System.out.println("局数\t玩家的出拳\t电脑的出拳\t输赢的情况");
			System.out.println((i+1) + "\t" + personGuess + "\t\t" + comGuess + "\t\t" + isWin);
			System.out.println("================================================");
			System.out.println("\n\n");
			
			//记录赢的次数
			isWinCount = t.winCount(isWin);
			
		}
		
		//对游戏的最终结果进行输出
		System.out.println("局数\t\t玩家的出拳\t电脑的出拳\t输赢的情况");
		for(int a = 0; a < arr1.length; a++){
		
			for(int b = 0; b < arr1[a].length; b++){
			
				System.out.print(arr1[a][b] + "\t\t");
			
			}
			
			System.out.print(arr2[a]);
			System.out.println();
		
		}
		
		System.out.println("你赢了" + isWinCount + "次");
		
	}

}

//Person类
class Person{

	//玩家出拳的类型
	int personGuessNum; //0,1,2
	//电脑出拳的类型
	int comGuessNum; //0,1,2
	//玩家赢的次数
	int winCountNum; //默认值为0
	//比赛的次数
	//int count = 1;
	
	public void showInfo(){
		
	}
	
	//电脑随机生成猜拳的方法
	public int computerNum(){
	
		Random r = new Random();
		comGuessNum = r.nextInt(3); //返回0-2的随机数
		return comGuessNum;
	
	}
	
	//设置玩家猜拳的数字的方法
	public void setPersonGuessNum(int personGuessNum){
	
		if(personGuessNum > 2 || personGuessNum < 0){
		
			//抛出一个异常
			throw new IllegalArgumentException("数字输入有误");
			
		}
		
		this.personGuessNum = personGuessNum;
	
	}
	
	public int getPersonGuessNum(){
	
		return personGuessNum;
	
	}
	
	//比较猜拳的结果
	//玩家赢返回true，否则返回false
	public String vsComputer(){
	
		//
		if(personGuessNum == 0 && comGuessNum == 1){
			return "你赢了";
		}else if(personGuessNum == 1 && comGuessNum == 2){
			return "你赢了";
		}else if(personGuessNum == 2 && comGuessNum == 0){
			return "你赢了";
		}else if(personGuessNum == comGuessNum){
			return "平手";
		}else{
			return "你输了";
		}
	
	}
	
	//记录玩家赢的次数
	public int winCount(String s){
	
		//count++;   //记录游戏次数
		//统计赢的次数
		if(s.equals("你赢了")){
		
			winCountNum++;
		
		}
		
		return winCountNum;
	
	}

}