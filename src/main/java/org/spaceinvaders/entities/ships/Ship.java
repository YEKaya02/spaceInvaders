package org.spaceinvaders.entities.ships;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.TimerContainer;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import org.spaceinvaders.entities.projectiles.Bullet;
import org.spaceinvaders.scenes.GameScene;

public abstract class Ship extends DynamicSpriteEntity implements SceneBorderTouchingWatcher {
    private final GameScene scene;
    private boolean canShoot = true;

    protected Ship(String resource, Coordinate2D initialLocation, GameScene scene) {
        super(resource, initialLocation);
        this.scene = scene;
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
    }

    public void setCanShoot(boolean canShoot){
        this.canShoot = canShoot;
    }

    public void shoot(Ship ship, Direction direction){
        if (canShoot) {
            Bullet bullet = new Bullet(new Coordinate2D(ship.getLocationInScene().getX(), ship.getLocationInScene().getY() + 30), direction);
            scene.createProjectile(bullet);
        }
    }
}
