/*

对一个数组进行定位再扩容

*/
public class Homework01{

	public static void main(String[] args){
	
		int[] arr = {10, 12, 45, 90};
		int insertNum = 23;
		int insertIndex = arr.length;//默认值为数组的末尾，防止下面的条件不成立，导致位置没有在正确的地方，减少了判断insertIndex的位置是否发生变化
		//遍历原数组，比较大小，判断inserIndex的位置
		for(int i = 0; i < arr.length; i++){
		
			if(insertNum <= arr[i]){
			
				insertIndex = i;
				break;
			
			}
		
		}
		
		System.out.println(insertIndex);
		//扩容
		//新建一个数组
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
		
		//让 arr 指向 arrNew
		arr = arrNew;
		//遍历arr数组
		for(int i = 0; i < arr.length; i++){
		
			System.out.print(arr[i] + "\t");
		
		}
		
	}

}