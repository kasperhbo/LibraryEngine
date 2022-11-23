package fluffy.engine.library.components;

import processing.core.PImage;

public class Sprite {
    private float width, height;
    private PImage texture = null;



    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public void setTexture(PImage tex) {
        this.texture = tex;
    }

    public PImage getTexture() {
        return this.texture;
    }

}
