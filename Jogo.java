public class Jogo {

    private final int tamanhoLadoTabuleiro = 8;
    private int[][] tabuleiro;
    private boolean[][] espacoJogada;
    private int comidasBrancas, comidasPretas;

    public Jogo() {
        tabuleiro = new int[tamanhoLadoTabuleiro][tamanhoLadoTabuleiro];
        espacoJogada = new boolean[tamanhoLadoTabuleiro][tamanhoLadoTabuleiro];
        comidasBrancas = comidasPretas = 0;
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

    private boolean estaNosLimites(int x, int y) {
        return x >= 1 && x <= tamanhoLadoTabuleiro && y >= 1 && y <= tamanhoLadoTabuleiro;
    }

    public boolean jogadaValida(int posX, int posY, int novaX, int novaY, String jogador) {
        if (!estaNosLimites(posX, posY) || !estaNosLimites(novaX, novaY))
            return false;

        if (!espacoJogada[novaX - 1][novaY - 1])  
            return false;

        int peca = tabuleiro[posX - 1][posY - 1];
        if (jogador.equals("B") && peca != 1) 
            return false;
        if (jogador.equals("P") && peca != 0)  
            return false;

        if (tabuleiro[novaX - 1][novaY - 1] != -1)
            return false;

        int dx = novaX - posX;
        int dy = novaY - posY;

        if (Math.abs(dx) == 1 && Math.abs(dy) == 1) {
            if (jogador.equals("B") && dx == -1)
                return true;  
            if (jogador.equals("P") && dx == 1)
                return true;
        }

        if (Math.abs(dx) == 2 && Math.abs(dy) == 2) {
            int meioX = posX + dx / 2;
            int meioY = posY + dy / 2;
            int pecaMeio = tabuleiro[meioX - 1][meioY - 1];
            if (jogador.equals("B") && pecaMeio == 0)
                return true;
            if (jogador.equals("P") && pecaMeio == 1)
                return true;
        }

        return false;
    }

    public void mover(int posX, int posY, int novaX, int novaY, String jogador) {
        tabuleiro[posX - 1][posY - 1] = -1;

        if (Math.abs(novaX - posX) == 2 && Math.abs(novaY - posY) == 2) {
            int meioX = (posX + novaX) / 2;
            int meioY = (posY + novaY) / 2;
            int pecaComida = tabuleiro[meioX - 1][meioY - 1];
            tabuleiro[meioX - 1][meioY - 1] = -1;

            if (pecaComida == 0)
                comidasBrancas++;
            else if (pecaComida == 1)
                comidasPretas++;
        }

        if (jogador.equals("B"))
            tabuleiro[novaX - 1][novaY - 1] = 1;
        else
            tabuleiro[novaX - 1][novaY - 1] = 0;
    }

    public int verificarEstadoJogo() {
        if (comidasBrancas == 12)
            return 1;
        if (comidasPretas == 12)
            return 0;
        return -1;
    }

    public static void limparTerminal() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            System.out.println("\n\n\n\n\n\n\n\n\n\n");
        }
    }

}
