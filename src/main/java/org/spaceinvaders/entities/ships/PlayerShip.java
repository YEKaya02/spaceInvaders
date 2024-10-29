package org.spaceinvaders.entities.ships;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.TimerContainer;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.input.KeyCode;
import org.spaceinvaders.scenes.GameScene;
import org.spaceinvaders.timers.CooldownTimer;

import java.util.Set;

public class PlayerShip extends Ship implements KeyListener, TimerContainer, SceneBorderCrossingWatcher, SceneBorderTouchingWatcher {
    private final int upperLimit;

    public PlayerShip(String resource, Coordinate2D initialLocation, Size gameSize, GameScene scene) {
        super(resource, initialLocation, scene, "projectiles/bullet.png", 30);
        int movementHeight = 200;
        this.upperLimit = (int) (gameSize.height() - movementHeight);
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
        // defined key presses:
        // space: shoot
        // WASD: move into direction of keypress, diagonal movement is also possible
        if(pressedKeys.contains(KeyCode.SPACE)) {
            shoot(new Coordinate2D(getLocationInScene().getX(), getLocationInScene().getY() - 55), Direction.UP);
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

        if (sceneBorder == SceneBorder.BOTTOM) {
            setAnchorLocationY(getSceneHeight() - 5);
        }
    }

    @Override
    public void setupTimers() {
        addTimer(new CooldownTimer(500, this));
        getTimers().getFirst().pause();
        getTimers().getFirst().reset();
    }

    @Override
    public void shoot(Coordinate2D coordinate2D, Direction direction){
        super.shoot(coordinate2D, direction);
        setCanShoot(false);
        getTimers().getFirst().resume();
    }

    private void gameOver(){
        System.out.println("game over");
    }

    @Override
    protected void handleDeath() {
        gameOver();
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder sceneBorder) {
        switch(sceneBorder){
            case LEFT:
                setAnchorLocationX(getSceneWidth());
                break;
            case RIGHT:
                setAnchorLocationX(0);
                break;
            default:
                break;
        }
    }
}
