public class Factorial{

	public static void main(String[] args){
	
		Tools T = new Tools();
		int t = T.factorial(4);
		System.out.println("½×³ËÎª£º" + t);
	
	}

}
class Tools{

	public int factorial(int n){
	
		if(n == 1){
		
			return 1;
		
		}else{
		
			return factorial(n - 1) * n;
		
		}
	
	}

}