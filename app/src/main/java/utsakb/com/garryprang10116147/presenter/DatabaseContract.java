package utsakb.com.garryprang10116147.presenter;

import android.provider.BaseColumns;

/** Tanggal : 11 Mei 2020
 ** NIM     : 10116147
 ** Nama    : Garry Prang
 ** Kelas   : IF-3 **/

public class DatabaseContract {

    static String TABLE_NAME = "friend";

    public static final class NoteColumns implements BaseColumns{
       public static String NIM = "nim";
       public static String NAMA = "nama";
       public static String KELAS = "kelas";
       public static String TELPON = "telpon";
       public static String EMAIL = "email";
       public static String IG = "ig";
       public static String DATE = "date";
    }
}
