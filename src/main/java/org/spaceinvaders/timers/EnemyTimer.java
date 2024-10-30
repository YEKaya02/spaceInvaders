package org.spaceinvaders.timers;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Timer;
import com.github.hanyaeger.api.entities.Direction;
import org.spaceinvaders.entities.projectiles.Bullet;
import org.spaceinvaders.entities.projectiles.Projectile;
import org.spaceinvaders.entities.ships.EnemyShip;
import org.spaceinvaders.scenes.GameScene;

import java.util.Random;

public class EnemyTimer extends Timer {
    EnemyShip ship;
    Random random = new Random();
    GameScene gameScene;

    public EnemyTimer(long intervalInMs, EnemyShip ship, GameScene gameScene) {
        super(intervalInMs);
        this.ship = ship;
        this.gameScene = gameScene;
    }

    @Override
    public void onAnimationUpdate(long l) {
        if (random.nextInt(10) < 6) {
            Projectile bullet = new Bullet(new Coordinate2D(ship.getLocation().getX(), ship.getLocation().getY() + 30),
                    Direction.DOWN,
                    Bullet.BulletType.EnemyBullet);

            ship.shoot(bullet);
        }
        ship.move();
    }
}
