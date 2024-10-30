package org.spaceinvaders.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.YaegerEntity;
import com.github.hanyaeger.api.scenes.DynamicScene;
import org.spaceinvaders.LevelManager;
import org.spaceinvaders.SpaceInvaders;
import org.spaceinvaders.UIEntities.gameover.GameOverScreen;
import org.spaceinvaders.UIEntities.gamescene.MissileIndicator;
import org.spaceinvaders.entities.ships.EnemyShip;
import org.spaceinvaders.entities.ships.PlayerShip;
import org.spaceinvaders.entities.projectiles.Projectile;

import java.util.ArrayList;

public class GameScene extends DynamicScene {
    private final Coordinate2D playerShipPosition;
    private final Size gameSize;
    private final LevelManager levelManager;
    private final SpaceInvaders spaceInvaders;
    private final MissileIndicator missileIndicator;
    public boolean gameOver = false;


    public GameScene(Size gameSize, SpaceInvaders spaceInvaders) {
        this.playerShipPosition = new Coordinate2D(gameSize.width() / 2 , gameSize.height() / 1.2);
        this.gameSize = gameSize;
        this.levelManager = new LevelManager(gameSize, this);
        this.spaceInvaders = spaceInvaders;
        this.missileIndicator = new MissileIndicator(new Coordinate2D(gameSize.width() - 40, gameSize.height() - 40));
    }

    @Override
    public void setupScene() {
        setBackgroundImage("background.gif");
    }

    @Override
    public void setupEntities() {
        // todo: define ship sprite in respective ship class
        PlayerShip playerShip = new PlayerShip("ships/playerShip.png", playerShipPosition, gameSize, this);
        levelManager.setPlayerShip(playerShip);
        levelManager.nextLevel();

        ArrayList<YaegerEntity> entities = new ArrayList<>();
        entities.add(levelManager.getLevelIndicator());
        entities.add(playerShip);
        entities.add(missileIndicator);

        for (YaegerEntity entity : entities) {
            addEntity(entity);
        }
    }

    public void setMissileIndicatorOpacity(double opacity) {
        missileIndicator.setOpacity(opacity);
    }

    public double getMissileIndicatorOpacity() {
        return missileIndicator.getOpacity();
    }

    public void handleEnemyShipDeath(){
        levelManager.removeShipFromTotal();
        levelManager.nextLevel();
    }

    public void createEnemyShip(Coordinate2D coordinate2D){
        addEntity(new EnemyShip("ships/enemyShip.png", coordinate2D, this));
    }

    public void createProjectile(Projectile bullet){
        addEntity(bullet);
    }

    public void gameOver(){
        gameOver = true;
        pause();
        addEntity(new GameOverScreen(new Coordinate2D(), gameSize, spaceInvaders));
    }
}
