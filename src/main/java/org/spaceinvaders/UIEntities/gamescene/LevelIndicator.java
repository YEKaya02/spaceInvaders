package org.spaceinvaders.UIEntities.gamescene;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.CustomFont;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import javafx.scene.paint.Color;

public class LevelIndicator extends TextEntity {
    private int level = 0;

    public LevelIndicator(Coordinate2D initialLocation) {
        super(initialLocation);
        setFont(new CustomFont("fonts/TechnoRaceItalic.otf", 20));
        setText("level " + level);
        setFill(Color.WHITE);
    }

    public void nextLevel() {
        level++;
        setText("level " + level);
    }
}
