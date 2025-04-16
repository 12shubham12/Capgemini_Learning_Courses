package testcases.genericProgram.Programs_on_String;

import java.util.HashMap;
import java.util.Map;

public class DuplicateWords_InString {

    public static void main(String[] args) {

        String input = "this is this what it is so it is it";

        String[] split = input.split(" ");
        Map<String, Integer> hm = new HashMap<>();
        for(String s: split){
            if(hm.containsKey(s)){
                hm.put(s, hm.get(s)+1);
            }
            else{
                hm.put(s,1);
            }
        }
        for(String s1:hm.keySet()){
            if(hm.get(s1)>=2){
                System.out.println("Duplicate word: "+s1+" ,Repeated times: "+hm.get(s1));
            }
        }
    }
}
