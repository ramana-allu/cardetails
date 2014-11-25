package net.uday.web.config;

import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

import java.util.Locale;

public class JsonViewResolver implements ViewResolver {

    @Override
    public View resolveViewName(String viewName, Locale locale) {
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        view.setPrettyPrint(true);      // Lay the JSON out to be nicely readable
        return view;
    }
}
