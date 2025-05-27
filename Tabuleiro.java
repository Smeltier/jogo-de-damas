public class Tabuleiro {
    
    private final int tamanhoLadoTabuleiro = 8;
    private int[][] tabuleiro;
    private boolean[][] espacoJogada;

    public Tabuleiro() {
        tabuleiro = new int[tamanhoLadoTabuleiro][tamanhoLadoTabuleiro];
        espacoJogada = new boolean[tamanhoLadoTabuleiro][tamanhoLadoTabuleiro];
        ajustarEspaco();
        ajustarTabuleiro();
    }

    private void ajustarEspaco() {
        for (int i = 0; i < tamanhoLadoTabuleiro; i++) {
            for (int j = 0; j < tamanhoLadoTabuleiro; j++) {
                espacoJogada[i][j] = (i + j) % 2 != 0;
            }
        }
    }

    private void ajustarTabuleiro() {
        for (int i = 0; i < tamanhoLadoTabuleiro; i++) {
            for (int j = 0; j < tamanhoLadoTabuleiro; j++) {
                if (i <= 1 && espacoJogada[i][j])  
                    tabuleiro[i][j] = 0;
                else if (i >= 6 && espacoJogada[i][j])  
                    tabuleiro[i][j] = 1;
                else
                    tabuleiro[i][j] = -1;  
            }
        }
    }

    public void mostrarTabuleiro() {
        System.out.print("     ");
        for (int i = 0; i < tamanhoLadoTabuleiro; i++)
            System.out.print((i + 1) + "  ");
        System.out.println();

        System.out.print("   \u250C");
        for (int i = 0; i < tamanhoLadoTabuleiro; i++)
            System.out.print("\u2500\u2500\u2500");
        System.out.println("\u2510");

        for (int i = 0; i < tamanhoLadoTabuleiro; i++) {
            System.out.printf("%2d \u2502", i + 1);
            for (int j = 0; j < tamanhoLadoTabuleiro; j++) {
                if (tabuleiro[i][j] == 1)
                    System.out.print("\u001B[31m O \033[0m");
                else if (tabuleiro[i][j] == 0)
                    System.out.print("\u001B[34m O \033[0m");
                else if (espacoJogada[i][j])
                    System.out.print(" * ");
                else
                    System.out.print("   ");
            }
            System.out.println("\u2502");
        }

        System.out.print("   \u2514");
        for (int i = 0; i < tamanhoLadoTabuleiro; i++)
            System.out.print("\u2500\u2500\u2500");
        System.out.println("\u2518");
    }

    public int getTamanhoTabuleiro(){
        return tamanhoLadoTabuleiro;
    }

    public boolean[][] getEspacoJogada(){
        return espacoJogada;
    }

    public int getElemento(int x, int y){
        return tabuleiro[x - 1][y - 1];
    }

    public void setElemento(int x, int y, int valor){
        tabuleiro[x - 1][y - 1] = valor;
    }

    public boolean getEspacoValido(int x, int y){
        return espacoJogada[x - 1][y - 1];
    }

}
