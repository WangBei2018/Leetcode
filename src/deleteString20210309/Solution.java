package deleteString20210309;

public class Solution {
    public String removeDuplicates(String S) {
        StringBuilder sb = new StringBuilder(S);
//         for(int i=0; i < S.length(); i++){
//             System.out.println(S.charAt(i));
//             System.out.println(sb.charAt(i));
//         }
        int i = 1;
        int flag = 0;
        while(i < sb.length()){
            if(sb.charAt(i) == sb.charAt(i-1)){
                flag = 1;
                sb.deleteCharAt(i);
                continue;
            }else if(flag == 1){
                sb.deleteCharAt(i-1);
                flag = 0;
                if(i > 1){
                    i--;
                }
            }else{
                i++;
            }
        }
        if(flag == 1){
            sb.deleteCharAt(i-1);
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String S = "bbsdgf";
        Solution sl = new Solution();
        String s2 = sl.removeDuplicates(S);
        System.out.println("s2:" + s2);
    }
}
