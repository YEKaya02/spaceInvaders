package org.spaceinvaders;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import org.spaceinvaders.UIEntities.LevelIndicator;
import org.spaceinvaders.scenes.GameScene;

import java.util.Random;

public class LevelManager {
    private final GameScene gameScene;
    private final LevelIndicator levelIndicator;
    private final Random random = new Random();
    private final int gameWidth;
    private int totalEnemyShips = 1;
    private int enemyShips;

    public LevelManager(Size gameSize, GameScene gameScene) {
        this.levelIndicator = new LevelIndicator(new Coordinate2D(gameSize.width() / 2, 10));
        this.enemyShips = 2;
        this.gameScene = gameScene;
        this.gameWidth = (int) gameSize.width();
    }

    public LevelIndicator getLevelIndicator() {
        return levelIndicator;
    }

    public void nextLevel(){
        // This method is called at the start of each level even level 1.

        totalEnemyShips++;
        enemyShips = totalEnemyShips;
        levelIndicator.nextLevel();

        for (int i = 0; i < totalEnemyShips; i++){
            // Here we make our new ships for the new level, its x coordinate is randomly chosen.
            gameScene.createEnemyShip(new Coordinate2D(random.nextInt(gameWidth),100));
        }
    }
}
