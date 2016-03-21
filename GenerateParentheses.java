//Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
public class Solution {
    List<String> result=new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        sub("(",1,0,n);
        return result;
    }
    public void sub(String s, int left, int right,int n){
        if(left==n) {
            if(right==n) result.add(s);
            else sub(s+")",left,right+1,n);
        }
        else{
            sub(s+"(",left+1,right,n);
            if(left!=right) sub(s+")",left,right+1,n);
        }
    }
}
