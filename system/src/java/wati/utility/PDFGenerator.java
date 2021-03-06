/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wati.utility;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author thiago
 */
public class PDFGenerator {
    
    public ByteArrayOutputStream generatePDF(String html) {
        ByteArrayOutputStream pdf = new ByteArrayOutputStream();
        try {
            Document document = new Document();
            PdfWriter pdfWriter = PdfWriter.getInstance(document, pdf);
            InputStream is = new ByteArrayInputStream(html.getBytes());
            XMLWorkerHelper.getInstance().parseXHtml(pdfWriter, document, is);
            document.close();
            pdf.close();
        } catch (DocumentException | IOException ex) {
            Logger.getLogger(PDFGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pdf;
    }
    
}
