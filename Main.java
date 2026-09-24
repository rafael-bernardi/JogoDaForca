package JogoDaForca;

import java.util.Scanner;   
import java.util.Random;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random aleatorio = new Random();

        String[] frutas = {"ABACATE", "GOIABA", "BANANA", "UVA", "MANGA"};
        String[] paises = {"BRASIL", "ARGENTINA", "CHILE", "COLOMBIA", "PERU"};
        String[] animais = {"CACHORRO", "GATO", "PORCO", "VACA", "CAVALO", "OVELHA"};
        String[] cores = {"VERMELHO", "AZUL", "AMARELO", "VERDE", "ROXO", "LARANJA"};

        System.out.println("=== JOGO DA FORCA ===");
        System.out.println("Escolha uma categoria:");
        System.out.println("1 - Frutas");
        System.out.println("2 - Países");
        System.out.println("3 - Animais");
        System.out.println("4 - Cores");
        System.out.println("Opção: ");

        int opcao = 0;
        String[] categoriaEscolhida = null;
        String nomeCategoria = "";

        while(categoriaEscolhida == null){
            if(input.hasNextInt()){
                opcao = input.nextInt();
                input.nextLine(); 

                switch(opcao){
                    case 1:
                        categoriaEscolhida = frutas;
                        nomeCategoria = "Frutas";
                        break;
                    case 2:
                        categoriaEscolhida = paises;
                        nomeCategoria = "Países";
                        break;
                    case 3:
                        categoriaEscolhida = animais;
                        nomeCategoria = "Animais";
                        break;
                    case 4:
                        categoriaEscolhida = cores;
                        nomeCategoria = "Cores";
                        break;
                    default:
                        System.out.println("Opção inválida. Escolha novamente: ");
                }
            }
        }

        int indiceSorteado = aleatorio.nextInt(categoriaEscolhida.length);
        String palavraSecreta = categoriaEscolhida[indiceSorteado];

        char[] palavraOculta = new char[palavraSecreta.length()];
        for(int i = 0; i < palavraOculta.length; i++){
            palavraOculta[i] = '_';
        }

        ArrayList<Character> letrasTentadas = new ArrayList<>();

        int erros = 0;
        final int MAX_ERROS = 5;
        boolean acertou = false;

        

        while(!acertou && erros < MAX_ERROS){
            desenharForca(erros);

            System.out.print("\nPalavra: ");
            for (char letra : palavraOculta){
                System.out.print(letra + " "); 
            }
            System.out.println();

            System.out.println("Letras tentadas: " + letrasTentadas);

            System.out.print("Qual o seu chute? ");
            String entrada = input.nextLine().trim().toUpperCase();

            if(entrada.isEmpty()){
                System.out.println("Entrada inválida. Por favor, digite uma letra.");
                continue;
            }

            char chute = entrada.charAt(0);

            if(letrasTentadas.contains(chute)){
                System.out.println("-- Você já tentou a letra: '" +  chute + "'. Tente outra Letra. ");
                continue;
            }

            letrasTentadas.add(chute);

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