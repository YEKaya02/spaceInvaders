package org.spaceinvaders.entities.projectiles;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Direction;

public class Bullet extends Projectile {
    public Bullet(Coordinate2D initialLocation, Direction direction, BulletType type) {
        super(initialLocation, direction, type.sprite, 6, 25);
    }

    public enum BulletType {
        EnemyBullet("projectiles/enemyBullet.png"),
        PlayerBullet("projectiles/bullet.png");

        final String sprite;

        BulletType(String sprite) {
            this.sprite = sprite;
        }
    }
}
