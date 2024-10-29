package org.spaceinvaders.UIEntities.button;

import com.github.hanyaeger.api.Coordinate2D;
import javafx.scene.input.MouseButton;
import org.spaceinvaders.scenes.MainMenu;

public class MainMenuButton extends Button{
    private final MainMenu mainMenu;

    public MainMenuButton(Coordinate2D initialLocation, String buttonText, MainMenu mainMenu) {
        super(initialLocation, buttonText);
        this.mainMenu = mainMenu;
    }

    @Override
    public void onMouseButtonReleased(MouseButton mouseButton, Coordinate2D coordinate2D) {
        mainMenu.handleButtonPress();
    }
}
