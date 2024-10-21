package org.spaceinvaders.entities.ships;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.TimerContainer;
import com.github.hanyaeger.api.entities.*;
import com.github.hanyaeger.api.scenes.SceneBorder;
import org.spaceinvaders.entities.projectiles.Bullet;
import org.spaceinvaders.scenes.GameScene;
import org.spaceinvaders.timers.EnemyTimer;

import java.util.List;

public class EnemyShip extends Ship implements Collided, Collider, TimerContainer, SceneBorderCrossingWatcher {
    public Direction movingDirection = Direction.RIGHT;

    public EnemyShip(String resource, Coordinate2D initialLocation, GameScene scene) {
        super(resource, initialLocation, scene, "projectiles/enemyBullet.png", -30);
    }

    @Override
    public void onCollision(List<Collider> colliders) {
        for (Collider collider : colliders) {
            if (collider instanceof Bullet){
                ((Bullet) collider).remove();
                int newWidth = ((int) calculateHealthWidth(25.0));
                if (newWidth < 0){
                    this.remove();
                }
                healthBar.setWidth(newWidth);
                healthBar.setAnchorPoint(AnchorPoint.CENTER_CENTER);
            }
        }
    }

    @Override
    public void setupTimers() {
        addTimer(new EnemyTimer(500, this));
    }

    public void move(){
        setMotion(2, movingDirection);
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
}
