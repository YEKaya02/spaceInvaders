package org.spaceinvaders.UIEntities;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.CompositeEntity;
import com.github.hanyaeger.api.entities.impl.CustomFont;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import javafx.scene.paint.Color;

public class Button extends CompositeEntity {
    private final String buttonText;

    public Button(Coordinate2D initialLocation, String buttonText) {
        super(initialLocation);
        this.buttonText = buttonText;
    }

    @Override
    protected void setupEntities() {
        ButtonRectangle buttonRectangle = new ButtonRectangle(new Coordinate2D());
        addEntity(buttonRectangle);

        TextEntity text = new TextEntity(new Coordinate2D(), buttonText);
        text.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        text.setFont(new CustomFont("fonts/TechnoRaceItalic.otf", 32));
        text.setFill(Color.WHITE);
        addEntity(text);
    }
}
