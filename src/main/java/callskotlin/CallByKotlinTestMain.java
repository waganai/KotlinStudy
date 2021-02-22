package callskotlin;

import java.util.Date;

public class CallByKotlinTestMain {
    public static CallByKotlinTestMain object = new CallByKotlinTestMain();

    public String name = "name";
    public int id = 233;

    public Date birthDate;

    @Override
    public String toString() {
        return "CallByKotlinTestMain{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
