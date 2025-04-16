package testcases.genericProgram.Programs_on_String;

import java.util.HashMap;
import java.util.Map;

public class WordCount_In_String {

    public static void main(String[] args) {

        String input = "hello this is hello and hello is gesture";

        String[] split = input.split(" ");
        Map<String, Integer> hm = new HashMap<>();
        for(String s:split){
            if(hm.containsKey(s)){
                hm.put(s,hm.get(s)+1);
            }
            else{
                hm.put(s,1);
            }
        }
        System.out.println(hm);
    }
}
