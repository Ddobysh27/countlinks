package by.dobysh.countlinks.service;

import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Класс сервис, который необходим для валидации URL
 *
 * @version 1.0
 * @autor Добыш Дмитрий
 */
@Service
public class ValidatorServiceImpl implements ValidatorService {

    //Регулярное выражение проверки URL
    private static final String URL = "^(http?|https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|:;,.]*[-a-zA-Z0-9+&@#/%=~_|]";

    public boolean checkURL(String testURL) {
        Pattern pattern = Pattern.compile(URL);
        Matcher matcher = pattern.matcher(testURL.toLowerCase().trim());
        return matcher.matches();
    }

}
