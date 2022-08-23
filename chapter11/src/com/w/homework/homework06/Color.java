package com.w.homework.homework06;

/**
 * @author blue
 * @version 1.0
 */
public enum Color implements Interface{
    RED(255, 0, 0),
    BLUE(0, 0, 255),
    YELLOW(255, 255, 0),
    BLACK(0, 0, 255),
    GREEN(0, 255, 0);

    private int redValue;
    private int greenValue;
    private int blueValue;

    private Color(int redValue, int greenValue, int blueValue) {
        this.redValue = redValue;
        this.greenValue = greenValue;
        this.blueValue = blueValue;
    }

    public int getRedValue() {
        return redValue;
    }

    public int getGreenValue() {
        return greenValue;
    }

    public int getBlueValue() {
        return blueValue;
    }

    @Override
    public void show(){
        System.out.println("redValue=" + redValue);
        System.out.println("greenValue=" + greenValue);
        System.out.println("blueValue=" + blueValue);
    }
}
