package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class BaseStage extends Stage {
    public Game game;

    public BaseStage(ScreenViewport scr, Game game){
        super(scr);
        this.game = game;
    }

    public void init(){

    }

    public void update(float delta){

    }

    public void dispose(){

    }

    public void win() {

    }
    public void lose() {
        Gdx.input.vibrate(200);
    }
    static public int randomInRange(int min, int max) {
        return (int) (min + Math.random() * (max - min + 1));
    }
}
