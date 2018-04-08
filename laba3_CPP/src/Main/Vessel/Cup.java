package Main.Vessel;

public class Cup extends Vessel {
    private boolean full;

    @Override
    public boolean isFull() {
        return full;
    }

    @Override
    public void setFull(boolean full) {
        this.full = full;
    }
}
