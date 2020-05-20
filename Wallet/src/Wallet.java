import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Wallet {
    public Map<String, Integer> hashMapCurrency;
    Bank bank;
    MoneyPrinter moneyPrinter;

    public Wallet(){
        hashMapCurrency = new HashMap<String, Integer>();
        bank = new Bank();
        moneyPrinter = new MoneyPrinter();
    }

    //добавление валюты
    public void addMoney(String key, int value){
        if (hashMapCurrency.containsKey(key)){
            int balance = hashMapCurrency.get(key);
            hashMapCurrency.replace(key, balance + value);
        }
        else{
            hashMapCurrency.put(key, value);
        }
        moneyPrinter.print("ДОБАВЛЕНИЕ", key, value);
    }
    //извлеечние валюты
    public void removeMoney(String key, int value) throws ValueException{
        if (hashMapCurrency.containsKey(key)){
            int balance = hashMapCurrency.get(key);
            if (balance < value)
                throw new ValueException("Недостаточно средств");
            hashMapCurrency.replace(key, balance - value);
            moneyPrinter.print("ИЗВЛЕЧЕНИЕ", key, value);
        }
        else{
            throw new ValueException("Данная валюта отсутствует");
        }
    }
    //кол-во определенной валюты в кошельке
    public int getMoney(String key){
        if (hashMapCurrency.containsKey(key)){
            return hashMapCurrency.get(key);
        }else{
            return 0;
        }
    }
    //кол-во видов валюты с ненулевым значением
    public int getCurrencyAmount(){
        int amount = 0;
        for (String key: hashMapCurrency.keySet()) {
            if (hashMapCurrency.get(key) > 0)
                amount ++;
        }

        return amount;
    }
    //содержание кошелька
    public String toString() {
        String res = "{ ";

        for (String key: hashMapCurrency.keySet()) {
            res +=  String.format("%d %s; ",
                    hashMapCurrency.get(key) ,
                    key);
        }

        res += "}";

        return res;
    }
    //конвертирование всех денег в одну валюту
    public int getTotalMoney(String keyIn) throws ValueException{
        int result = getMoney(keyIn);

        for (String key: hashMapCurrency.keySet()) {
            if (hashMapCurrency.get(key) > 0 && keyIn != key)
                result += bank.convert(hashMapCurrency.get(key), key, keyIn);
        }

        return result;
    }

}
