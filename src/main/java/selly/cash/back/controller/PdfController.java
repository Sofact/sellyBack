package selly.cash.back.controller;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfWriter;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import selly.cash.back.models.entity.Codigos;
import selly.cash.back.models.services.ICodigosService;
import selly.cash.back.models.services.IGeneradorService;
import selly.cash.back.utilities.QrCodeGenerator;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Controller
public class PdfController {

    @Autowired
    private IGeneradorService generadorService;

    @Autowired
    private ICodigosService codigoService;

    @PostMapping("/generate-pdf")
    public void generatePdf(@RequestBody Codigos codigo ,HttpServletResponse response) throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Document document = new Document();
        PdfWriter.getInstance(document, baos);
        document.open();


        String text = "http://locaLhost:4200/auth/loginCliente/" ;
        System.out.println("id en el save code:::"+ codigo.getCodId());
        Long cantidad=codigo.getCodId();
        Codigos cod = null;

        for (int x=0; x<cantidad; x++) {
            codigo.setCodId((long) x);
            codigo.setCodCodigo(generadorService.generar(codigo));
            codigo.setCodUrl(text+codigo.getCodCodigo());
            File f = new File("F:\\ANGULAR\\04-pipesApp\\src\\assets\\images\\"+codigo.getCodCodigo()+".png");
            System.out.println("Esta generando codigos::"+ codigo.getCodCodigo());
            generadorService.generarQR(f, codigo.getCodUrl(), 300, 300);

            cod= codigoService.save(codigo);
        }
        List<String> qrCodeTexts = new ArrayList<>();
        for( int cant=0; cant<cantidad; cant++){
            codigo.setCodId((long) cant);
         //   codigo.setCodCodigo(generadorService.generar(codigo));

            qrCodeTexts.add(text+codigo.getCodCodigo());
        }


        for (String qrCodeText : qrCodeTexts) {
            BufferedImage qrCodeImage = QrCodeGenerator.generateQrCode(qrCodeText, 300, 300);
            Image image = Image.getInstance(qrCodeImage, null);
            document.add(image);
        }

        document.close();
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=\"qr_codes.pdf\"");
        response.getOutputStream().write(baos.toByteArray());
        response.flushBuffer();
    }

}
