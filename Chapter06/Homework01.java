/*

��һ��������ж�λ������

*/
public class Homework01{

	public static void main(String[] args){
	
		int[] arr = {10, 12, 45, 90};
		int insertNum = 23;
		int insertIndex = arr.length;//Ĭ��ֵΪ�����ĩβ����ֹ���������������������λ��û������ȷ�ĵط����������ж�insertIndex��λ���Ƿ����仯
		//����ԭ���飬�Ƚϴ�С���ж�inserIndex��λ��
		for(int i = 0; i < arr.length; i++){
		
			if(insertNum <= arr[i]){
			
				insertIndex = i;
				break;
			
			}
		
		}
		
		System.out.println(insertIndex);
		//����
		//�½�һ������
		int[] arrNew = new int[arr.length+1];
		for(int i = 0, j = 0; i < arrNew.length; i++){
		
			if(i != insertIndex){
			
				arrNew[i] = arr[j];
				j++;
			
			}else{
			
				arrNew[i] = insertNum;
			
			}
		
		}
		
		//for(int i = 0, j = 0; i < arrNew.length; i++, j++){
		
		//	if(i != insertIndex){
			
		//		arrNew[i] = arr[j];
			
		//	}else{
			
		//		arrNew[i] = insertNum;
		//		j--;
			
		//	}
		
		//}
		
		//�� arr ָ�� arrNew
		arr = arrNew;
		//����arr����
		for(int i = 0; i < arr.length; i++){
		
			System.out.print(arr[i] + "\t");
		
		}
		
	}

}