package org.spaceinvaders.entities.projectiles;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Direction;

public class Bullet extends Projectile {
    public Bullet(Coordinate2D initialLocation, Direction direction, String resource) {
        super(initialLocation, direction, resource, 6, 25);
    }
}
