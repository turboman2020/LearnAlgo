package CodeInterviews.src.LeetcodeHot100.P02_Leetcode49;

import java.util.*;

public class Solution {
    public static void main(String [] args){
        String [] strs = new String [] {"eat","tea","tan","ate","nat","bat"};
        groupAnagrams(strs);

    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(int i = 0; i < strs.length; i++){
            char [] temp = strs[i].toCharArray();
            Arrays.sort(temp);
            String key = String.valueOf(temp);
            List<String> s = map.getOrDefault(key, new LinkedList<String>());
            s.add(strs[i]);
            map.put(key, s);
        }

        return new ArrayList<>(map.values());

    }
}
