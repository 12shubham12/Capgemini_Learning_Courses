package testcases.UI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayToArrayList {

    public static void main(String[] args) {
        int[] a = {1,6,2,8,5};
        List<Integer> arrayList = new ArrayList<>();
        for(int i=0;i<a.length;i++){
            arrayList.add(a[i]);
        }
        System.out.println(arrayList);

        String[] s = {"abc","efg","hij"};
        List<String> arrayList2 = new ArrayList<>(Arrays.asList(s));
        System.out.println(arrayList2);
    }

}
