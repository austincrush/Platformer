package utils;

public class Constants {

    public static class Directions {
        public static final int LEFT = 0;
        public static final int UP = 1;
        public static final int RIGHT = 2;
        public static final int DOWN = 3;
    }

    public static class PlayerConstants {
        public static final int IDLE = 0;
        public static final int WALKING = 1;
        public static final int RUNNING = 2;
        public static final int SKIPPING = 3;
        public static final int JUMPING = 4;
        public static final int ATTACKING_1 = 5;
        public static final int ATTACKING_2 = 6;
        public static final int ATTACKING_3 = 7;
        public static final int ATTACKING_4 = 8;

        public static int getSpriteAmount(int player_action) {
            switch (player_action) {
                case IDLE, WALKING, RUNNING:
                    return 6;
                case SKIPPING, JUMPING:
                    return 4;
                case ATTACKING_1, ATTACKING_2, ATTACKING_3, ATTACKING_4:
                    return 5;
                default:
                    return 1;
            }
        }
    }

}
