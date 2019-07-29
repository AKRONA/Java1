import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Main {
    private static final String[] words = {"A","A","A","B","C","A","A","B","C","A","A","B","C","A","A","B","C","D","E","B","CDD","A","A","B","C"};
    public static void main(String[] args) {
        System.out.println(wordListFilter(words));
        System.out.println(wordsCount(words));
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Petrov", "(867)456-22-78","nuwogaw@best-mail.net");
        phoneBook.add("Ivanov", "(44)962-47-87","sopayo@mini-mail.net");
        phoneBook.add("Sidorov", "(3965)216-59-42","cehuji@nextmail.in");
        phoneBook.add("Petrov", "(1817)892-68-03","gucog@mailline.net");
        System.out.println("Petrov phone: "+phoneBook.getPhones("Petrov"));
        System.out.println("Ivanov mail: "+phoneBook.getEmails("Ivanov"));
    }

    private static HashSet<String> wordListFilter(String[] list) {
        return new HashSet<>(Arrays.asList(list));
    }
    private static HashMap<String, Integer> wordsCount (String[] list){
        HashMap<String, Integer> answer = new HashMap<>();
        for (int i = 0; i < list.length; i++) {
            String word = list[i];
            answer.put(word, (answer.containsKey(word))?answer.get(word)+1:1);
        }
        return answer;
    }
}
