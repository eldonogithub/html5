package ca.blackperl.apps;

import java.net.URL;
import java.net.URLClassLoader;

public class ClasspathApp {

    public static void main(String[] args) {
        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        while (cl != null) {
            URL[] urls = ((URLClassLoader) cl).getURLs();
            for (URL url : urls) {
                System.out.println(url.getFile());
            }
            cl = cl.getParent();
        }
    }

}
