package org.spaceinvaders.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.YaegerEntity;
import com.github.hanyaeger.api.scenes.DynamicScene;
import org.spaceinvaders.entities.ships.EnemyShip;
import org.spaceinvaders.entities.ships.PlayerShip;
import org.spaceinvaders.entities.projectiles.Bullet;

public class GameScene extends DynamicScene {
    private final Coordinate2D playerShipPosition;
    private Size gameSize;

    public GameScene(Size gameSize) {
        // Position of the playerShip is calculated by taking half the width and offsetting it by 30,
        // this is done because the moon in the background is also offset.
        this.playerShipPosition = new Coordinate2D(gameSize.width() / 2 - 30, gameSize.height() / 1.2);
        this.gameSize = gameSize;
    }

    @Override
    public void setupScene() {
        setBackgroundImage("background.gif");
    }

    @Override
    public void setupEntities() {

        YaegerEntity[] yaegerEntities = new YaegerEntity[2];
        yaegerEntities[0] = new PlayerShip("ships/playerShip.png", playerShipPosition, gameSize, this);
        yaegerEntities[1] = new EnemyShip("ships/enemyShip.png", new Coordinate2D(100,100), this);

        for (YaegerEntity entity : yaegerEntities) {
            addEntity(entity);
        }


    }

    public void createProjectile(Bullet bullet){
        addEntity(bullet);
    }
}
