package de.hilling.junit.cdi.microprofile;

import de.hilling.junit.cdi.annotations.GlobalTestImplementation;
import de.hilling.junit.cdi.scope.TestSuiteScoped;
import io.smallrye.config.inject.ConfigProducerUtil;
import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.*;

@TestSuiteScoped
public class TestConfigProducer implements Serializable {

    @Inject
    private Config config;

    @GlobalTestImplementation
    @Dependent
    @Produces
    @ConfigProperty
    String produceStringConfigProperty(InjectionPoint ip) {
        return ConfigProducerUtil.getValue(ip, String.class, config);
    }

    @GlobalTestImplementation
    @Dependent
    @Produces
    @ConfigProperty
    Long getLongValue(InjectionPoint ip) {
        return ConfigProducerUtil.getValue(ip, Long.class, config);
    }

    @GlobalTestImplementation
    @Dependent
    @Produces
    @ConfigProperty
    Integer getIntegerValue(InjectionPoint ip) {
        return ConfigProducerUtil.getValue(ip, Integer.class, config);
    }

    @GlobalTestImplementation
    @Dependent
    @Produces
    @ConfigProperty
    Float produceFloatConfigProperty(InjectionPoint ip) {
        return ConfigProducerUtil.getValue(ip, Float.class, config);
    }

    @GlobalTestImplementation
    @Dependent
    @Produces
    @ConfigProperty
    Double produceDoubleConfigProperty(InjectionPoint ip) {
        return ConfigProducerUtil.getValue(ip, Double.class, config);
    }

    @GlobalTestImplementation
    @Dependent
    @Produces
    @ConfigProperty
    Boolean produceBooleanConfigProperty(InjectionPoint ip) {
        return ConfigProducerUtil.getValue(ip, Boolean.class, config);
    }

    @GlobalTestImplementation
    @Dependent
    @Produces
    @ConfigProperty
    <T> Optional<T> produceOptionalConfigValue(InjectionPoint injectionPoint) {
        return ConfigProducerUtil.optionalConfigValue(injectionPoint, config);
    }

    @GlobalTestImplementation
    @Dependent
    @Produces
    @ConfigProperty
    <T> Set<T> producesSetConfigPropery(InjectionPoint ip) {
        return ConfigProducerUtil.collectionConfigProperty(ip, config, HashSet::new);
    }

    @GlobalTestImplementation
    @Dependent
    @Produces
    @ConfigProperty
    <T> List<T> producesListConfigPropery(InjectionPoint ip) {
        return ConfigProducerUtil.collectionConfigProperty(ip, config, ArrayList::new);
    }

}
