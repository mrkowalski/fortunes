package pl.marcinkowalski.fortunes.test;

import org.junit.Test;
import pl.marcinkowalski.fortunes.Fortunes;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.Assert.assertEquals;

public class FortunesTest {

    private String quote(final String systemResourceName) throws URISyntaxException, IOException {
        return new Fortunes(new File(ClassLoader.getSystemResource(systemResourceName).toURI())).getQuote();
    }

    @Test
    public void test01() throws URISyntaxException, IOException {
        assertEquals("tc01", quote("tc01"));
    }

    @Test
    public void test02() throws URISyntaxException, IOException {
        assertEquals("tc02", quote("tc02"));
    }

    @Test
    public void test03() throws URISyntaxException, IOException {
        assertEquals("tc03", quote("tc03"));
    }

    @Test
    public void test04() throws URISyntaxException, IOException {
        assertEquals("", quote("tc04"));
    }

    @Test
    public void test05() throws URISyntaxException, IOException {
        assertEquals("", quote("tc05"));
    }

    @Test
    public void test06() throws URISyntaxException, IOException {
        assertEquals("%%%", quote("tc06"));
    }

    @Test
    public void test07() throws URISyntaxException, IOException {
        assertEquals("%kowalski%", quote("tc07"));
    }

    @Test
    public void test08() throws URISyntaxException, IOException {
        assertEquals("%kowalski%", quote("tc08"));
    }
}
