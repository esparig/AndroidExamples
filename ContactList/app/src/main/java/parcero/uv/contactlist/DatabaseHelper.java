package parcero.uv.contactlist;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "mydb.db";
    public static final String TABLE_NAME = "contacts";
    public static final int DATABASE_VERSION = 1;
    public static final String KEY_ROWID = "_id";
    public static final String KEY_NAME = "name";
    public static final String KEY_EMAIL = "email";
    public static final String CREATE_TABLE = "create table " + TABLE_NAME +
            " (" + KEY_ROWID + " integer primary key autoincrement, " + KEY_NAME + " text, " + KEY_EMAIL + " text)";
    public static final String DROP_TABLE = "drop table if exists " + TABLE_NAME;
    public static final String[] samples = {"INSERT INTO " + TABLE_NAME + " (" + KEY_NAME + ", " + KEY_EMAIL + ") VALUES ( 'alicia', 'alicia@mail.com')",
            "INSERT INTO " + TABLE_NAME + " (" + KEY_NAME + ", " + KEY_EMAIL + ") VALUES ( 'borja', 'borja@mail.com')",
            "INSERT INTO " + TABLE_NAME + " (" + KEY_NAME + ", " + KEY_EMAIL + ") VALUES ( 'carla', 'carla@mail.com')",
            "INSERT INTO " + TABLE_NAME + " (" + KEY_NAME + ", " + KEY_EMAIL + ") VALUES ( 'daniel', 'daniel@mail.com')",
            "INSERT INTO " + TABLE_NAME + " (" + KEY_NAME + ", " + KEY_EMAIL + ") VALUES ( 'elena', 'elena@mail.com')",
            "INSERT INTO " + TABLE_NAME + " (" + KEY_NAME + ", " + KEY_EMAIL + ") VALUES ( 'fidel', 'fidel@mail.com')",
            "INSERT INTO " + TABLE_NAME + " (" + KEY_NAME + ", " + KEY_EMAIL + ") VALUES ( 'guille', 'guille@mail.com')",
            "INSERT INTO " + TABLE_NAME + " (" + KEY_NAME + ", " + KEY_EMAIL + ") VALUES ( 'hector', 'hector@mail.com')",
            "INSERT INTO " + TABLE_NAME + " (" + KEY_NAME + ", " + KEY_EMAIL + ") VALUES ( 'isabel', 'isabel@mail.com')",
            "INSERT INTO " + TABLE_NAME + " (" + KEY_NAME + ", " + KEY_EMAIL + ") VALUES ( 'juana', 'juana@mail.com')"};
    public Context context;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
        Toast.makeText(context, "constructor called", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL(CREATE_TABLE);
            Toast.makeText(context, "onCreate called", Toast.LENGTH_SHORT).show();
        } catch (SQLException e) {
            Toast.makeText(context, "" + e, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try {
            Toast.makeText(context, "onUpgrade called", Toast.LENGTH_SHORT).show();
            db.execSQL(DROP_TABLE);
            onCreate(db);
        } catch (SQLException e) {
            Toast.makeText(context, "" + e, Toast.LENGTH_SHORT).show();
        }
    }

    public void insertSamples(SQLiteDatabase db) {
        try {
            db.execSQL(DROP_TABLE);
            onCreate(db);
            for (String sample : samples) {
                db.execSQL(sample);
            }
            Toast.makeText(context, "samples inserted", Toast.LENGTH_SHORT).show();
        } catch (SQLException e) {
            Toast.makeText(context, "" + e, Toast.LENGTH_SHORT).show();
        }
    }
}