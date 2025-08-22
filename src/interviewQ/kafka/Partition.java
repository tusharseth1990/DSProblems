package interviewQ.kafka;

import java.util.LinkedList;
import java.util.Queue;

public class Partition {
    int partitionId;
    Queue<Message> messages;

    public Partition(int partitionId, Queue<Message> messages) {
        this.partitionId = partitionId;
        this.messages = messages;
    }

    public Partition() {
    }

    public void addMessage(Message message){
        messages.add(message);
    }

    public Message getMessage(){
       return messages.poll();
    }

    public Queue<Message> getMessages(){
        return messages;
    }
}
