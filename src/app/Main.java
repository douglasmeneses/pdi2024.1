package app;

import java.awt.image.BufferedImage;

public class Main {
    public static void main(String[] args) {
        BufferedImage imagem = ManipulaImagem.abrirImagem("menino.png");
        ManipulaImagem.exibirImagem(imagem,
                OperacoesLocais.media(imagem),
                OperacoesLocais.mediana3x3(imagem)
        );

        //ManipulaImagem.salvarImagem(imagem, "jpg", "lena2.jpg");
    }
}

