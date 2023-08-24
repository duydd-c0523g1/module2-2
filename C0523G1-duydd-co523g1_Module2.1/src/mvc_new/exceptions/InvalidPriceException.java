package src.mvc_new.exceptions;

import src.mvc_new.utils.Stream;

public class InvalidPriceException extends Exception {
    public InvalidPriceException(String msg) {
        super(msg);
    }
}
