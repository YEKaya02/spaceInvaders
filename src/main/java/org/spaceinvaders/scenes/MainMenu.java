package org.spaceinvaders.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.CustomFont;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;
import javafx.scene.paint.Color;
import org.spaceinvaders.SpaceInvaders;
import org.spaceinvaders.UIEntities.button.Button;
import org.spaceinvaders.UIEntities.mainmenu.MainMenuButton;

public class MainMenu extends StaticScene {
    private final CustomFont font = new CustomFont("fonts/TechnoRaceItalic.otf", 36);
    Size gameSize;
    SpaceInvaders spaceInvaders;


    public MainMenu(Size gameSize, SpaceInvaders spaceInvaders){
        this.gameSize = gameSize;
        this.spaceInvaders = spaceInvaders;
    }

    @Override
    public void setupScene() {
        setBackgroundImage("background.gif");
    }

    private TextEntity returnTitle(){
        TextEntity title = new TextEntity(new Coordinate2D(gameSize.width()/2, 100), "Space Invaders");
        title.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        title.setFont(font);
        title.setFill(Color.WHITE);
        return title;
    }

    @Override
    public void setupEntities() {
        addEntity(returnTitle());

        Button startButton = new MainMenuButton(new Coordinate2D(gameSize.width()/2, gameSize.height()/2), "Play", this);
        addEntity(startButton);
    }

    public void handleButtonPress() {
        spaceInvaders.setActiveScene(1);
    }
}
