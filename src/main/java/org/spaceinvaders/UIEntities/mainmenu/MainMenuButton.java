package org.spaceinvaders.UIEntities.mainmenu;

import com.github.hanyaeger.api.Coordinate2D;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import org.spaceinvaders.UIEntities.button.Button;
import org.spaceinvaders.scenes.MainMenu;

public class MainMenuButton extends Button {
    private final MainMenu mainMenu;

    public MainMenuButton(Coordinate2D initialLocation, String buttonText, MainMenu mainMenu) {
        super(initialLocation, buttonText, Color.rgb(120, 120, 125), Color.WHITE);
        this.mainMenu = mainMenu;
    }

    @Override
    public void onMouseButtonReleased(MouseButton mouseButton, Coordinate2D coordinate2D) {
        mainMenu.handleButtonPress();
    }
}
