package org.spaceinvaders.UIEntities;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;
import javafx.scene.paint.Color;


public class ButtonRectangle extends RectangleEntity {
    private final Color primaryColor = Color.color(0.47, 0.47, 0.49);
    private final Color secondaryColor = Color.color(0.20, 0.20, 0.23);
    private boolean colorFlip = true;

    protected ButtonRectangle(Coordinate2D initialLocation) {
        super(initialLocation, new Size(155, 60));
        setFill(Color.color(0.47, 0.47, 0.49));
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
