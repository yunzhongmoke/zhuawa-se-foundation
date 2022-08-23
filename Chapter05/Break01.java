public class Break01{

	public static void main(String[] args){
	
		int i;
		int count = 0;
		while(true){
		
			i = (int)(Math.random() * 100) + 1;
			if(i == 97){
				
				count++;
				System.out.println("i=" + i);
				break;
			
			}
			
			count++;
			System.out.println("i=" + i);
		
		}
		
		System.out.println("count=" + count);
	}

}