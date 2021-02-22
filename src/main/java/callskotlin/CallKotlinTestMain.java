package callskotlin;

import callbyjava.ClassCallByJavaTest;
import callbyjava.DataCallByJava;
import callbyjava.DataCallByJavaTest;
import callbyjava.ObjectCallByJavaTest;

import java.text.ParseException;

public class CallKotlinTestMain {
    public static void main(String[] args) {
        CallKotlinTestMain callKotlinTestMain = new CallKotlinTestMain();
//       callKotlinTestMain.callKotlinDataClassAttribute();
//        callKotlinTestMain.callKotlinPackage();
//        callKotlinTestMain.callKotlinClass();
//        callKotlinTestMain.callKotlinClassStatic();
//        callKotlinTestMain.callKotlinObject();
        callKotlinTestMain.callKotlinException();
    }

    private void callKotlinClass() {
        ClassCallByJavaTest classCallByJavaTest = new ClassCallByJavaTest();
        System.out.println("classCallByJavaTest.getName() = " + classCallByJavaTest.getName());
        // 注意 @JvmField 注解的作用
        System.out.println("classCallByJavaTest.name1 = " + classCallByJavaTest.name1);
        System.out.println("classCallByJavaTest.birthDate = " + classCallByJavaTest.birthDate);
        classCallByJavaTest.function1();
    }

    private void callKotlinClassStatic() {
        System.out.println("ClassCallByJavaTest.Companion.getId() = " + ClassCallByJavaTest.Companion.getId());
        // 注意 @JvmField 注解的作用
        System.out.println("ClassCallByJavaTest.id1 = " + ClassCallByJavaTest.id1);
        System.out.println("ClassCallByJavaTest.birthDate2 = " + ClassCallByJavaTest.birthDate2);
        ClassCallByJavaTest.Companion.function2();
    }

    private void callKotlinObject() {
        System.out.println("ObjectCallByJavaTest.INSTANCE.getName() = " + ObjectCallByJavaTest.INSTANCE.getName());
        // 注意 @JvmField 注解的作用
        System.out.println("ObjectCallByJavaTest.name1 = " + ObjectCallByJavaTest.name1);
        System.out.println("ObjectCallByJavaTest.birtDate = " + ObjectCallByJavaTest.birtDate);
        ObjectCallByJavaTest.INSTANCE.function1();
    }

    private void callKotlinException() {
        ClassCallByJavaTest classCallByJavaTest = new ClassCallByJavaTest();
        try {
            classCallByJavaTest.functionException();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println("callKotlinException() finish");
    }

    private void callKotlinPackageFunction() {
        // @file: JvmName("xxxx")和kt文件名的使用似乎不是共存的
//        DataCallByJavaTest.packageFunctionCallByJava();
        DataCallByJava.packageFunctionCallByJava();

        System.out.println("DataCallByJava.getPackageAttributeCallByJava() is " + DataCallByJava.getPackageAttributeCallByJava());
    }

    private void callKotlinDataClassAttribute() {
        DataCallByJavaTest dataCallByJavaTest = new DataCallByJavaTest();

        System.out.println("dataCallByJavaTest.getName1() = " + dataCallByJavaTest.getName1());
        System.out.println("dataCallByJavaTest.getId1() = " + dataCallByJavaTest.getId1());

        System.out.println("dataCallByJavaTest.getName2() = " + dataCallByJavaTest.getName2());
        System.out.println("dataCallByJavaTest.getId2() = " + dataCallByJavaTest.getId2());

        System.out.println("dataCallByJavaTest.getName3() = " + dataCallByJavaTest.getName3());
        System.out.println("dataCallByJavaTest.getId3() = " + dataCallByJavaTest.getId3());

        System.out.println("dataCallByJavaTest.getName4() = " + dataCallByJavaTest.getName4());
        System.out.println("dataCallByJavaTest.getId4() = " + dataCallByJavaTest.getId4());

        dataCallByJavaTest.setName1("Kotlin");
        dataCallByJavaTest.setId1(666);

        dataCallByJavaTest.setName3("Android");
        dataCallByJavaTest.setId3(123456789);

        System.out.println("after change, dataCallByJavaTest.getName1() = " + dataCallByJavaTest.getName1());
        System.out.println("after change, dataCallByJavaTest.getId1() = " + dataCallByJavaTest.getId1());

        System.out.println("after change, dataCallByJavaTest.getName3() = " + dataCallByJavaTest.getName3());
        System.out.println("after change, dataCallByJavaTest.getId3() = " + dataCallByJavaTest.getId3());
    }
}