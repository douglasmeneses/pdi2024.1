package app;


import app.utils.Utils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class OperacoesPontuais {

    public static BufferedImage bandaR(BufferedImage imgEntrada) {
        int width = imgEntrada.getWidth();
        int height = imgEntrada.getHeight();
        BufferedImage imgSaida = Utils.criarImagemVazia(imgEntrada);

        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                Color cor = new Color(imgEntrada.getRGB(w, h));
                Color novaCor = new Color (cor.getRed(), 0 ,0);
                imgSaida.setRGB(w, h, novaCor.getRGB());
            }
        }
        return imgSaida;
    }

    public static BufferedImage bandaG(BufferedImage imgEntrada) {
        int width = imgEntrada.getWidth();
        int height = imgEntrada.getHeight();
        BufferedImage imgSaida = Utils.criarImagemVazia(imgEntrada);

        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                Color cor = new Color(imgEntrada.getRGB(w, h));
                Color novaCor = new Color (0, cor.getGreen() ,0);
                imgSaida.setRGB(w, h, novaCor.getRGB());
            }
        }
        return imgSaida;
    }

    public static BufferedImage bandaB(BufferedImage imgEntrada) {
        int width = imgEntrada.getWidth();
        int height = imgEntrada.getHeight();
        BufferedImage imgSaida = Utils.criarImagemVazia(imgEntrada);

        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                Color cor = new Color(imgEntrada.getRGB(w, h));
                Color novaCor = new Color (0, 0 ,cor.getBlue());
                imgSaida.setRGB(w, h, novaCor.getRGB());
            }
        }
        return imgSaida;
    }

    public static BufferedImage negativo(BufferedImage imgEntrada) {
        int width = imgEntrada.getWidth();
        int height = imgEntrada.getHeight();
        BufferedImage imgSaida = Utils.criarImagemVazia(imgEntrada);

        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                Color cor = new Color(imgEntrada.getRGB(w, h));
                int red = cor.getRed();
                int green = cor.getGreen();
                int blue = cor.getBlue();
                Color novaCor = new Color (255 - red, 255 - green , 255 - blue);
                imgSaida.setRGB(w, h, novaCor.getRGB());
            }
        }
        return imgSaida;
    }

    public static BufferedImage cinzaRed(BufferedImage imgEntrada) {
        int width = imgEntrada.getWidth();
        int height = imgEntrada.getHeight();
        BufferedImage imgSaida = Utils.criarImagemVazia(imgEntrada);

        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                Color cor = new Color(imgEntrada.getRGB(w, h));
                int red = cor.getRed();
                Color novaCor = new Color (red, red, red);
                imgSaida.setRGB(w, h, novaCor.getRGB());
            }
        }
        return imgSaida;
    }

    public static BufferedImage cinzaGreen(BufferedImage imgEntrada) {
        int width = imgEntrada.getWidth();
        int height = imgEntrada.getHeight();
        BufferedImage imgSaida = Utils.criarImagemVazia(imgEntrada);

        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                Color cor = new Color(imgEntrada.getRGB(w, h));
                int green = cor.getGreen();
                Color novaCor = new Color (green, green, green);
                imgSaida.setRGB(w, h, novaCor.getRGB());
            }
        }
        return imgSaida;
    }

    public static BufferedImage cinzaBlue(BufferedImage imgEntrada) {
        int width = imgEntrada.getWidth();
        int height = imgEntrada.getHeight();
        BufferedImage imgSaida = Utils.criarImagemVazia(imgEntrada);

        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                Color cor = new Color(imgEntrada.getRGB(w, h));
                int blue = cor.getBlue();
                Color novaCor = new Color (blue, blue, blue);
                imgSaida.setRGB(w, h, novaCor.getRGB());
            }
        }
        return imgSaida;
    }

    public static BufferedImage cinzaMedia(BufferedImage imgEntrada) {
        int width = imgEntrada.getWidth();
        int height = imgEntrada.getHeight();
        BufferedImage imgSaida = Utils.criarImagemVazia(imgEntrada);

        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                Color cor = new Color(imgEntrada.getRGB(w, h));
                int red = cor.getRed();
                int green = cor.getGreen();
                int blue = cor.getBlue();
                int media = (red + green + blue) / 3;
                Color novaCor = new Color(media, media, media);
                imgSaida.setRGB(w, h, novaCor.getRGB());
            }
        }
        return imgSaida;
    }

    public static BufferedImage binarizacao(BufferedImage imgEntrada, int limiar) {
        //calistenia ==> early return
        if (limiar < 1 || limiar > 254)
            throw new IllegalArgumentException("Limiar inválido. Deve ser entre 1 e 254.");

        int width = imgEntrada.getWidth();
        int height = imgEntrada.getHeight();
        BufferedImage imgSaida = Utils.criarImagemVazia(imgEntrada);

        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                Color cor = new Color(imgEntrada.getRGB(w, h));
                int red = cor.getRed();
                int green = cor.getGreen();
                int blue = cor.getBlue();
                int media = (red + green + blue) / 3;
                int novoValor = media > limiar ? 255 : 0;
                Color novaCor = new Color(novoValor, novoValor, novoValor);
                imgSaida.setRGB(w, h, novaCor.getRGB());
            }
        }
        return imgSaida;
    }

    public static BufferedImage alteracaoTonalidade(BufferedImage imgEntrada, String banda, int valor) {
        if (!banda.equalsIgnoreCase("red")
        && !banda.equalsIgnoreCase("green")
        && !banda.equalsIgnoreCase("blue"))
            throw new IllegalArgumentException("Banda inválida. Deve ser red, green ou blue.");

        int width = imgEntrada.getWidth();
        int height = imgEntrada.getHeight();
        BufferedImage imgSaida = Utils.criarImagemVazia(imgEntrada);

        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                Color cor = new Color(imgEntrada.getRGB(w, h));
                int red = cor.getRed();
                int green = cor.getGreen();
                int blue = cor.getBlue();
                if (banda.equalsIgnoreCase("red"))
                    red = Utils.validaLimitesRGB(red, valor);
                 else if (banda.equalsIgnoreCase("green"))
                    green = Utils.validaLimitesRGB(green, valor);
                else
                    blue = Utils.validaLimitesRGB(blue, valor);

                Color novaCor = new Color(red, green, blue);
                imgSaida.setRGB(w, h, novaCor.getRGB());
            }
        }
        return imgSaida;
    }

    public static BufferedImage brilhoAdd(BufferedImage imgEntrada, int valor) {
        int width = imgEntrada.getWidth();
        int height = imgEntrada.getHeight();
        BufferedImage imgSaida = Utils.criarImagemVazia(imgEntrada);

        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                Color cor = new Color(imgEntrada.getRGB(w, h));
                int red = cor.getRed();
                int green = cor.getGreen();
                int blue = cor.getBlue();

                red = Utils.validaLimitesRGB(red, valor);
                green = Utils.validaLimitesRGB(green, valor);
                blue = Utils.validaLimitesRGB(blue, valor);

                Color novaCor = new Color(red, green, blue);
                imgSaida.setRGB(w, h, novaCor.getRGB());
            }
        }
        return imgSaida;
    }

    public static BufferedImage brilhoMtt(BufferedImage imgEntrada, float valor) {
        int width = imgEntrada.getWidth();
        int height = imgEntrada.getHeight();
        BufferedImage imgSaida = Utils.criarImagemVazia(imgEntrada);

        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                Color cor = new Color(imgEntrada.getRGB(w, h));
                int red = cor.getRed();
                int green = cor.getGreen();
                int blue = cor.getBlue();

                red = Utils.validaLimitesRGB(red, valor);
                green = Utils.validaLimitesRGB(green, valor);
                blue = Utils.validaLimitesRGB(blue, valor);

                Color novaCor = new Color(red, green, blue);
                imgSaida.setRGB(w, h, novaCor.getRGB());
            }
        }
        return imgSaida;
    }

   
}
