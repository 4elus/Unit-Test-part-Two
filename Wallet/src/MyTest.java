import org.junit.Assert;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;

public class MyTest {
    TestBank bank = new TestBank();
    Wallet wallet = new Wallet(bank);
    String mainKey = "RUB";

    @Test
    public void addMoney() {
        int add = 500;
        int result = wallet.getMoney(mainKey) + add;

        wallet.addMoney(mainKey, add);
        Assert.assertEquals(result, wallet.getMoney(mainKey));
    }

    @Test
    public void addMoneyNull() {
        int result = wallet.getMoney(mainKey);

        wallet.addMoney(mainKey, 0);
        Assert.assertEquals(result, wallet.getMoney(mainKey));
    }

    @Test(expected = ValueException.class)
    public void removeMoneyCurrencyNotFound() throws Exception{
        wallet.removeMoney("WER", 20);
    }

    @Test(expected = ValueException.class)
    public void removeMoneyExcess() throws Exception{
        int remove = wallet.getMoney(mainKey) + 500;

        wallet.removeMoney(mainKey, remove);
    }

    @Test
    public void removeMoneyNotEmpty() throws Exception{
        int addAndRemove = 500;
        int result = wallet.getMoney(mainKey);

        wallet.addMoney(mainKey, addAndRemove);
        wallet.removeMoney(mainKey, addAndRemove);

        Assert.assertEquals(result, wallet.getMoney(mainKey));
    }

    @Test
    public void getMoneyNotEmpty() throws Exception{
        int result = 500;
        wallet.addMoney("RES", 500);

        Assert.assertEquals(500, wallet.getMoney("RES"));
    }

    @Test
    public void getMoneyEmpty() throws Exception{
        Assert.assertEquals(0, wallet.getMoney("empty"));
    }

    @Test
    public void bankTestConvertEurToRub() throws Exception{
        int convert = bank.convert(1000, "EUR", "RUB");

        Assert.assertEquals(79000, convert);
    }

    @Test
    public void bankTestConvertEurToRubReverseInteger() throws Exception{
        int convert = bank.convert(1000, "RUB", "EUR");

        Assert.assertEquals(13, convert);
    }

    @Test
    public void bankTestConvertEurToRubReverseDouble() throws Exception{
        int convert = bank.convert(233, "RUB", "EUR");

        Assert.assertEquals(3, convert);
    }

    @Test(expected = ValueException.class)
    public void bankTestConvertUnknownCurrency() throws Exception{
        bank.convert(50, "unknown", "unknown");
    }
}

