public class MoneyPrinter{

    public void print(String operation, String currency, int amount){
        System.out.println(String.format("Действие: %s\nВалюта: %s\nСумма: %d",
                operation, currency, amount));
    }
}
