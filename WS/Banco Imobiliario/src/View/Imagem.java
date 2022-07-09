package View;

import java.awt.*;
import java.io.*;
import java.util.HashMap;
import javax.imageio.ImageIO;

public class Imagem {
	private static final HashMap<String, Image> hash = new HashMap<>();
	private static final String path = "src/View/img/";
	
	/**
	 * Carrega todas as imagens e passa elas para um hashMap
	 */
	public static void carregar() {
		String s;
		try {
			hash.put("icon_menu", ImageIO.read(new File(path+"icon_menu.png")));
			hash.put("tabuleiro", ImageIO.read(new File(path+"tabuleiro.png")));
			
			hash.put("casa1", ImageIO.read(new File(path+"casa1.png")));
			hash.put("casa3", ImageIO.read(new File(path+"casa3.png")));
			hash.put("casa4", ImageIO.read(new File(path+"casa4.png")));
			hash.put("casa5", ImageIO.read(new File(path+"casa5.png")));
			hash.put("casa6", ImageIO.read(new File(path+"casa6.png")));
			hash.put("casa7", ImageIO.read(new File(path+"casa7.png")));
			hash.put("casa8", ImageIO.read(new File(path+"casa8.png")));
			hash.put("casa9", ImageIO.read(new File(path+"casa9.png")));
			hash.put("casa11", ImageIO.read(new File(path+"casa11.png")));
			hash.put("casa13", ImageIO.read(new File(path+"casa13.png")));
			hash.put("casa14", ImageIO.read(new File(path+"casa14.png")));
			hash.put("casa15", ImageIO.read(new File(path+"casa15.png")));
			hash.put("casa17", ImageIO.read(new File(path+"casa17.png")));
			hash.put("casa19", ImageIO.read(new File(path+"casa19.png")));
			hash.put("casa21", ImageIO.read(new File(path+"casa21.png")));
			hash.put("casa23", ImageIO.read(new File(path+"casa23.png")));
			hash.put("casa25", ImageIO.read(new File(path+"casa25.png")));
			hash.put("casa26", ImageIO.read(new File(path+"casa26.png")));
			hash.put("casa28", ImageIO.read(new File(path+"casa28.png")));
			hash.put("casa29", ImageIO.read(new File(path+"casa29.png")));
			hash.put("casa31", ImageIO.read(new File(path+"casa31.png")));
			hash.put("casa32", ImageIO.read(new File(path+"casa32.png")));
			hash.put("casa33", ImageIO.read(new File(path+"casa33.png")));
			hash.put("casa34", ImageIO.read(new File(path+"casa34.png")));
			hash.put("casa35", ImageIO.read(new File(path+"casa35.png")));
			hash.put("casa36", ImageIO.read(new File(path+"casa36.png")));
			hash.put("casa38", ImageIO.read(new File(path+"casa38.png")));
			hash.put("casa39", ImageIO.read(new File(path+"casa39.png")));
			
			for (int i=1; i<=6; i++) {
				s = String.valueOf(i);
				hash.put("dice" + s, ImageIO.read(new File(path+"dice" + s + ".png")));
				hash.put("pin" + s, ImageIO.read(new File(path+"pin" + s + ".png")));
				hash.put("chance" + s, ImageIO.read(new File(path+"chance" + s + ".png")));
			}
			
			for (int i=7; i<=30; i++) {
				s = String.valueOf(i);
				hash.put("chance" + s, ImageIO.read(new File(path+"chance" + s + ".png")));
			}
			
		}
		catch (IOException e) {
			System.out.println("Erro ao carregar as imagens do Banco Imobiliário -> " + e.toString());
			System.exit(-1);
		}
	}
	
	static Image get (String s) { return hash.get(s); }
}
