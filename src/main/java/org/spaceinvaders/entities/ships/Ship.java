package org.spaceinvaders.entities.ships;

import com.github.hanyaeger.api.*;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;
import org.spaceinvaders.UIEntities.gamescene.HealthBar;
import org.spaceinvaders.entities.projectiles.Projectile;
import org.spaceinvaders.scenes.GameScene;

import java.util.List;

public abstract class Ship extends DynamicCompositeEntity implements Collided {
    private final ShipSprite shipSprite;
    protected HealthBar healthBar;
    protected Coordinate2D healthBarPosition;
    protected int healthBarWidthTotal = 32;
    protected final GameScene gameScene;
    private boolean canShoot = true;

    protected Ship(String resource, Coordinate2D initialLocation, GameScene scene, int healthBarOffset) {
        super(initialLocation);
        this.shipSprite = new ShipSprite(resource, new Coordinate2D());
        this.healthBarPosition = new Coordinate2D(0,shipSprite.getHeight()+healthBarOffset);
        this.gameScene = scene;
        Size healthBarSize = new Size(healthBarWidthTotal, 5);
        this.healthBar = new HealthBar(this.healthBarPosition, healthBarSize);

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

    // projectile polymorphism
    public void shoot(Projectile projectile){
        if (canShoot) {
            gameScene.createProjectile(projectile);
        }
    }

    // projectile polymorphism
    @Override
    public void onCollision(List<Collider> colliders) {
        for (Collider collider : colliders) {
            if (collider instanceof Projectile){
                ((Projectile) collider).remove();
                handleDamage(((Projectile) collider).getDamage());
            }
        }
    }

    protected void handleDamage(double damage){
        int newWidth = ((int) calculateHealthWidth(damage));

        if (newWidth < 1){
            handleDeath();
        }

        healthBar.setWidth(newWidth);
    }

    protected abstract void handleDeath();

    public double calculateHealthWidth(double damagePercentage){
        double damage = (healthBarWidthTotal / 100.0) * damagePercentage;
        return healthBar.getWidth() - damage;
    }
}
