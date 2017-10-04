package ca.blackperl;

import java.util.TreeSet;

import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.converters.ArrayConverter;
import org.apache.commons.beanutils.converters.StringConverter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ca.blackperl.BUTest.TreeConverter;

public class BUTest {
	private static final Logger log = LogManager.getLogger(BUTest.class);

	public static class TreeConverter implements Converter {
		private static final Logger log = LogManager.getLogger(TreeConverter.class);

		@Override
		public <T> T convert(Class<T> type, Object value) {
			return null;
		}

	}

	public void testconverter() {
		new TreeConverter();
	}
}
