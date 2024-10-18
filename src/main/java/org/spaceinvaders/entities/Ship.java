package org.spaceinvaders.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public abstract class Ship extends DynamicSpriteEntity {
    protected Ship(String resource, Coordinate2D initialLocation) {
        super(resource, initialLocation);
    }
}
