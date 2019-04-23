package mysolution;

/**
 * @program: Code
 * @author: KDF
 * @create: 2019-04-16
 **/
/*
两个线程交替执行任务
 */
public class ThreadTest {
//
//    public static void main(String[] args) {
//        ThreadTest threadTest = new ThreadTest();
//
//
//         class MyThreadA extends Thread {
//             int num = 0;
//
//             @Override
//             public void run() {
//                 for (int i = 0; i < 100; i = i + 2) {
//                     synchronized (ThreadTest.class) {
//                         System.out.println(Thread.currentThread().getName() + " " + num++);
//                         synchronized (ThreadTest.class) {
//                             System.out.println(Thread.currentThread().getName() + " " + num++);
//                             this.notify();
//                             try {
//                                 this.wait();
//                                 Thread.sleep(100);
//                             } catch (InterruptedException e) {
//                                 e.printStackTrace();
//                             }
//
//                         }
//                     }
//                 }
//             }
//         }
//
//         class MyThreadB extends Thread {
//             int num = 0;
//
//             @Override
//             public void run() {
//                 for (int i = 0; i < 100; i += 1) {
//                     synchronized (ThreadTest.class) {
//                         System.out.println(Thread.currentThread().getName() + " " + num++);
//                         this.notify();
//                         try {
//                             this.wait();
//                             Thread.sleep(100);
//                         } catch (InterruptedException e) {
//                             e.printStackTrace();
//                         }
//
//                     }
//                 }
//             }
//         }
//
//        MyThreadA myThreadA = new MyThreadA();
//         MyThreadB myThreadB = new MyThreadB();
//         myThreadA.start();
//         myThreadB.start();
//    }

    public static volatile int num = 0;
    public static volatile boolean flag = false;
    public static void main(String[] args) {
        Thread threadA = new Thread(() -> {
            for (; num < 100; ) {
                if (flag && (num & 1) == 1) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(num++);
                flag = true;
            }

        });

        Thread threadB = new Thread(() -> {
            for (; num < 100; ) {
                if (!flag && (num & 1) != 1) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(num++);
                flag = false;
            }

        });
        threadA.start();
        threadB.start();
    }
}



