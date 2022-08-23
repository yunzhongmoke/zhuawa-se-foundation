public class Fibonacci{

	public static void main(String[] args){
	
		Tool T = new Tool();
		int n = 7;
		int res = T.fibonacci(n);
		System.out.println("res=" + res);
		
	}

}
class Tool{
	//计算斐波那契数方法
	public int fibonacci(int n){
	
		if(n == 1 || n == 2){
		
			return 1;
		
		}else{
		
			return fibonacci(n - 2) + fibonacci(n - 1);
		
		}
	
	}

}