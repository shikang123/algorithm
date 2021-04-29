package org.shikang.algorithm;

public class Algorithm {

    /**
     * Insertion sort
     *
     * @param arr 待排序的数组
     */
    public static void insertionSort(int[] arr) {
        insertionSort(arr, false);
    }

    /**
     * Insertion sort
     *
     * @param arr  待排序的数组
     * @param flag 若flag为true，则按降序排序；否则按升序排序
     */
    public static void insertionSort(int[] arr, boolean flag) {
        for (int i = 1; i < arr.length; i++) {
            int t = arr[i];
            int j = i - 1;
            while (j >= 0 && (flag ? (arr[j] < t) : (arr[j] > t))) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = t;
        }
    }

    /**
     * merge_sort
     *
     * @param arr 待排序的数组
     */
    public static void merge_sort(int[] arr) {
        merge_sort(arr, 0, arr.length - 1);
    }

    /**
     * merge_sort
     *
     * @param arr 待排序的数组
     * @param p   需要排序的开始位置
     * @param r   需要排序的结尾位置
     */
    public static void merge_sort(int[] arr, int p, int r) {
        if (p < r) {
            int mid = (r + p) / 2;
            merge_sort(arr, p, mid);
            merge_sort(arr, mid + 1, r);

            merge(arr, p, mid, r);
        }
    }

    /**
     * 将数组中 [p,q] 与 (q,r] 两个有序序列合并
     *
     * @param arr 待操作的数组
     * @param p   左有序序列起始位置
     * @param q   左有序序列结束位置（q+1为右有序序列开始位置）
     * @param r   右有序序列结束位置
     */
    public static void merge(int[] arr, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;
        int[] left = new int[n1 + 1];
        int[] right = new int[n2 + 1];
        System.arraycopy(arr, p, left, 0, n1);
        System.arraycopy(arr, q + 1, right, 0, n2);

        //哨兵
        left[n1] = Integer.MAX_VALUE;
        right[n2] = Integer.MAX_VALUE;

        int i = 0, j = 0;
        for (int k = p; k <= r; k++) {
            if (left[i] < right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
        }
    }
}
