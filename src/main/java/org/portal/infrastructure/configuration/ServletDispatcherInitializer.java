package org.portal.infrastructure.configuration;

/*import jakarta.servlet.Filter;
import org.portal.infrastructure.configuration.ApplicationConfiguration;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;*/

@SuppressWarnings("unused")
public class ServletDispatcherInitializer /*extends AbstractAnnotationConfigDispatcherServletInitializer*/ {
/*    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class []{ApplicationConfiguration.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }

    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        return new Filter[]{new HiddenHttpMethodFilter(),characterEncodingFilter};
    }*/
}
