package top.clearlight.util;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Base {
    public static void main(String[] args) {
        int[] arr = new int[5];
        Scanner sc = new Scanner(System.in);
        for (int i = 1; i <= arr.length; i++) {
            System.out.println("请输入第" + i + "个1-60之间的数字:");
            int n = sc.nextInt();
            arr[i - 1] = n;
        }

        System.out.println("输入的数组: " + Arrays.toString(arr));

        int[] newArr = new int[5];
        int index = 0;
        Random r = new Random();
        int num = r.nextInt(10) + 1;

        System.out.println("随机数: " + num);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % num == 0) {
                newArr[index] = arr[i];
                index++;
            }
        }

        System.out.println("符合条件的数组: " + Arrays.toString(newArr));

    }
}
