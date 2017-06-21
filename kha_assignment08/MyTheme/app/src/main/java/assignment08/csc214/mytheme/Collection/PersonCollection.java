package assignment08.csc214.mytheme.Collection;

import android.content.Context;
import android.database.CursorWrapper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tkha on 6/20/17.
 */

public class PersonCollection {

    private List<Person> mList;
    private static PersonCollection sPersonCollection;

    public PersonCollection(Context context) {
        mList = new ArrayList<>();
        Person person1 = new Person("Thanh");
        Person person2 = new Person("Ryan");
        Person person3 = new Person("Billy");
        Person person4 = new Person("Bryan");
        add(person1);
        add(person2);
        add(person3);
        add(person4);
        add(person2);
        add(person3);
        add(person4);

    }

    public void add(Person person) {
        mList.add(person);
    }

    public List<Person> getList() {
        return mList;
    }

    public static PersonCollection get(Context context) {
        if(sPersonCollection == null) {
            sPersonCollection = new PersonCollection(context);
        }
        return sPersonCollection;
    }


}
