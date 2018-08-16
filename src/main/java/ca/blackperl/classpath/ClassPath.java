package ca.blackperl.classpath;

import java.net.URL;
import java.net.URLClassLoader;

public class ClassPath {
	public static void main(String[] args) {
		ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();

		ClassLoader classLoader = contextClassLoader;
		while (classLoader != null) {
			@SuppressWarnings("resource")
			URLClassLoader urlClassLoader = (URLClassLoader) classLoader;
			URL[] urLs = urlClassLoader.getURLs();
			System.out.println("ClassLoader:");
			for (URL url : urLs) {
				System.out.println(url);
			}
			System.out.println();
			classLoader = classLoader.getParent();
		}
	}
}
