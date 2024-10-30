package org.spaceinvaders.UIEntities.gamescene;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public class MissileIndicator extends SpriteEntity {
    public MissileIndicator(Coordinate2D initialLocation) {
        super("projectiles/missile.png", initialLocation);
        setOpacity(0.5);
    }
}
