package org.spaceinvaders.entities.ships;

import com.github.hanyaeger.api.*;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;
import org.spaceinvaders.UIEntities.HealthBar;
import org.spaceinvaders.entities.projectiles.Bullet;
import org.spaceinvaders.scenes.GameScene;

import java.util.List;

public abstract class Ship extends DynamicCompositeEntity implements Collided, Collider {
    private final ShipSprite shipSprite;
    protected HealthBar healthBar;
    protected Coordinate2D healthBarPosition;
    protected int healthBarWidthTotal = 32;
    protected final GameScene scene;
    private boolean canShoot = true;
    private final String bulletResource;

    protected Ship(String resource, Coordinate2D initialLocation, GameScene scene, String bulletResource, int healthBarOffset) {
        super(initialLocation);
        this.shipSprite = new ShipSprite(resource, new Coordinate2D());
        this.healthBarPosition = new Coordinate2D(0,shipSprite.getHeight()+healthBarOffset);
        Size healthBarSize = new Size(healthBarWidthTotal, 5);
        this.healthBar = new HealthBar(this.healthBarPosition, healthBarSize);
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

    @Override
    public void onCollision(List<Collider> colliders) {
        for (Collider collider : colliders) {
            if (collider instanceof Bullet){
                ((Bullet) collider).remove();
                handleDamage(25.0);
            }
        }
    }

    protected void handleDamage(double damage){
        int newWidth = ((int) calculateHealthWidth(damage));
        if (newWidth < 1){
            handleDeath();
        }
        healthBar.setWidth(newWidth);
        healthBar.setAnchorPoint(AnchorPoint.CENTER_CENTER);
    }

    protected abstract void handleDeath();

    public double calculateHealthWidth(double damagePercentage){
        double damage = (healthBarWidthTotal / 100.0) * damagePercentage;
        return healthBar.getWidth() - damage;
    }
}
