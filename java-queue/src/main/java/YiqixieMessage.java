import com.mongodb.BasicDBObject;

public class YiqixieMessage {
    private BasicDBObject payload;

    public YiqixieMessage() {
        this.payload = new BasicDBObject();
    }

    public YiqixieMessage(BasicDBObject message) {
        this.payload = (BasicDBObject) message.get("payload");
    }

    public BasicDBObject getMessage() {
        BasicDBObject message = new BasicDBObject().append("payload", payload);
        return message;
    }

    public void setPayload(BasicDBObject payload) {
        this.payload = payload;
    }

    public BasicDBObject getPayload() {
        return payload;
    }
}
