package util.test;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import util.Config;

public class TestConfig {

	@BeforeClass
	public static void initClass() {
	}

	@Before
	public void initMethod() {
	}

	@Test
	public void testConfigReadValue() {
		Config.readValue(null, "INFO_OUTPUT_DEGREE");
	}
	
	@Test
	public void testConfigReadAllValues(){
		HashMap<String, String> configMap = Config.readProperties(null);
		Iterator<?> iter = configMap.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry<String, String> entry = (Map.Entry<String, String>) iter.next();
			String key = entry.getKey();
			String value = entry.getValue();
			System.out.println(key + "," + value);
		}
	}
	
	@Test
	public void testConfigWriteValue(){
		Config.writeValue(null, "SHOW_INFO_FLAG", "1");
	}
}
