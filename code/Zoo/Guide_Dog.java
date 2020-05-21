package Zoo;

import java.awt.*;

public class Guide_Dog extends Dog{

    protected boolean isTrained;

    @Override
    public String voice(){
        if(isTrained) return super.voice() + " I can take you home";
        else return super.voice();
    }

    public Guide_Dog(){
        id = 1;
        name = "Drew";
        age = 3;
        weight = 8;
        color = Color.BLACK;
        isVaccinated = true;
        isTrained = true;
    }

    public void goHome () {
        System.out.println("Follow me");
    }
}
