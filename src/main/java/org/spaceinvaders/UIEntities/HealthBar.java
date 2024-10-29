package org.spaceinvaders.UIEntities;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.DynamicRectangleEntity;
import javafx.scene.paint.Color;

public class HealthBar extends DynamicRectangleEntity {

    public HealthBar(Coordinate2D initialLocation, Size size) {
        super(initialLocation, size);
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
        setFill(Color.RED);
        setArcHeight(10);
        setArcWidth(10);
    }

    @Override public void setWidth(double width) {
        super.setWidth(width);
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
    }
}
