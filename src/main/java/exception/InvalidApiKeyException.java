package exception;

/**
 * InvalidApiKeyException
 * To be raised when valid api key is not present in config
 */
public class InvalidApiKeyException extends Exception{
    public InvalidApiKeyException() {
        super("A valid API key is needed." +
                "Please check if a valid API key is updated in config.properties file");
    }
}
