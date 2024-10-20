package org.spaceinvaders.entities.ships;

import com.github.hanyaeger.api.Timer;
import com.github.hanyaeger.api.entities.Direction;

public class EnemyTimer extends Timer {
    EnemyShip ship;

    public EnemyTimer(long intervalInMs, EnemyShip ship) {
        super(intervalInMs);
        this.ship = ship;
    }

    @Override
    public void onAnimationUpdate(long l) {
        ship.shoot(ship, Direction.DOWN);
        ship.move();
    }
}
