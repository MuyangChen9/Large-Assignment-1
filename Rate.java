public class Rate {
    private int rate;

    public Rate(int rate) {
        setRate(rate);
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        if (rate > 0 && rate < 6) {
            this.rate = rate;
        }
    }
}