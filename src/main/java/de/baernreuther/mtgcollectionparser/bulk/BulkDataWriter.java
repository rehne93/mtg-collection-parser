package de.baernreuther.mtgcollectionparser.bulk;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.net.URL;

public class BulkDataWriter {


    public String saveBulkdata(String uri) {

        File f = new File("test.json");

        try {
            URL url = new URL(uri);
            FileUtils.copyURLToFile(url, f);
        } catch (Exception e) {
            System.err.println(e);
        }

        return f.getAbsolutePath();
    }
}
