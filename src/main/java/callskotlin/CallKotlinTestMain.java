package callskotlin;

import callbyjava.ClassCallByJavaTest;
import callbyjava.DataCallByJava;
import callbyjava.DataCallByJavaTest;

public class CallKotlinTestMain {
    public static void main(String[] args) {
        CallKotlinTestMain callKotlinTestMain = new CallKotlinTestMain();
//       callKotlinTestMain.callKotlinDataClassAttribute();
//        callKotlinTestMain.callKotlinPackageFunction();
        callKotlinTestMain.callKotlinClassFunction();
    }

    private void callKotlinClassFunction() {
        ClassCallByJavaTest classCallByJavaTest = new ClassCallByJavaTest();
        System.out.println("classCallByJavaTest.getName() = " + classCallByJavaTest.getName());
        // 注意 @JvmField 注解的作用
        System.out.println("classCallByJavaTest.name1 = " + classCallByJavaTest.name1);
        System.out.println("classCallByJavaTest.birthDate = " + classCallByJavaTest.birthDate);
        classCallByJavaTest.function1();
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