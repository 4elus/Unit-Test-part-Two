public class TestBank extends Bank {

    @Override
    public int convert(int value, String from, String to) throws ValueException {
        String key = String.format("%s-%s", from, to);

        if (currencyHash.containsKey(key))
            return (int) Math.round(currencyHash.get(key) * value);
        else
            throw new ValueException("В банке отсутвует одна из валют " + key);
    }
}
