package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.mygdx.game.BaseStage;
import com.mygdx.game.Game;
import com.mygdx.game.MiniGames.CowBoy;
import com.mygdx.game.MiniGames.KillMuha;
import com.mygdx.game.MiniGames.MathCal;



public class GameScreen implements Screen {
    BaseStage currStage;
    public BitmapFont font;
    Game game;
   public int countWins = 0;
   public Label winsLabel;

    public GameScreen(Game game){
        this.game = game;
    }

    @Override
    public void show() {
        FreeTypeFontGenerator gen = new FreeTypeFontGenerator(Gdx.files.internal("Algeria.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter param = new FreeTypeFontGenerator.FreeTypeFontParameter();
        param.size =  (int) (Gdx.graphics.getWidth()*0.125f);
        font = gen.generateFont(param);
        winsLabel = new Label("0", new com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle(font, Color.BLACK));
        winsLabel.setPosition(Gdx.graphics.getWidth()-winsLabel.getWidth(), Gdx.graphics.getHeight()-winsLabel.getHeight());
        currStage = new CowBoy(game.scr, game);
        currStage.init();
        currStage.addActor(winsLabel);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        currStage.update(delta);
        currStage.act();
        currStage.draw();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
