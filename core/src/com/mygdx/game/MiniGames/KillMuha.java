package com.mygdx.game.MiniGames;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.BaseStage;
import com.mygdx.game.Game;
import com.mygdx.game.GameObject;

public class KillMuha extends BaseStage {
    GameObject muha;
    public KillMuha(ScreenViewport scr, Game game) {
        super(scr, game);
    }

    @Override
    public void init() {
        muha = new GameObject(Gdx.graphics.getWidth()*0.1f, Gdx.graphics.getWidth()*0.1f, new TextureRegion(new Texture(Gdx.files.internal("muha.png"))));
        muha.setPosition(randomInRange((int) muha.getWidth()/2, Gdx.graphics.getWidth())- ((int) muha.getWidth()/2f), randomInRange((int) muha.getHeight()/2, Gdx.graphics.getHeight())- ((int) muha.getHeight()/2f) );
        addActor(muha);
        muha.addListener(new ClickListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                Gdx.app.log("LOL","LOH");
                win();
                Gdx.input.vibrate(200);
                return true;
            }
        });


        new Thread(new Runnable() {
            @Override
            public void run() {
                int randx = 0, randy = 0;
                int test = 0;
                while(true){
                    test++;

                    //while(!(muha.getX() > muha.getWidth()/2 && muha.getX() < Gdx.graphics.getWidth()-muha.getWidth()/2 && muha.getY() > muha.getHeight()/2 && muha.getY() < Gdx.graphics.getHeight()-muha.getHeight()/2  )){

                        randx = randomInRange(-150, 150);
                        randy = randomInRange(-150, 150);

                    //}
                    if(!(muha.getX() > muha.getWidth()/2 && muha.getX() < Gdx.graphics.getWidth()-muha.getWidth()/2 || muha.getY() > muha.getHeight()/2 && muha.getY() < Gdx.graphics.getHeight()-muha.getHeight()/2 )){
                        muha.setPosition(randomInRange((int) muha.getWidth()/2, Gdx.graphics.getWidth())- ((int) muha.getWidth()/2f), randomInRange((int) muha.getHeight()/2, Gdx.graphics.getHeight())- ((int) muha.getHeight()/2f) );

                    }

                    muha.rotation = new Vector2(randx,randy).angleDeg();
                    muha.addAction(Actions.moveBy(randx, randy, 0.2f));
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
   }

}
