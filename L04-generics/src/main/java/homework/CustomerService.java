package homework;


import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class CustomerService {

    //todo: 3. надо реализовать методы этого класса
    //важно подобрать подходящую Map-у, посмотрите на редко используемые методы, они тут полезны

    private final TreeMap<Customer, String> map;

    public CustomerService() {
        this.map = new TreeMap<>(Comparator.comparing(Customer::getScores));
    }

    public Map.Entry<Customer, String> getSmallest() {
        //Возможно, чтобы реализовать этот метод, потребуется посмотреть как Map.Entry сделан в jdk
        Map.Entry<Customer, String> customerStringEntry = map.firstEntry();
        TreeMap<Customer, String> treeMap = new TreeMap<>(Comparator.comparing(Customer::getScores));
        if (customerStringEntry != null) {
            treeMap.put(new Customer(customerStringEntry.getKey().getId(), customerStringEntry.getKey().getName(), customerStringEntry.getKey().getScores()), customerStringEntry.getValue());
        }
        return treeMap.firstEntry();
    }

    public Map.Entry<Customer, String> getNext(Customer customer) {
        Map.Entry<Customer, String> customerStringEntry = map.higherEntry(customer);

        TreeMap<Customer, String> buf = new TreeMap<>(Comparator.comparing(Customer::getScores));
        if (customerStringEntry != null) {
            buf.put(new Customer(customerStringEntry.getKey().getId(), customerStringEntry.getKey().getName(), customerStringEntry.getKey().getScores()), customerStringEntry.getValue());
        }
        return buf.firstEntry();
    }

    public void add(Customer customer, String data) {
        map.put(customer, data);
    }
}
