package org.spaceinvaders.entities.projectiles;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;

public abstract class Projectile extends DynamicSpriteEntity implements Collider, SceneBorderCrossingWatcher {
    private final int damage;

    public Projectile(Coordinate2D initialLocation, Direction direction, String resource, int speed, int damage) {
        super(resource, initialLocation);
        setMotion(speed, direction);
        this.damage = damage;
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder sceneBorder) {
        remove();
    }

    public double getDamage() {
        return damage;
    }
}
