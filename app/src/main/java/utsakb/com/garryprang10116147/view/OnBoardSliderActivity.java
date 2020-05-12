package utsakb.com.garryprang10116147.view;



import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import com.hololo.tutorial.library.Step;
import com.hololo.tutorial.library.TutorialActivity;

import utsakb.com.garryprang10116147.R;

/** Tanggal : 11 Mei 2020
 ** NIM     : 10116147
 ** Nama    : Garry Prang
 ** Kelas   : IF-3 **/

public class OnBoardSliderActivity extends TutorialActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        addFragment(new Step.Builder().setTitle("Friend Data")
                .setContent("Add friend data to friends list")
                .setBackgroundColor(Color.parseColor("#801d3f")) // int background color
                .setDrawable(R.drawable.addfriend) // int top drawable
                .setSummary("Feature #1")
                .build());
        addFragment(new Step.Builder().setTitle("Friend List")
                .setContent("Shows the list of added friend data")
                .setBackgroundColor(Color.parseColor("#801d3f")) // int background color
                .setDrawable(R.drawable.listfriend) // int top drawable
                .setSummary("Feature #2")
                .build());
        addFragment(new Step.Builder().setTitle("Modify Data")
                .setContent("Modify friend data from the friend list")
                .setBackgroundColor(Color.parseColor("#801d3f")) // int background color
                .setDrawable(R.drawable.updatefriend) // int top drawable
                .setSummary("Feature #3")
                .build());
        setCancelText("Skip");

    }

    @Override
    public void finishTutorial() {
        super.finishTutorial();
        Intent intent = new Intent(OnBoardSliderActivity.this, SplashScreenActivity.class);
        startActivity(intent);
    }

    @Override
    public void currentFragmentPosition(int position) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
