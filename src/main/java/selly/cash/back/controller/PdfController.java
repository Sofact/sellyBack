package selly.cash.back.controller;

import com.itextpdf.text.*;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.*;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import selly.cash.back.models.entity.Codigos;
import selly.cash.back.models.entity.Producto;
import selly.cash.back.models.services.ICodigosService;
import selly.cash.back.models.services.IGeneradorService;
import selly.cash.back.models.services.IProductoService;
import selly.cash.back.utilities.QrCodeGenerator;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;


@CrossOrigin(origins= "${myapp.datasource.url}")
@Controller
public class PdfController {

    @Autowired
    private IGeneradorService generadorService;

    @Autowired
    private ICodigosService codigoService;

    @Autowired
    private IProductoService productoService;

    @PostMapping("/generate-pdf")
    public void generatePdf(@RequestBody Codigos codigo ,HttpServletResponse response) throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Document document = new Document();
        PdfWriter.getInstance(document, baos);
        document.setPageSize(new Rectangle(272, 567));
        document.setMargins(5,2,0, 2);
        document.open();



        String text = "https://sellycash.com/auth/loginCliente/" ;
        System.out.println("id en el save code:::"+ codigo.getCodId());
        Long cantidad=codigo.getCodId();
        Codigos cod = null;

        for (int x=0; x<cantidad; x++) {
            codigo.setCodId((long) x);
            //codigo.setCodCodigo(generadorService.generar(codigo));
            codigo.setCodUrl(text+codigo.getCodCodigo());
            File f = new File("F:\\ANGULAR\\04-pipesApp\\src\\assets\\images\\"+codigo.getCodCodigo()+".png");
            System.out.println("Esta generando codigos::"+ codigo.getCodCodigo());
          //  generadorService.generarQR(f, codigo.getCodUrl(), 76, 76);

            cod= codigoService.save(codigo);
        }
        List<String> qrCodeTexts = new ArrayList<>();
        for( int cant=0; cant<cantidad; cant++){
            codigo.setCodId((long) cant);
            codigo.setCodCodigo(generadorService.generar(codigo));

            qrCodeTexts.add(text+codigo.getCodCodigo());
        }

        PdfPTable table = new PdfPTable(6);
        Paragraph paragraph = new Paragraph();
        int contador =1;
        for (String qrCodeText : qrCodeTexts) {

            System.out.println("codigos::"+ qrCodeText);
            BufferedImage qrCodeImage = QrCodeGenerator.generateQrCode(qrCodeText, 76, 76);
            Image image = Image.getInstance(qrCodeImage, null);
            image.setAlignment(4);

            PdfPCell imagen = (new PdfPCell(image));
            imagen.setPaddingRight(22f);
            imagen.setPaddingLeft(10f);

            System.out.println("El codigo::"+codigo.getProId());
            Producto producto = productoService.findById(codigo.getProId());
            System.out.println("El producto::"+producto.getProDescripcion());
            PdfPCell cell = new PdfPCell(new Phrase(producto.getProDescripcion() , new Font(Font.FontFamily.HELVETICA, 8)));
            cell.setRotation(-90);
          //  cell.setPaddingTop(5);
            cell.setPadding(0f);
            cell.setPaddingTop(8);
            cell.setFixedHeight(0f);



            table.setWidthPercentage(100);
            table.setSpacingBefore(15f);
            table.setSpacingAfter(25f);
            table.setHorizontalAlignment(4);

            table.addCell(imagen);
            table.addCell(cell);




         //   PdfPCell cell = new PdfPCell(new Phrase("Texto de ejemplo"));
            // Agregamos el texto rotado -90 grados
            /*
            Graphics2D graphics = qrCodeImage.createGraphics();
            graphics.setColor(Color.BLACK);
            //graphics.setFont(new Font("Arial", Font.NORMAL, 12));
            AffineTransform at = new AffineTransform();
            at.rotate(-Math.PI / 2);
            graphics.setTransform(at);

            graphics.drawString("Coffe Colageno", -170, 10);
            table.addCell(new PdfPCell(graphics));
            graphics.dispose();
*/

        //    paragraph.add(image);
         //  paragraph.setSpacingBefore(30);
        System.out.println("El contador:::"+contador);
            if(contador==3){
                System.out.println("Ingreso al if:::"+contador);
                table.completeRow();
                contador=0;
            }
            contador++;

        }
        table.completeRow();
        document.add(table);

        document.close();
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=\"qr_codes.pdf\"");
        response.getOutputStream().write(baos.toByteArray());
        response.flushBuffer();
    }



}
