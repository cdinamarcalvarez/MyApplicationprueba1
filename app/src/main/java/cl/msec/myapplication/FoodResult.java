package cl.msec.myapplication;

public class FoodResult extends FoodAnswer {
    public FoodResult(String answer) {
        super(answer);
    }

    public String score (){return processing();}

    private String processing(){
        String answer = getAnswer();
        if (answer.contains("5")){
            return "600";
        } else  if (answer.contains("10")){
            return "500";
        }else  {
            return "300";
        }
    }
}

