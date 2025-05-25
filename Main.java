public class Main {
    public static void main(String[] args) {
        System.out.print("     ");

        for(int i = 0; i < 8; i++){
            if(i+1 < 10)
                System.out.print((i+1) + "  ");
            else 
                System.out.print((i+1) + " ");
        }
        System.out.print("\n   \u250C");
        
        for(int i = 0; i < 8; i++){
            System.out.print("\u2500\u2500\u2500");
        }
        System.out.println("\u2510");
        System.out.print("   \u2514");
        for(int i = 0; i < 8; i++){
            System.out.print("\u2500\u2500\u2500");
        }
        System.out.println("\u2518");
    }
}
