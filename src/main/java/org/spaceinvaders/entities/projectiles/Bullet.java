package org.spaceinvaders.entities.projectiles;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public class Bullet extends DynamicSpriteEntity implements Collider {
    public Bullet(Coordinate2D initialLocation) {
        super("projectiles/bullet.png", initialLocation);
        setMotion(4, Direction.UP);
    }
}
