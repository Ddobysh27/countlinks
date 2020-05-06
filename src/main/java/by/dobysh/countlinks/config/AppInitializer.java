package by.dobysh.countlinks.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Класс регистрации конфигурации в контексте Spring
 * @version 1.0
 * @autor Добыш Дмитрий
 */
public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{};
    }

    /**
     * Помещаем веб-конфигурации где определяются ViewResolver в getServletConfigClasses()
     *
     */
    @Override
        protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }


}
