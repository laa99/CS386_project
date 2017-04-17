package com.example.chandler.hack;

import android.media.Image;

/**
 * The purpose of this class is to build a Beer class that takes the Drink
 * extend and the alcohol tuturial
 */

public class Beer extends Drink implements IDrink{
    // Scale of bitterness of beer
    float ibu;

    public float getIBU() {
        return this.ibu;
    }

    public void setIBU(float alcohol_lvl) {
        this.ibu = ibu;
    }

    @Override
    public void setImage(Image image) {

    }

    @Override
    public Image getImage() {
        return null;
    }

    @Override
    public void update() {

    }

    @Override
    public void edit() {

    }
}
