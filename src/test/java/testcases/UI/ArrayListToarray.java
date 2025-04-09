package testcases.UI;

import java.util.ArrayList;
import java.util.List;

public class ArrayListToarray {

    public static void main(String[] args) {
        List<String> arrayList = new ArrayList<>();
        arrayList.add("abc");
        arrayList.add("abc2");
        arrayList.add("abc3");

        System.out.println(arrayList);

        String[] s = arrayList.toArray(new String[0]);

        List<Integer> arrayList2 = new ArrayList<>();
        arrayList.add("1");
        arrayList.add("4");
        arrayList.add("8");

        System.out.println(arrayList2);

        Integer[] s2 = arrayList2.toArray(new Integer[0]);
    }


}
