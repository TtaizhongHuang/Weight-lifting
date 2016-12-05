package se329.com.weight_lifting;


import android.app.Activity;
import android.content.Context;
import android.util.Log;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.Random;

/**
 * Created by valbi_000 on 11/2/2016.
 */
public class geneWork extends Activity {
    private String gymType;
    private String muscleGroup;
    private workout[] workOuts = new workout[12];
    geneWork(String gymType, String muscleGroup){
        this.gymType = gymType;
        this.muscleGroup = muscleGroup;
    }

    workout[] party = new workout[5];

    void generate(){


            Random rand = new Random();
            int randomNum = rand.nextInt(4);
            party[4] = workOuts[randomNum];
            randomNum = rand.nextInt(11);
            while(workOuts[randomNum].getType() != "tricep"){
                randomNum = rand.nextInt(11);
            }
        party[1] = workOuts[randomNum];
            while(workOuts[randomNum].getType() != "tricep"){
                randomNum = rand.nextInt(11);
            }
        party[2] = workOuts[randomNum];
            while(workOuts[randomNum].getType() != "Chest"){
                randomNum = rand.nextInt(11);
            }
        party[3] = workOuts[randomNum];
            while(workOuts[randomNum].getType() != "Chest"){
                randomNum = rand.nextInt(11);
            }
        party[0] = workOuts[randomNum];

    }

    void fillwork(){
        workOuts[0] = new workout("abs", "AB Crunch Machine");
        workOuts[1] = new workout("abs", "AB Roller");
        workOuts[2] = new workout("abs", "Air Bike");
        workOuts[3] = new workout("abs", "Dumbbell Side Bend");
        workOuts[4] = new workout("Chest", "Bench Press");
        workOuts[5] = new workout("Chest", "Push Ups");
        workOuts[6] = new workout("Chest", "Around the Worlds");
        workOuts[7] = new workout("Chest", "Dumbbell Incline Bench Press");
        workOuts[8] = new workout("tricep", "Decline Dumbbell Tricep Extension");
        workOuts[9] = new workout("tricep", "Close Grip Ez Bar");
        workOuts[10] = new workout("tricep", "Body Up");
        workOuts[11] = new workout("tricep", "Bench Dips");

    }


    class workout{
        private String name;
        private String type;
        workout(String type, String name){
            this.type = type;
            this.name = name;
        }

        public String getType(){
            return this.type;
        }

        public String toString(){
            return this.name;
        }
    }
}
