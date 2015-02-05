import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;

import java.net.UnknownHostException;
import java.util.Date;

public class Main {
    public static void main(final String[] args) throws UnknownHostException {
        final YiqixieMessageQueue queue = new YiqixieMessageQueue(new MongoClient().getDB("test"), "testQueue");
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("begin pop : " + new Date().toString());
                while (true) {
                    YiqixieMessage message = queue.pop();
//                    System.out.println("pop result : " + new Date().toString());
                    System.out.println("result is : " + message.getMessage().values());
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(Math.round(200 * Math.random()));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    YiqixieMessage message = new YiqixieMessage();
                    message.setPayload(new BasicDBObject("test", new Date().toString()));
                    System.out.println("push");
                    queue.push(message);
                }
            }
        }).start();
    }
}
