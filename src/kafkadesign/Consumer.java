package kafkadesign;

import java.util.List;
import java.util.Queue;

public class Consumer {
    String consumerId;

   public void consumeMessage(Topic topic){
       List<Partition> partitionList = topic.partitions;
       for (int i = 0; i < partitionList.size(); i++) {

           //while reading from partition
           //get message
           Queue<Message> message = partitionList.get(i).getMessages();

       }
   }

}
