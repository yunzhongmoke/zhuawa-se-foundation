import java.util.Scanner;//表示把java.util下的Scanner类导入
public class Input{

	public static void main(String[] args){
	
		//Scanner类 表示 简单文本扫描器，在java.util 包
		//创建Scanner对象，new 创建一个对象
		//myScanner 就是 Scanner类的对象
		Scanner myScanner = new Scanner(System.in);
		//接收用户输入的， 使用相关的方法
		System.out.println("请输入名字：");
		String name = myScanner.next();//接收用户输入的字符串
		System.out.println("请输入年龄：");
		int age = myScanner.nextInt();//接收用户输入的int
		System.out.println("请输入薪水：");
		double sal = myScanner.nextDouble();//接收用户输入的double
		System.out.println("人的信息如下");
		System.out.println("名字=" + name + " 年龄=" + 
		age + " 薪水=" + sal);
		
	}

}