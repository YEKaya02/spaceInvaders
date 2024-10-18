package org.spaceinvaders;

import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;
import org.spaceinvaders.scenes.GameScene;

/**
 * Hello world!
 *
 */
public class SpaceInvaders extends YaegerGame {
    private final Size gameSize = new Size(800, 600);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void setupGame() {
        setGameTitle("Space invaders");
        setSize(gameSize);
    }

    @Override
    public void setupScenes() {
        GameScene gameScene = new GameScene(gameSize);
        addScene(0, gameScene);
    }
}
