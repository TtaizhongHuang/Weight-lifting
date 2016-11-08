package se329.com.weight_lifting;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class buildBodyFatP extends AppCompatActivity  {
    public final static String CLUB_MESSAGE = "com.SE329.CLUB";
    public final static String MGROUP_MESSAGE = "com.SE329.MGROUP";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_build_BodyFatP);
        Spinner dropdown = (Spinner)findViewById(R.id.spinner);
        String[] items = new String[]{"Male", "Female"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);
    }

    public void generateWork(View view){
        Intent intent = new Intent(this, genWorkout.class);
        final EditText ageText =  (EditText)findViewById(R.id.age);
        int age= Integer.parseInt(ageText.getText().toString());
        final Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);
        String mGroup = spinner2.getSelectedItem().toString();
        intent.putExtra(CLUB_MESSAGE, age);
        intent.putExtra(MGROUP_MESSAGE, mGroup);
        startActivity(intent);
    }
}
