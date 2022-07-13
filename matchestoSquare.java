class Solution {
    public boolean makesquare(int[] matchsticks) {
        int sum = 0;
        for (int sides : matchsticks)
            sum += sides;
        if (sum % 4 != 0)
            return false;
        int len = matchsticks.length;
        boolean[] visited = new boolean[len];
        return kEqualSubset(matchsticks, 0, len, 0, 4, 0, sum / 4, visited);
    }

    public static boolean kEqualSubset(int[] arr, int index, int len, int bucket, int totalSide, int sum, int target,
            boolean[] visited) {

        if (target < sum)
            return false;
        if (bucket == 3)
            return true;

        if (sum == target) {
            return kEqualSubset(arr, 0, len, bucket + 1, totalSide, 0, target, visited);
        }
        if (index == len)
            return false;
        if (visited[index])
            return kEqualSubset(arr, index + 1, len, bucket, totalSide, sum, target, visited);
        else {

            // pick Up
            visited[index] = true;
            boolean op1 = kEqualSubset(arr, index + 1, len, bucket, totalSide, sum + arr[index], target, visited);
            visited[index] = false;

            // Not pick up
            boolean op2 = kEqualSubset(arr, index + 1, len, bucket, totalSide, sum, target, visited);

            return op1 | op2;
        }

    }
}