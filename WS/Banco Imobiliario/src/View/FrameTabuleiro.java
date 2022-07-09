package View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Collections;
import javax.swing.*;

import Controller.Controller;
import Controller.Observer.*;

public class FrameTabuleiro extends JFrame implements ActionListener, ObservadorAPI {
	private Controller controller;
	private Image tabuleiro, imagemDados[], pino[];
	private String[] nomes;
	private int nJogadores, jogadorDaVez, casaDaVez, dadosDaVez[], saldoJogadores[], posJogadores[];
	final int ALTURA = 700;
	final int COMPRIMENTO = 1200;
	final int N_DADOS = 6;
	final int N_PINOS = 6;
	Color[] cores = {Color.RED, Color.BLUE, Color.ORANGE, Color.YELLOW, Color.MAGENTA, Color.GRAY};
	Color corPadrao = new Color(51, 185, 222);
	Color corBox = new Color(223, 239, 245);
	
	String[] notificacoes = {"-", "-", "-", "-", "-", "-", "-", "-", "-", "-"};
	String[] selecaoDados = {"1", "2", "3", "4", "5", "6"};
	String[] descricaoDaVez = {""};
	
	private JButton botaoLancarDado = createButton("Lançar Dados", 690, 150, 170, 30);
	private JButton botaoEncerrarJogo = createButton("Encerrar Partida", 950, 575, 170, 30);
	private JButton botaoSalvarJogo = createButton("Salvar Partida", 950, 540, 170, 30);
	
	private JComboBox<String> comboDado1 = createCombo(selecaoDados, 710, 185);
	private JComboBox<String> comboDado2 = createCombo(selecaoDados, 790, 185);
	private JComboBox<String> comboPropriedades;
	
	public FrameTabuleiro(boolean godMode, String[] selecaoPropriedades, int nJogadores, String[] nomes, int[] saldoJogadores, int[] posJogadores, int jogadorDaVez) {
		this.controller = Controller.getController();
		this.jogadorDaVez = jogadorDaVez;
		this.nJogadores = nJogadores;
		this.nomes = nomes;
		this.saldoJogadores = saldoJogadores;
		this.posJogadores = posJogadores;
    	tabuleiro = Imagem.get("tabuleiro");
    	dadosDaVez = new int[]{1,1};
    	
    	pino = new Image[N_PINOS];
		for (int i=0; i<N_PINOS; i++) {
			pino[i] = Imagem.get("pin" + String.valueOf(i+1));
		}
    	
		imagemDados = new Image[N_DADOS];
    	for (int i=0; i<N_DADOS; i++) {
    		imagemDados[i] = Imagem.get("dice" + String.valueOf(i+1));
    	}
    	    	
    	setLayout(null);
    	setTitle("Banco Imobiliário");
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();
		int x = (screenSize.width - COMPRIMENTO) / 2;
		int y = (screenSize.height - ALTURA) / 2;
        setBounds(x, y, COMPRIMENTO, ALTURA);
        ImageIcon icon = new ImageIcon(Imagem.get("icon_menu"));
        setIconImage(icon.getImage());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(corPadrao);
    	
    	if (!godMode) {
    		comboDado1.setVisible(false);
    		comboDado2.setVisible(false);
    	}
    	
    	comboPropriedades = createCombo(selecaoPropriedades, 685, 350);
    	
    	this.add(botaoLancarDado);
    	this.add(botaoEncerrarJogo);
    	this.add(botaoSalvarJogo);
    	this.add(comboDado1);
    	this.add(comboDado2);
    	this.add(comboPropriedades);
	}
	
