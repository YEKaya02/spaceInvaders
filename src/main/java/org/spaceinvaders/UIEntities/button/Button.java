package org.spaceinvaders.UIEntities.button;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.CompositeEntity;
import com.github.hanyaeger.api.entities.impl.CustomFont;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.userinput.MouseButtonReleasedListener;
import com.github.hanyaeger.api.userinput.MouseEnterListener;
import com.github.hanyaeger.api.userinput.MouseExitListener;
import javafx.scene.Cursor;
import javafx.scene.paint.Color;

public abstract class Button extends CompositeEntity implements MouseEnterListener, MouseExitListener, MouseButtonReleasedListener {
    private final String buttonText;
    private final ButtonRectangle buttonRectangle;

    public Button(Coordinate2D initialLocation, String buttonText) {
        super(initialLocation);
        this.buttonText = buttonText;
        this.buttonRectangle = new ButtonRectangle(new Coordinate2D());
    }

    @Override
    protected void setupEntities() {
        addEntity(buttonRectangle);

        TextEntity text = new TextEntity(new Coordinate2D(), buttonText);
        text.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        text.setFont(new CustomFont("fonts/TechnoRaceItalic.otf", 32));
        text.setFill(Color.WHITE);
        addEntity(text);
    }

    @Override
    public void onMouseEntered() {
        setCursor(Cursor.HAND);
        buttonRectangle.flipColor();
    }

    @Override
    public void onMouseExited() {
        setCursor(Cursor.DEFAULT);
        buttonRectangle.flipColor();
    }
}
