public class Jogo {

    private Tabuleiro tabuleiro;
    private int comidasBrancas, comidasPretas;

    public Jogo() {
        tabuleiro = new Tabuleiro();
        comidasBrancas = comidasPretas = 0;
    }

    private boolean estaNosLimites(int x, int y) {
        return x >= 1 && x <= tabuleiro.getTamanhoTabuleiro() && y >= 1 && y <= tabuleiro.getTamanhoTabuleiro();
    }

    public boolean jogadaValida(int posX, int posY, int novaX, int novaY, String jogador) {
        if (!estaNosLimites(posX, posY) || !estaNosLimites(novaX, novaY))
            return false;

        if (!tabuleiro.getEspacoValido(novaX, novaY))  
            return false;

        int peca = tabuleiro.getElemento(posX, posY);
        if (jogador.equals("B") && peca != 1) 
            return false;
        if (jogador.equals("P") && peca != 0)  
            return false;

        if (tabuleiro.getElemento(novaX, novaY) != -1)
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
            int pecaMeio = tabuleiro.getElemento(meioX, meioY);
            if (jogador.equals("B") && pecaMeio == 0)
                return true;
            if (jogador.equals("P") && pecaMeio == 1)
                return true;
        }

        return false;
    }

    public void mover(int posX, int posY, int novaX, int novaY, String jogador) {
        tabuleiro.setElemento(posX, posY, -1);

        if (Math.abs(novaX - posX) == 2 && Math.abs(novaY - posY) == 2) {
            int meioX = (posX + novaX) / 2;
            int meioY = (posY + novaY) / 2;
            int pecaComida = tabuleiro.getElemento(meioX, meioY);
            tabuleiro.setElemento(meioX, meioY, -1);

            if (pecaComida == 0)
                comidasBrancas++;
            else if (pecaComida == 1)
                comidasPretas++;
        }

        if (jogador.equals("B"))
            tabuleiro.setElemento(novaX, novaY, 1);
        else
            tabuleiro.setElemento(novaX, novaY, 0);
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

    public void mostrarTabuleiro(){
        tabuleiro.mostrarTabuleiro();
    }
}