package de.baernreuther.mtgcollectionparser.bulk;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.net.URI;
import java.net.URL;
import java.nio.file.Paths;

public class BulkDataWriter {


    private final static String DEFAULT_FILENAME = "bulk-data-full";

    public String saveBulkdata(String uri) {


        File f = new File(DEFAULT_FILENAME + ".json");

        if (f.exists()) {
            return f.getAbsolutePath();
        }

        try {
            URL url = new URL(uri);
            FileUtils.copyURLToFile(url, f);
        } catch (Exception e) {
            System.err.println(e);
        }

        return f.getAbsolutePath();
    }
}
