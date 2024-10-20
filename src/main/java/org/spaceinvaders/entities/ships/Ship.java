package org.spaceinvaders.entities.ships;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.TimerContainer;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import org.spaceinvaders.UIEntities.HealthBar;
import org.spaceinvaders.entities.projectiles.Bullet;
import org.spaceinvaders.scenes.GameScene;

public abstract class Ship extends DynamicCompositeEntity {
    private final ShipSprite shipSprite;
    private final HealthBar healthBar;
    private final GameScene scene;
    private boolean canShoot = true;
    private final String bulletResource;

    protected Ship(String resource, Coordinate2D initialLocation, GameScene scene, String bulletResource, int healthBarOffset) {
        super(initialLocation);
        this.shipSprite = new ShipSprite(resource, new Coordinate2D());
        this.healthBar = new HealthBar(new Coordinate2D(0,shipSprite.getHeight()+healthBarOffset), new Size(32, 5));
        this.scene = scene;
        this.bulletResource = bulletResource;
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
    }

    public void setCanShoot(boolean canShoot){
        this.canShoot = canShoot;
    }

    @Override
    public void setupEntities(){
        addEntity(shipSprite);
        addEntity(healthBar);
    }

    public void shoot(Coordinate2D coordinate2D, Direction direction){
        if (canShoot) {
            Bullet bullet = new Bullet(coordinate2D, direction, bulletResource);
            scene.createProjectile(bullet);
        }
    }
}
