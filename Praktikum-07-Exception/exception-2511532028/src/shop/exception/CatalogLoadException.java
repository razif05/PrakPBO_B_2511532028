package shop.exception;

public class CatalogLoadException extends ShopException {

    public static final long serialVersionUID = 1L;

    public CatalogLoadException(String message, Throwable cause) {
        super(message, cause);
    }

}
