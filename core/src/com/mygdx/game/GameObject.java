package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class GameObject extends Actor {
    TextureRegion texture;
   public float rotation;

    public GameObject(float width, float height, TextureRegion texture){
        super();
        setWidth(width);
        setHeight(height);
        this.texture = texture;
    }
    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(texture, getX() - getWidth()/2, getY()-getHeight()/2,getWidth()/2,getHeight()/2,getWidth(), getHeight(),1,1,rotation);
    }
}
