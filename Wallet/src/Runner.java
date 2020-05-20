import java.util.Arrays;

public class Runner {
    public static void main(String[] args) throws ValueException {
        Wallet myWallet = new Wallet();
        myWallet.addMoney("RUB", 200);
        myWallet.addMoney("RUB", 200);
        myWallet.addMoney("USD", 20);
        myWallet.removeMoney("RUB", 50);

        System.out.println(myWallet.toString());
        System.out.println(myWallet.getTotalMoney("EUR"));
    }
}
