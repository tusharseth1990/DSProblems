package interviewQ.kafka;

import java.util.ArrayList;
import java.util.List;

public class Topic {
    String topicName;
    List<Partition> partitions;

    Integer noOfPartitions;

    public Topic(String topicName, Integer noOfPartitions) {
        this.topicName = topicName;
        this.noOfPartitions = noOfPartitions;
        this.partitions = new ArrayList<>();
        for (int i = 0; i < noOfPartitions.intValue(); i++) {
            partitions.add(new Partition());
        }
    }

     interviewQ.kafka.Partition getPartitionByKey(String key){
        int hash = key.hashCode();
        int index = hash % noOfPartitions;
        return partitions.get(index);
    }
}
