package kafkadesign;

public class Producer {

    String producerId;

    public void send(Topic topic , String key, String value){
        Message message = new Message(key,value);
        Partition partition = topic.getPartitionByKey(key);
        partition.addMessage(message);
    }
}
