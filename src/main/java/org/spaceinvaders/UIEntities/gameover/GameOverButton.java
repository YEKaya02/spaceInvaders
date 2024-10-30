package org.spaceinvaders.UIEntities.gameover;

import com.github.hanyaeger.api.Coordinate2D;
import javafx.scene.input.MouseButton;
import org.spaceinvaders.UIEntities.button.Button;
import javafx.scene.paint.Color;

public class GameOverButton extends Button {
    private final GameOverScreen gameOverScreen;

    public GameOverButton(Coordinate2D initialLocation, GameOverScreen gameOverScreen) {
        super(initialLocation, "Exit", Color.rgb(255, 25, 25), Color.BLACK);
        this.gameOverScreen = gameOverScreen;
    }

    @Override
    public void onMouseButtonReleased(MouseButton mouseButton, Coordinate2D coordinate2D) {
        gameOverScreen.handleButtonPress();
    }
}
