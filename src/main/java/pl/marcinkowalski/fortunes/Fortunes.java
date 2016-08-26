package pl.marcinkowalski.fortunes;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URISyntaxException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Random;

public class Fortunes {

    private final File fortunesFile;
    private final static String defaultFortuneCookie = "Those who can, do; those who can't, simulate.";

    public Fortunes(final File fortunesFile) {
        this.fortunesFile = fortunesFile;
    }

    public Fortunes(final String fortunesPath) {
        this.fortunesFile = new File(fortunesPath);
    }

    public static void main(String[] args) throws IOException, URISyntaxException {
        System.out.println(new Fortunes(new File("data/fortunes")).getQuote());
    }

    public String getQuote() throws IOException {
        final FileChannel fc = new RandomAccessFile(fortunesFile, "r").getChannel();
        if (fc.size() > Integer.MAX_VALUE) {
            return defaultFortuneCookie;
        } else {
            final int size = (int) fc.size();
            if (size == 0) return "";
            return new Random().ints(1, 0, (int) fc.size()).boxed().findFirst().map(i -> {
                try {
                    return getQuote(fc.map(FileChannel.MapMode.READ_ONLY, 0, size), i, size);
                } catch (IOException e) {
                    return defaultFortuneCookie;
                }
            }).orElse(defaultFortuneCookie);
        }
    }

    private String getQuote(final MappedByteBuffer map, final int randomPosition, final int len) {

        int start = randomPosition;
        while (start > 0 && ((char) map.get(start)) != '%') start--;
        if (start > 0 || map.get(start) == '%') start++;
        int end = start + 1;
        while (end < len && ((char) map.get(end)) != '%') end++;
        if (end > len) end = len;
        if (map.get(end) == '%') end--;
        byte[] data = new byte[end - start];
        map.position(start);
        map.get(data);

        return new String(data).trim();
    }
}