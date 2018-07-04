import java.util.Date;


public class InitServlet {
    public void init() {
        while (true) {
            System.out.println("--------------->" + new Date());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }
}
