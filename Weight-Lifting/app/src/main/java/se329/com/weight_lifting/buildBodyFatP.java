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
        setContentView(R.layout.activity_build_bodyfat);
        //Spinner dropdown = (Spinner)findViewById(R.id.spinner);
        //String[] items = new String[]{"Male", "Female"};
        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
        //dropdown.setAdapter(adapter);
    }


}
