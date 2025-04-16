package testcases.genericProgram.Programs_on_String;

public class ReverseStringNotWords {


    public static void main(String[] args) {
        String input = "Hello World";
        String expected = "World Hello";

        String[] split = input.split(" ");
        String rev = "";
        for(int i = split.length-1;i>=0;i--){
            rev = rev+split[i];
            rev = rev+" ";
        }
        rev= rev.trim();
        System.out.println(rev);
    }
}
