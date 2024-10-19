package org.spaceinvaders.entities.ships;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import org.spaceinvaders.entities.projectiles.Bullet;
import org.spaceinvaders.scenes.GameScene;

import java.util.List;

public class EnemyShip extends Ship implements Collided, Collider {
    public EnemyShip(String resource, Coordinate2D initialLocation, GameScene scene) {
        super(resource, initialLocation, scene);
    }

    @Override
    public void onCollision(List<Collider> list) {
        for (Collider collider : list) {
            if (collider instanceof Bullet){
                ((Bullet) collider).remove();
                remove();
            }
        }
    }
}
