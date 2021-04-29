import org.shikang.algorithm.Algorithm;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {3, 41, 52, 26, 38, 57, 9, 49};
        Algorithm.merge_sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}