	public void paint(Graphics gr) {
		super.paint(gr);
		Graphics2D g = (Graphics2D) gr; 
		g.drawImage(tabuleiro, 20, 40, 620, 620, this);
		
		g.setFont(g.getFont().deriveFont(g.getFont().getSize() * 1.6F)); 
		g.drawString("Vez de " + nomes[jogadorDaVez], 715, 60);
		g.drawString("Notificações", 990, 60);
		g.drawString("Ver propriedades", 710, 367);
		g.drawString("Saldos", 1015, 330);
		
		g.setColor(cores[jogadorDaVez]);
		g.fillRect(685, 70, 190, 100);
		
		g.setColor(corBox);
		g.fillRect(920, 70, 250, 230);
		g.fillRect(920, 340, 250, 35*nJogadores);
		
		g.drawImage(imagemDados[dadosDaVez[0]-1], 695, 80, 80, 80, this);
		g.drawImage(imagemDados[dadosDaVez[1]-1], 785, 80, 80, 80, this);
		g.drawImage(Imagem.get("casa" + Integer.toString(casaDaVez)), 715, 420, 132, 150, this);
		
		g.setFont(g.getFont().deriveFont(g.getFont().getSize() * 1F)); 
		for (int i=0; i<nJogadores; i++) {
			g.setColor(cores[i]);
			g.drawString(nomes[i] + ": $" + Integer.toString(saldoJogadores[i]), 930, 340 + (i+1)*30);
		}
		
		g.setColor(Color.BLACK);
		g.setFont(g.getFont().deriveFont(g.getFont().getSize() * 0.65F)); 
		for (int i=(notificacoes.length)-1; i>=0; i--) {
			g.drawString(notificacoes[i], 930, 70 + ((notificacoes.length)-i)*22);
		}
		
		for (int i=0; i<descricaoDaVez.length; i++) {
			if (i==1 && !descricaoDaVez[i].equals("Titular: sem titular")) {  // mudar para a cor do jogador titular
				for (int j=0; j<nJogadores; j++) {
					if (("Titular: " + nomes[j]).equals(descricaoDaVez[i])) {
						g.setColor(cores[j]);
						break;
					}
				}
			}
			g.drawString(descricaoDaVez[i], 735, 590 + i*20);
			g.setColor(Color.BLACK);
		}
		for (int i=0; i<nJogadores; i++) {
			g.drawImage(pino[i], Coordenada.getX(posJogadores[i], i), Coordenada.getY(posJogadores[i], i), 15, 22, this);
		}
	}
	
    public void abrir() {
        setVisible(true);
    }
    
    public void fechar() {
        setVisible(false);
    }
	
    public void actionPerformed(ActionEvent e) {
    	Object obj = e.getSource();
    	
        if (obj.equals(comboPropriedades)) {
        	String p = (String)(((JComboBox<String>)obj).getSelectedItem());
        	casaDaVez = controller.getPosCasa(p);
        	descricaoDaVez = controller.getDescricao(casaDaVez);
        } 
        
        else if (obj.equals(botaoLancarDado)) {
        	controller.rolarDados(jogadorDaVez);
        }
        
        else if (obj.equals(botaoSalvarJogo)) {
        	controller.salvarPartida();
        }
        
        else if (obj.equals(botaoEncerrarJogo)) {
        	encerraJogo(controller.reunePatrimonios());
        }
        
        else if (obj.equals(comboDado1)) {
        	dadosDaVez[0] = Integer.parseInt((String) comboDado1.getSelectedItem());
        }
        
        else if (obj.equals(comboDado2)) {
        	dadosDaVez[1] = Integer.parseInt((String) comboDado2.getSelectedItem());
        }
        
        repaint();
    }
    
    public void atualiza(String evento) {
    	switch(evento) {
    		case "novoValorDados":
    			dadosDaVez = controller.getDados();
    			break;
    			
    		case "usouSaidaLivre":
    			addNotificacao(nomes[jogadorDaVez] + " utilizou a Saída Livre!");
    			break;
    			
    		case "sucessoCompra":
    			addNotificacao("Compra efetuada com sucesso!");
    			descricaoDaVez = controller.getDescricao(casaDaVez);
    			break;
    			
    		case "falhaCompra":
    			addNotificacao("Compra não efetuada: saldo insuficiente");
    			break;
    			
    		case "sucessoVenda":
    			addNotificacao("Venda efetuada com sucesso!");
    			descricaoDaVez = controller.getDescricao(casaDaVez);
    			break;
    			
    		case "prisao":
    			addNotificacao(nomes[jogadorDaVez] + " foi para a prisão");
    			break;
    			
    		case "propriedadeComDono":
    			addNotificacao("Propriedade com dono. Pague o aluguel");
    			break;
    			
    		case "falencia":
    			addNotificacao("Jogador foi à falência");
    			break;
    			
    		case "fimDoJogo":
    			encerraJogo(controller.reunePatrimonios());
    			break;
    	}
    	repaint();
    }
    
