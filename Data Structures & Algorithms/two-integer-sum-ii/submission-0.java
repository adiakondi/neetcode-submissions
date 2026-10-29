class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int leftIdx = 0;
        int rightIdx = numbers.length-1;
        int[] solution = new int[2];
        boolean found = false;

        while(leftIdx < rightIdx && found == false) {
            int sum = numbers[leftIdx] + numbers[rightIdx];
            if(sum > target) {
                rightIdx--;
            }
            else if(sum < target) {
                leftIdx++;
            }
            else if(sum == target) {
                leftIdx++; rightIdx++;
                solution[0] = leftIdx;
                solution[1] = rightIdx;
                found = true;
            }
        }
        return solution;
    }
}
