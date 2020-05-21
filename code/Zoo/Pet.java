package Zoo;

public class Pet extends Animal {

    protected String name;
    protected boolean isVaccinated;

    @Override
    public String voice() {
        return super.voice() + " my name is " + name;
    }
}
