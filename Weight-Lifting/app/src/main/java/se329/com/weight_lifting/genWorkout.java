package se329.com.weight_lifting;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Console;
import java.util.HashMap;
import java.util.Map;

public class genWorkout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gen_workout);
        Log.d("Hello", "world");
        ServerResponseListener createListener = new ServerResponseListener(){
            @Override
            public void getResult(Object object){
                ServerResponseListener accountListener = new ServerResponseListener(){
                    @Override
                    public void getResult(Object object){
                        String stringResult = object.toString();

                            Log.e("Erro:",object.toString());

                    }
                };
                //NetworkManager accDets = NetworkManager.getInstance();
                //Map<String, String> accParams = new HashMap<>();
                //String accInfo = "{\"email\":\"\"}";
                //accParams.put("data", accInfo);
               // accDets.asyncronousCall("getAccountInfo.php", accParams,accountListener);
            }
        };
        NetworkManager accDets = NetworkManager.getInstance(this);
        Map<String, String> accParams = new HashMap<>();
        //String accInfo = "{\"Email\":\"" + SaveSharedPreference.getUserName(this) +"\",\"Password\":\"";
        //accInfo += password.getText().toString() + "\",\"FirstName\":\"" + firstName.getText().toString();
        //accInfo += "\",\"LastName\":\"" + lastName.getText().toString() + "\",\"PhoneNumber\":\"";
        //accInfo += PhoneNumber.getText().toString() + "\"}";
        //accParams.put("data", accInfo);
        accDets.asyncronousCall("phoneCall.php", accParams, createListener);
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

