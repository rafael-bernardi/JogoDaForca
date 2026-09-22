package jogoDaForca;

import java.util.Scanner;   
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random aleatorio = new Random();

        String[] frutas = {"ABACATE", "GOIABA", "BANANA", "UVA", "MANGA"};

        int indiceSorteado = aleatorio.nextInt(frutas.length);
        String palavraSecreta = frutas[indiceSorteado];

        char[] palavraOculta = new char[palavraSecreta.length()];
        for(int i = 0; i < palavraOculta.length; i++){
            palavraOculta[i] = '_';
        }

        int erros = 0;
        final int MAX_ERROS = 5;
        boolean acertou = false;

        System.out.println("=== JOGO DA FORCA ===");

        while(!acertou && erros < MAX_ERROS){
            desenharForca(erros);

            System.out.print("\nPalavra: ");
            for (char letra : palavraOculta){
                System.out.print(letra + " "); 
            }
            System.out.println();

            System.out.print("Qual o seu chute? ");
            char chute = input.nextLine().toUpperCase().charAt(0); 

            boolean letraEncontrada = false;
            for(int i = 0; i < palavraSecreta.length(); i++){
                if(palavraSecreta.charAt(i) == chute){
                    palavraOculta[i] = chute;
                    letraEncontrada = true;
                }
            }

            if(letraEncontrada){
                System.out.println("Bom chute! A letra '" + chute + "' existe na palavra."); 
            } else {
                erros++;
                System.out.println("Que pena, a letra '" + chute + "' nao existe. Erros: " + erros + "/" + MAX_ERROS); 
            }

            boolean temTraco = false;
            for(char c : palavraOculta){
                if(c == '_'){
                    temTraco = true;
                    break;
                }
            }

            if(!temTraco){
                acertou = true;
            }
        }

        System.out.println("\n========================");
        if(acertou){
            System.out.println("PARABENS! Voce venceu! A palavra era: " + palavraSecreta);
        } else {
            desenharForca(erros);
            System.out.println("GAME OVER! Voce atingiu o numero maximo de 5 erros.");
            System.out.println("A palavra secreta era: " + palavraSecreta);
        }
        System.out.println("===========================");
        input.close();
    }

    public static void desenharForca(int erros){
        System.out.println("\n +---+");
        System.out.println("  |   |");

        switch (erros) {
            case 0:
                System.out.println("      |");
                System.out.println("      |");
                System.out.println("      |");
                break;
            case 1:
                System.out.println("  O   |");
                System.out.println("      |");
                System.out.println("      |");
                break;
            case 2:
                System.out.println("  O   |");
                System.out.println("  |   |");
                System.out.println("      |");
                break;
            case 3:
                System.out.println("  O   |");
                System.out.println(" /|   |");
                System.out.println("      |");
                break;
            case 4:
                System.out.println("  O   |");
                System.out.println(" /|\\  |");
                System.out.println("      |");
                break;
            case 5:
                System.out.println("  O   |");
                System.out.println(" /|\\  |");
                System.out.println(" / \\  |");
                break;                    
        }
        System.out.println("=========");
    }
}