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
    private String bulletResource;

    protected Ship(String resource, Coordinate2D initialLocation, GameScene scene, String bulletResource) {
        super(resource, initialLocation);
        this.scene = scene;
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
        this.bulletResource = bulletResource;
    }

    public void setCanShoot(boolean canShoot){
        this.canShoot = canShoot;
    }

    public void shoot(Coordinate2D coordinate2D, Direction direction){
        if (canShoot) {
            Bullet bullet = new Bullet(coordinate2D, direction, bulletResource);
            scene.createProjectile(bullet);
        }
    }
}
