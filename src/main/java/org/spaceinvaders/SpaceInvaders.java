package org.spaceinvaders;

import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;
import com.github.hanyaeger.api.entities.impl.CustomFont;
import com.github.hanyaeger.api.scenes.YaegerScene;
import org.spaceinvaders.scenes.GameScene;
import org.spaceinvaders.scenes.MainMenu;

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
        YaegerScene[] scenes = new YaegerScene[2];
        scenes[0] = new MainMenu(gameSize, this);
        scenes[1] = new GameScene(gameSize);

        for (int i = 0; i < scenes.length; i++) {
            addScene(i, scenes[i]);
        }
    }
}
