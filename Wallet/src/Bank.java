import java.util.*;

public class Bank {
    protected Map<String, Double> currencyHash;
    Random rnd;

    public Bank(){
        this.rnd = new Random();
        setCurrencyHash();
    }

    protected void setCurrencyHash(){
        currencyHash = new HashMap<String, Double>();
        currencyHash.put("USD-RUB", 73.0);
        currencyHash.put("USD-EUR", 0.92);

        currencyHash.put("RUB-USD", 0.014);
        currencyHash.put("RUB-EUR", 0.013);

        currencyHash.put("EUR-RUB", 79.0);
        currencyHash.put("EUR-USD", 1.08);
    }

    public int convert(int value, String from, String to) throws ValueException {
        String key = String.format("%s-%s", from, to);

        if (currencyHash.containsKey(key))
            return (int) Math.round(currencyHash.get(key) * value + 0.2*(rnd.nextInt(20) - rnd.nextInt(20)));
        else
            throw new ValueException("В банке отсутвует одна из валют " + key);
    }
}
