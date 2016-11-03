package se329.com.weight_lifting;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class buildWorkout extends AppCompatActivity {
    public final static String CLUB_MESSAGE = "com.SE329.CLUB";
    public final static String MGROUP_MESSAGE = "com.SE329.MGROUP";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_build_workout);
        Spinner dropdown = (Spinner)findViewById(R.id.spinner1);
        String[] items = new String[]{"Basic", "Commercial", "Health Club"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);
        dropdown = (Spinner) findViewById(R.id.spinner2);
        String[] mGroups = new String[]{"Chest and Triceps", "Biceps and Back", "Legs", "Random"};
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, mGroups);
        dropdown.setAdapter(adapter2);

    }

    public void generateWork(View view){
        Intent intent = new Intent(this, genWorkout.class);
        final Spinner spinner = (Spinner) findViewById(R.id.spinner1);
        String club = spinner.getSelectedItem().toString();
        final Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);
        String mGroup = spinner2.getSelectedItem().toString();
        intent.putExtra(CLUB_MESSAGE, club);

        intent.putExtra(MGROUP_MESSAGE, mGroup);
        startActivity(intent);
    }
}
