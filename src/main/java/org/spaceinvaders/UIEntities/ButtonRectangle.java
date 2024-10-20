package org.spaceinvaders.UIEntities;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;
import javafx.scene.paint.Color;


public class ButtonRectangle extends RectangleEntity {
    protected ButtonRectangle(Coordinate2D initialLocation) {
        super(initialLocation, new Size(155, 60));
        setFill(Color.DARKGRAY);
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
        setArcHeight(10);
        setArcWidth(10);
    }
}
