package org.spaceinvaders.entities.ships;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.TimerContainer;
import com.github.hanyaeger.api.entities.*;
import com.github.hanyaeger.api.scenes.SceneBorder;
import org.spaceinvaders.scenes.GameScene;
import org.spaceinvaders.timers.EnemyTimer;

import java.util.Random;

public class EnemyShip extends Ship implements Collided, Collider, TimerContainer, SceneBorderCrossingWatcher {
    private final Direction movingDirection;
    private final double speed;

    public EnemyShip(String resource, Coordinate2D initialLocation, GameScene scene) {
        super(resource, initialLocation, scene, "projectiles/enemyBullet.png", -30);
        Random random = new Random();

        if (random.nextBoolean()) {
            movingDirection = Direction.RIGHT;
        } else {
            movingDirection = Direction.LEFT;
        }

        speed = random.nextDouble(1.5, 2.3) ;
    }

    @Override
    public void setupTimers() {
        addTimer(new EnemyTimer(500, this, gameScene));
    }

    public void move(){
        setMotion(speed, movingDirection);
    }

    public Coordinate2D getLocation(){
        return getLocationInScene();
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder sceneBorder) {
        switch (sceneBorder) {
            case LEFT:
                setAnchorLocationX(getSceneWidth());
                break;
            case RIGHT:
                setAnchorLocationX(0);
                break;
        }
    }

    @Override
    protected void handleDeath() {
        remove();
        gameScene.handleEnemyShipDeath();
    }
}
