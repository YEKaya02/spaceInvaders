package org.spaceinvaders.timers;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Timer;
import com.github.hanyaeger.api.entities.Direction;
import org.spaceinvaders.entities.projectiles.Bullet;
import org.spaceinvaders.entities.projectiles.Projectile;
import org.spaceinvaders.entities.ships.EnemyShip;
import org.spaceinvaders.scenes.GameScene;

import java.util.Random;

public class EnemyLogicTimer extends Timer {
    private final EnemyShip ship;
    private final Random random = new Random();

    public EnemyLogicTimer(long intervalInMs, EnemyShip ship) {
        super(intervalInMs);
        this.ship = ship;
    }

    @Override
    public void onAnimationUpdate(long l) {
        if (random.nextInt(10) < 6) {
            Projectile bullet = new Bullet(
                    new Coordinate2D(ship.getLocation().getX(), ship.getLocation().getY() + 30),
                    Direction.DOWN,
                    Bullet.BulletType.EnemyBullet);

            ship.shoot(bullet);
        }
        ship.move();
    }
}
