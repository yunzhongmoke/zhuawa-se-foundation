public class MonkeyEatPeach{
	//猴子吃桃问题
	public static void main(String[] args){
	
		Tool T = new Tool();
		int day = 8;
		int peachNum = T.peach(day);
		System.out.println("第" + day + "天的起始桃子数量：" + peachNum);
	
	}

}
class Tool{

	public int peach(int day){
	
		if(day == 10){
		
			return 1;
		
		}else{
			
			//方法递归
			return (peach((day + 1)) + 1) * 2;
		
		}
	
	}

}