package java8;

import java.util.List;
import java.util.stream.Collectors;

public class StringJoining {

    private void joinTheStringTogether(List<String> list) {

        System.out.println(list.stream().collect(Collectors.joining(",","{","}")));
    }


    //[{Facebook},{Twitter},{YouTube},{WhatsApp},{LinkedIn}]

    public static void main(String[] args) {
        StringJoining stringJoining= new StringJoining();
        stringJoining.joinTheStringTogether(List.of("Facebook", "Twitter", "YouTube", "WhatsApp", "LinkedIn"));
    }


}
