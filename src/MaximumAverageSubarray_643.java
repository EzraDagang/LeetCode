/*
---GIVEN---
int[] nums = size (n)
int k

return max subarray.average where
    - contiguous (side-by-side) &&
    - subarray.length() = k

Initialize average with Integer.MIN_VALUE because the arrays could have negative numbers, so a negative average that is
the maximum could be obtained.

Strategy:

double sumAverage = Integer.MIN_VALUE;

for ( int i = 0; i + 4 < nums.length(); i++) {
    double sum = 0;
    for ( int j = i; j < i+4; j++){
        sum += nums[j];
    }

    if(sum/4 > sumAverage) sumAverage = sum/4;
}
 */
public class MaximumAverageSubarray_643 {
    public static double findMaxAverage(int[] nums, int k) {

        int currentSum = 0;

        for (int i = 0; i <= k - 1; i++) {
            currentSum += nums[i];
        }

        int largestSum = currentSum;

        for (int i = k; i <= nums.length - 1; i++) {
            currentSum = currentSum + nums[i] - nums[i - k];

            largestSum = Math.max(currentSum, largestSum);
        }

        return (double) largestSum / k;
    }
}


//public static double findMaxAverage(int[] nums, int k) {
//    double sumAverage = Integer.MIN_VALUE;
//
//    for (int i = 0; i < nums.length - k; i++) {
//        double sum = 0;
//        for (int j = i; j < i + k; j++) {
//            sum += nums[j];
//        }
//
//        if (sum / k > sumAverage)
//            sumAverage = sum / k;
//    }
//
//    return sumAverage;
//}

/// / 1. Calculate the sum of the first window
//int currentSum = 0;
//    for (int i = 0; i < k; i++) {
//currentSum += nums[i];
//        }
//
//int maxSum = currentSum;
//
/// / 2. Slide the window across the remaining elements
//    for (int i = k; i < nums.length; i++) {
//currentSum += nums[i] - nums[i - k]; // Add right, subtract left
//maxSum = Math.max(maxSum, currentSum);
//    }
//
//            // 3. Divide by k once at the end
//            return (double) maxSum / k;

