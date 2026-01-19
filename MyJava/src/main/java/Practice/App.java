package Practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {

    public static void main(String[] args) {
        System.out.println(solution("azABaabza"));
    }

    public static  int solution(String s) {

        Map<Integer, Integer> asciiIndex = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            asciiIndex.put((int) s.charAt(i), i);
        }
        String fragment = "";
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                int upperChar = (int) ch - 32;
                if (asciiIndex!=null && asciiIndex.get(upperChar) != null) {
                    fragment+=ch;
                } else {
                    fragment = "";
                }
            } else if (ch >= 'A' && ch <= 'Z') {
                int lowerChar = (int) ch + 32;
                if (asciiIndex!=null && asciiIndex.get(lowerChar) !=null) {
                    fragment += ch;

                } else {
                    fragment = "";
                }
            }

        }

        fragment=getValidFragment(fragment);


        System.out.println(fragment);
        return (fragment.length() >1) ? fragment.length() : -1;

    }

    private static String getValidFragment(String fragment) {
        Map<Character, List<Integer>> validIndexes= new HashMap<>();
        for(int i= 0;i<fragment.length();i++){
            List<Integer> indexList= new ArrayList<>();
            List<Integer> existingIndexes = validIndexes.get(fragment.charAt(i));
            if(existingIndexes !=null && existingIndexes.size()>0 ){
                existingIndexes.add(i);
                validIndexes.put(fragment.charAt(i), existingIndexes);
            }
            else {
                indexList.add(i);
                validIndexes.put(fragment.charAt(i), indexList);
            }


        }

        int start=0;
        int end=fragment.length()-1;
        String validFragment="";
        while(start<=end){
          char ch= fragment.charAt(start);
            if (ch >= 'a' && ch <= 'z') {
                int upperChar = (int) ch - 32;
                List<Integer> indexes = validIndexes.get(upperChar);
                if (indexes != null && indexes.size() > 0) {
                    start++;
                    end--;
                    if(indexes.get(upperChar)<end){
                        validFragment+=ch;
                    }
                } else {
                    end--;
                    validFragment="";
                }
            }

            if (ch >= 'A' && ch <= 'Z') {
                int lowerChar = (int) ch + 32;
                List<Integer> indexes = validIndexes.get(lowerChar);
                if (indexes != null && indexes.size() > 0) {
                    start++;
                    end--;
                    if(indexes.get(lowerChar)<end){
                        validFragment+=ch;
                    }
                } else {
                    end--;
                    validFragment="";
                }
            }

        }

        return validFragment;

    }

}
