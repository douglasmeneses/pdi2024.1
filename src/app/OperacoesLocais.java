package app;

import app.utils.Utils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Arrays;

public class OperacoesLocais {
    public static BufferedImage media(BufferedImage imagemEntrada, int tamViz){
        int width = imagemEntrada.getWidth();
        int height = imagemEntrada.getHeight();
        BufferedImage imagemSaida = Utils.criarImagemVazia(imagemEntrada);

        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                if (Utils.verificaPixelBordas(h, w, height, width)) {
                    int rgb = imagemEntrada.getRGB(w,h);
                    imagemSaida.setRGB(w,h,rgb);
                    continue;
                }

                int[] vizinhanca = Utils.obterVizinhanca(imagemEntrada, w, h);
                int media = Arrays.stream(vizinhanca).sum() / 9; //TODO
                Color novaCor = new Color(media, media, media);
                imagemSaida.setRGB(w, h, novaCor.getRGB());
            }
        }
        return imagemSaida;
    }

    public static BufferedImage mediana3x3 (BufferedImage imagemEntrada){
        int width = imagemEntrada.getWidth();
        int height = imagemEntrada.getHeight();
        BufferedImage imagemSaida = Utils.criarImagemVazia(imagemEntrada);

        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                if (Utils.verificaPixelBordas(h, w, height, width)) {
                    int rgb = imagemEntrada.getRGB(w,h);
                    imagemSaida.setRGB(w,h,rgb);
                    continue;
                }

                int[] vizinhanca = Utils.obterVizinhanca(imagemEntrada, w, h);
                Arrays.sort(vizinhanca);
                int mediana = vizinhanca[4]; //TODO

                Color novaCor = new Color(mediana, mediana, mediana);
                imagemSaida.setRGB(w, h, novaCor.getRGB());
            }
        }
        return imagemSaida;
    }


}
