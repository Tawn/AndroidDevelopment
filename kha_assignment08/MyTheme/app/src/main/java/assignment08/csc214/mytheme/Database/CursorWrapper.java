package assignment08.csc214.mytheme.Database;

import android.database.Cursor;

import assignment08.csc214.mytheme.Collection.Person;

/**
 * Created by Tkha on 6/21/17.
 */

public class CursorWrapper extends android.database.CursorWrapper{

    public CursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public Person getPerson() {
        String name = getString(getColumnIndex(Schema.PersonTable.Columns.NAME));
        Person person = new Person(name);
        return person;
    }
}
