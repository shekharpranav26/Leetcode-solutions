# Title: Minimum Number of People to Teach
# Submission ID: 1766285780
# Status: Accepted
# Date: September 10, 2025 at 10:29:45 PM GMT+5:30

class Solution {

    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        Set<Integer> cncon = new HashSet<>();
        for (int[] friendship : friendships) {
            Map<Integer, Integer> mp = new HashMap<>();
            boolean conm = false;
            for (int lan : languages[friendship[0] - 1]) {
                mp.put(lan, 1);
            }
            for (int lan : languages[friendship[1] - 1]) {
                if (mp.containsKey(lan)) {
                    conm = true;
                    break;
                }
            }
            if (!conm) {
                cncon.add(friendship[0] - 1);
                cncon.add(friendship[1] - 1);
            }
        }
        int max_cnt = 0;
        int[] cnt = new int[n + 1];
        for (int friendship : cncon) {
            for (int lan : languages[friendship]) {
                cnt[lan]++;
                max_cnt = Math.max(max_cnt, cnt[lan]);
            }
        }
        return cncon.size() - max_cnt;
    }
}