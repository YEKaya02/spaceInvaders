module SpaceInvaders {
    requires hanyaeger;
    requires java.desktop;
    requires com.google.guice;

    exports org.spaceinvaders;

    opens ships;
    opens projectiles;
    opens fonts;
}