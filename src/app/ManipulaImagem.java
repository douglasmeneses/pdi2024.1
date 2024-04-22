package app;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ManipulaImagem {

    public static void exibirImagem(BufferedImage... imagens) {
        JFrame frame = new JFrame();
        frame.setTitle("Proc. de Imagens");
        frame.getContentPane().setLayout(new FlowLayout());
        for (BufferedImage imagem : imagens) {
            JLabel label = new JLabel(new ImageIcon(imagem));
            frame.getContentPane().add(label);
        }
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static BufferedImage abrirImagem(String path) {
        try {
            return ImageIO.read(new File(path));
        } catch (IOException e) {
            System.out.println("Erro ao carregar a imagem");
            throw new RuntimeException(e);
        }
    }

    public static void salvarImagem(BufferedImage imagem, String formato, String path) {
        try {
            ImageIO.write(imagem, formato, new File(path));
        } catch (IOException e) {
            System.out.println("Erro ao salvar a imagem");
            throw new RuntimeException(e);
        }
    }
}
