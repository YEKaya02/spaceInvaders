package org.spaceinvaders.UIEntities.gameover;

import com.github.hanyaeger.api.Coordinate2D;
import javafx.scene.input.MouseButton;
import org.spaceinvaders.UIEntities.button.Button;

public class GameOverButton extends Button {
    public GameOverButton(Coordinate2D initialLocation, String buttonText) {
        super(initialLocation, buttonText);
    }

    @Override
    public void onMouseButtonReleased(MouseButton mouseButton, Coordinate2D coordinate2D) {

    }
}
