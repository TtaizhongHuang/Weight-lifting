package se329.com.weight_lifting;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class FrontPage extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front_page);

    }

    public void buildWorkout(View view) {
        Intent intent = new Intent(this, buildWorkout.class);
        startActivity(intent);

    }

    public void buildBodyFatP(View view) {
        Intent intent = new Intent(this, buildBodyFatP.class);
        startActivity(intent);
    }


}
