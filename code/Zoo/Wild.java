package Zoo;

public class Wild extends Animal {

    protected boolean isPredator;

    @Override
    public String voice() {
        StringBuilder stringBuilder = new StringBuilder(super.voice() + " I am a wild animal");
        if(isPredator) return stringBuilder.toString() + " and I am angry";
        else return stringBuilder.toString();
    }

}
