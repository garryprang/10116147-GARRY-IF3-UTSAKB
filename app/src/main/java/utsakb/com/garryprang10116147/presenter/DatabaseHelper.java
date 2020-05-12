package utsakb.com.garryprang10116147.presenter;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/** Tanggal : 11 Mei 2020
 ** NIM     : 10116147
 ** Nama    : Garry Prang
 ** Kelas   : IF-3 **/

public class DatabaseHelper extends SQLiteOpenHelper {

    public static String DATABASE_NAME = "dbfriendapp";
    private static final int DATABASE_VERSION =1;
    private static final String SQL_CREATE_TABLE_NOTE = String.format("CREATE TABLE %s"
                        + " (%s INTEGER PRIMARY KEY AUTOINCREMENT," +
                        " %s TEXT NOT NULL," +
                        " %s TEXT NOT NULL," +
                        " %s TEXT NOT NULL," +
                        " %s TEXT NOT NULL," +
                        " %s TEXT NOT NULL," +
                        " %s TEXT NOT NULL," +
                        " %s TEXT NOT NULL)",
            DatabaseContract.TABLE_NAME,
            DatabaseContract.NoteColumns._ID,
            DatabaseContract.NoteColumns.NIM,
            DatabaseContract.NoteColumns.NAMA,
            DatabaseContract.NoteColumns.KELAS,
            DatabaseContract.NoteColumns.TELPON,
            DatabaseContract.NoteColumns.EMAIL,
            DatabaseContract.NoteColumns.IG,
            DatabaseContract.NoteColumns.DATE

    );

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE_NOTE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DatabaseContract.TABLE_NAME);
        onCreate(db);
    }
}
