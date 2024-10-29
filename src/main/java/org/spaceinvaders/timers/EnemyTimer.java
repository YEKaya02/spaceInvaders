package org.spaceinvaders.timers;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Timer;
import com.github.hanyaeger.api.entities.Direction;
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
        // If the gameOver state has been reached we return so that the enemy ships stops shooting.
        if(gameScene.gameOver) {
            return;
        }

        if (random.nextInt(10) < 6) {
            ship.shoot(new Coordinate2D(ship.getLocation().getX(), ship.getLocation().getY() + 30), Direction.DOWN);
        }
        ship.move();
    }
}
