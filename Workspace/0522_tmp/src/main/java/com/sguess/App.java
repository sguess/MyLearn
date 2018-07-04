package com.sguess;

public class App {
    int num = 0;

    public static void main(String[] args) {
        new App().validation();
    }


    public void validation() {
        num++;
        if (num < 5) {
            System.out.println("回调: " + num);
            this.validation();
//			return;
        }
        System.out.println("End: " + num);
    }

}
