package com.mygdx.game.MiniGames;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.BaseStage;
import com.mygdx.game.Game;
import com.mygdx.game.Screens.GameScreen;

public class CowBoy extends BaseStage {
    Label ready, steady, bang;

    public CowBoy(ScreenViewport scr, Game game) {
        super(scr, game);
    }@Override

    public void init() {
        Gdx.input.setInputProcessor(this);
        BitmapFont font = ((GameScreen) game.getScreen()).font;
        //Gdx.input.setOnscreenKeyboardVisible(true, Input.OnscreenKeyboardType.NumberPad);
        ready = new Label("READY", new Label.LabelStyle(font, Color.GREEN));
        steady = new Label("STEADY", new Label.LabelStyle(font, Color.YELLOW));
        bang = new Label("BANG", new Label.LabelStyle(font, Color.RED));
        ready.setPosition(Gdx.graphics.getWidth()/2f, Gdx.graphics.getHeight()/2f);
        steady.setPosition(Gdx.graphics.getWidth()/2f, Gdx.graphics.getHeight()/2f);
        bang.setPosition(Gdx.graphics.getWidth()/2f, Gdx.graphics.getHeight()/2f);
        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    Thread.sleep(randomInRange(500, 3000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                addActor(ready);

                try {
                    Thread.sleep(randomInRange(500, 3000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ready.remove();

                addActor(steady);

                try {
                    Thread.sleep(randomInRange(500, 3000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                steady.remove();

                final boolean[] neuspel = {false};
                final boolean[] readyToBang = {false};


                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(250);
                            neuspel[0] = true;
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
                addActor(bang);
                readyToBang[0] = true;

                addListener(new ClickListener(){
                    @Override
                    public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                        if(neuspel[0] || !readyToBang[0]){
                            lose();
                        }
                        else
                        {
                            win();
                        }
                        return true;
                    }
                });


            }
        }).start();

    }



    static public int randomInRange(int min, int max) {
        return (int) (min + Math.random() * (max - min + 1));
    }

}