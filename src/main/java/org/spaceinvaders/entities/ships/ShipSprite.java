package org.spaceinvaders.entities.ships;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public class ShipSprite extends DynamicSpriteEntity {
    protected ShipSprite(String resource, Coordinate2D initialLocation) {
        super(resource, initialLocation);
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
    }
}
