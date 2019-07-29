import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

public class PhoneBook {
    private final HashMap<String, ArrayList<Person>> contacts = new HashMap<>();

    public void add(String surname, String phone, String email){
        if (contacts.containsKey(surname)){
            contacts.get(surname).add(new Person(phone, email));
        } else {
            ArrayList<Person> persons = new ArrayList<>();
            persons.add(new Person(phone, email));
            contacts.put(surname, persons);
        }
    }
    public ArrayList<String> getEmails(String surname){
         if(contacts.containsKey(surname)) return contacts.get(surname).stream().map(person -> person.email).collect(Collectors.toCollection(ArrayList::new));
            else
                return null;
    }
    public ArrayList<String> getPhones(String surname){
          if(contacts.containsKey(surname))return contacts.get(surname).stream().map(person -> person.phone).collect(Collectors.toCollection(ArrayList::new));
            else
                return null;
    }
}