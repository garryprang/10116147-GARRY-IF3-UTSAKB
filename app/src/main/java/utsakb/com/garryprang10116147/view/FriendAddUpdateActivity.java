package utsakb.com.garryprang10116147.view;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import utsakb.com.garryprang10116147.R;
import utsakb.com.garryprang10116147.model.buddyme;
import utsakb.com.garryprang10116147.presenter.FriendHelper;

import static utsakb.com.garryprang10116147.presenter.DatabaseContract.NoteColumns.DATE;
import static utsakb.com.garryprang10116147.presenter.DatabaseContract.NoteColumns.EMAIL;
import static utsakb.com.garryprang10116147.presenter.DatabaseContract.NoteColumns.IG;
import static utsakb.com.garryprang10116147.presenter.DatabaseContract.NoteColumns.KELAS;
import static utsakb.com.garryprang10116147.presenter.DatabaseContract.NoteColumns.NAMA;
import static utsakb.com.garryprang10116147.presenter.DatabaseContract.NoteColumns.NIM;
import static utsakb.com.garryprang10116147.presenter.DatabaseContract.NoteColumns.TELPON;

/** Tanggal : 11 Mei 2020
 ** NIM     : 10116147
 ** Nama    : Garry Prang
 ** Kelas   : IF-3 **/

public class FriendAddUpdateActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtNim, edtNama, edtKelas, edtNohp, edtEmail, edtIg;
    private Button btnSubmit;

    private boolean isEdit = false;
    private buddyme buddyme;
    private int position;
    private FriendHelper friendHelper;

    public static final String EXTRA_NOTE = "extra_note";
    public static final String EXTRA_POSITION = "extra_position";
    public static final int REQUEST_ADD = 100;
    public static final int RESULT_ADD = 101;
    public static final int REQUEST_UPDATE = 200;
    public static final int RESULT_UPDATE = 201;
    public static final int RESULT_DELETE = 301;
    private final int ALERT_DIALOG_CLOSE = 10;
    private final int ALERT_DIALOG_DELETE = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend_add_update);

        edtNim = findViewById(R.id.edt_nim);
        edtNama = findViewById(R.id.edt_nama);
        edtKelas = findViewById(R.id.edt_kelas);
        edtNohp = findViewById(R.id.edt_telpon);
        edtEmail = findViewById(R.id.edt_email);
        edtIg = findViewById(R.id.edt_ig);
        btnSubmit = findViewById(R.id.btn_submit);
        btnSubmit.setOnClickListener(this);

        friendHelper = FriendHelper.getInstance(getApplicationContext());

        buddyme = getIntent().getParcelableExtra(EXTRA_NOTE);
        if (buddyme != null){
            position = getIntent().getIntExtra(EXTRA_POSITION, 0);
            isEdit = true;
        }else {
            buddyme = new buddyme();
        }

        String actionBarTitle;
        String btnTitle;

        if (isEdit){
            actionBarTitle = "Update";
            btnTitle = "Update";
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#853350")));

            if (buddyme != null){
                edtNim.setText(buddyme.getNim());
                edtNama.setText(buddyme.getNama());
                edtKelas.setText(buddyme.getKelas());
                edtNohp.setText(buddyme.getTelpon());
                edtEmail.setText(buddyme.getEmail());
                edtIg.setText(buddyme.getIg());
            }
        }else {
            actionBarTitle = "Add";
            btnTitle = "Save";
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#853350")));
        }

        if (getSupportActionBar() != null){
            getSupportActionBar().setTitle(actionBarTitle);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        btnSubmit.setText(btnTitle);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_submit){
            String nim = edtNim.getText().toString().trim();
            String nama = edtNama.getText().toString().trim();
            String kelas = edtKelas.getText().toString().trim();
            String nohp = edtNohp.getText().toString().trim();
            String email = edtEmail.getText().toString().trim();
            String ig = edtIg.getText().toString().trim();

            if (TextUtils.isEmpty(nim)){
                edtNim.setError("Student ID cannot be empty!");
                return;
            }else if (TextUtils.isEmpty(nama)){
                edtNama.setError("Name cannot be empty!");
                return;
            }else if (TextUtils.isEmpty(kelas)){
                edtKelas.setError("Class cannot be empty!");
                return;
            }else if (TextUtils.isEmpty(nohp)){
                edtNohp.setError("Phone cannot be empty!");
                return;
            }else if (TextUtils.isEmpty(email)){
                edtEmail.setError("Email cannot be empty!");
                return;
            }else if (TextUtils.isEmpty(ig)){
                edtIg.setError("Instagram cannot be empty!");
                return;
            }

            buddyme.setNim(nim);;
            buddyme.setNama(nama);
            buddyme.setKelas(kelas);
            buddyme.setTelpon(nohp);
            buddyme.setEmail(email);
            buddyme.setIg(ig);

            Intent intent = new Intent();
            intent.putExtra(EXTRA_NOTE, buddyme);
            intent.putExtra(EXTRA_POSITION, position);

            ContentValues values = new ContentValues();
            values.put(NIM, nim);
            values.put(NAMA, nama);
            values.put(KELAS, kelas);
            values.put(TELPON, nohp);
            values.put(EMAIL, email);
            values.put(IG, ig);

            if (isEdit){
                long result = friendHelper.update(String.valueOf(buddyme.getId()), values);
                if (result > 0){
                    setResult(RESULT_UPDATE, intent);
                    finish();
                }else {
                    Toast.makeText(FriendAddUpdateActivity.this, "Failed Updating", Toast.LENGTH_SHORT).show();
                }
            }else {
                buddyme.setDate(getCurrentDate());
                values.put(DATE, getCurrentDate());
                long result = friendHelper.insert(values);

                if (result > 0){
                    buddyme.setId((int) result);
                    setResult(RESULT_ADD, intent);
                    finish();
                }else {
                    Toast.makeText(FriendAddUpdateActivity.this, "Failed Adding", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    private String getCurrentDate(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.getDefault());
        Date date = new Date();

        return dateFormat.format(date);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (isEdit){
            getMenuInflater().inflate(R.menu.menu_form, menu);
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_delete:
                showAlertDialog(ALERT_DIALOG_DELETE);
                break;
            case android.R.id.home:
                showAlertDialog(ALERT_DIALOG_CLOSE);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        showAlertDialog(ALERT_DIALOG_CLOSE);
    }

    private void showAlertDialog(int type){
        final boolean isDialogClose = type == ALERT_DIALOG_CLOSE;
        String dialogtitle, dialogMessage;

        if (isDialogClose){
            dialogtitle = "Canceled";
            dialogMessage ="Cancel process?";
        }else {
            dialogMessage = "Are you sure?";
            dialogtitle = "Delete Friend";
        }

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

        alertDialogBuilder.setTitle(dialogtitle);
        alertDialogBuilder
                .setMessage(dialogMessage)
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (isDialogClose){
                            finish();
                        }else {
                            long result = friendHelper.deleteById(String.valueOf(buddyme.getId()));
                            if (result > 0){
                                Intent intent = new Intent();
                                intent.putExtra(EXTRA_POSITION, position);
                                setResult(RESULT_DELETE, intent);
                                finish();
                            }else {
                                Toast.makeText(FriendAddUpdateActivity.this, "Failed Deleting", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}
