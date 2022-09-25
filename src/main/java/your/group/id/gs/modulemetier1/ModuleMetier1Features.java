package your.group.id.gs.modulemetier1;

import io.vertigo.datamodel.impl.smarttype.ModelDefinitionProvider;
import io.vertigo.core.node.config.DefinitionProviderConfig;
import io.vertigo.core.node.config.discovery.ModuleDiscoveryFeatures;

public class ModuleMetier1Features extends ModuleDiscoveryFeatures<ModuleMetier1Features> { // nous étendons ModuleDiscoveryFeatures pour activer la découverte automatique

    public ModuleMetier1Features() {
        super("ModuleMetier1"); // Nous donnons un nom signigiant à notre module métier
    }

    @Override
    protected void buildFeatures() {
        super.buildFeatures(); // découverte automatique de tous les composants
        getModuleConfigBuilder()
                .addDefinitionProvider(DefinitionProviderConfig.builder(ModelDefinitionProvider.class)
                        .addDefinitionResource("smarttypes", "your.group.id.gs.GsSmartTypes")
                        .addDefinitionResource("dtobjects", "your.group.id.gs.domain.DtDefinitions") // chargement de notre modèle de donnée

                        .build());

    }

    @Override
    protected String getPackageRoot() {
        return this.getClass().getPackage().getName(); // nous utilisons la localisation de la classe de manisfeste comme racine du module
    }

}