package lio;
import java.util.Random;

public class gerarAleatorio {

    String letras = "0123456789";
    int i;
   
    String gerarNumero(int tamanho){
        Random random = new Random();
        String armazenaChaves = "";
        int index = -1;
            for(i = 0; i < tamanho; i++ ) {
                index = random.nextInt( letras.length() );
                armazenaChaves += letras.substring( index, index + 1 );
            }
       return armazenaChaves;
    }

}
