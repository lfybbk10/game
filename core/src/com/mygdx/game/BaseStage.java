package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.Screens.GameScreen;

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
        Gdx.gl.glClearColor(0, 1, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        ((GameScreen) game.getScreen()).countWins++;
        ((GameScreen) game.getScreen()).winsLabel.setText(((GameScreen) game.getScreen()).countWins);
    }
    public void lose() {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.input.vibrate(100);
    }
    static public int randomInRange(int min, int max) {
        return (int) (min + Math.random() * (max - min + 1));
    }
}
