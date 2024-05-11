package it.itismeucci;

public class Player {
    private String nickname;
    private String sign;

    public Player(String nickname, String sign) {
        this.nickname = nickname;
        this.sign = sign;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
