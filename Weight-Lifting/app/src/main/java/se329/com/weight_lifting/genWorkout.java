package se329.com.weight_lifting;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.Button;
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
        wOut.fillwork();
        wOut.generate();;
        Button firstwork = new Button(this);
        firstwork.setText(wOut.party[0].toString());
        Button secondwork = new Button(this);
        secondwork.setText(wOut.party[1].toString());
        Button thirdwork = new Button(this);
        thirdwork.setText(wOut.party[2].toString());
        Button fourthwork = new Button(this);
        fourthwork.setText(wOut.party[3].toString());
        Button fifthwork = new Button(this);
        fifthwork.setText(wOut.party[4].toString());

        ViewGroup layout = (ViewGroup) findViewById(R.id.activity_display_message);
        layout.addView(firstwork);
        layout.addView(secondwork);
        layout.addView(thirdwork);
        layout.addView(fourthwork);
        layout.addView(fifthwork);
    }


}

