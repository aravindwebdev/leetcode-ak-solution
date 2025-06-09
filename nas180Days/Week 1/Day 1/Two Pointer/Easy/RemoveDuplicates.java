package dsa160.week1.easy;

import java.util.HashSet;

public class RemoveDuplicates {

    public static void main(String args[]) {
        int nums[] = { 1, 1, 2 };
        int k1 = removeDuplicatesBruteforce(nums);
        int k2 = removeDuplicatesOptimal(nums);
        int k3 = removeDuplicatesOptimized(nums);
        System.out.println(k1);
        System.out.println(k2);
        System.out.println(k3);

        for (int i : nums) {
            System.out.println(i);
        }
    }

    public static int removeDuplicatesBruteforce(int[] nums) {
        // Brute force - Using HashSet
        // Time complexity - O(n + n) = O(n)
        // Space complexity - O(n)
        // Fast but not in-place

        HashSet<Integer> hSet = new HashSet<>();
        int n = nums.length;

        for (int i : nums) {
            hSet.add(i);
        }
        int k = hSet.size();
        int j = 0;
        for (int i : hSet) {
            nums[j++] = i;
        }
        return k;
    }

    public static int removeDuplicatesOptimal(int[] nums) {
        // Optimal - Extra temp array
        // Time complexity - O(n)
        // Space complexity - O(n)
        // Efficent but extra space

        int n = nums.length;
        int temp[] = new int[n];
        int res = 0;
        temp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            if (temp[res] != nums[i]) {
                temp[++res] = nums[i];
            }
        }
        int t = 0;
        for (int i : temp) {
            nums[t++] = i;
        }
        return res + 1;

    }

    public static int removeDuplicatesOptimized(int[] nums) {
        // Optimzed - Using Two pointer
        // Time complexity - O(n)
        // Space complexity - O(1)
        // Efficient, in-place order

        int firstPointer = 0;
        for (int secondPointer = 1; secondPointer < nums.length; secondPointer++) {
            if (nums[firstPointer] != nums[secondPointer]) {
                firstPointer++;
                nums[firstPointer] = nums[secondPointer];
            }
        }
        return firstPointer + 1;
    }

}
