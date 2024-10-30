package org.spaceinvaders.UIEntities.gameover;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.CompositeEntity;
import com.github.hanyaeger.api.entities.YaegerEntity;
import com.github.hanyaeger.api.entities.impl.CustomFont;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import javafx.scene.paint.Color;
import org.spaceinvaders.SpaceInvaders;

public class GameOverScreen extends CompositeEntity {
    private final CustomFont font = new CustomFont("fonts/TechnoRaceItalic.otf", 36);
    private final Size gameSize;
    private final SpaceInvaders spaceInvaders;

    public GameOverScreen(Coordinate2D initialLocation, Size gameSize, SpaceInvaders spaceInvaders) {
        super(initialLocation);
        this.gameSize = gameSize;
        this.spaceInvaders = spaceInvaders;
    }

    @Override
    protected void setupEntities() {
        YaegerEntity[] entities = new YaegerEntity[3];

        TextEntity gameOverText = new TextEntity(new Coordinate2D(gameSize.width() /2, gameSize.height() /2), "Game Over");
        gameOverText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        gameOverText.setFill(Color.WHITE);
        gameOverText.setFont(font);

        entities[0] = new GameOverOverlay(gameSize);
        entities[1] = gameOverText;
        entities[2] = new GameOverButton(new Coordinate2D(gameSize.width() /2, gameSize.height() /2 + 100), this);

        for (YaegerEntity entity : entities) {
            addEntity(entity);
        }
    }

    public void handleButtonPress(){
        spaceInvaders.quit();
    }
}
