package jogo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

/**
 * @author Francisco de Assis de Souza Rodrigues. 03 de março de 2014.
 */

/**
 * Desenha a interface do jogo, o tabuleiro e nove botoes, sendo que um botão
 * representando um espaço em branco e os demais de 1 à 8 ou A à H. Um jogo de
 * raciocinio logico e que tem o objetivo ordenação de numero ou letras em um
 * tabuleiro.
 */

/* TELA INICIAL *//* ORDENAÇÃO NUMERICA *//* ORDENAÇÃO ALFABETICA */
/* '-----------' *//* '-----------' *//* '-----------' */
/* ' F ' R ' A ' *//* ' 1 ' 2 ' 3 ' *//* ' A ' B ' C ' */
/* ' N ' C ' I ' *//* ' 4 ' 5 ' 6 ' *//* ' D ' E ' F ' */
/* ' S ' C ' O ' *//* ' 7 ' 8 ' 0 ' *//* ' G ' H ' 0 ' */
/* '-----------' *//* '-----------' *//* '-----------' */

public class Jogo extends JFrame {

	private static final long serialVersionUID = 1L;

	/* Content Pane */
	private JPanel contentPane;

	/* Tabuleiro */
	private JPanel tabuleiro;

	/* Objetos da Class JButton */
	private JButton b0;
	private JButton b1;
	private JButton b2;
	private JButton b3;
	private JButton b4;
	private JButton b5;
	private JButton b6;
	private JButton b7;
	private JButton b8;

	/* Variavel usada para Definir o Tamanho Horizontal e Vertical dos Botões */
	private int Horizontal = 100;
	private int Vertical = 100;

	/* Coordenadas */
	private int ZERO = 0;
	private int UM = 102;
	private int DOIS = 204;

	/* Menu Barra */
	private JMenuBar menuBarra;

	/* Menu */
	private JMenu menuNovoJogo;
	private JMenu menuAjuda;

	/* Itens do Menu */
	private JMenuItem itemMenuNovoJogoNumerico;
	private JMenuItem itemMenuNovoJogoAlfabetico;
	private JMenuItem itemMenuSair;
	private JMenuItem itemMenuSobre;

	/* ######(Definições de Fonte)###### */
	// Objeto fonteBotao.
	private Font fonteBotao;
	/* Tipo da Fonte */
	private String fonteFonte = "Arial";
	/* Eestilo da Fonte */
	private int estiloFonte = Font.BOLD;
	/* TamanhoFonte */
	private int tamanhoFonte = 80;

	/* Variaveis Auxiliares para trocar de Posição */
	private int xx, yy, x, y;

	// Variaveis usadas para posicionamento dos botoes no tabuleiro, armezenaram
	// as coordenadas atuais dos Botões */
	private int colunaB0 = 0, linhaB0 = 0;
	private int colunaB1 = 0, linhaB1 = 0;
	private int colunaB2 = 0, linhaB2 = 0;
	private int colunaB3 = 0, linhaB3 = 0;
	private int colunaB4 = 0, linhaB4 = 0;
	private int colunaB5 = 0, linhaB5 = 0;
	private int colunaB6 = 0, linhaB6 = 0;
	private int colunaB7 = 0, linhaB7 = 0;
	private int colunaB8 = 0, linhaB8 = 0;

	/* Variaveis Auxiliar para armazenar os valores gerados pelo random */
	private int colunaAleatorio = 0;
	private int linhaAleatorio = 0;

	/* Contador do Loop */
	private int botao;

	// Instância um Objeto random da class java.leng, para gerar
	// numeros aleatórios.
	Random random = new Random();

	/* Objeto da Class Som.java (Reproduz o quando clica no botão) */
	Som som;

