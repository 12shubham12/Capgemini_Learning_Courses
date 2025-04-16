package testcases.genericProgram.Programs_on_String;

public class ReverseWordsOnly {

    public static void main(String[] args) {

        String input = "Hello World";
        String expected = "olleH dlroW";

        String[] split = input.split(" ");

        String rev = "";
        for(String s: split){
            char[] ch = s.toCharArray();
            for(int i=ch.length-1;i>=0;i--){
                rev = rev+ch[i];
            }
            rev = rev+" ";
        }
        rev = rev.trim();
        System.out.println(rev);
    }
}
