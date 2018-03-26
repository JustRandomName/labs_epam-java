package sample.ves;


public class Cup extends Vessel {
    private boolean full = false;
    private String lic;

    public String getLic() {
        return lic;
    }

    public void setLic(String lic) {
        this.lic = lic;
    }


    public boolean getFull() {
        return full;
    }

    public void setFull(boolean full) {
        this.full = full;
    }


}
