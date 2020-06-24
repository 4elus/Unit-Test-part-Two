// класс ошибки - используется при необходимости
// вывода исключения с определенным сообщением
public class ValueException extends Exception{
    public ValueException(String msg){
        super(msg);
    }
}