package br.com.comerciobinario.log;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.PropertyConfigurator;

@WebServlet(value = "/log4j-init", loadOnStartup=1,
	initParams = {
			@WebInitParam(name = "log4j-init-file", 
						  value = "/WEB-INF/classes/br/com/comerciobinario/log/log4j.properties")                
	})
public class Log4jInit extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
    public void init() {
        String prefix = getServletContext().getRealPath("/");
        String file = getInitParameter("log4j-init-file");
        
        if (file != null) {
            PropertyConfigurator.configure(prefix + file);
        }
    }

}
