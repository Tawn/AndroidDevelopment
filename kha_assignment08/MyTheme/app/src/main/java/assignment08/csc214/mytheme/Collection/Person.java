package assignment08.csc214.mytheme.Collection;

/**
 * Created by Tkha on 6/20/17.
 */

public class Person {

    private String mName;


    public Person(String name) {
        mName = name;
    }

    @Override
    public String toString() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getName() {
        return mName;
    }

}
