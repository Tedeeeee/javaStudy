package src.sec10.chap04;

import src.sec10.chap03.WrongMonbthException;

public class WrongMonthException extends Exception{
    public WrongMonthException(String message) {
        super(message);
    }

    public WrongMonthException(String message, Throwable cause) {
        super(message, cause);
    }
}
