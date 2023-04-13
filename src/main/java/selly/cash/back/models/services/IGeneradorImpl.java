package selly.cash.back.models.services;

import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.springframework.stereotype.Service;
import selly.cash.back.models.entity.Codigos;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class IGeneradorImpl implements IGeneradorService{
    @Override
    public String generar(Codigos codigo) throws NoSuchAlgorithmException {

       String cadena= "";
       String sha3Hex="";
       cadena= codigo.getProId()+ codigo.getCodEstado()+ codigo.getCodFecha();

        final MessageDigest digest = MessageDigest.getInstance("SHA-256");
        final byte[] hashbytes = digest.digest(
                cadena.getBytes(StandardCharsets.UTF_8));
        sha3Hex = (hashbytes.toString());

        System.out.println("EL valor hashh::" + sha3Hex + "...el original..."+cadena);
        return sha3Hex;
    }

    public File generarQR(File file, String text, int h, int w) throws NoSuchAlgorithmException, IOException, WriterException {

        QRCodeWriter writer = new QRCodeWriter();
        BitMatrix matrix = writer.encode(text, com.google.zxing.BarcodeFormat.QR_CODE, w, h);

        BufferedImage image = new BufferedImage(matrix.getWidth(), matrix.getHeight(), BufferedImage.TYPE_INT_RGB);
        image.createGraphics();

        Graphics2D graphics = (Graphics2D) image.getGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, matrix.getWidth(), matrix.getHeight());
        graphics.setColor(Color.BLACK);

        for (int i = 0; i < matrix.getWidth(); i++) {
            for (int j = 0; j < matrix.getHeight(); j++) {
                if (matrix.get(i, j)) {
                    graphics.fillRect(i, j, 1, 1);
                }
            }
        }

        ImageIO.write(image, "png", file);

        return file;
    }
}
