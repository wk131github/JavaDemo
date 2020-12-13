import java.util.PriorityQueue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author walkinger
 * @version 1.0
 * @date 2020/12/13 14:52
 */
public class ConsumerAndProducer {
    private int queueSize = 10;
    //private PriorityQueue<Integer> queue = new PriorityQueue<>(queueSize);

    private ArrayBlockingQueue<Integer> blockingQueue=new ArrayBlockingQueue<>(queueSize);

    public static void main(String[] args) {
        ConsumerAndProducer consumerAndProducer = new ConsumerAndProducer();
        //consumerAndProducer.new Producer().start();
       // consumerAndProducer.new Consumer().start();
        consumerAndProducer.new Producer1().start();
        consumerAndProducer.new Consumer1().start();

    }



//    class Consumer extends Thread {
//        @Override
//        public void run() {
//            consumer();
//        }
//
//        private void consumer() {
//            while (true) {
//                synchronized (queue) {
//                    while (queue.size() == 0) {
//                        System.out.println("queue is empty , please wait !");
//                        try {
//                            queue.wait();
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                            queue.notify();
//                        }
//                    }
//                    queue.poll();
//                    queue.notify();
//                    System.out.println(Thread.currentThread() + "从队列中取走了一个元素，队列还剩" + queue.size());
//                }
//            }
//        }
//    }
//
//    class Producer extends Thread{
//        @Override
//        public void run(){
//            producer();
//        }
//        private void producer(){
//            while(true){
//                synchronized (queue){
//                    while (queue.size()==queueSize){
//                        System.out.println("queue is full ,please wait !");
//                        try {
//                            queue.wait();
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                            queue.notify();
//                        }
//                    }
//                    queue.offer(1);
//                    queue.notify();
//                    System.out.println(Thread.currentThread()+"往队列里放了一个元素，队列现在有"+queue.size()+"个元素");
//                }
//            }
//        }
//    }


    /**
     * 使用阻塞队列实现生产者消费者模型
     */
    class Consumer1 extends  Thread{
        @Override
        public void run(){
            consumer();
        }
        public void consumer(){
            while (true){
                try {
                    blockingQueue.take();
                    System.out.println(Thread.currentThread() + "从队列中取走了一个元素，队列还剩" + blockingQueue.size());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class Producer1 extends Thread{
        @Override
        public void run(){
            producer();
        }

        private void producer() {
            while (true){
                try {
                    blockingQueue.put(1);
                    System.out.println(Thread.currentThread()+"往队列里放了一个元素，队列现在有"+blockingQueue.size()+"个元素");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
