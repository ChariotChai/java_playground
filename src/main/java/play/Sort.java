package play;

import com.alibaba.fastjson.JSON;

public class Sort {

    void quickSort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    private void quickSort(int[] nums, int lo, int hi) {
        //闭区间，终止条件为交叉
        if (lo > hi) {
            return;
        }

        int pivot = lo;
        int base = nums[pivot];
        for (int i = lo + 1; i <= hi; i++) {
            if (nums[i] <= base) {
                pivot++;
                swap(nums, i, pivot);
            }
        }
        swap(nums, lo, pivot);

        quickSort(nums, lo, pivot - 1);
        quickSort(nums, pivot + 1, hi);
    }

    private void swap(int[] nums, int from, int to) {
        if (from == to) {
            return;
        }
        int tmp = nums[from];
        nums[from] = nums[to];
        nums[to] = tmp;
    }

    void mergeSort(int[] nums) {

    }

    void bubbleSort(int[] nums) {

    }

    void selectSort(int[] nums) {

    }

    void radixSort(int[] nums) {

    }

    void heapSort(int[] nums) {

    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 4, 3, 1, 6, 5, 3};
        Sort sort = new Sort();
        sort.quickSort(nums);
        System.out.println(JSON.toJSONString(nums));
    }

}
