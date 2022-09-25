package your.group.id.gs.boot;

import org.springframework.context.annotation.ComponentScan;

import io.vertigo.ui.impl.springmvc.config.VSpringWebConfig;

@ComponentScan({"your.group.id.gs.modulemetier1.controllers" })
public class GettingStartedVSpringWebConfig extends VSpringWebConfig {
// nothing basic config is enough

}