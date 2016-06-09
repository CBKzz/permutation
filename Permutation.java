//Given a collection of distinct numbers, return all possible permutations.

public class Solution {
    List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> list=new ArrayList<>();
        for(int i:nums){
            list.add(i);
        }
        sub(list,new ArrayList<>());
        return result;
    }
    public void sub(List<Integer> list, List<Integer> re){
        if(list.isEmpty()) {
            result.add(re);
            return;
        }
        for(int i=0;i<list.size();i++){
            List<Integer> temp=new ArrayList<>(list);
            List<Integer> temp1=new ArrayList<>(re);
            temp1.add(temp.remove(i));
            sub(temp,temp1);
        }
    }
}


//Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]



public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        helper(result, nums, 0, new ArrayList<>());
        return result;
    }
    public void helper(List<List<Integer>> result, int[] nums, int index, List<Integer> list){
        if(index==nums.length){
            result.add(new ArrayList<>(list));
            return ;
        }
        Set<Integer> set=new HashSet<>();
        for(int i=index;i<nums.length;i++){
            if(!set.contains(nums[i])){
            list.add(nums[i]);
            set.add(nums[i]);
            swap(nums,i, index);
            helper(result,nums, index+1, list);
            list.remove(list.size()-1);
            swap(nums,i, index);
            }
        }
    }
    public void swap(int [] nums, int i, int j){
        int t=nums[i];
        nums[i]=nums[j];
        nums[j]=t;
    }
}
