package org.spaceinvaders.timers;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Timer;
import com.github.hanyaeger.api.entities.Direction;
import org.spaceinvaders.entities.ships.EnemyShip;

import java.util.Random;

public class EnemyTimer extends Timer {
    EnemyShip ship;
    Random rand = new Random();

    public EnemyTimer(long intervalInMs, EnemyShip ship) {
        super(intervalInMs);
        this.ship = ship;
    }

    @Override
    public void onAnimationUpdate(long l) {
        if (rand.nextInt(10) < 7) {
            ship.shoot(new Coordinate2D(ship.getLocation().getX(), ship.getLocation().getY() + 30), Direction.DOWN);
        }
        ship.move();
    }
}
