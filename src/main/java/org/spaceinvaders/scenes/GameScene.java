package org.spaceinvaders.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.YaegerEntity;
import com.github.hanyaeger.api.scenes.DynamicScene;
import org.spaceinvaders.SpaceInvaders;
import org.spaceinvaders.entities.PlayerShip;

public class GameScene extends DynamicScene {
    private final Coordinate2D playerShipPosition;

    public GameScene(Size gameSize) {
        // Position of the playerShip is calculated by taking half the width and offsetting it by 30,
        // this is done because the moon in the background is also offset.
        this.playerShipPosition = new Coordinate2D(gameSize.width() / 2 - 30, gameSize.height() / 1.2);
    }

    @Override
    public void setupScene() {
        setBackgroundImage("background.gif");
    }

    @Override
    public void setupEntities() {
        YaegerEntity[] yeagerEntities = new YaegerEntity[1];
        yeagerEntities[0] = new PlayerShip("ships/playerShip.png", playerShipPosition);

        for (YaegerEntity entity : yeagerEntities) {
            addEntity(entity);
        }
    }
}
