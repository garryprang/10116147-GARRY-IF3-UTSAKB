package utsakb.com.garryprang10116147.model;

import android.os.Parcel;
import android.os.Parcelable;

/** Tanggal : 11 Mei 2020
 ** NIM     : 10116147
 ** Nama    : Garry Prang
 ** Kelas   : IF-3 **/

public class buddyme implements Parcelable {
    private int id;
    private String nim;
    private String nama;
    private String kelas;
    private String telpon;
    private String email;
    private String ig;
    private String date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public String getTelpon() {
        return telpon;
    }

    public void setTelpon(String telpon) {
        this.telpon = telpon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIg() {
        return ig;
    }

    public void setIg(String ig) {
        this.ig = ig;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    public buddyme(int id, String nim, String nama, String kelas, String telpon, String email, String ig, String date) {
        this.id = id;
        this.nim = nim;
        this.nama = nama;
        this.kelas = kelas;
        this.telpon = telpon;
        this.email = email;
        this.ig = ig;
        this.date = date;
    }



    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.nim);
        dest.writeString(this.nama);
        dest.writeString(this.kelas);
        dest.writeString(this.telpon);
        dest.writeString(this.email);
        dest.writeString(this.ig);
        dest.writeString(this.date);
    }

    public buddyme(){
    }

    public buddyme(Parcel in){
        this.id = in.readInt();
        this.nim = in.readString();
        this.nama = in.readString();
        this.kelas = in.readString();
        this.telpon = in.readString();
        this.email = in.readString();
        this.ig = in.readString();
        this.date = in.readString();
    }

    public static final Creator<buddyme> CREATOR = new Creator<buddyme>(){

        @Override
        public buddyme createFromParcel(Parcel source) {
            return new buddyme(source);
        }

        @Override
        public buddyme[] newArray(int size) {
            return new buddyme[size];
        }
    };
}
