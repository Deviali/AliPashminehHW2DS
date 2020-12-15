public class Subscriber {
    public Subscriber(String...topics) {
        for (String t : topics) {
            ContentServer.getInstance().registerSubscriber(this, t);
        }
    }

    public void receivedMessage(String t, String m) {
        System.out.println(t + " : " + m);
    }
}