module SpaceInvaders {
    requires hanyaeger;
    requires java.desktop;

    exports org.spaceinvaders;

    opens ships;
    opens projectiles;
}