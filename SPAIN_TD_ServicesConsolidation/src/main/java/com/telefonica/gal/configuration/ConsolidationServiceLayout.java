package com.telefonica.gal.configuration;

import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.apache.logging.log4j.core.layout.AbstractStringLayout;

import java.nio.charset.Charset;

@Plugin(name = "ConsolidationServiceLayout", category = "Core", elementType = "layout", printObject = true)
public class ConsolidationServiceLayout extends AbstractStringLayout {

    private static final String DEFAULT_EOL = "\r\n";

    protected ConsolidationServiceLayout(Charset charset) {
        super(charset);
    }

    @PluginFactory
    public static ConsolidationServiceLayout createLayout(@PluginAttribute(value = "charset", defaultString = "UTF-8") Charset charset) {
        return new ConsolidationServiceLayout(charset);
    }

    @Override
    public String toSerializable(LogEvent logEvent) {
        return null;
    }
}
