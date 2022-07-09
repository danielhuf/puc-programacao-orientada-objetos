package View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import Controller.Controller;

public class FrameNomes extends JFrame implements ActionListener {
	final int COMPRIMENTO = 300;
    final int ESPACO = 20;
    final int LARGURA = 30;
    private int ALTURA, nJogadores;
    private boolean godMode;
    private ArrayList<JTextField> campoTexto;
    private JButton botaoIniciarPartida;
    private JCheckBox godModeBox; 
    private Dimension gap, jTextSize;
    private JLabel name_error, id_error;
    Color[] cores = {Color.RED, Color.BLUE, Color.ORANGE, Color.YELLOW, Color.MAGENTA, Color.GRAY};
	Color corPadrao = new Color(51, 185, 222);
	Color corErro = new Color(189, 68, 28);
    
    public FrameNomes(int nJogadores) {
    	
    	this.nJogadores = nJogadores;
    	
    	// Configurações iniciais
    	ALTURA = (LARGURA + ESPACO) * (nJogadores + 2) + 2*ESPACO;
    	setTitle("PRE GAME");
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();
		int x = (screenSize.width - COMPRIMENTO) / 2;
		int y = (screenSize.height - ALTURA) / 2;
        setBounds(x, y, COMPRIMENTO + 30, ALTURA + 30);    
        ImageIcon icon = new ImageIcon(Imagem.get("icon_menu"));
        setIconImage(icon.getImage());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(corPadrao);
        
        // Inicialização dos componentes Swing
        gap = new Dimension(0, ESPACO);
        jTextSize = new Dimension(COMPRIMENTO, LARGURA);
        
        godModeBox = new JCheckBox("Manipular dados do jogo");
        godModeBox.setBackground(corPadrao);
        godModeBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        godModeBox.addActionListener(this);
        
        botaoIniciarPartida = new JButton("Iniciar Partida");
        botaoIniciarPartida.setAlignmentX(Component.CENTER_ALIGNMENT);
        botaoIniciarPartida.addActionListener(this);
        
        name_error = new JLabel("Nomes devem conter 1 a 8 caracteres alfanuméricos", SwingConstants.CENTER);
        name_error.setForeground(corErro);
        name_error.setAlignmentX(Component.CENTER_ALIGNMENT);
        name_error.setVisible(false);
        
        id_error = new JLabel("Nomes dos jogadores devem ser unicos", SwingConstants.CENTER);
        id_error.setForeground(corErro);
        id_error.setAlignmentX(Component.CENTER_ALIGNMENT);
        id_error.setVisible(false);
        
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        
        campoTexto = new ArrayList<>();
        for (int i=0; i<nJogadores; i++) {
        	JTextField j = new JTextField("Player" + (i+1));
        	j.setBackground(cores[i]);
        	j.setAlignmentX(Component.CENTER_ALIGNMENT);
        	j.setMaximumSize(jTextSize);
        	add(Box.createRigidArea(gap));
            add(j);
            campoTexto.add(j);
        }
        
        add(Box.createRigidArea(gap));
        add(godModeBox);
        add(Box.createRigidArea(gap));
        add(botaoIniciarPartida);
        add(name_error);
        add(id_error);
    }
    
    public void abrir() { setVisible(true); }
    
    public void fechar() { setVisible(false); }
    
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        String nome;
        if (obj.equals(botaoIniciarPartida)) {
    		name_error.setVisible(false);
    		id_error.setVisible(false);
    		
        	Set<String> setNomes = new HashSet<String>();  // complexidade O(n)
        	String[] nomes = new String[nJogadores];
        	
        	// Sequência de validação dos nomes dos jogadores
            for (int i = 0; i < nJogadores; i ++) {
            	nome = campoTexto.get(i).getText();
            	if (nome.length() < 1 || nome.length() > 8 || !nome.matches("^[a-zA-Z0-9]*$")) {
            		name_error.setVisible(true);
            		return;
            	}
            	else if (setNomes.contains(nome)) {
            		id_error.setVisible(true);
            		return;
            	}
            	else {
            		setNomes.add(nome);
            		nomes[i] = nome;
            	}
            }
            Controller.getController().iniciarPartida(nomes, godMode);
        }
        else { //check box clicado
        	godMode = !godMode;
        }
    }
}
