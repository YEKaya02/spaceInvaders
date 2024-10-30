package org.spaceinvaders.entities.projectiles;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.input.KeyCode;

import java.util.Set;

public class Missile extends Projectile implements KeyListener {
    public Missile(Coordinate2D initialLocation, Direction direction) {
        super(initialLocation, direction, "projectiles/missile.png", 5, 100);
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
        if (pressedKeys.contains(KeyCode.RIGHT)) {
            setDirection(Direction.UP_RIGHT);
        } else if (pressedKeys.contains(KeyCode.LEFT)) {
            setDirection(Direction.UP_LEFT);
        }
    }
}
