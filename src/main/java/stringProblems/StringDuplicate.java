package stringProblems;

import java.util.*;

/*
Remove the duplicates, count of duplicates and reverse teh string
 */
public class StringDuplicate {

    static void solution(String str) {
        String[] strArr = str.split(" ");

        Map<String, Integer> accrace = new HashMap<String, Integer>();

        for (String word : strArr) {
            if (accrace.containsKey(word)) {
                accrace.put(word, accrace.get(word) + 1);
            } else {
                accrace.put(word, 1);
            }
        }

        Set<Map.Entry<String, Integer>> entrySet = accrace.entrySet();
        List<String> duplicate = new ArrayList<String>();
        for (Map.Entry<String, Integer> entry : entrySet) {
            if (entry.getValue() > 1) {
                duplicate.add(entry.getKey());
            }
        }
        String dupString = getString(duplicate);
        System.out.println(dupString);

        //remove the dulpicates

        List<String> strAsList = new ArrayList<>(Arrays.asList(strArr));
        strAsList.removeAll(duplicate);
        String removeDup = "";
        for (String s : strAsList) {
            removeDup += " " + s;
        }
        System.out.println(removeDup);

        //reverse the string
        StringBuilder reverse = new StringBuilder();
        for (int i = strArr.length - 1; i >= 0; i--) {
            reverse.append(" ").append(strArr[i]);
        }

        System.out.println(reverse);

    }

    private static String getString(List<String> duplicate) {
        StringBuilder dupString = new StringBuilder();
        for (String s : duplicate) {
            dupString.append(" ").append(s);
        }
        return dupString.toString();
    }


    public static void main(String[] args) {
        solution("this is Me my name is Saurabh");
    }

}
