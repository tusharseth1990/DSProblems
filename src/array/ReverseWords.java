package array;


public class ReverseWords {

    String reverseSentence(String s) {
        StringBuilder sb = new StringBuilder();
        String[] words = s.trim().split(" ");
        for (int i = words.length-1; i > 0; i--) {
            if(!words[i].trim().equals(""))
            {
                sb.append(words[i]+ " ");
            }

        }

        sb.append(words[0]);
        return sb.toString();
    }

    public static void main(String[] args) {
        ReverseWords reverse = new ReverseWords();
        System.out.println(reverse.reverseSentence("Reverse the Sentence & check"));
        System.out.println(reverse.reverseSentence("a good   example"));
    }
}
