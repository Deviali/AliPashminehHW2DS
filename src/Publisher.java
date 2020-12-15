import java.io.File;
import java.util.Objects;

public class Publisher {
    private String topic;

    public Publisher(String t) {
        this.topic = t;
    }

    public void publish(String m) {
        ContentServer.getInstance().sendMessage(this.topic, m);
    }

    public void publishFromFile(File source) {
        try {
            for (File file : Objects.requireNonNull(source.listFiles())) {
                if (file.isDirectory())
                    publishFromFile(file);
                else publish(source.getAbsolutePath() + " has " + file.getName());
            }
        } catch (Exception ignored) { }
    }
}