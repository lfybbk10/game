package com.mygdx.game.MiniGames;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
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
        muha = new GameObject(Gdx.graphics.getWidth()*0.05f, Gdx.graphics.getWidth()*0.05f, new TextureRegion(new Texture(Gdx.files.internal("muha.png"))));
        muha.setPosition(randomInRange(int) muha.getWidth()/2, Gdx.graphics.getWidth() ));
    }
}
