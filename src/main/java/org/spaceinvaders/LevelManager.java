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
        if (enemyShips != 0){
            return;
        }

        playerShip.resetHealth();

        totalEnemyShips++;
        enemyShips = totalEnemyShips;
        levelIndicator.nextLevel();

        for (int i = 0; i < totalEnemyShips; i++){
            gameScene.createEnemyShip(new Coordinate2D(random.nextInt(gameWidth),100));
        }
    }
}
