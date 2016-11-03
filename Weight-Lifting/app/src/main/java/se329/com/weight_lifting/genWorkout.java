package se329.com.weight_lifting;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.Console;

public class genWorkout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gen_workout);

        Intent intent = getIntent();
        String club = intent.getStringExtra(buildWorkout.CLUB_MESSAGE);
        String mGroup = intent.getStringExtra(buildWorkout.MGROUP_MESSAGE);
        geneWork wOut = new geneWork(club, mGroup);
        wOut.generate();
        wOut.party[0].toString();
        TextView textView = new TextView(this);
        textView.setTextSize(30);
        Log.e("Club = ", club);
        textView.setText(club);

        ViewGroup layout = (ViewGroup) findViewById(R.id.activity_display_message);
        layout.addView(textView);
    }


}

