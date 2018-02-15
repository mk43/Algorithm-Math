package testCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class T11 {

    public static void main(String args[]) {
//        String s = "catsanddog";
        String s = "aaaaaaa";
//        String[] ss = {"cat", "cats", "and", "sand", "dog"};
        String[] ss = {"aaaa","aa","a"};
        Set<String> dict = new HashSet<>();
        for (String str : ss) {
            dict.add(str);
        }
//        System.out.print(s.substring(0, 10));
        ArrayList<String> result = wordBreak(s, dict);
        for (String sss : result) {
            System.out.println(sss);
        }
    }

    public static ArrayList<String> wordBreak(String s, Set<String> dict) {
        ArrayList<String> result = new ArrayList<>();

        ArrayList<String> temp = new ArrayList<>();
        for (int i = s.length() - 1; i >= 0; --i) {
            String word = s.substring(i, s.length());
            if (dict.contains(word)) {
                temp = wordBreak(s.substring(0, i), dict);
                if (0 == temp.size() && i == 0) {
                    result.add(word);
                } else {
//                    for (int j = temp.size() - 1; j >= 0; --j) {
//                        result.add(temp.get(j) + " " + word);
//                    }
                    for (String str : temp) {
                        result.add(str + " " + word);
                    }
                }
            }
        }
//        temp.clear();
//        for (int i = result.size() - 1; i >= 0; --i) {
//            System.out.println(result.get(i));
//            temp.add(result.get(i));
//        }

        return result;
//        return temp;
    }

}


//    public static ArrayList<String> wordBreak(String s, Set<String> dict) {
//        ArrayList<String> result = new ArrayList<>();
//        ArrayList<String> temp = new ArrayList<>();
//        for (int i = 0; i < s.length(); ++i) {
//            String word = s.substring(0, i + 1);
//            if (dict.contains(word)) {
//                temp = wordBreak(s.substring(i + 1, s.length()), dict);
//                if (0 == temp.size() && i == s.length() - 1) {
//                    result.add(word);
//                } else {
//                    for (String str : temp) {
//                        result.add(word + " " + str);
//                    }
//                }
//            }
//        }
//        return result;
//    }