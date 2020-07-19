public class Cell implements Cloneable {
    private int locationX;
    private int locationY;
    private boolean isGreen;
    private GreenCounter greenCounter;

    public Cell(int locationX, int locationY, int value) {
        this.locationX = locationX;
        this.locationY = locationY;
        this.greenCounter = new GreenCounter();
        this.setGreen(value);
    }

    public void changeColor() {
        this.isGreen = !this.isGreen;
    }

    /**
     * Return how many generation the cell was green.
     *
     * @return int
     */
    public int getCounter() {
        return greenCounter.getCounter();
    }

    /**
     * Return the GreenCounter instance for the cell,
     * inherited from generation to generation
     *
     * @return GreenCounter
     */
    public GreenCounter getGreenCounter() {
        return greenCounter;
    }

    public void setGreen(int value) {
        this.isGreen = value == 1;
        if (this.isGreen) this.greenCounter.increaseCounter();
    }

    public boolean isGreen() {
        return isGreen;
    }


    //Making shallow copy of the Cell class
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
