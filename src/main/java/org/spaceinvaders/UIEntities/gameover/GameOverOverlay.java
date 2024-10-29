package org.spaceinvaders.UIEntities.gameover;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;
import javafx.scene.paint.Color;

public class GameOverOverlay extends RectangleEntity {
    public GameOverOverlay(Size gameSize) {
        super(new Coordinate2D(), gameSize);
        setFill(Color.BLACK);
        setOpacity(0.5);
    }
}
