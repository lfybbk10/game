package com.mygdx.game.MiniGames;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.BaseStage;
import com.mygdx.game.Game;
import com.mygdx.game.Screens.GameScreen;

public class MathCal extends BaseStage {
    Label num1, num2, symbol, equal;
    Label btn1, btn2, btn3;
    int res;


    public MathCal(ScreenViewport scr, Game game) {
        super(scr, game);

    }

    @Override
    public void init() {
        BitmapFont font = ((GameScreen) game.getScreen()).font;
        //Gdx.input.setOnscreenKeyboardVisible(true, Input.OnscreenKeyboardType.NumberPad);
        num1 = new Label("20", new Label.LabelStyle(font, Color.BLACK));
        num2 = new Label("30", new Label.LabelStyle(font, Color.BLACK));
        symbol = new Label("+", new Label.LabelStyle(font, Color.BLACK));
        equal = new Label(" = ?", new Label.LabelStyle(font, Color.BLACK));

        num1.invalidate();
        num2.invalidate();
        symbol.invalidate();
        equal.invalidate();

        num1.setPosition(num1.getWidth(), getHeight()*2/3);
        symbol.setPosition(num1.getX()+num1.getWidth(), getHeight()*2/3);
        num2.setPosition(symbol.getX()+num2.getWidth(), getHeight()*2/3);
        equal.setPosition(num2.getX()+equal.getWidth(), getHeight()*2/3);

        symbol.moveBy(symbol.getWidth(),0);

        btn1 = new Label("20", new Label.LabelStyle(font, Color.BLACK));
        btn2 = new Label("31", new Label.LabelStyle(font, Color.BLACK));
        btn3 = new Label("234", new Label.LabelStyle(font, Color.BLACK));


        btn2.setPosition(Gdx.graphics.getWidth()/2f, getHeight()/3);
        btn1.setPosition(btn2.getX()-btn1.getWidth(), getHeight()/3);
        btn3.setPosition(btn2.getX()+btn3.getWidth(), getHeight()/3);


        genExercise();

        addActor(num1);
        addActor(num2);
        addActor(symbol);
        addActor(equal);
        addActor(btn1);
        addActor(btn2);
        addActor(btn3);
    }

    public void genExercise(){
        int n1, n2, res;
        if(randomInRange(0,1)==0){
            n1 = randomInRange(10,99);
            n2 = randomInRange(10,99);

            num1.setText(n1);
            num2.setText(n2);
            symbol.setText("+");
            this.res = n1 + n2;
        }
        else {
            n1 = randomInRange(2,9);
            n2 = randomInRange(2,9);

            num1.setText(n1);
            num2.setText(n2);
            symbol.setText("*");
            this.res = n1 * n2;
        }

    }

    public void setAnswers(){
        int rightButton = randomInRange(1,3);
        int wrongBut1 = res + randomInRange(1, 2);
        int wrongBut2 = res - randomInRange(1, 2);
        if(rightButton == 1){
            btn1.setText(res);
            btn2.setText(wrongBut1);
            btn3.setText(wrongBut2);
        }
        else if(rightButton == 2){
            btn2.setText(res);
            btn1.setText(wrongBut1);
            btn3.setText(wrongBut2);
        }
        else{
            btn3.setText(res);
            btn1.setText(wrongBut1);
            btn2.setText(wrongBut2);
        }
    }

    static public int randomInRange(int min, int max) {
        return (int) (min + Math.random() * (max - min + 1));
    }
}