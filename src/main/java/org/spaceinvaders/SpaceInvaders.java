package org.spaceinvaders;

import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;
import org.spaceinvaders.scenes.GameScene;

/**
 * Hello world!
 *
 */
public class SpaceInvaders extends YaegerGame {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void setupGame() {
        setGameTitle("Space invaders");
        setSize(new Size(800, 600));
    }

    @Override
    public void setupScenes() {
        GameScene gameScene = new GameScene();
        addScene(0, gameScene);
    }
}
