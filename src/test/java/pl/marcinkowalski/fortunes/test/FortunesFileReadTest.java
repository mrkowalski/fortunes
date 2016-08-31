package pl.marcinkowalski.fortunes.test;

import org.junit.Test;
import pl.marcinkowalski.fortunes.Fortunes;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class FortunesFileReadTest {

    @Test
    public void missingFortuneFileTest() throws IOException {
        assertEquals(Fortunes.defaultFortuneCookie, new Fortunes("missing-file").getQuote());
    }

    @Test
    public void invalidFortuneFileTest() throws IOException {
        assertEquals(Fortunes.defaultFortuneCookie, new Fortunes(new File(".")).getQuote());
    }

}
