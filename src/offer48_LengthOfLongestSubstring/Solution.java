package offer48_LengthOfLongestSubstring;

import java.util.HashMap;

/**
 * @Author WangBei
 * @Date 2021/7/23 10:56
 * @Description:
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        int len = 0;
        HashMap<Character, Integer> hm = new HashMap<>();       // 哈希表中key是字符，value是下标
        for (int i = 0; i < s.length(); i++) {

/*          方法一：
            if (hm.containsKey(s.charAt(i))) {              // 哈希表中存在当前字符
                int index = hm.get(s.charAt(i));            // 获取上一次出现当前字符的位置
                if (i - index <= len) {     // 当前字符在计数区间内，改变当前区间长度
                    len = i - index;
                } else {                    // 当前字符不在计数区间内，区间长度+1
                    len++;
                }
                hm.put(s.charAt(i), i);    // 更新哈希表
            } else {                                        // 哈希表中不存在当前字符
                hm.put(s.charAt(i), i);
                len++;
            }
*/

            // 简化
            int index = hm.getOrDefault(s.charAt(i), -1);        // hm中包含key时返回value，否则返回设置的默认值
            hm.put(s.charAt(i), i);
            if (i - index > len) {
                len++;
            } else {
                len = i - index;
            }

            maxLen = Math.max(maxLen, len);
        }
        return maxLen;
    }
}
