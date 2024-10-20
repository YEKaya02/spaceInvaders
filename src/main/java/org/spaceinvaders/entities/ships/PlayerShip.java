package org.spaceinvaders.entities.ships;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.TimerContainer;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.input.KeyCode;
import org.spaceinvaders.scenes.GameScene;
import org.spaceinvaders.timers.CooldownTimer;

import java.util.Set;

public class PlayerShip extends Ship implements KeyListener, TimerContainer {
    private final int upperLimit;

    public PlayerShip(String resource, Coordinate2D initialLocation, Size gameSize, GameScene scene) {
        super(resource, initialLocation, scene);
        int movementHeight = 200;
        this.upperLimit = (int) (gameSize.height() - movementHeight);
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
        if(pressedKeys.contains(KeyCode.SPACE)) {
            shoot(this, Direction.UP);
        }
        if (pressedKeys.contains(KeyCode.W)) {
            if (getLocationInScene().getY() > upperLimit) {
                if (pressedKeys.contains(KeyCode.D)) {
                    setMotion(3, Direction.UP_RIGHT);
                } else if (pressedKeys.contains(KeyCode.A)) {
                    setMotion(3, Direction.UP_LEFT);
                } else {
                    setMotion(3, Direction.UP);
                }
            } else {
                // Stop the motion.
                setMotion(0, 0);
            }
        } else if (pressedKeys.contains(KeyCode.S)) {
            if (pressedKeys.contains(KeyCode.D)) {
                setMotion(3, Direction.DOWN_RIGHT);
            } else if (pressedKeys.contains(KeyCode.A)) {
                setMotion(3, Direction.DOWN_LEFT);
            } else {
                setMotion(3, Direction.DOWN);
            }
        } else if (pressedKeys.contains(KeyCode.A)) {
            setMotion(3, Direction.LEFT);
        } else if (pressedKeys.contains(KeyCode.D)) {
            setMotion(3, Direction.RIGHT);
        } else if (!pressedKeys.contains(KeyCode.W) && !pressedKeys.contains(KeyCode.A) && !pressedKeys.contains(KeyCode.S) && !pressedKeys.contains(KeyCode.D)) {
            // Stop the motion.
            setMotion(0,0);
        }
    }

    @Override
    public void notifyBoundaryTouching(SceneBorder sceneBorder) {
        int centerOffsetHeight = (int) getHeight() / 2;

        switch(sceneBorder){
            case BOTTOM:
                setAnchorLocationY(getSceneHeight() - getHeight() + centerOffsetHeight);
                break;
            case LEFT:
                setAnchorLocationX(getSceneWidth()-30);
                break;
            case RIGHT:
                setAnchorLocationX(30);
                break;
            default:
                break;
        }
    }

    @Override
    public void setupTimers() {
        addTimer(new CooldownTimer(500, this));
        getTimers().getFirst().pause();
        getTimers().getFirst().reset();
    }

    @Override
    public void shoot(Ship ship, Direction direction){
        super.shoot(ship, direction);
        setCanShoot(false);
        getTimers().getFirst().resume();
    }
}
