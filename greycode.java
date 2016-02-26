//I was still wondering why can't I just add every element from 0~2^n to the list

public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> ans = new ArrayList<>();
        ans.add(0);

        for(int i = 0; i < n ; i++)
            for(int j = ans.size()-1; j>=0; j--)
                ans.add(ans.get(j)+(1<<i));

    return ans;
    }
}
