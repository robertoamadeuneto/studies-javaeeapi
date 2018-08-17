package br.com.studiesjavaeeapi.api.application.config;

import io.swagger.jaxrs.config.BeanConfig;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

/**
 * Swagger's Bootstrap class.
 *
 * @author Roberto Amadeu Neto
 * @since 16/08/2018
 */
@WebServlet(name = "SwaggerBootstrap", loadOnStartup = 2)
public class SwaggerConfig extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("1.0.0");
        beanConfig.setSchemes(new String[]{"http"});
        beanConfig.setHost("localhost:8080");
        beanConfig.setBasePath("/studies-javaeeapi/api");
        beanConfig.setResourcePackage("br.com.studiesjavaeeapi.api.application.resource");
        beanConfig.setTitle("Studies - JavaEE API");
        beanConfig.setDescription("Studies - JavaEE API: Swagger Documentation");
        beanConfig.setScan(true);
    }
}
