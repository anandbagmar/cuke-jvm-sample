package gradle.cucumber;

public class Production {

    public void doFailingWork() {
        throw new RuntimeException("production failed here");
    }

    public void doPassingWork() {
        assert (true);
    }

}
