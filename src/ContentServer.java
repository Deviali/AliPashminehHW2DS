import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class ContentServer {
    private Hashtable<String, List<Subscriber>> subscriberLists;

    private static ContentServer serverInstance;

    public static ContentServer getInstance() {
        if (serverInstance == null) {
            serverInstance = new ContentServer();
        }
        return serverInstance;
    }

    private ContentServer() {
        this.subscriberLists = new Hashtable<>();
    }

    public void sendMessage(String t, String m) {
        List<Subscriber> subs = subscriberLists.get(t);
        for (Subscriber s : subs) {
            s.receivedMessage(t, m);
        }
    }

    public void registerSubscriber(Subscriber s, String t) {
        subscriberLists.putIfAbsent(t, new ArrayList<>());
        subscriberLists.get(t).add(s);
    }
}