package testcases.genericProgram.Programs_on_String;

public class StringReversal {

    public static void main(String[] args) {
        String input = "hello java";
        StringBuffer sb = new StringBuffer(input);
        System.out.println(sb.reverse());

        //or
        String rev = "";
        for(int i=input.length()-1;i>=0;i--){
            rev = rev+input.charAt(i);
        }
        System.out.println("Reversed String: "+rev);
    }
}
