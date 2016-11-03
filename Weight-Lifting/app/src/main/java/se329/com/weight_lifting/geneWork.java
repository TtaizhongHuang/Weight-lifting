package se329.com.weight_lifting;

/**
 * Created by valbi_000 on 11/2/2016.
 */
public class geneWork {
    private String gymType;
    private String muscleGroup;
    private workout[] workOuts = new workout[11];
    geneWork(String gymType, String muscleGroup){
        this.gymType = gymType;
        this.muscleGroup = muscleGroup;
    }

    workout[] party = new workout[5];

    void generate(){
        for(int i = 0; i < 5; i++) {
            party[i] = workOuts[i];
        }
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
        workOuts[8] = new workout("tricpe", "Decline Dumbbell Tricep Extension");
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

        public String toString(){
            return this.name;
        }
    }
}
