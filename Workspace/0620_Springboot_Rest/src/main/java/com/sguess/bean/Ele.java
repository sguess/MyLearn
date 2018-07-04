package com.sguess.bean;

public class Ele {
    private String css;
    private String str;

    public Ele() {
        super();
    }

    public Ele(String css, String str) {
        super();
        this.css = css;
        this.str = str;
    }

    public String getCss() {
        return css;
    }

    public void setCss(String css) {
        this.css = css;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    @Override
    public String toString() {
        return "Ele [css=" + css + ", str=" + str + "]";
    }

}
