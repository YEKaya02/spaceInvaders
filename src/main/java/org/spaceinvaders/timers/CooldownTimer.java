package org.spaceinvaders.entities.ships;

import com.github.hanyaeger.api.Timer;

public class CooldownTimer extends Timer {
    private final Ship ship;

    protected CooldownTimer(long intervalInMs, Ship ship) {
        super(intervalInMs);
        this.ship = ship;
    }

    @Override
    public void onAnimationUpdate(long now) {
        System.out.println("test");
        ship.setCanShoot(true);
        this.pause();
    }
}
