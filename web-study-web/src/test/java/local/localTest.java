package local;


/**
 * Created by cdyujing7 on 2018/8/13.
 */
public class localTest {

    public static void main(String[] args) {

        System.out.println(-1<<29);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("1:" + Thread.currentThread().getName());
                ThreadGroup group = Thread.currentThread().getThreadGroup();
                System.out.println("2:" + group.getName());
            }
        });
        thread.start();
        ThreadGroup group = Thread.currentThread().getThreadGroup();
        group.list();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
