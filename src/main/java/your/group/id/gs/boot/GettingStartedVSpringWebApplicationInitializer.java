package your.group.id.gs.boot;

import io.vertigo.ui.impl.springmvc.config.AbstractVSpringMvcWebApplicationInitializer;

public class GettingStartedVSpringWebApplicationInitializer extends AbstractVSpringMvcWebApplicationInitializer {

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] { GettingStartedVSpringWebConfig.class };
    }
}
