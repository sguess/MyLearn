package com.sguess.threads.fields;

public class FieldInThreads {

    public static void main(String[] args) throws InterruptedException {
        MyObj obj = new MyObj();
        for (int i = 0; i < 1000; i++) {
            Thread thread = new MyThreads(obj);
            thread.start();
        }
    }
}

class MyObj {
    private int outsideNum = 0;

    public void add() throws InterruptedException {
        int internalNum = 0;
        Thread.sleep(100);
        internalNum++;
        outsideNum++;
        System.out.println(
//			Thread.currentThread().getName() + "\t:" + Calendar.getInstance().get(Calendar.SECOND)+ "\t:" + outsideNum + "\t:" + internalNum);
                Thread.currentThread().getName() + "\t:" + outsideNum + "\t:" + internalNum);
        if (internalNum >= 2) {
            System.err.println("Error internal Num: " + internalNum);
        }
    }

    public synchronized void synAdd() throws InterruptedException {
        add();
    }
}

class MyThreads extends Thread {
    MyObj obj;

    public MyThreads(MyObj obj) {
        this.obj = obj;
    }

    @Override
    public void run() {
        try {
            obj.add();
//			obj.synAdd();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
