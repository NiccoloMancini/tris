package it.itismeucci;

public class Game {
    private static Player p1 = new Player("Player 1", "X");
    private static Player p2 = new Player("Player 2", "O");
    private static String[][] field = new String[3][3];
    private static boolean turnP1 = true;

    public static Player getP1() {
        return p1;
    }

    public static void setP1(Player p1) {
        Game.p1 = p1;
    }

    public static Player getP2() {
        return p2;
    }

    public static void setP2(Player p2) {
        Game.p2 = p2;
    }

    public static Player playerTurn() {
        if (turnP1) {
            return p1;
        }
        return p2;
    }

    public static void changeTurn() {
        turnP1 = !turnP1;
    }

    public static void setSign(int x, int y, Player p) {
        field[x][y] = p.getSign();
    }

    public static void resetField() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                field[i][j] = "-";
            }
        }
    }

    public static boolean victory() {
        String sign = Game.playerTurn().getSign();
        if ((field[0][0].equals(sign) && field[0][1].equals(sign) && field[0][2].equals(sign)) ||
                (field[0][0].equals(sign) && field[1][0].equals(sign) && field[2][0].equals(sign)) ||
                (field[0][0].equals(sign) && field[1][1].equals(sign) && field[2][2].equals(sign))) {
            return true;
        }
        if ((field[2][2].equals(sign) && field[1][2].equals(sign) && field[0][2].equals(sign)) ||
                (field[2][2].equals(sign) && field[2][1].equals(sign) && field[2][0].equals(sign))) {
            return true;
        }
        if ((field[1][0].equals(sign) && field[1][1].equals(sign) && field[1][2].equals(sign)) ||
                (field[0][1].equals(sign) && field[1][1].equals(sign) && field[2][1].equals(sign)) ||
                (field[0][2].equals(sign) && field[1][1].equals(sign) && field[2][0].equals(sign))) {
            return true;
        }
        return false;
    }
}
