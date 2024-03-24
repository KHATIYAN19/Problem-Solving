import java.util.*;
public class Solution {
      public int upperBound(List<Integer> list, int target) {
        int left = 0;
        int right = list.size();
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
    public int findMedian(List<List<Integer>> A) {
        int r = A.size();
        int c = A.get(0).size();
        int req = (r * c + 1) / 2;
        int minm = Integer.MAX_VALUE;
        int maxm = Integer.MIN_VALUE;
        for (int i = 0; i < r; i++) {
            minm = Math.min(minm, A.get(i).get(0));
            maxm = Math.max(maxm, A.get(i).get(c - 1));
        }
        while (minm < maxm) {
            int mid = minm + (maxm - minm) / 2;
            int place = 0;
            for (int i = 0; i < r; i++) {
                place += upperBound(A.get(i), mid) - A.get(i).indexOf(0);
            }
            if (place < req) {
                minm = mid + 1;
            } else {
                maxm = mid;
            }
        }
        return minm;
    }
}

