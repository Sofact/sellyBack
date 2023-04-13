package selly.cash.back.models.services;

import com.google.zxing.WriterException;
import selly.cash.back.models.entity.Codigos;

import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public interface IGeneradorService {

    public String generar(Codigos codigo) throws NoSuchAlgorithmException;

    public File generarQR(File file, String text, int h, int w) throws NoSuchAlgorithmException, IOException, WriterException;
}
