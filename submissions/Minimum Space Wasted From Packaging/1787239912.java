# Title: Minimum Space Wasted From Packaging
# Submission ID: 1787239912
# Status: Accepted
# Date: September 30, 2025 at 06:26:30 PM GMT+5:30

class Solution {
    public int minWastedSpace(int[] packages, int[][] boxes) {
        Arrays.sort(packages);
        int n = packages.length;
        long minTotalBoxSize = Long.MAX_VALUE;
        for (int[] boxSizes : boxes) {
            Arrays.sort(boxSizes);
            if (boxSizes[boxSizes.length - 1] < packages[n-1]) continue; // if the largest box can't pack the largest package -> skip
            long totalBoxSize = 0;  // Total box size to pack all n packages
            int startIdx = 0;
            for (int boxSize : boxSizes) {
                int idx = searchLargestElementLessOrEqual(packages, boxSize, startIdx);  // find the largest index of the package which is less or equal to boxSize
                long packedCount = (idx - startIdx + 1);  // number of remain packages that this box can be packed.
                totalBoxSize += packedCount * boxSize;
                startIdx = idx + 1;
            }
            minTotalBoxSize = Math.min(minTotalBoxSize, totalBoxSize);
        }
        if (minTotalBoxSize == Long.MAX_VALUE) return -1;  // can't packed all n packages
        long totalPackageSize = 0;
        for (int p : packages) totalPackageSize += p;
        return (int) ((minTotalBoxSize - totalPackageSize) % 1_000_000_007);  // minTotalWasted = totalBoxSize - totalPackageSize
    }
    int searchLargestElementLessOrEqual(int[] arr, int x, int left) {
        int right = arr.length - 1, ans = left - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] <= x) { // found an answer -> try to find better answer in the right side
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1; // find in the left side
            }
        }
        return ans;
    }
}