	/**
	 * Método Principal, Inicia o Aplicativo.
	 */
	public static void main(String[] args) {
		try {
			UIManager
					.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// Instâcia de um objeto frame da class Jogo.java
					Jogo frame = new Jogo();

					// Define frame visivel.
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Construtor da Class.
	 */
	public Jogo() {
		/* titulo do Jogo */
		setTitle("Jogo de Raciocinio");

		// Chamada dos métodos.
		CarregarComponetesJanela();
		CarregarBotoes();
		CarregarEventos();
	}

	/**
	 * Método que Cria a estrutura.
	 */
	private void CarregarComponetesJanela() {
		/**
		 * (FONTE).
		 */
		// Instância do Objeto (fonteBotao) e atribue (fonte), (estilo) e
		// (tamanho).
		fonteBotao = new Font(fonteFonte, estiloFonte, tamanhoFonte);

		/**
		 * (JANELA).
		 */
		/* Define que o contentPane não é redimencionavel */
		setResizable(false);
		/* Cor do contentPane */
		setBackground(Color.WHITE);
		/* Função Feixar Janela */
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/* Dimensões do contentPane */
		setBounds(100, 100, 316, 370);
		// Inicializar Janela no Centro da Tela.
		setLocationRelativeTo(null);

		/**
		 * (CONTENT PANE).
		 */
		/* Instância do objeto contentPane */
		contentPane = new JPanel();
		/* Define Cor contentPane */
		contentPane.setBackground(Color.WHITE);
		/* Espaçamento das Bordas da Janela */
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		/* Define as dimenções da BorderLayout do objeto janela */
		contentPane.setLayout(new BorderLayout(0, 0));
		/* Adiciona a janela ao ContentPane */
		setContentPane(contentPane);

		/**
		 * (MENU).
		 */
		/* Instância do objeto menuBarra */
		menuBarra = new JMenuBar();
		contentPane.add(menuBarra, BorderLayout.NORTH);

		/* Instacia Objeto Menu */
		menuNovoJogo = new JMenu("Iniciar");
		/* Instancia do Menu Ajuda */
		menuAjuda = new JMenu("Ajuda");

		/* Adiciona Objeto Menu a Barra de Menu */
		menuBarra.add(menuNovoJogo);
		/* Adiciona Menu Ajuda ao contentPane */
		menuBarra.add(menuAjuda);

		/**
		 * Define Configuração da Fonte
		 */
		menuNovoJogo.setFont(new Font("DejaVu Sans", Font.BOLD, 12));
		menuAjuda.setFont(new Font("DejaVu Sans", Font.BOLD, 12));

		/**
		 * (Define Dica No Menu).
		 */
		menuBarra.setToolTipText("Iniciar Um Novo Jogo");
		/* Adiciona meuBarra ao contentPane */

		/**
		 * (ITENS DO MENU).
		 */
		/* Instacia os Objetos Itens do Menu */
		itemMenuNovoJogoNumerico = new JMenuItem("Jogo Numérico");
		itemMenuNovoJogoAlfabetico = new JMenuItem("Jogo Alfabético");
		itemMenuSair = new JMenuItem("Sair");
		itemMenuSobre = new JMenuItem("Sobre");

		/* Adiciona Objeto Item do Menu ao Menu */
		menuNovoJogo.add(itemMenuNovoJogoNumerico);
		menuNovoJogo.add(itemMenuNovoJogoAlfabetico);
		menuNovoJogo.add(itemMenuSair);
		menuAjuda.add(itemMenuSobre);

		/**
		 * (TABULEIRO).
		 */
		/* Instancia objeto tabuleiro */
		tabuleiro = new JPanel();
		/* Define Cor Para O Tabuleiro */
		tabuleiro.setBackground(Color.WHITE);
		/* Adiciona tabuleiro a janela */
		contentPane.add(tabuleiro, BorderLayout.CENTER);
		/* Define tipo do esbouço (Layout) do tabuleiro */
		tabuleiro.setLayout(null);
	}/* FIM */

	/**
	 * Carrega as Configurações dos BOtões.
	 */
	private void CarregarBotoes() {
		/* Instância os objetos Botões */
		b0 = new JButton();
		b1 = new JButton();
		b2 = new JButton();
		b3 = new JButton();
		b4 = new JButton();
		b5 = new JButton();
		b6 = new JButton();
		b7 = new JButton();
		b8 = new JButton();

		/* Chamda do Método que Atribue (Nome: Francisco) */
		CarregarNome();

		/* Define Coordenadas Inicial */
		b0.setBounds(ZERO, ZERO, Horizontal, Vertical);
		b1.setBounds(UM, ZERO, Horizontal, Vertical);
		b2.setBounds(DOIS, ZERO, Horizontal, Vertical);
		b3.setBounds(ZERO, UM, Horizontal, Vertical);
		b4.setBounds(UM, UM, Horizontal, Vertical);
		b5.setBounds(DOIS, UM, Horizontal, Vertical);
		b6.setBounds(ZERO, DOIS, Horizontal, Vertical);
		b7.setBounds(UM, DOIS, Horizontal, Vertical);
		b8.setBounds(DOIS, DOIS, Horizontal, Vertical);

		/* Adiciona Botões ao Tabuleiro */
		tabuleiro.add(b0);
		tabuleiro.add(b1);
		tabuleiro.add(b2);
		tabuleiro.add(b3);
		tabuleiro.add(b4);
		tabuleiro.add(b5);
		tabuleiro.add(b6);
		tabuleiro.add(b7);
		tabuleiro.add(b8);

		/* Define Fonte dos Botões */
		b0.setFont(fonteBotao);
		b1.setFont(fonteBotao);
		b2.setFont(fonteBotao);
		b3.setFont(fonteBotao);
		b4.setFont(fonteBotao);
		b5.setFont(fonteBotao);
		b6.setFont(fonteBotao);
		b7.setFont(fonteBotao);
		b8.setFont(fonteBotao);

		/* Background dos Botões */
		// b1.setBackground(new Color(230, 230, 250));
		// b2.setBackground(new Color(230, 230, 250));
		// b3.setBackground(new Color(230, 230, 250));
		// b4.setBackground(new Color(230, 230, 250));
		// b5.setBackground(new Color(230, 230, 250));
		// b6.setBackground(new Color(230, 230, 250));
		// b7.setBackground(new Color(230, 230, 250));
		// b8.setBackground(new Color(230, 230, 250));

		/* Foreground do Botões */
		b1.setForeground(Color.BLACK);
		b2.setForeground(Color.BLACK);
		b3.setForeground(Color.BLACK);
		b4.setForeground(Color.BLACK);
		b5.setForeground(Color.BLACK);
		b6.setForeground(Color.BLACK);
		b7.setForeground(Color.BLACK);
		b8.setForeground(Color.BLACK);

		/* Define Cor dos Botões */
		b0.setBackground(Color.WHITE);

		/*
		 * Define Dica, ao passar o cusor do Mouse sobre o Botão (espaço) em
		 * branco
		 */
		b0.setToolTipText("Clique em Um dos Botões para Mover ao Espaço em Branco.");

	}/* FIM */

	/**
	 * Math.abs - Retorna o valor absoluto (módulo) do numero passado por
	 * parametro.
	 */
	private void MathABS() {
		xx = Math.abs(x - b0.getX());
		yy = Math.abs(y - b0.getY());
	}/* FIM */

	/**
	 * Eventos de todos os Botões.
	 */
	private void CarregarEventos() {
		itemMenuNovoJogoNumerico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/* Chama Método Carregar Numeros */
				CarregarNumeros();

				// Chama o Metodo que distribue os botões de forma aleatoria.
				DistribuirBotoes();
			}
		});
		itemMenuNovoJogoAlfabetico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/* Chama Método Carregar Alfabeto */
				CarregarAlfabeto();

