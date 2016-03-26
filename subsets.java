/*
Given a set of distinct integers, nums, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
*/

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result=new ArrayList<>();
        result.add(new ArrayList<>());
        for(int i:nums){
            List<List<Integer>> res=new ArrayList<>();
            for(List<Integer> list: result){
                List<Integer> temp=new ArrayList<>(list);
                temp.add(i);
                res.add(temp);
            }
            result.addAll(res);
        }
        return result;
    }
}

/*
Given a collection of integers that might contain duplicates, nums, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If nums = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
*/
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Map<Integer,Integer> map=new TreeMap<>();
        for(int i:nums){
            if(map.containsKey(i)) {
                int count=map.get(i);
                count++;
                map.put(i,count);
            }
            else{
                map.put(i,1);
            }
        }
        List<List<Integer>> result=new ArrayList<>();
        result.add(new ArrayList<>());
        for(int i:map.keySet()){
            int count=map.get(i);
            List<Integer> temp=new ArrayList<>();
            List<List<Integer>> re=new ArrayList<>();
            for(int j=0;j<count;j++){
                temp.add(i);
                List<Integer> tt=new ArrayList<>(temp);
                for(List<Integer> list:result){
                    List<Integer> tempp=new ArrayList<>(list);
                    tempp.addAll(tt);
                    re.add(tempp);
                }
            }
            result.addAll(re);
        }
        return result;
    }
    
}


