package com.apress.prospring4.ch4;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.regex.Pattern;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.context.support.GenericXmlApplicationContext;

public class PropertyEditorBean {

    // ByteArray PropertyEditor
    private byte[] bytes;
    // Class editor
    private Class<?> cls;
    // Custom Boolean Editor
    private Boolean trueOrFalse;
    // Custom Collection Editor
    private List<String> stringList;
    // Custom Date Editor
    private Date date;
    // Custom Number Editor
    private Float floatValue;
    // File Editor
    private File file;
    // InputStream Editor
    private InputStream stream;
    // Locale Editor
    private Locale locale;
    // Pattern Editor
    private Pattern pattern;
    // Properties Editor
    private Properties properties;
    // String Trimmer Editor
    private String trimString;
    // URL Editor
    private URL url;

    public void setBytes(byte[] bytes) {
	System.out.println("Adding " + bytes.length + " bytes");
	this.bytes = bytes;
    }

    public void setCls(Class<?> cls) {
	System.out.println("Setting class: " + cls.getName());
	this.cls = cls;
    }

    public void setTrueOrFalse(Boolean trueOrFalse) {
	System.out.println("Setting Boolean: " + trueOrFalse);
	this.trueOrFalse = trueOrFalse;
    }

    public void setStringList(List<String> stringList) {
	System.out.println("Setting string list with size: " + stringList.size());
	this.stringList = stringList;
	for (String string : stringList) {
	    System.out.println("String member: " + string);
	}
    }

    public void setDate(Date date) {
	System.out.println("Setting date: " + date);
	this.date = date;
    }

    public void setFloatValue(Float floatValue) {
	System.out.println("Setting float value: " + floatValue);
	this.floatValue = floatValue;
    }

    public void setFile(File file) {
	System.out.println("Setting file: " + file.getName());
	this.file = file;
    }

    public void setStream(InputStream stream) {
	System.out.println("Setting stream: " + stream);
	this.stream = stream;
    }

    public void setLocale(Locale locale) {
	System.out.println("Setting locale: " + locale.getDisplayName());
	this.locale = locale;
    }

    public void setPattern(Pattern pattern) {
	System.out.println("Setting pattern: " + pattern);
	this.pattern = pattern;
    }

    public void setProperties(Properties properties) {
	System.out.println("Loaded " + properties.size() + " properties");
	this.properties = properties;
    }

    public void setTrimString(String trimString) {
	System.out.println("Setting trim string: " + trimString);
	this.trimString = trimString;
    }

    public void setUrl(URL url) {
	System.out.println("Setting URL: " + url.toExternalForm());
	this.url = url;
    }

    public static class CustomPropertyEditorRegistrar implements PropertyEditorRegistrar {

	@Override
	public void registerCustomEditors(PropertyEditorRegistry registry) {
	    SimpleDateFormat dateFormatter = new SimpleDateFormat("MM/dd/yyyy");
	    registry.registerCustomEditor(Date.class, new CustomDateEditor(dateFormatter, true));
	    registry.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}

    }

    public static void main(String[] args) {
	File file = null;
	try {
	    file = File.createTempFile("test", ".txt");
	    file.deleteOnExit();
	} catch (IOException e) {
	    System.out.println(e.getMessage());
	}

	GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
	ctx.load("classpath:META-INF/spring/app-context-PropertyEditors.xml");
	ctx.refresh();

	PropertyEditorBean bean = (PropertyEditorBean) ctx.getBean("builtInSample");

    }

}
