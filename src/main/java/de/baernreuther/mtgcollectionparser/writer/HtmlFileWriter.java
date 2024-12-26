package de.baernreuther.mtgcollectionparser.writer;

import de.baernreuther.mtgcollectionparser.scryfall.model.card.Card;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

public class HtmlFileWriter implements IFileWriter {

    private static final String INPUT_TEMPLATE = "index.vm";

    @Override
    public void writeFile(List<Card> cards, String filePath) throws FileWriterException {

        VelocityContext velocityContext = new VelocityContext();
        velocityContext.put("cards", cards);
        VelocityEngine velocityEngine = new VelocityEngine();
        velocityEngine.init();

        Template template = velocityEngine.getTemplate(INPUT_TEMPLATE);

        try {
            Writer writer = new FileWriter(filePath + ".html");
            template.merge(velocityContext, writer);
        } catch (IOException e) {
            throw new FileWriterException(e.getMessage(), e);
        }

    }
}
