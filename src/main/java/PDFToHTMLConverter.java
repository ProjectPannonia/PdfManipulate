import org.apache.pdfbox.pdmodel.PDDocument;
import org.fit.pdfdom.PDFDomTree;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

public class PDFToHTMLConverter {
    public static void generateHTMLFromPDF(String filename) {
        try {
            PDDocument pdf = PDDocument.load(new File(filename));
            Writer output = new PrintWriter("converted.pdf","UTF-8");
            new PDFDomTree().writeText(pdf,output);
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }
}