				// Chama o Metodo que distribue os botões de forma aleatoria.
				DistribuirBotoes();
			}
		});
		itemMenuSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/* Fechar o Sistema */
				System.exit(0);
			}
		});
		itemMenuSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane
						.showMessageDialog(
								null,
								"Desenvolvido por:\nFrancisco de Assis de Souza Rodrigues\n05 de Março de 2014.");
			}
		});
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				/* Captura as Coordenadas Atual */
				x = b1.getX();
				y = b1.getY();

				/* Método */
				MathABS();

				/* Condição para Troca de Posições */
				if (xx <= 102 && yy <= 102 && xx != yy) {

					/* Define Nova Coordenada */
					b1.setBounds(colunaB1 = b0.getX(), linhaB1 = b0.getY(),
							Horizontal, Vertical);

					/* Define Nova Coordenada */
					b0.setBounds(colunaB0 = x, linhaB0 = y, Horizontal,
							Vertical);

					/* Reproduz Som */
					som = new Som();
					som.main(null);

					/* Chamada do método que Verifica a Ordenação */
					VerificarOrdenacao();
				}

			}
		});
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/* Captura as Coordenadas Atual */
				x = b2.getX();
				y = b2.getY();

				/* Método */
				MathABS();

				/* Condição para Troca de Posições */
				if (xx <= 102 && yy <= 102 && xx != yy) {

					/* Define Nova Coordenada */
					b2.setBounds(colunaB2 = b0.getX(), linhaB2 = b0.getY(),
							Horizontal, Vertical);

					/* Define Nova Coordenada */
					b0.setBounds(colunaB0 = x, linhaB0 = y, Horizontal,
							Vertical);

					/* Reproduz Som */
					som = new Som();
					som.main(null);

					/* Chamada do método que Verifica a Ordenação */
					VerificarOrdenacao();
				}
			}
		});
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/* Captura as Coordenadas Atual */
				x = b3.getX();
				y = b3.getY();

				/* Método */
				MathABS();

				/* Condição para Troca de Posições */
				if (xx <= 102 && yy <= 102 && xx != yy) {

					/* Define Nova Coordenada */
					b3.setBounds(colunaB3 = b0.getX(), linhaB3 = b0.getY(),
							Horizontal, Vertical);

					/* Define Nova Coordenada */
					b0.setBounds(colunaB0 = x, linhaB0 = y, Horizontal,
							Vertical);

					/* Reproduz Som */
					som = new Som();
					som.main(null);

					/* Chamada do método que Verifica a Ordenação */
					VerificarOrdenacao();
				}
			}
		});
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/* Captura as Coordenadas Atual */
				x = b4.getX();
				y = b4.getY();

				/* Método */
				MathABS();

				/* Condição para Troca de Posições */
				if (xx <= 102 && yy <= 102 && xx != yy) {

					/* Define Nova Coordenada */
					b4.setBounds(colunaB4 = b0.getX(), linhaB4 = b0.getY(),
							Horizontal, Vertical);

					/* Define Nova Coordenada */
					b0.setBounds(colunaB0 = x, linhaB0 = y, Horizontal,
							Vertical);

					/* Reproduz Som */
					som = new Som();
					som.main(null);

					/* Chamada do método que Verifica a Ordenação */
					VerificarOrdenacao();
				}
			}
		});
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/* Captura as Coordenadas Atual */
				x = b5.getX();
				y = b5.getY();

				/* Método */
				MathABS();

				/* Condição para Troca de Posições */
				if (xx <= 102 && yy <= 102 && xx != yy) {

					/* Define Nova Coordenada */
					b5.setBounds(colunaB5 = b0.getX(), linhaB5 = b0.getY(),
							Horizontal, Vertical);

					/* Define Nova Coordenada */
					b0.setBounds(colunaB0 = x, linhaB0 = y, Horizontal,
							Vertical);

					/* Reproduz Som */
					som = new Som();
					som.main(null);

					/* Chamada do método que Verifica a Ordenação */
					VerificarOrdenacao();
				}
			}
		});
		b6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/* Captura as Coordenadas Atual */
				x = b6.getX();
				y = b6.getY();

				/* Método */
				MathABS();

				/* Condição para Troca de Posições */
				if (xx <= 102 && yy <= 102 && xx != yy) {

					/* Define Nova Coordenada */
					b6.setBounds(colunaB6 = b0.getX(), linhaB6 = b0.getY(),
							Horizontal, Vertical);

					/* Define Nova Coordenada */
					b0.setBounds(x, y, Horizontal, Vertical);

					/* Reproduz Som */
					som = new Som();
					som.main(null);

					/* Chamada do método que Verifica a Ordenação */
					VerificarOrdenacao();
				}
			}
		});
		b7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/* Captura as Coordenadas Atual */
				x = b7.getX();
				y = b7.getY();

				/* Método */
				MathABS();

				/* Condição para Troca de Posições */
				if (xx <= 102 && yy <= 102 && xx != yy) {

					/* Define Nova Coordenada */
					b7.setBounds(colunaB7 = b0.getX(), linhaB7 = b0.getY(),
							Horizontal, Vertical);

					/* Define Nova Coordenada */
					b0.setBounds(colunaB0 = x, linhaB0 = y, Horizontal,
							Vertical);

					/* Reproduz Som */
					som = new Som();
					som.main(null);

					/* Chamada do método que Verifica a Ordenação */
					VerificarOrdenacao();
				}
			}
		});
		b8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/* Captura as Coordenadas Atual */
				x = b8.getX();
				y = b8.getY();

				/* Método */
				MathABS();

				/* Condição para Troca de Posições */
				if (xx <= 102 && yy <= 102 && xx != yy) {

					/* Define Nova Coordenada */
					b8.setBounds(colunaB8 = b0.getX(), linhaB8 = b0.getY(),
							Horizontal, Vertical);

					/* Define Nova Coordenada */
					b0.setBounds(colunaB0 = x, linhaB0 = y, Horizontal,
							Vertical);

					/* Reproduz Som */
					som = new Som();
					som.main(null);

					/* Chamada do método que Verifica a Ordenação */
					VerificarOrdenacao();
				}
			}
		});
	}/* FIM */

	/**
	 * Método que Distribue Aleatoriamente os Botões no Tabuleiro.
	 */
	private void DistribuirBotoes() {
		// Loop Preenchimento das coordenada dos botões.
		for (botao = 0; botao < 9; botao++) {
			// Variaveis auxiliares recebem os valores que foram gerados
			// aleatoriamente de 0 á 2.
			colunaAleatorio = random.nextInt(3);
			linhaAleatorio = random.nextInt(3);

			/* Passagem do valor da Coordenada para a Coluna */
			if (colunaAleatorio == 0) {
				colunaAleatorio = ZERO;
			}
			if (colunaAleatorio == 1) {
				colunaAleatorio = UM;
			}
			if (colunaAleatorio == 2) {
				colunaAleatorio = DOIS;
			}

			/* Passagem do valor da Coordenada para a Linha */
			if (linhaAleatorio == 0) {
				linhaAleatorio = ZERO;
			}
			if (linhaAleatorio == 1) {
				linhaAleatorio = UM;
			}
			if (linhaAleatorio == 2) {
				linhaAleatorio = DOIS;
			}

			/* Define as Coordenadas Aleatoria de cada Botão */
			switch (botao) {
			case 0:
				colunaB0 = colunaAleatorio;
				linhaB0 = linhaAleatorio;
				b0.setBounds(colunaB0, linhaB0, Horizontal, Vertical);
				break;
			case 1:
				colunaB1 = colunaAleatorio;
				linhaB1 = linhaAleatorio;
				/* Tratamento de Erro (Espaço "Coordenada" Ocupada) */
				if ((colunaB1 == colunaB0) && (linhaB1 == linhaB0)
						|| (colunaB1 == colunaB2) && (linhaB1 == linhaB2)
						|| (colunaB1 == colunaB3) && (linhaB1 == linhaB3)
						|| (colunaB1 == colunaB4) && (linhaB1 == linhaB4)
						|| (colunaB1 == colunaB5) && (linhaB1 == linhaB5)
						|| (colunaB1 == colunaB6) && (linhaB1 == linhaB6)
						|| (colunaB1 == colunaB7) && (linhaB1 == linhaB7)
						|| (colunaB1 == colunaB8) && (linhaB1 == linhaB8)) {
					// Retorna Loop para Randomisar as cooredenadas novamente,
					// até a condição ser falsa.
					botao--;
				} else {
					b1.setBounds(colunaB1, linhaB1, Horizontal, Vertical);
				}
				break;
			case 2:
				if (botao == 2) {
					colunaB2 = colunaAleatorio;
					linhaB2 = linhaAleatorio;
					/* Tratamento de Erro (Coordenada Ocupada) */
					if ((colunaB2 == colunaB0) && (linhaB2 == linhaB0)
							|| (colunaB2 == colunaB1) && (linhaB2 == linhaB1)
							|| (colunaB2 == colunaB3) && (linhaB2 == linhaB3)
							|| (colunaB2 == colunaB4) && (linhaB2 == linhaB4)
							|| (colunaB2 == colunaB5) && (linhaB2 == linhaB5)
							|| (colunaB2 == colunaB6) && (linhaB2 == linhaB6)
							|| (colunaB2 == colunaB7) && (linhaB2 == linhaB7)
							|| (colunaB2 == colunaB8) && (linhaB2 == linhaB8)) {
						// Retorna Loop para Randomisar as cooredenadas
						// novamente, até a condição ser falsa.
						botao--;
					} else {
						b2.setBounds(colunaB2, linhaB2, Horizontal, Vertical);
					}
				}
				break;
			case 3:
				if (botao == 3) {
					colunaB3 = colunaAleatorio;
					linhaB3 = linhaAleatorio;
					/* Tratamento de Erro (Coordenada Ocupada) */
					if ((colunaB3 == colunaB0) && (linhaB3 == linhaB0)
							|| (colunaB3 == colunaB1) && (linhaB3 == linhaB1)
							|| (colunaB3 == colunaB2) && (linhaB3 == linhaB2)
							|| (colunaB3 == colunaB4) && (linhaB3 == linhaB4)
							|| (colunaB3 == colunaB5) && (linhaB3 == linhaB5)
							|| (colunaB3 == colunaB6) && (linhaB3 == linhaB6)
							|| (colunaB3 == colunaB7) && (linhaB3 == linhaB7)
							|| (colunaB3 == colunaB8) && (linhaB3 == linhaB8)) {
						// Retorna Loop para Randomisar as cooredenadas
						// novamente, até a condição ser falsa.
						botao--;
					} else {
						b3.setBounds(colunaB3, linhaB3, Horizontal, Vertical);
					}
				}
				break;
			case 4:
				if (botao == 4) {
					colunaB4 = colunaAleatorio;
					linhaB4 = linhaAleatorio;
					/* Tratamento de Erro (Coordenada Ocupada) */
					if ((colunaB4 == colunaB0) && (linhaB4 == linhaB0)
							|| (colunaB4 == colunaB1) && (linhaB4 == linhaB1)
							|| (colunaB4 == colunaB2) && (linhaB4 == linhaB2)
							|| (colunaB4 == colunaB3) && (linhaB4 == linhaB3)
							|| (colunaB4 == colunaB5) && (linhaB4 == linhaB5)
							|| (colunaB4 == colunaB6) && (linhaB4 == linhaB6)
							|| (colunaB4 == colunaB7) && (linhaB4 == linhaB7)
							|| (colunaB4 == colunaB8) && (linhaB4 == linhaB8)) {
						// Retorna Loop para Randomisar as cooredenadas
						// novamente, até a condição ser falsa.
						botao--;
					} else {
						b4.setBounds(colunaB4, linhaB4, Horizontal, Vertical);
					}
				}
				break;
			case 5:
				if (botao == 5) {
					colunaB5 = colunaAleatorio;
					linhaB5 = linhaAleatorio;
					/* Tratamento de Erro (Coordenada Ocupada) */
					if ((colunaB5 == colunaB0) && (linhaB5 == linhaB0)
							|| (colunaB5 == colunaB1) && (linhaB5 == linhaB1)
							|| (colunaB5 == colunaB2) && (linhaB5 == linhaB2)
							|| (colunaB5 == colunaB3) && (linhaB5 == linhaB3)
							|| (colunaB5 == colunaB4) && (linhaB5 == linhaB4)
							|| (colunaB5 == colunaB6) && (linhaB5 == linhaB6)
							|| (colunaB5 == colunaB7) && (linhaB5 == linhaB7)
							|| (colunaB5 == colunaB8) && (linhaB5 == linhaB8)) {
						// Retorna Loop para Randomisar as cooredenadas
						// novamente, até a condição ser falsa.
						botao--;
					} else {
						b5.setBounds(colunaB5, linhaB5, Horizontal, Vertical);
					}
				}
				break;
			case 6:
				if (botao == 6) {
					colunaB6 = colunaAleatorio;
					linhaB6 = linhaAleatorio;
					/* Tratamento de Erro (Coordenada Ocupada) */
					if ((colunaB6 == colunaB0) && (linhaB6 == linhaB0)
							|| (colunaB6 == colunaB1) && (linhaB6 == linhaB1)
							|| (colunaB6 == colunaB2) && (linhaB6 == linhaB2)
							|| (colunaB6 == colunaB3) && (linhaB6 == linhaB3)
							|| (colunaB6 == colunaB4) && (linhaB6 == linhaB4)
							|| (colunaB6 == colunaB5) && (linhaB6 == linhaB5)
							|| (colunaB6 == colunaB7) && (linhaB6 == linhaB7)
							|| (colunaB6 == colunaB8) && (linhaB6 == linhaB8)) {
						// Retorna Loop para Randomisar as cooredenadas
						// novamente, até a condição ser falsa.
						botao--;
					} else {
						b6.setBounds(colunaB6, linhaB6, Horizontal, Vertical);
					}
				}
				break;
			case 7:
				if (botao == 7) {
					colunaB7 = colunaAleatorio;
					linhaB7 = linhaAleatorio;
					/* Tratamento de Erro (Coordenada Ocupada) */
					if ((colunaB7 == colunaB0) && (linhaB7 == linhaB0)
							|| (colunaB7 == colunaB1) && (linhaB7 == linhaB1)
							|| (colunaB7 == colunaB2) && (linhaB7 == linhaB2)
							|| (colunaB7 == colunaB3) && (linhaB7 == linhaB3)
							|| (colunaB7 == colunaB4) && (linhaB7 == linhaB4)
							|| (colunaB7 == colunaB5) && (linhaB7 == linhaB5)
							|| (colunaB7 == colunaB6) && (linhaB7 == linhaB6)
							|| (colunaB7 == colunaB8) && (linhaB7 == linhaB8)) {
						// Retorna Loop para Randomisar as cooredenadas
						// novamente, até a condição ser falsa.
						botao--;
					} else {
						b7.setBounds(colunaB7, linhaB7, Horizontal, Vertical);
					}
				}
				break;
			case 8:
				if (botao == 8) {
					colunaB8 = colunaAleatorio;
					linhaB8 = linhaAleatorio;
					/* Tratamento de Erro (Coordenada Ocupada) */
					if ((colunaB8 == colunaB0) && (linhaB8 == linhaB0)
							|| (colunaB8 == colunaB1) && (linhaB8 == linhaB1)
							|| (colunaB8 == colunaB2) && (linhaB8 == linhaB2)
							|| (colunaB8 == colunaB3) && (linhaB8 == linhaB3)
							|| (colunaB8 == colunaB4) && (linhaB8 == linhaB4)
							|| (colunaB8 == colunaB5) && (linhaB8 == linhaB5)
							|| (colunaB8 == colunaB6) && (linhaB8 == linhaB6)
							|| (colunaB8 == colunaB7) && (linhaB8 == linhaB7)) {
						// Retorna Loop para Randomisar as cooredenadas
						// novamente, até a condição ser falsa.
						botao--;
					} else {
						b8.setBounds(colunaB8, linhaB8, Horizontal, Vertical);
					}
				}
				break;
			} /* FIM switch case */
		}/* FIM Loop For */

	}/* FIM */

	/**
	 * Carrega Números nos Botões.
	 */
	private void CarregarNumeros() {
		b0.setText("");
		b1.setText("1");
		b2.setText("2");
		b3.setText("3");
		b4.setText("4");
		b5.setText("5");
		b6.setText("6");
		b7.setText("7");
		b8.setText("8");
	}/* FIM */

	/**
	 * Carrega Alfabeto nos Botões.
	 */
	private void CarregarAlfabeto() {
		b0.setText(" ");
		b1.setText("A");
		b2.setText("B");
		b3.setText("C");
		b4.setText("D");
		b5.setText("E");
		b6.setText("F");
		b7.setText("G");
		b8.setText("H");
	}/* FIM */

	/**
	 * Carrega Nome Nos Botões (Apresentação Inicial do Jogo).
	 */
	private void CarregarNome() {
		b0.setText("F");
		b1.setText("R");
		b2.setText("A");
		b3.setText("N");
		b4.setText("C");
		b5.setText("I");
		b6.setText("S");
		b7.setText("C");
		b8.setText("O");
	}/* FIM */

	/**
	 * Esse Método e chamado sempre que um botão é movimentado, verifica
	 * andamento do Jogo se Ordenou o não os Botões no Tabuleiro.
	 */
	private void VerificarOrdenacao() {
		/* Representação da Ordenação */
		/* '-----------' */
		/* ' 1 ' 2 ' 3 ' */
		/* ' 4 ' 5 ' 6 ' */
		/* ' 7 ' 8 ' 0 ' */
		/* '-----------' */

		/* Condição da Ordenação */
		if ((colunaB1 == ZERO && linhaB1 == ZERO)
				&& (colunaB2 == UM && linhaB2 == ZERO)
				&& (colunaB3 == DOIS && linhaB3 == ZERO)
				&& (colunaB4 == ZERO && linhaB4 == UM)
				&& (colunaB5 == UM && linhaB5 == UM)
				&& (colunaB6 == DOIS && linhaB6 == UM)
				&& (colunaB7 == ZERO && linhaB7 == DOIS)
				&& (colunaB8 == UM && linhaB8 == DOIS)
				&& (colunaB0 == DOIS && linhaB0 == DOIS)) {

			JOptionPane.showMessageDialog(null,
					"PARABÉNS VOCÊ CONCEGUIU UMA ORDENAÇÃO!");
		}
	}

}/* FIM Class */