package learn_thread;

public class LearnRunAndStart {

    private static void attack() {
        System.out.println("运行 attack");
        System.out.println("当前线程：" + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        Thread thread = new Thread() {
            public void run() {
                attack();
            }
        };
//        thread.run(); // 打印：当前线程：main，说明没有创建新线程
        thread.start(); // 打印：当前线程：Thread-0，说明创建了新线程
    }
}
