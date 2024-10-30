package org.spaceinvaders.UIEntities.button;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;
import javafx.scene.paint.Color;


public class ButtonRectangle extends RectangleEntity {
    private final Color primaryColor;
    private final Color secondaryColor;
    private boolean colorFlip = true;

    protected ButtonRectangle(Coordinate2D initialLocation, Color primaryColor) {
        super(initialLocation, new Size(155, 60));
        this.primaryColor = primaryColor;
        this.secondaryColor = primaryColor.darker();

        setFill(primaryColor);
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
        setArcHeight(10);
        setArcWidth(10);
    }

    public void flipColor(){
        if (colorFlip){
            setFill(secondaryColor);
            colorFlip = false;
        } else {
            setFill(primaryColor);
            colorFlip = true;
        }
    }
}
