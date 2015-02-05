import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class YiqixieMessageQueue {
    private DBCollection collection;

    public YiqixieMessageQueue(DB db) {
        this.collection = db.getCollection("default");
    }

    public YiqixieMessageQueue(DB db, String queueName) {
        this.collection = db.getCollection(queueName);
    }

    public void push(YiqixieMessage yiqixieMessage) {
        push(yiqixieMessage, 0);
    }

    public void push(YiqixieMessage yiqixieMessage, int timeDelay) {
        BasicDBObject message = yiqixieMessage.getMessage();
        collection.insert(((BasicDBObject) message.copy()).append("startTime", System.currentTimeMillis() + timeDelay));
    }

    public YiqixieMessage get() {
        return get(new BasicDBObject());
    }

    public YiqixieMessage get(BasicDBObject query) {
        return get(query, Integer.MAX_VALUE, 200);
    }

    public YiqixieMessage get(BasicDBObject query, int timeout, int period) {
        return get(query, timeout, period, false);
    }

    private YiqixieMessage get(BasicDBObject query, int timeout, int period, boolean remove) {
        BasicDBObject newQuery = (BasicDBObject) query.copy();
        BasicDBObject sort = new BasicDBObject().append("_id", 1);
        BasicDBObject update = null;
        if (!remove) {
            update = new BasicDBObject("$inc", new BasicDBObject("getCount", 1));
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.MILLISECOND, timeout);
        Date end = calendar.getTime();
        while (true) {
            newQuery.put("startTime", new BasicDBObject("$lte", System.currentTimeMillis()));
            BasicDBObject result = (BasicDBObject) collection.findAndModify(newQuery, null, sort, remove, update, false, false);
            if (result != null) {
                return new YiqixieMessage(result);
            }
            if (new Date().compareTo(end) >= 0) {
                return null;
            }
            try {
                Thread.sleep(period);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public YiqixieMessage pop() {
        return pop(new BasicDBObject());
    }

    public YiqixieMessage pop(BasicDBObject query) {
        return pop(query, Integer.MAX_VALUE, 200);
    }

    public YiqixieMessage pop(BasicDBObject query, int timeout, int period) {
        return get(query, timeout, period, true);
    }

    public List<YiqixieMessage> getAll() {
        return getAll(new BasicDBObject());
    }

    public List<YiqixieMessage> getAll(BasicDBObject query) {
        List<YiqixieMessage> messages = new ArrayList<YiqixieMessage>();
        DBCursor cursor = collection.find(query);
        while (cursor.hasNext()) {
            messages.add(new YiqixieMessage((BasicDBObject) cursor.next()));
        }
        return messages;
    }

    public void ack(YiqixieMessage message) {
        collection.remove(message.getMessage());
    }

    public void ackAll(List<YiqixieMessage> messages) {
        for (YiqixieMessage message : messages) {
            collection.remove(message.getMessage());
        }
    }
}
