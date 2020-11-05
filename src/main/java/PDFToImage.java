import org.apache.pdfbox.debugger.ui.ImageUtil;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.pdfbox.tools.imageio.ImageIOUtil;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PDFToImage {
    public static void generateImageFromPDF(String filename, String extension) {
        PDDocument document;
        PDFRenderer pdfRenderer;
        BufferedImage bim;
        int nameCounter = 0;
        try {
            document = PDDocument.load(new File(filename));
            pdfRenderer = new PDFRenderer(document);
            for (int page = 0; page <document.getNumberOfPages(); page++) {
                bim = pdfRenderer.renderImageWithDPI(page, 300, ImageType.RGB);
                ImageIOUtil.writeImage(bim, String.format("D:\\RawPdf\\and" + String.valueOf(nameCounter) + ".jpg", page + 1, extension),300);
                nameCounter++;
            }
            document.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