    public void atualiza(String evento, String s, int q1, int q2)  {
    	switch(evento) {
    		case "novoSaldoJogador":
    			for (int i=0; i<nJogadores; i++) {
    				if (nomes[i].equals(s)) {
    					saldoJogadores[i] = q2;
    					break;
    				}
    			}
    			addNotificacao("Saldo de " + s + ": $" + Integer.toString(q1) + " -> $" + Integer.toString(q2));
    			break;
    		case "novaPosJogador":
    			posJogadores[jogadorDaVez] = q1;
				comboPropriedades.setSelectedItem(s);
    			break;
    	}
    	repaint();
    }
    
    public void atualiza(String evento, int n) {
    	switch(evento) {
			case "passouVez":
				jogadorDaVez = n;
				break;
				
	    	case "sorteReves":
	    		ImageIcon icon_carta = new ImageIcon(Imagem.get("chance" + Integer.toString(n)));
	    		JOptionPane.showMessageDialog(this, new JLabel(icon_carta, JLabel.CENTER), "Sorte ou Reves selecionado", JOptionPane.INFORMATION_MESSAGE);
	    		break;
	    	}
    }
    
    public int[] getValorDados() {
    	return new int[] {Integer.parseInt((String) comboDado1.getSelectedItem()), Integer.parseInt((String) comboDado2.getSelectedItem())};
    }
    
	public void encerraJogo(int[] patrimonios) {
		String ordenado[] = new String[nJogadores];
		for (int i=0; i<nJogadores; i++) {
			ordenado[i] = ("$" + Integer.toString(patrimonios[i]) + "#" + nomes[i]);
		}
		Arrays.sort(ordenado, Collections.reverseOrder());
		
		String msg = "Posição dos jogadores:\n";
		for (int i=0; i<nJogadores; i++) {
			msg += Integer.toString(i+1) + " - " + ordenado[i].split("#")[1] + ": (" + ordenado[i].split("#")[0] + ")\n";
		}
		msg += "\n";
		JOptionPane.showMessageDialog(this, msg, "PARTIDA ENCERRADA", JOptionPane.INFORMATION_MESSAGE);
		System.exit(0);
	}
    
    private void addNotificacao(String msg) {
    	for (int i=(notificacoes.length)-1; i>=1; i--) {
    		notificacoes[i] = notificacoes[i-1];
    	}
    	notificacoes[0] = "- " + msg;
    }
    
	private JButton createButton(String name, int x, int y, int comp, int alt) {
		JButton b = new JButton(name);
		b.setBounds(x, y, comp, alt);
		b.addActionListener(this);
		return b;
	}
	
	private JComboBox<String> createCombo(String[] selecao, int x, int y) {
		JComboBox<String> c = new JComboBox<>(selecao);
		c.setBounds(x, y, c.getPreferredSize().width, c.getPreferredSize().height);
		c.addActionListener(this);
		return c;
	}
	
	public int exibeCompraProp(int posCasa) {
		return JOptionPane.showConfirmDialog(this, "A proriedade está à venda. Você deseja comprá-la?", "Propriedade à venda", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	}
	
	public int exibeDonoProp(int posCasa, boolean podeCasa, boolean podeHotel) {
		String[] opcoes;
		if (podeCasa && podeHotel) {
			opcoes = new String[]{"Não fazer nada", "Vender propriedade", "Comprar casa", "Comprar hotel"};
		}
		else if (podeCasa) {
			opcoes = new String[]{"Não fazer nada", "Vender propriedade", "Comprar casa"};
		}
		else if (podeHotel) {
			opcoes = new String[]{"Não fazer nada", "Vender propriedade", "Comprar hotel"};
		}
		else {  //jogador já possui todas as casas e hoteis desse terreno, ou todas as casas e hoteis do jogo estão sendo utilizadas
			opcoes = new String[]{"Não fazer nada", "Vender propriedade"};
		}
		return JOptionPane.showOptionDialog(this, "Você é o dono dessa propriedade. Escolha o que deseja fazer com ela:", "Titular da propriedade", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
	}
	
	public String exibeVendaForcada(String[] propriedades, String nome) {
		JComboBox<String> selecao = new JComboBox<>(propriedades);
		JOptionPane.showMessageDialog(this, selecao, nome + ": venda uma propriedade", JOptionPane.QUESTION_MESSAGE);
		return (String) selecao.getSelectedItem();
	}
}
