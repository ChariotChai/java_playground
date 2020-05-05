package play;

public class BiSearch {

    int biSearch(int[] nums, int target) {
        //闭区间搜索
        int lo = 0;
        int hi = nums.length - 1;

        //终止条件是交叉
        while (lo <= hi) {
            int mi = (lo + hi) / 2;
            if (nums[mi] == target) {
                return mi;
            } else if (nums[mi] < target) {
                lo = mi + 1;
            } else if (nums[mi] > target) {
                hi = mi - 1;
            }
        }

        return -1;
    }

    int leftBound(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }

        //左闭右开搜索
        int lo = 0;
        int hi = nums.length;

        //终止条件为重合
        while (lo < hi) {
            int mi = (lo + hi) / 2;
            if (nums[mi] == target) {
                hi = mi; //不断向左收缩
            } else if (nums[mi] < target) {
                lo = mi + 1;
            } else if (nums[mi] > target) {
                hi = mi; //注意由于是左闭右开，这里右界只缩减到mi
            }
        }

        //全数组都小于目标值
        if (lo == nums.length) {
            return -1;
        }

        //以上的搜索只保证lo位置以左的值小于目标值，数组中是否有该值仍需要比较一次
        return nums[lo] == target ? lo : -1;
    }

    int rightBound(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }

        //左闭右开搜索
        int lo = 0;
        int hi = nums.length;

        while (lo < hi) {
            int mi = (lo + hi) / 2;
            if (nums[mi] == target) {
                lo = mi + 1; //不断向右收缩
            } else if (nums[mi] < target) {
                lo = mi + 1;
            } else if (nums[mi] > target) {
                hi = mi; //注意由于是左闭右开，这里右界只缩减到mi
            }
        }

        //全数组都大于目标值
        if (lo == 0) {
            return -1;
        }

        //以上的搜索只保证lo位置【及】以右的值大于目标值，数组中是否有该值仍需要比较一次
        return nums[lo - 1] == target ? lo - 1 : -1;
    }

}
