package generic;

import java.util.ArrayList;

public class ArrayGenericTestMain {
    public static void main(String[] args) {
        Object[] objects;
        String[] strs = new String[10];
        objects = strs;
//        objects[0] = Integer.valueOf(0);
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("666");

        System.out.println("strs' type is" + strs.getClass());
        System.out.println("arrayList' type is" + arrayList.getClass());

//        ArrayList<Object> objectList = arrayList;

        ArrayList arrayList1 = new ArrayList();
        ArrayList arrayList2 = new ArrayList<String>();
    }
}