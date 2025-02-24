package model;

public class Rate {
    private int rate;

    public Rate(int rate) {
        setRate(rate);
    }

    public int getRate() {
        return rate;
    }
//set the rate and make sure the rating is between 0 and 5.
    public void setRate(int rate) {
        if (rate > 0 && rate < 6) {
            this.rate = rate;
        }
    }
}
