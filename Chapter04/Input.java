import java.util.Scanner;//��ʾ��java.util�µ�Scanner�ർ��
public class Input{

	public static void main(String[] args){
	
		//Scanner�� ��ʾ ���ı�ɨ��������java.util ��
		//����Scanner����new ����һ������
		//myScanner ���� Scanner��Ķ���
		Scanner myScanner = new Scanner(System.in);
		//�����û�����ģ� ʹ����صķ���
		System.out.println("���������֣�");
		String name = myScanner.next();//�����û�������ַ���
		System.out.println("���������䣺");
		int age = myScanner.nextInt();//�����û������int
		System.out.println("������нˮ��");
		double sal = myScanner.nextDouble();//�����û������double
		System.out.println("�˵���Ϣ����");
		System.out.println("����=" + name + " ����=" + 
		age + " нˮ=" + sal);
		
	}

}