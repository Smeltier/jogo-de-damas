public class Jogo {

    private int tamanhoLadoTabuleiro = 8;
    private int[][] tabuleiro;
    private boolean[][] espacoJogadaBranco;
    private boolean[][] espacoJogadaPreto;

    private void ajustarEspacoPreto(){
        boolean casaAtual = true;
        for(int i = 0; i < tamanhoLadoTabuleiro; i++){
            espacoJogadaPreto[i][0] = casaAtual;
            for(int j = 0; j < tamanhoLadoTabuleiro; j++){
                casaAtual = !casaAtual;
                espacoJogadaPreto[i][j] = casaAtual;
            }
        }
    }    

    private void ajustarEspacoBranco(){
        
    }

}