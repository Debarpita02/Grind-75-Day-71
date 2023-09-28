import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        
        generatePermutations(nums, used, current, result);
        
        return result;
    }
    
    private void generatePermutations(int[] nums, boolean[] used, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current)); // Add a copy of the current permutation
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                current.add(nums[i]);
                used[i] = true;
                
                generatePermutations(nums, used, current, result);
                
                current.remove(current.size() - 1); // Backtrack
                used[i] = false;
            }
        }
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        int[] nums1 = {1, 2, 3};
        List<List<Integer>> result1 = solution.permute(nums1);
        System.out.println(result1);
        
        int[] nums2 = {0, 1};
        List<List<Integer>> result2 = solution.permute(nums2);
        System.out.println(result2);
        
        int[] nums3 = {1};
        List<List<Integer>> result3 = solution.permute(nums3);
        System.out.println(result3);
    }
}
