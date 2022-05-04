package parcero.uv.contactlist;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import java.util.ArrayList;
import java.util.List;

public class DatabaseAdapter {
    DatabaseHelper helper;
    SQLiteDatabase db;
    List<Contact> contactList = new ArrayList<>();

    public DatabaseAdapter(Context context) {
        helper = new DatabaseHelper(context);
        db = helper.getWritableDatabase();

        // Clean and initialize DB with samples to have something to show.
        helper.insertSamples(db);
    }

    public List<Contact> getAllContacts() {
        String[] columns = {DatabaseHelper.KEY_ROWID, DatabaseHelper.KEY_NAME, DatabaseHelper.KEY_EMAIL};
        Cursor cursor = db.query(DatabaseHelper.TABLE_NAME, columns, null, null, null, null, null, null);
        while (cursor.moveToNext()) {
            int indexRowId = cursor.getColumnIndex(DatabaseHelper.KEY_ROWID);
            int rowId = cursor.getInt(indexRowId);
            int indexName = cursor.getColumnIndex(DatabaseHelper.KEY_NAME);
            String name = cursor.getString(indexName);
            int indexEmail = cursor.getColumnIndex(DatabaseHelper.KEY_EMAIL);
            String email = cursor.getString(indexEmail);
            Contact contact = new Contact(rowId, name, email);
            contactList.add(contact);
        }
        return contactList;
    }



}
