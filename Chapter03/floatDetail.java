public class floatDetail{

	public static void main(String[] args){
		//java的浮点型常量（具体值）默认为double型，声明float型常量，须后加‘f’或‘F’
		//float num1 = 1.1;//对不对？错误
		float num2 = 1.1F;//对的
		double num3 = 1.1;//对的
		double num4 = 1.1F;//对的
		
		//十进制数形式：如 5.12  512.0f    .512 （必须有小数点）
		double num5 = .123;//等价于0.123
		
		//当我们对运算结果时小数的进行相等判断时，要小心
		//应该是以两个数的差值的绝对值，在某个精度范围内判断
		double num6 = 2.7;//2.7
		double num7 = 8.1 / 3;//接近2.7的一个小数
		if(num6 == num7){
			System.out.println("两数相等");
		}
		//Math.abs -> 取绝对值
		if(Math.abs( num6 - num7) < 0.00001){
			System.out.println("差值非常小，在规定范围内，认为相等...");
		}
	}
	
}