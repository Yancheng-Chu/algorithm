package sort;

import java.util.Arrays;

class merge {
    public static int[] divide(int[] arr) {
        if (arr.length < 2) {
            return arr;
        }
        int center = (int) Math.floor(arr.length / 2);

        int[] left = Arrays.copyOfRange(arr, 0, center);
        int[] right = Arrays.copyOfRange(arr, center, arr.length);

        return mergeSort(divide(left), divide(right));
    }

    public static int[] mergeSort(int[] left, int[] right) {
        System.out.println("L " + Arrays.toString(left));
        System.out.println("R " + Arrays.toString(right));
        int[] result = new int[left.length + right.length];
        int i = 0;
        while (left.length > 0 && right.length > 0) {
            if (left[0] < right[0]) {
                result[i++] = left[0];
                left = Arrays.copyOfRange(left, 1, left.length);
                // System.out.println("L Small R");
            } else {
                result[i++] = right[0];
                // System.out.println("L Big R");
                right = Arrays.copyOfRange(right, 1, right.length);
            }
        }
        while (left.length > 0) {
            result[i++] = left[0];
            left = Arrays.copyOfRange(left, 1, left.length);
        }

        while (right.length > 0) {
            result[i++] = right[0];
            right = Arrays.copyOfRange(right, 1, right.length);
        }
        // System.out.println(Arrays.toString(result));
        return result;
    }


    public static void main(String[] args) {
        // int[] s = new int[] { 10, 1, 2, 12, 20 };
        int[] s = new int[] { 14, 1 , 2, 12};
        s = divide(s);
        System.out.println(Arrays.toString(s));
    }
}
