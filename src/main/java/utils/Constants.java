package utils;

import main.Game;

public class Constants {

    public static class UI {
        public static class Buttons {
            public static final int B_WIDTH_DEFAULT = 140;
            public static final int B_HEIGHT_DEFAULT = 56;
            public static final int B_WIDTH = (int) (B_WIDTH_DEFAULT * Game.SCALE);
            public static final int B_Height = (int) (B_HEIGHT_DEFAULT * Game.SCALE);
        }
    }

    public static class Directions {
        public static final int LEFT = 0;
        public static final int UP = 1;
        public static final int RIGHT = 2;
        public static final int DOWN = 3;
    }

    public static class PlayerConstants {
        public static final int IDLE = 0;
        public static final int IDLE_BLINK = 1;
        public static final int WALK = 2;
        public static final int RUN = 3;
        public static final int DUCK = 4;
        public static final int JUMP = 5;
        public static final int DISSAPEAR = 6;
        public static final int DIE = 7;
        public static final int ATTACK = 8;

        public static int GetSpriteAmount(int player_action) {
            switch (player_action) {
                case IDLE:
                    return 2;
                case IDLE_BLINK:
                    return 2;
                case WALK:
                    return 4;
                case RUN:
                    return 8;
                case DUCK:
                    return 6;
                case JUMP:
                    return 8;
                case DISSAPEAR:
                    return 8;
                case DIE:
                    return 8;
                case ATTACK:
                    return 8;
                default:
                    return 1;
            }
        }
    }

}
