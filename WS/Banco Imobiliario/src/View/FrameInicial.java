package View;

import javax.swing.*;
import Controller.Controller;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class FrameInicial extends JFrame implements ActionListener{ 
	final int ALTURA = 250;
	final int COMPRIMENTO = 250;
	final int ESPACO = 20;
	private int nJogadores = 2;
	private JLabel welcome, load_error;
    private JButton botaoNovaPartida, botaoCarregarPartida;
    private String[] selecaoJogadores;
    private JComboBox<String> comboQuantidadeJogadores;
    private Dimension gap;
    Color corPadrao = new Color(51, 185, 222);

	public FrameInicial() {
		
		// Confugurações iniciais
		setTitle("MENU");
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();
		int x = (screenSize.width - COMPRIMENTO) / 2;
		int y = (screenSize.height - ALTURA) / 2;
        setBounds(x, y, COMPRIMENTO, ALTURA);    
        ImageIcon icon = new ImageIcon(Imagem.get("icon_menu"));
        setIconImage(icon.getImage());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(corPadrao);
        
        // Inicialização dos componentes Swing
        gap = new Dimension(0,20);
        
        welcome = new JLabel("Seja bem-vindo ao Banco Imobiliário!", SwingConstants.CENTER);
        welcome.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        load_error = new JLabel("Erro ao carregar partida", SwingConstants.CENTER);
        load_error.setForeground(new Color(189, 68, 28));
        load_error.setAlignmentX(Component.CENTER_ALIGNMENT);
        load_error.setVisible(false);
        
        botaoNovaPartida = new JButton("Nova Partida");
        botaoNovaPartida.addActionListener(this);
        botaoNovaPartida.setAlignmentX(Component.CENTER_ALIGNMENT);

        botaoCarregarPartida = new JButton("Carregar Partida");
        botaoCarregarPartida.addActionListener(this);
        botaoCarregarPartida.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        selecaoJogadores = new String[]{"2 jogadores", "3 jogadores", "4 jogadores", "5 jogadores", "6 jogadores"};
        comboQuantidadeJogadores = new JComboBox<>(selecaoJogadores);
        comboQuantidadeJogadores.setMaximumSize(botaoNovaPartida.getPreferredSize());
        comboQuantidadeJogadores.setSelectedIndex(0);
        comboQuantidadeJogadores.addActionListener(this);
        
        // Arranjo dos componentes na tela inicial
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        add(Box.createRigidArea(gap));
        add(welcome);
        add(Box.createRigidArea(gap));
        add(botaoNovaPartida);
        add(comboQuantidadeJogadores);
        add(Box.createRigidArea(gap));
        add(Box.createRigidArea(gap));
        add(botaoCarregarPartida);
        add(load_error);
	}
	
    public void abrir() { setVisible(true); }
    
    public void fechar() { setVisible(false); }
    
    public void exibeErroCarregar() { load_error.setVisible(true); }
    
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();

        if (obj.equals(botaoNovaPartida)) { 
            Controller.getController().iniciarEscolhaNomes(nJogadores);
        } 
        else if (obj.equals(botaoCarregarPartida)) {
        	Controller.getController().carregarPartida();
        } 
        else {  // mudou a quantidade de jogadores
            JComboBox<String> cb = (JComboBox<String>) obj;
            String quantidade = (String)cb.getSelectedItem();
            nJogadores = Integer.parseInt(String.valueOf(quantidade.charAt(0)));
        }
    }
}
