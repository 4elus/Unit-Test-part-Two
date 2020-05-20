import org.junit.Assert;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;

public class MyTest {
    @Test
    public void addMoneyEmpty() {
        Wallet wallet = new Wallet();
        String key = "RUB";
        wallet.addMoney(key, 500);

        Assert.assertEquals(500, (long) wallet.hashMapCurrency.get(key));
    }

    @Test
    public void addMoneyNotEmpty() {
        Wallet wallet = new Wallet();
        String key = "RUB";
        wallet.addMoney(key, 500);
        wallet.addMoney(key, 520);

        Assert.assertEquals(1020, (long) wallet.hashMapCurrency.get(key));
    }

    @Test(expected = ValueException.class)
    public void removeMoneyCurrencyNotFound() throws Exception{
        Wallet wallet = new Wallet();
        String key = "RUB";
        wallet.removeMoney(key, 20);
    }

    @Test(expected = ValueException.class)
    public void removeMoneyExcess() throws Exception{
        Wallet wallet = new Wallet();
        String key = "RUB";
        wallet.addMoney(key, 500);
        wallet.removeMoney(key, 520);
    }

    @Test
    public void removeMoneyNotEmpty() throws Exception{
        Wallet wallet = new Wallet();
        String key = "RUB";
        wallet.addMoney(key, 500);
        wallet.addMoney(key, 520);
        wallet.removeMoney(key, 20);

        Assert.assertEquals(1000, (long) wallet.hashMapCurrency.get(key));
    }

    @Test
    public void getMoneyNotEmpty() throws Exception{
        Wallet wallet = new Wallet();
        String key = "RUB";
        wallet.addMoney(key, 500);

        Assert.assertEquals(500, wallet.getMoney(key));
    }

    @Test
    public void getMoneyEmpty() throws Exception{
        Wallet wallet = new Wallet();
        String key = "RUB";

        Assert.assertEquals(0, wallet.getMoney(key));
    }

    @Test
    public void getCurrencyAmountAll() throws Exception{
        Wallet wallet = new Wallet();
        wallet.addMoney("RUB", 10);
        wallet.addMoney("USD", 20);

        Assert.assertEquals(2, wallet.getCurrencyAmount());
    }

    @Test
    public void getCurrencyAmountNotAll() throws Exception{
        Wallet wallet = new Wallet();
        wallet.addMoney("RUB", 10);
        wallet.addMoney("USD", 0);

        Assert.assertEquals(1, wallet.getCurrencyAmount());
    }

    @Test
    public void toStringEmpty() throws Exception{
        Wallet wallet = new Wallet();

        Assert.assertEquals("{ }", wallet.toString());
    }

    @Test
    public void toStringNotEmpty() throws Exception{
        Wallet wallet = new Wallet();
        wallet.addMoney("RUB", 10);
        wallet.addMoney("USD", 20);

        Assert.assertEquals("{ 20 USD; 10 RUB; }", wallet.toString());
    }
}

