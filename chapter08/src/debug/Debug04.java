package debug;

import java.util.Arrays;

//执行到下一个断点。同时支持动态的下断点
public class Debug04 {
    public static void main(String[] args) {
        int[] arr = {1, -1, 10, -20, 100};
        //看Arrays.sort方法底层实现 -> Debug
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }


    }
}
