package org.spaceinvaders.entities.ships;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.TimerContainer;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import org.spaceinvaders.entities.projectiles.Bullet;
import org.spaceinvaders.scenes.GameScene;

public abstract class Ship extends DynamicSpriteEntity implements TimerContainer {
    private final GameScene scene;
    private boolean canShoot = true;

    protected Ship(String resource, Coordinate2D initialLocation, GameScene scene) {
        super(resource, initialLocation);
        this.scene = scene;
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
    }

    @Override
    public void setupTimers() {
        addTimer(new CooldownTimer(500, this));
        getTimers().getFirst().pause();
        getTimers().getFirst().reset();
    }

    public void setCanShoot(boolean canShoot){
        this.canShoot = canShoot;
    }

    public void shoot(Ship ship){
        if (canShoot) {
            setCanShoot(false);
            getTimers().getFirst().resume();
            Bullet bullet = new Bullet(new Coordinate2D(ship.getLocationInScene().getX(), ship.getLocationInScene().getY() - 70));
            scene.createProjectile(bullet);
        }
    }
}
