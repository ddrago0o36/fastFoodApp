package com.example.fastfoodapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.EditText;

public class DBHandler extends SQLiteOpenHelper {

    // DB name
    private static final String DB_NAME = "fastFood.db";

    //DB version
    private static final int DB_VERSION = 1;

    // DB- table name
    private static final String TABLE_NAME = "mylogin";

    //ID column
    private static final String ID_COL = "id";

    // below variable is for our course name column
    private static final String NAME_COL = "name";

    // below variable id for our course duration column.
    private static final String EMAIL_COL = "email";

    // below variable for our course description column.
    private static final String PASS_COL = "password";

    // below variable is for our course tracks column.
    private static final String REPPASS_COL = "reppass";

    // creating a constructor for our database handler.
    public DBHandler(Context cxt){
        super(cxt,DB_NAME,null,DB_VERSION);
    }

    // Create a DB

    public void onCreate(SQLiteDatabase db) {
        //SQlITE Query for creating DB table + var types
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME_COL + " TEXT,"
                + EMAIL_COL + " TEXT,"
                + PASS_COL + " TEXT,"
                + REPPASS_COL + " TEXT)";

        //Executing the query
        db.execSQL(query);
    }

    // this method is use to add new course to our sqlite database.
    public void addNewUser(String nameUser, String emailUser, String passUser, String repppassUser) {

        // on below line we are creating a variable for
        // our sqlite database and calling writable method
        // as we are writing data in our database.
        SQLiteDatabase db = this.getWritableDatabase();

        // on below line we are creating a
        // variable for content values.
        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put(NAME_COL, nameUser);
        values.put(EMAIL_COL, emailUser);
        values.put(PASS_COL, passUser);
        values.put(REPPASS_COL, repppassUser);

        // after adding all values we are passing
        // content values to our table.
        db.insert(TABLE_NAME, null, values);

        // at last we are closing our
        // database after adding database.
        db.close();
    }

    /**
     * Check for existing username and password
     * @param username
     * @param password
     * @return
     */
    public boolean checkusers(String username, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT *  FROM mylogin WHERE name = ? and password= ?",new String[] {username,password});
        if(cursor.getCount() >0)
            return true;
        else
            return false;
    }

    /**
     * Check if the DB has already been created
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

}
