public class MinimumSizeSubarraySum_209 {
    public static int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int left = 0;
        int minLength = Integer.MAX_VALUE;

        for (int right = 0; right <= nums.length - 1; right++) {
            sum += nums[right];

            while (sum >= target) {
                minLength = Math.min(minLength, right - left + 1);

                sum -= nums[left];
                left++;
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;

    }
}

//===============================
// SAMPLE ANSWER
//===============================

//    public static int minSubArrayLen(int target, int[] nums) {
//        int left = 0;
//        int sum = 0;
//        int minLength = Integer.MAX_VALUE;
//
//        for (int right = 0; right < nums.length; right++) {
//
//            sum += nums[right];
//
//            while (sum >= target) {
//
//                minLength = Math.min(minLength, right - left + 1);
//
//                sum -= nums[left];
//                left++;
//            }
//        }
//
//        return minLength == Integer.MAX_VALUE ? 0 : minLength;
//    }


//===============================
// PERSONAL ATTEMPT: 1
//===============================

//public static int minSubArrayLen(int target, int[] nums) {
//
//        int sum = 0, right = 0;
//
//        while (sum < target) {
//            sum = sum + nums[right];
//            right++;
//
//            if (right == nums.length) {
//                if (sum >= target)
//                    return right;
//                else
//                    return 0;
//            }
//        }
//        right =+ 1;
//        int minCount = right;
//
//        for (int left = 0; right <= nums.length - 1; left++) {
//            sum = sum - nums[left];
//
//            while (right < nums.length - 1) {
//                sum = sum + nums[right];
//                right++;
//
//                if (sum >= target) {
//                    if(right - left < minCount)
//                        minCount = right - left;
//                    break;
//                }
//            }
//        }
//
//        return minCount;
//    }
