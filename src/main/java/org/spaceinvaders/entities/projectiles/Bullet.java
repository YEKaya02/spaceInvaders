package org.spaceinvaders.entities.projectiles;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;

import java.util.List;

public class Bullet extends DynamicSpriteEntity implements Collider, SceneBorderTouchingWatcher {
    public Bullet(Coordinate2D initialLocation, Direction direction, String resource) {
        super(resource, initialLocation);
        setMotion(6, direction);
    }

    @Override
    public void notifyBoundaryTouching(SceneBorder sceneBorder) {
        remove();
    }
}
