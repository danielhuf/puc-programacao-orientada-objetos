package View;

public class Coordenada {
	private static final int CASAS = 40;
	private static final int PIOES = 6;
	private static final int EIXOS = 2;
	private final static int mapaPosicoes[][][] = new int[CASAS][PIOES][EIXOS];
	
	/**
	 * Mapeia as posi??es de todos os pi?es em todas as casas do tabuleiro
	 */
	public static void carregar() {
		mapaPosicoes[0][0][0] = 557;
		mapaPosicoes[0][0][1] = 570;
		mapaPosicoes[0][1][0] = 612;
		mapaPosicoes[0][1][1] = 570;
		mapaPosicoes[0][2][0] = 557;
		mapaPosicoes[0][2][1] = 600;
		mapaPosicoes[0][3][0] = 612;
		mapaPosicoes[0][3][1] = 600;
		mapaPosicoes[0][4][0] = 557;
		mapaPosicoes[0][4][1] = 630;
		mapaPosicoes[0][5][0] = 612;
		mapaPosicoes[0][5][1] = 630;
		mapaPosicoes[1][0][0] = 505;
		mapaPosicoes[1][0][1] = 600;
		mapaPosicoes[1][1][0] = 525;
		mapaPosicoes[1][1][1] = 600;
		mapaPosicoes[1][2][0] = 505;
		mapaPosicoes[1][2][1] = 615;
		mapaPosicoes[1][3][0] = 525;
		mapaPosicoes[1][3][1] = 615;
		mapaPosicoes[1][4][0] = 505;
		mapaPosicoes[1][4][1] = 630;
		mapaPosicoes[1][5][0] = 525;
		mapaPosicoes[1][5][1] = 630;
		mapaPosicoes[2][0][0] = 460;
		mapaPosicoes[2][0][1] = 600;
		mapaPosicoes[2][1][0] = 480;
		mapaPosicoes[2][1][1] = 600;
		mapaPosicoes[2][2][0] = 460;
		mapaPosicoes[2][2][1] = 615;
		mapaPosicoes[2][3][0] = 480;
		mapaPosicoes[2][3][1] = 615;
		mapaPosicoes[2][4][0] = 460;
		mapaPosicoes[2][4][1] = 630;
		mapaPosicoes[2][5][0] = 480;
		mapaPosicoes[2][5][1] = 630;
		mapaPosicoes[3][0][0] = 410;
		mapaPosicoes[3][0][1] = 600;
		mapaPosicoes[3][1][0] = 430;
		mapaPosicoes[3][1][1] = 600;
		mapaPosicoes[3][2][0] = 410;
		mapaPosicoes[3][2][1] = 615;
		mapaPosicoes[3][3][0] = 430;
		mapaPosicoes[3][3][1] = 615;
		mapaPosicoes[3][4][0] = 410;
		mapaPosicoes[3][4][1] = 630;
		mapaPosicoes[3][5][0] = 430;
		mapaPosicoes[3][5][1] = 630;
		mapaPosicoes[4][0][0] = 360;
		mapaPosicoes[4][0][1] = 600;
		mapaPosicoes[4][1][0] = 380;
		mapaPosicoes[4][1][1] = 600;
		mapaPosicoes[4][2][0] = 360;
		mapaPosicoes[4][2][1] = 615;
		mapaPosicoes[4][3][0] = 380;
		mapaPosicoes[4][3][1] = 615;
		mapaPosicoes[4][4][0] = 360;
		mapaPosicoes[4][4][1] = 630;
		mapaPosicoes[4][5][0] = 380;
		mapaPosicoes[4][5][1] = 630;
		mapaPosicoes[5][0][0] = 310;
		mapaPosicoes[5][0][1] = 600;
		mapaPosicoes[5][1][0] = 330;
		mapaPosicoes[5][1][1] = 600;
		mapaPosicoes[5][2][0] = 310;
		mapaPosicoes[5][2][1] = 615;
		mapaPosicoes[5][3][0] = 330;
		mapaPosicoes[5][3][1] = 615;
		mapaPosicoes[5][4][0] = 310;
		mapaPosicoes[5][4][1] = 630;
		mapaPosicoes[5][5][0] = 330;
		mapaPosicoes[5][5][1] = 630;
		mapaPosicoes[6][0][0] = 260;
		mapaPosicoes[6][0][1] = 600;
		mapaPosicoes[6][1][0] = 280;
		mapaPosicoes[6][1][1] = 600;
		mapaPosicoes[6][2][0] = 260;
		mapaPosicoes[6][2][1] = 615;
		mapaPosicoes[6][3][0] = 280;
		mapaPosicoes[6][3][1] = 615;
		mapaPosicoes[6][4][0] = 260;
		mapaPosicoes[6][4][1] = 630;
		mapaPosicoes[6][5][0] = 280;
		mapaPosicoes[6][5][1] = 630;
		mapaPosicoes[7][0][0] = 210;
		mapaPosicoes[7][0][1] = 600;
		mapaPosicoes[7][1][0] = 230;
		mapaPosicoes[7][1][1] = 600;
		mapaPosicoes[7][2][0] = 210;
		mapaPosicoes[7][2][1] = 615;
		mapaPosicoes[7][3][0] = 230;
		mapaPosicoes[7][3][1] = 615;
		mapaPosicoes[7][4][0] = 210;
		mapaPosicoes[7][4][1] = 630;
		mapaPosicoes[7][5][0] = 230;
		mapaPosicoes[7][5][1] = 630;
		mapaPosicoes[8][0][0] = 165;
		mapaPosicoes[8][0][1] = 600;
		mapaPosicoes[8][1][0] = 185;
		mapaPosicoes[8][1][1] = 600;
		mapaPosicoes[8][2][0] = 165;
		mapaPosicoes[8][2][1] = 615;
		mapaPosicoes[8][3][0] = 185;
		mapaPosicoes[8][3][1] = 615;
		mapaPosicoes[8][4][0] = 165;
		mapaPosicoes[8][4][1] = 630;
		mapaPosicoes[8][5][0] = 185;
		mapaPosicoes[8][5][1] = 630;
		mapaPosicoes[9][0][0] = 115;
		mapaPosicoes[9][0][1] = 600;
		mapaPosicoes[9][1][0] = 135;
		mapaPosicoes[9][1][1] = 600;
		mapaPosicoes[9][2][0] = 115;
		mapaPosicoes[9][2][1] = 615;
		mapaPosicoes[9][3][0] = 135;
		mapaPosicoes[9][3][1] = 615;
		mapaPosicoes[9][4][0] = 115;
		mapaPosicoes[9][4][1] = 630;
		mapaPosicoes[9][5][0] = 135;
		mapaPosicoes[9][5][1] = 630;
		mapaPosicoes[10][0][0] = 30;
		mapaPosicoes[10][0][1] = 570;
		mapaPosicoes[10][1][0] = 30;
		mapaPosicoes[10][1][1] = 585;
		mapaPosicoes[10][2][0] = 30;
		mapaPosicoes[10][2][1] = 600;
		mapaPosicoes[10][3][0] = 30;
		mapaPosicoes[10][3][1] = 615;
		mapaPosicoes[10][4][0] = 30;
		mapaPosicoes[10][4][1] = 630;
		mapaPosicoes[10][5][0] = 45;
		mapaPosicoes[10][5][1] = 630;
		mapaPosicoes[11][0][0] = 30;
		mapaPosicoes[11][0][1] = 530;
		mapaPosicoes[11][1][0] = 50;
		mapaPosicoes[11][1][1] = 530;
		mapaPosicoes[11][2][0] = 70;
		mapaPosicoes[11][2][1] = 530;
		mapaPosicoes[11][3][0] = 30;
		mapaPosicoes[11][3][1] = 545;
		mapaPosicoes[11][4][0] = 50;
		mapaPosicoes[11][4][1] = 545;
		mapaPosicoes[11][5][0] = 70;
		mapaPosicoes[11][5][1] = 545;
		mapaPosicoes[12][0][0] = 30;
		mapaPosicoes[12][0][1] = 475;
		mapaPosicoes[12][1][0] = 50;
		mapaPosicoes[12][1][1] = 475;
		mapaPosicoes[12][2][0] = 70;
		mapaPosicoes[12][2][1] = 475;
		mapaPosicoes[12][3][0] = 30;
		mapaPosicoes[12][3][1] = 490;
		mapaPosicoes[12][4][0] = 50;
		mapaPosicoes[12][4][1] = 490;
		mapaPosicoes[12][5][0] = 70;
		mapaPosicoes[12][5][1] = 490;
		mapaPosicoes[13][0][0] = 30;
		mapaPosicoes[13][0][1] = 430;
		mapaPosicoes[13][1][0] = 50;
		mapaPosicoes[13][1][1] = 430;
		mapaPosicoes[13][2][0] = 70;
		mapaPosicoes[13][2][1] = 430;
		mapaPosicoes[13][3][0] = 30;
		mapaPosicoes[13][3][1] = 445;
		mapaPosicoes[13][4][0] = 50;
		mapaPosicoes[13][4][1] = 445;
		mapaPosicoes[13][5][0] = 70;
		mapaPosicoes[13][5][1] = 445;
		mapaPosicoes[14][0][0] = 30;
		mapaPosicoes[14][0][1] = 380;
		mapaPosicoes[14][1][0] = 50;
		mapaPosicoes[14][1][1] = 380;
		mapaPosicoes[14][2][0] = 70;
		mapaPosicoes[14][2][1] = 380;
		mapaPosicoes[14][3][0] = 30;
		mapaPosicoes[14][3][1] = 395;
		mapaPosicoes[14][4][0] = 50;
		mapaPosicoes[14][4][1] = 395;
		mapaPosicoes[14][5][0] = 70;
		mapaPosicoes[14][5][1] = 395;
		mapaPosicoes[15][0][0] = 30;
		mapaPosicoes[15][0][1] = 325;
		mapaPosicoes[15][1][0] = 50;
		mapaPosicoes[15][1][1] = 325;
		mapaPosicoes[15][2][0] = 70;
		mapaPosicoes[15][2][1] = 325;
		mapaPosicoes[15][3][0] = 30;
		mapaPosicoes[15][3][1] = 340;
		mapaPosicoes[15][4][0] = 50;
		mapaPosicoes[15][4][1] = 340;
		mapaPosicoes[15][5][0] = 70;
		mapaPosicoes[15][5][1] = 340;
		mapaPosicoes[16][0][0] = 30;
		mapaPosicoes[16][0][1] = 275;
		mapaPosicoes[16][1][0] = 50;
		mapaPosicoes[16][1][1] = 275;
		mapaPosicoes[16][2][0] = 70;
		mapaPosicoes[16][2][1] = 275;
		mapaPosicoes[16][3][0] = 30;
		mapaPosicoes[16][3][1] = 290;
		mapaPosicoes[16][4][0] = 50;
		mapaPosicoes[16][4][1] = 290;
		mapaPosicoes[16][5][0] = 70;
		mapaPosicoes[16][5][1] = 290;
		mapaPosicoes[17][0][0] = 30;
		mapaPosicoes[17][0][1] = 235;
		mapaPosicoes[17][1][0] = 50;
		mapaPosicoes[17][1][1] = 235;
		mapaPosicoes[17][2][0] = 70;
		mapaPosicoes[17][2][1] = 235;
		mapaPosicoes[17][3][0] = 30;
		mapaPosicoes[17][3][1] = 250;
		mapaPosicoes[17][4][0] = 50;
		mapaPosicoes[17][4][1] = 250;
		mapaPosicoes[17][5][0] = 70;
		mapaPosicoes[17][5][1] = 250;
		mapaPosicoes[18][0][0] = 30;
		mapaPosicoes[18][0][1] = 180;
		mapaPosicoes[18][1][0] = 50;
		mapaPosicoes[18][1][1] = 180;
		mapaPosicoes[18][2][0] = 70;
		mapaPosicoes[18][2][1] = 180;
		mapaPosicoes[18][3][0] = 30;
		mapaPosicoes[18][3][1] = 195;
		mapaPosicoes[18][4][0] = 50;
		mapaPosicoes[18][4][1] = 195;
		mapaPosicoes[18][5][0] = 70;
		mapaPosicoes[18][5][1] = 195;
		mapaPosicoes[19][0][0] = 30;
		mapaPosicoes[19][0][1] = 135;
		mapaPosicoes[19][1][0] = 50;
		mapaPosicoes[19][1][1] = 135;
		mapaPosicoes[19][2][0] = 70;
		mapaPosicoes[19][2][1] = 135;
		mapaPosicoes[19][3][0] = 30;
		mapaPosicoes[19][3][1] = 150;
		mapaPosicoes[19][4][0] = 50;
		mapaPosicoes[19][4][1] = 150;
		mapaPosicoes[19][5][0] = 70;
		mapaPosicoes[19][5][1] = 150;
		mapaPosicoes[20][0][0] = 30;
		mapaPosicoes[20][0][1] = 55;
		mapaPosicoes[20][1][0] = 85;
		mapaPosicoes[20][1][1] = 55;
		mapaPosicoes[20][2][0] = 30;
		mapaPosicoes[20][2][1] = 80;
		mapaPosicoes[20][3][0] = 85;
		mapaPosicoes[20][3][1] = 80;
		mapaPosicoes[20][4][0] = 30;
		mapaPosicoes[20][4][1] = 105;
		mapaPosicoes[20][5][0] = 85;
		mapaPosicoes[20][5][1] = 105;
		mapaPosicoes[21][0][0] = 115;
		mapaPosicoes[21][0][1] = 55;
		mapaPosicoes[21][1][0] = 135;
		mapaPosicoes[21][1][1] = 55;
		mapaPosicoes[21][2][0] = 115;
		mapaPosicoes[21][2][1] = 70;
		mapaPosicoes[21][3][0] = 135;
		mapaPosicoes[21][3][1] = 70;
		mapaPosicoes[21][4][0] = 115;
		mapaPosicoes[21][4][1] = 85;
		mapaPosicoes[21][5][0] = 135;
		mapaPosicoes[21][5][1] = 85;
		mapaPosicoes[22][0][0] = 165;
		mapaPosicoes[22][0][1] = 55;
		mapaPosicoes[22][1][0] = 185;
		mapaPosicoes[22][1][1] = 55;
		mapaPosicoes[22][2][0] = 165;
		mapaPosicoes[22][2][1] = 70;
		mapaPosicoes[22][3][0] = 185;
		mapaPosicoes[22][3][1] = 70;
		mapaPosicoes[22][4][0] = 165;
		mapaPosicoes[22][4][1] = 85;
		mapaPosicoes[22][5][0] = 185;
		mapaPosicoes[22][5][1] = 85;
		mapaPosicoes[23][0][0] = 210;
		mapaPosicoes[23][0][1] = 55;
		mapaPosicoes[23][1][0] = 230;
		mapaPosicoes[23][1][1] = 55;
		mapaPosicoes[23][2][0] = 210;
		mapaPosicoes[23][2][1] = 70;
		mapaPosicoes[23][3][0] = 230;
		mapaPosicoes[23][3][1] = 70;
		mapaPosicoes[23][4][0] = 210;
		mapaPosicoes[23][4][1] = 85;
		mapaPosicoes[23][5][0] = 230;
		mapaPosicoes[23][5][1] = 85;
		mapaPosicoes[24][0][0] = 260;
		mapaPosicoes[24][0][1] = 55;
		mapaPosicoes[24][1][0] = 280;
		mapaPosicoes[24][1][1] = 55;
		mapaPosicoes[24][2][0] = 260;
		mapaPosicoes[24][2][1] = 70;
		mapaPosicoes[24][3][0] = 280;
		mapaPosicoes[24][3][1] = 70;
		mapaPosicoes[24][4][0] = 260;
		mapaPosicoes[24][4][1] = 85;
		mapaPosicoes[24][5][0] = 280;
		mapaPosicoes[24][5][1] = 85;
		mapaPosicoes[25][0][0] = 310;
		mapaPosicoes[25][0][1] = 55;
		mapaPosicoes[25][1][0] = 330;
		mapaPosicoes[25][1][1] = 55;
		mapaPosicoes[25][2][0] = 310;
		mapaPosicoes[25][2][1] = 70;
		mapaPosicoes[25][3][0] = 330;
		mapaPosicoes[25][3][1] = 70;
		mapaPosicoes[25][4][0] = 310;
		mapaPosicoes[25][4][1] = 85;
		mapaPosicoes[25][5][0] = 330;
		mapaPosicoes[25][5][1] = 85;
		mapaPosicoes[26][0][0] = 360;
		mapaPosicoes[26][0][1] = 55;
		mapaPosicoes[26][1][0] = 380;
		mapaPosicoes[26][1][1] = 55;
		mapaPosicoes[26][2][0] = 360;
		mapaPosicoes[26][2][1] = 70;
		mapaPosicoes[26][3][0] = 380;
		mapaPosicoes[26][3][1] = 70;
		mapaPosicoes[26][4][0] = 360;
		mapaPosicoes[26][4][1] = 85;
		mapaPosicoes[26][5][0] = 380;
		mapaPosicoes[26][5][1] = 85;
		mapaPosicoes[27][0][0] = 410;
		mapaPosicoes[27][0][1] = 55;
		mapaPosicoes[27][1][0] = 430;
		mapaPosicoes[27][1][1] = 55;
		mapaPosicoes[27][2][0] = 410;
		mapaPosicoes[27][2][1] = 70;
		mapaPosicoes[27][3][0] = 430;
		mapaPosicoes[27][3][1] = 70;
		mapaPosicoes[27][4][0] = 410;
		mapaPosicoes[27][4][1] = 85;
		mapaPosicoes[27][5][0] = 430;
		mapaPosicoes[27][5][1] = 85;
		mapaPosicoes[28][0][0] = 460;
		mapaPosicoes[28][0][1] = 55;
		mapaPosicoes[28][1][0] = 480;
		mapaPosicoes[28][1][1] = 55;
		mapaPosicoes[28][2][0] = 460;
		mapaPosicoes[28][2][1] = 70;
		mapaPosicoes[28][3][0] = 480;
		mapaPosicoes[28][3][1] = 70;
		mapaPosicoes[28][4][0] = 460;
		mapaPosicoes[28][4][1] = 85;
		mapaPosicoes[28][5][0] = 480;
		mapaPosicoes[28][5][1] = 85;
		mapaPosicoes[29][0][0] = 505;
		mapaPosicoes[29][0][1] = 55;
		mapaPosicoes[29][1][0] = 525;
		mapaPosicoes[29][1][1] = 55;
		mapaPosicoes[29][2][0] = 505;
		mapaPosicoes[29][2][1] = 70;
		mapaPosicoes[29][3][0] = 525;
		mapaPosicoes[29][3][1] = 70;
		mapaPosicoes[29][4][0] = 505;
		mapaPosicoes[29][4][1] = 85;
		mapaPosicoes[29][5][0] = 525;
		mapaPosicoes[29][5][1] = 85;
		mapaPosicoes[30][0][0] = 615;
		mapaPosicoes[30][0][1] = 40;
		mapaPosicoes[30][1][0] = 615;
		mapaPosicoes[30][1][1] = 55;
		mapaPosicoes[30][2][0] = 615;
		mapaPosicoes[30][2][1] = 70;
		mapaPosicoes[30][3][0] = 615;
		mapaPosicoes[30][3][1] = 85;
		mapaPosicoes[30][4][0] = 615;
		mapaPosicoes[30][4][1] = 100;
		mapaPosicoes[30][5][0] = 600;
		mapaPosicoes[30][5][1] = 100;
		mapaPosicoes[31][0][0] = 575;
		mapaPosicoes[31][0][1] = 135;
		mapaPosicoes[31][1][0] = 595;
		mapaPosicoes[31][1][1] = 135;
		mapaPosicoes[31][2][0] = 615;
		mapaPosicoes[31][2][1] = 135;
		mapaPosicoes[31][3][0] = 575;
		mapaPosicoes[31][3][1] = 150;
		mapaPosicoes[31][4][0] = 595;
		mapaPosicoes[31][4][1] = 150;
		mapaPosicoes[31][5][0] = 615;
		mapaPosicoes[31][5][1] = 150;
		mapaPosicoes[32][0][0] = 575;
		mapaPosicoes[32][0][1] = 180;
		mapaPosicoes[32][1][0] = 595;
		mapaPosicoes[32][1][1] = 180;
		mapaPosicoes[32][2][0] = 615;
		mapaPosicoes[32][2][1] = 180;
		mapaPosicoes[32][3][0] = 575;
		mapaPosicoes[32][3][1] = 195;
		mapaPosicoes[32][4][0] = 595;
		mapaPosicoes[32][4][1] = 195;
		mapaPosicoes[32][5][0] = 615;
		mapaPosicoes[32][5][1] = 195;
		mapaPosicoes[33][0][0] = 575;
		mapaPosicoes[33][0][1] = 235;
		mapaPosicoes[33][1][0] = 595;
		mapaPosicoes[33][1][1] = 235;
		mapaPosicoes[33][2][0] = 615;
		mapaPosicoes[33][2][1] = 235;
		mapaPosicoes[33][3][0] = 575;
		mapaPosicoes[33][3][1] = 250;
		mapaPosicoes[33][4][0] = 595;
		mapaPosicoes[33][4][1] = 250;
		mapaPosicoes[33][5][0] = 615;
		mapaPosicoes[33][5][1] = 250;
		mapaPosicoes[34][0][0] = 575;
		mapaPosicoes[34][0][1] = 275;
		mapaPosicoes[34][1][0] = 595;
		mapaPosicoes[34][1][1] = 275;
		mapaPosicoes[34][2][0] = 615;
		mapaPosicoes[34][2][1] = 275;
		mapaPosicoes[34][3][0] = 575;
		mapaPosicoes[34][3][1] = 290;
		mapaPosicoes[34][4][0] = 595;
		mapaPosicoes[34][4][1] = 290;
		mapaPosicoes[34][5][0] = 615;
		mapaPosicoes[34][5][1] = 290;
		mapaPosicoes[35][0][0] = 575;
		mapaPosicoes[35][0][1] = 325;
		mapaPosicoes[35][1][0] = 595;
		mapaPosicoes[35][1][1] = 325;
		mapaPosicoes[35][2][0] = 615;
		mapaPosicoes[35][2][1] = 325;
		mapaPosicoes[35][3][0] = 575;
		mapaPosicoes[35][3][1] = 340;
		mapaPosicoes[35][4][0] = 595;
		mapaPosicoes[35][4][1] = 340;
		mapaPosicoes[35][5][0] = 615;
		mapaPosicoes[35][5][1] = 340;
		mapaPosicoes[36][0][0] = 575;
		mapaPosicoes[36][0][1] = 380;
		mapaPosicoes[36][1][0] = 595;
		mapaPosicoes[36][1][1] = 380;
		mapaPosicoes[36][2][0] = 615;
		mapaPosicoes[36][2][1] = 380;
		mapaPosicoes[36][3][0] = 575;
		mapaPosicoes[36][3][1] = 395;
		mapaPosicoes[36][4][0] = 595;
		mapaPosicoes[36][4][1] = 395;
		mapaPosicoes[36][5][0] = 615;
		mapaPosicoes[36][5][1] = 395;
		mapaPosicoes[37][0][0] = 575;
		mapaPosicoes[37][0][1] = 430;
		mapaPosicoes[37][1][0] = 595;
		mapaPosicoes[37][1][1] = 430;
		mapaPosicoes[37][2][0] = 615;
		mapaPosicoes[37][2][1] = 430;
		mapaPosicoes[37][3][0] = 575;
		mapaPosicoes[37][3][1] = 445;
		mapaPosicoes[37][4][0] = 595;
		mapaPosicoes[37][4][1] = 445;
		mapaPosicoes[37][5][0] = 615;
		mapaPosicoes[37][5][1] = 445;
		mapaPosicoes[38][0][0] = 575;
		mapaPosicoes[38][0][1] = 475;
		mapaPosicoes[38][1][0] = 595;
		mapaPosicoes[38][1][1] = 475;
		mapaPosicoes[38][2][0] = 615;
		mapaPosicoes[38][2][1] = 475;
		mapaPosicoes[38][3][0] = 575;
		mapaPosicoes[38][3][1] = 490;
		mapaPosicoes[38][4][0] = 595;
		mapaPosicoes[38][4][1] = 490;
		mapaPosicoes[38][5][0] = 615;
		mapaPosicoes[38][5][1] = 490;
		mapaPosicoes[39][0][0] = 575;
		mapaPosicoes[39][0][1] = 530;
		mapaPosicoes[39][1][0] = 595;
		mapaPosicoes[39][1][1] = 530;
		mapaPosicoes[39][2][0] = 615;
		mapaPosicoes[39][2][1] = 530;
		mapaPosicoes[39][3][0] = 575;
		mapaPosicoes[39][3][1] = 545;
		mapaPosicoes[39][4][0] = 595;
		mapaPosicoes[39][4][1] = 545;
		mapaPosicoes[39][5][0] = 615;
		mapaPosicoes[39][5][1] = 545;
	}
	
	public static int getX(int casa, int piao) { return mapaPosicoes[casa][piao][0]; }
	
	public static int getY(int casa, int piao) { return mapaPosicoes[casa][piao][1]; }
}
