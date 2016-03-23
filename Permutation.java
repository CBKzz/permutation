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
