package array.hashing;
//Design an algorithm to encode a list of strings to a string. The encoded string is
// then sent over the network and is decoded back to the original list of strings.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EncodeDecodeString {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        // ["Hello","World"] => "5#Hello5#World"
        for (String str : strs) {
            sb.append(str.length());
            sb.append("#");
            sb.append(str);
        }

        return sb.toString();
    }

    public List<String> decode(String s) {
        List<String> list = new ArrayList<>();

        int i = 0;

        // "5#Hello5#World"
        //  i
        //   j
        //         ↑
        //   (j + len + 1)

        while (i < s.length()) {
            int j = i;
            while (s.charAt(j) != '#') {
                j++;
            }
            int len = Integer.parseInt(s.substring(i, j));
            list.add(s.substring(j + 1, j + len + 1));
            i = j + len + 1;
        }

        return list;
    }

    public static void main(String[] args) {
        String[] str = {"eat", "tea", "tan", "ate", "nat", "bat"};
        EncodeDecodeString ens= new EncodeDecodeString();
        String encodedString= ens.encode(Arrays.stream(str).toList());
        List<String> decoded= ens.decode(encodedString);
        System.out.println(decoded);
    }
}
