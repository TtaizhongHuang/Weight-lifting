package se329.com.weight_lifting;

/**
 * Created by valbi_000 on 11/2/2016.
 */
public class geneWork {
    private String gymType;
    private String muscleGroup;
    geneWork(String gymType, String muscleGroup){
        this.gymType = gymType;
        this.muscleGroup = muscleGroup;
    }

    workout[] party = new workout[5];

    void generate(){
        for(int i = 0; i < 5; i++){
            party[i] = new workout();
        }
    }

    class workout{
        private String name;
        workout(){

        }

        private String getworkout(){

        }
    }
}
