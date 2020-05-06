package by.dobysh.countlinks.exception;

import org.springframework.stereotype.Component;
/**
 * Класс пользовательское исключение со свойствами
 * <b>exception</b>, <b>url</b>, <b>timestamp</b> и <b>status</b>.
 * @autor Добыш Дмитрий
 * @version 1.0
 */
@Component
public class CustomException extends Exception {

    /** Поле ошибка*/
    private Exception exception;

    /** Поле веб-адрес*/
    private StringBuffer url;

    /** Поле временная отметка*/
    private String timestamp;

    /** Поле код ответа*/
    private int status;

    /**
     * Конструктор - создание нового объекта
     * @see CustomException#CustomException(Exception, StringBuffer, String, int)
     */
    public CustomException() {
    }

    /**
     * Конструктор - создание нового объекта с определенными значениями
     * @param exception - ошибка
     * @param url - веб-адрес
     * @param timestamp - временная отметка
     * @param status - код ответа
     * @see CustomException#CustomException()
     */
    public CustomException(Exception exception, StringBuffer url, String timestamp, int status) {
        this.exception = exception;
        this.url = url;
        this.timestamp = timestamp;
        this.status = status;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }

    public StringBuffer getUrl() {
        return url;
    }

    public void setUrl(StringBuffer url) {
        this.url = url;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "CustomException{" +
                "exception=" + exception +
                ", url=" + url +
                ", timestamp='" + timestamp + '\'' +
                ", status=" + status +
                '}';
    }

}
