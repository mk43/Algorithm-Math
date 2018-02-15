package testCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class T12 {

    public static void main(String args[]) {
//        String s = "catsanddog";
//        String s = "aaaaaaa";
        String s = "dogs";
//        String[] ss = {"cat", "cats", "and", "sand", "dog"};
//        String[] ss = {"aaaa","aa","a"};
        String[] ss = {"dog","s","gs"};
        Set<String> dict = new HashSet<>();
        for (String str : ss) {
            dict.add(str);
        }
        System.out.print(wordBreak(s, dict));
    }

    public static boolean wordBreak(String s, Set<String> dict) {
        ArrayList<String> result = new ArrayList<>();

        boolean flag = false;
        for (int i = s.length() - 1; i >= 0; --i) {
            String word = s.substring(i, s.length());
            if (dict.contains(word)) {
                flag = wordBreak(s.substring(0, i), dict);
                if (flag == true || 0 == i) {
                    return true;
                }
            }
        }
        return flag;
    }

}