public class Cell implements Cloneable{
    int locationX;
    int locationY;
    boolean isGreen;
    GreenCounter greenCounter;

    public Cell(int locationX, int locationY, int value) {
        this.locationX = locationX;
        this.locationY = locationY;
        this.greenCounter = new GreenCounter();
        this.setGreen(value);
    }

    public void changeColor(){
        this.isGreen = !this.isGreen;
    }

    public int getGreenCounter() {
        return greenCounter.getCounter();
    }

    public void setGreen(int value) {
        this.isGreen = value == 1;
        if (this.isGreen)this.greenCounter.increaseCounter();
    }

    //    Making Shallow copy
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
