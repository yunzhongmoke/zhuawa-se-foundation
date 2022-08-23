public class ArrayTest {
    public static void main(String[] args) {
        int[] arr = {1, 43, 23, 21, 86};
        MyTools tool = new MyTools();
        tool.bubble(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

class MyTools {
    public void bubble(int[] arr) {
        //冒泡排序,从小到大排序
        //设置一个临时变量，用于存放交换的值
        int temp;
        for (int i = 0; i < arr.length - 1; i++) {//外层循环次数，arr.length - 1
            for (int j = 0; j < arr.length - 1 - i; j++) {//内层循环次数，arr.length - 1 - i
                //根据大小交换顺序
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
