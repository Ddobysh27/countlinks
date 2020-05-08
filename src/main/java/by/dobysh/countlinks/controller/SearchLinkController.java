package by.dobysh.countlinks.controller;

import by.dobysh.countlinks.exception.CustomException;
import by.dobysh.countlinks.model.Link;
import by.dobysh.countlinks.service.FindLinkService;
import by.dobysh.countlinks.service.ValidatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;

/**
 * Класс контроллер, который будет обрабатывать запросы
 * Сопоставляет URL-адреса непосредственно с представлениями
 * @version 1.0
 * @autor Добыш Дмитрий
 */
@Controller
public class SearchLinkController {


    /** Сервис поиска ссылок*/
    private FindLinkService findLinkService;

    @Autowired
    public void setCarService(FindLinkService findLinkService) {
        this.findLinkService = findLinkService;
    }

    /** Сервис проверки URL*/
    private ValidatorService validatorService;

    @Autowired
    public void setValidatorService(ValidatorService validatorService) {
        this.validatorService = validatorService;
    }

    /**
     * Настраивает модель и представление для домашней страницы
     *
     * @return модель и представление
     */
    @GetMapping(value = "/")
    public ModelAndView homePage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("link", new Link());
        modelAndView.addObject("foundLinksList", null);
        modelAndView.setViewName("links");
        return modelAndView;
    }

    /**
     * Обращается к сервису для сотставления списка всех ссылок
     * в том случае, когда введённые данные валидны.
     * Иначе добавляем в модель сообщения с ошибкой
     *
     * @param link ссылка
     * @param modelAndView модель и представление
     * @return модель и представление с информацией о найденных ссылках
     * @throws IOException
     */
    @PostMapping(value = "/", params = "analyze")
    public ModelAndView searchById(@ModelAttribute("link") Link link, ModelAndView modelAndView) throws IOException {
        if (validatorService.checkURL(link.getAddress())) {
            modelAndView.addObject("foundLinksList", findLinkService.getLinks(link.getAddress()));
        } else {
            modelAndView.addObject("incorrectInputInfo", "Проверьте вводимые данные");
//            modelAndView.addObject("foundLinksList", findLinkService.getLinks(link.getAddress()));
        }
        modelAndView.setViewName("links");
        return modelAndView;
    }

    /**
     * Очищает список найденных ссылок
     *
     * @param link ссылка
     * @return модель и представление с информацией о найденных ссылках
     */
    @PostMapping(value = "/", params = "clean")
    public ModelAndView cleanFoundLinks(@ModelAttribute("link") Link link) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("foundLinksList", null);
        modelAndView.setViewName("links");
        return modelAndView;
    }

    /**
     * Настраивает модель, добавляет полезную информацию и возвращает представление «error»
     *
     * @param req - текущий HTTP-запрос.
     * @param exception - исключение
     * @return Модель и представление, используемые DispatcherServlet для генерации вывода
     */
    @ExceptionHandler(Exception.class)
    public ModelAndView handleError(HttpServletRequest req, Exception exception) {

        CustomException customException = new CustomException();
        customException.setException(exception);
        customException.setUrl(req.getRequestURL());
        customException.setTimestamp(new Date().toString());
        customException.setStatus(500);

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("customException", customException);

        modelAndView.setViewName("error");
        return modelAndView;
    }


}
