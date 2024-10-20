package org.spaceinvaders.timers;

import com.github.hanyaeger.api.Timer;
import org.spaceinvaders.entities.ships.Ship;

public class CooldownTimer extends Timer {
    private final Ship ship;

    public CooldownTimer(long intervalInMs, Ship ship) {
        super(intervalInMs);
        this.ship = ship;
    }

    @Override
    public void onAnimationUpdate(long now) {
        ship.setCanShoot(true);
        this.pause();
    }
}
