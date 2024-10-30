package org.spaceinvaders;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import org.spaceinvaders.UIEntities.gamescene.LevelIndicator;
import org.spaceinvaders.entities.ships.PlayerShip;
import org.spaceinvaders.scenes.GameScene;

import java.util.Random;

public class LevelManager {
    private final GameScene gameScene;
    private final LevelIndicator levelIndicator;
    private PlayerShip playerShip;
    private final Random random = new Random();
    private final int gameWidth;
    private int totalEnemyShips = 0;
    private int enemyShips;

    public LevelManager(Size gameSize, GameScene gameScene) {
        this.levelIndicator = new LevelIndicator(new Coordinate2D(gameSize.width() / 2, 10));
        this.gameScene = gameScene;
        this.gameWidth = (int) gameSize.width();
    }

    public void setPlayerShip(PlayerShip playerShip){
        this.playerShip = playerShip;
    }

    public LevelIndicator getLevelIndicator() {
        return levelIndicator;
    }

    public void removeShipFromTotal(){
        enemyShips--;
    }

    public void nextLevel(){
        // This method is called at the start of each level even level 1.
        // Because we call this method after any enemy ship dies we need to make sure
        // there are none left in the level before we go to the next level.
        if (enemyShips != 0){
            return;
        }

        playerShip.resetHealth();

        totalEnemyShips++;
        enemyShips = totalEnemyShips;
        levelIndicator.nextLevel();

        for (int i = 0; i < totalEnemyShips; i++){
            // Here we make our new ships for the new level, its x coordinate is randomly chosen.
            gameScene.createEnemyShip(new Coordinate2D(random.nextInt(gameWidth),100));
        }
    }
}
