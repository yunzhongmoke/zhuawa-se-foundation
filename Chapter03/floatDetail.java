public class floatDetail{

	public static void main(String[] args){
		//java�ĸ����ͳ���������ֵ��Ĭ��Ϊdouble�ͣ�����float�ͳ��������ӡ�f����F��
		//float num1 = 1.1;//�Բ��ԣ�����
		float num2 = 1.1F;//�Ե�
		double num3 = 1.1;//�Ե�
		double num4 = 1.1F;//�Ե�
		
		//ʮ��������ʽ���� 5.12  512.0f    .512 ��������С���㣩
		double num5 = .123;//�ȼ���0.123
		
		//�����Ƕ�������ʱС���Ľ�������ж�ʱ��ҪС��
		//Ӧ�������������Ĳ�ֵ�ľ���ֵ����ĳ�����ȷ�Χ���ж�
		double num6 = 2.7;//2.7
		double num7 = 8.1 / 3;//�ӽ�2.7��һ��С��
		if(num6 == num7){
			System.out.println("�������");
		}
		//Math.abs -> ȡ����ֵ
		if(Math.abs( num6 - num7) < 0.00001){
			System.out.println("��ֵ�ǳ�С���ڹ涨��Χ�ڣ���Ϊ���...");
		}
	}
	
}