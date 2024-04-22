package app.utils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Utils {
    public static int validaLimitesRGB(int banda, int valor) {
        banda += valor;
        if (banda > 255) banda = 255;
        else if (banda < 0) banda = 0;
        return banda;
    }

    public static int validaLimitesRGB(int banda, float valor) {
        float resultado = banda * valor;
        if (resultado > 255) resultado = 255;
        else if (resultado < 0) resultado = 0;
        return (int) resultado;
    }

    public static BufferedImage criarImagemVazia(BufferedImage img) {
        return new BufferedImage(img.getWidth(), img.getHeight(), img.getType());
    }

    public static boolean verificaPixelBordas(int h, int w, int height, int width) {
        return h == 0 || w == 0 || h == height - 1 || w == width - 1;
    }

    public static int[] obterVizinhanca(BufferedImage imagemEntrada, int w, int h) {
        int[] vizinhanca = new int[9];
        int count = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                Color cor = new Color(imagemEntrada.getRGB(w + j, h + i));
                int valorPixel = cor.getRed();
                vizinhanca[count++] = valorPixel;
            }
        }
        return vizinhanca;
    }
}
