package generic;

import java.util.ArrayList;
import java.util.List;

public class GenericTestMain<T extends Animal> {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(1));
        arrayList.add(Integer.valueOf(2));
        arrayList.add(Integer.valueOf(3));
        arrayList.add(Integer.valueOf(4));

        List<? extends Number> list1 = new ArrayList<Integer>(arrayList);

        for (int i = 0; i < list1.size(); i++) {
            System.out.println("list1.get(" + i + ") = " + list1.get(i));
        }

//        Object object = list1.get(0);
        Number integer  = list1.get(0);

        List<? super Cat> list2 = new ArrayList<Animal>();
        list2.add(new Cat());
        list2.add(new WhiteTiger());

        System.out.println("list2.get(0) instanceof Object == " + list2.get(0));
        System.out.println("list2.get(1) instanceof Object == " + list2.get(1));

        // 对于 <? super T>，只能往内部设置值，不能往外读取值，除非是Object object =
        Object object = list2.get(0);
        list2.set(0, new Tiger());

        System.out.println("list2.get(0) instanceof Object == " + list2.get(0));

        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new Animal());
        arrayList2.add(new Cat());
        arrayList2.add(new Tiger());
        arrayList2.add(new WhiteTiger());
        List<? extends Animal> list3 = new ArrayList<Animal>(arrayList2);
        System.out.println("list3.get(0) instanceof Object == " + list3.get(0).getName());
        System.out.println("list3.get(0) instanceof Object == " + list3.get(1).getName());
        System.out.println("list3.get(0) instanceof Object == " + list3.get(2).getName());
        System.out.println("list3.get(0) instanceof Object == " + list3.get(3).getName());
    }
}

class Animal {
    public String getName() {
        return "Animal";
    }
}

class Cat extends Animal {
    @Override
    public String getName() {
        return "Cat";
    }
}

class Tiger extends Cat {
    @Override
    public String getName() {
        return "Tiger";
    }
}

class WhiteTiger extends Tiger {
    @Override
    public String getName() {
        return "WhiteTiger";
    }
}

class Lion extends Cat {
    @Override
    public String getName() {
        return "Lion";
    }
}

