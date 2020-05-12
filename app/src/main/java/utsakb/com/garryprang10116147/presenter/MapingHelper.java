package utsakb.com.garryprang10116147.presenter;

import android.database.Cursor;

import java.util.ArrayList;

import utsakb.com.garryprang10116147.model.buddyme;

/** Tanggal : 11 Mei 2020
 ** NIM     : 10116147
 ** Nama    : Garry Prang
 ** Kelas   : IF-3 **/

public class MapingHelper {

    public static ArrayList<buddyme> mapCursorToArrayList(Cursor friendsCursor){
        ArrayList<buddyme> friendsList = new ArrayList<>();

        while (friendsCursor.moveToNext()){
            int id  = friendsCursor.getInt(friendsCursor.getColumnIndexOrThrow(DatabaseContract.NoteColumns._ID));
            String nim = friendsCursor.getString(friendsCursor.getColumnIndexOrThrow(DatabaseContract.NoteColumns.NIM));
            String nama = friendsCursor.getString(friendsCursor.getColumnIndexOrThrow(DatabaseContract.NoteColumns.NAMA));
            String kelas = friendsCursor.getString(friendsCursor.getColumnIndexOrThrow(DatabaseContract.NoteColumns.KELAS));
            String telp = friendsCursor.getString(friendsCursor.getColumnIndexOrThrow(DatabaseContract.NoteColumns.TELPON));
            String email = friendsCursor.getString(friendsCursor.getColumnIndexOrThrow(DatabaseContract.NoteColumns.EMAIL));
            String ig = friendsCursor.getString(friendsCursor.getColumnIndexOrThrow(DatabaseContract.NoteColumns.IG));
            String date = friendsCursor.getString(friendsCursor.getColumnIndexOrThrow(DatabaseContract.NoteColumns.DATE));
            friendsList.add(new buddyme(id, nim, nama, kelas, telp, email, ig, date));

        }
        return friendsList;
    }
}
