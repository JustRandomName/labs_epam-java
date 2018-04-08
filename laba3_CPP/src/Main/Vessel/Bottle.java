package Main.Vessel;

public class Bottle extends Vessel {
    private boolean full = true;

    @Override
    public boolean isFull() {
        return full;
    }

    @Override
    public void setFull(boolean full) {
        this.full = full;
    }
}
