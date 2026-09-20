package JogoDaForca;

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

        System.out.println("===Jogo da Forca===");

        boolean acertou = false;

        while(!acertou){
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
            }else{
                System.out.println("Que pena, a letra '" + chute + "' não existe na palavra."); 
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
                System.out.println("\nParabéns! Você conseguiu acertar a palavra: " + palavraSecreta);
            }
        }
        input.close();
    }
}