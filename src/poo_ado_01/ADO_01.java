package poo_ado_01;

import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import static poo_ado_01.Estado.lerPIB;

/**
 * Class Description...
 * 
 * @author Douglas Cardoso Ferreira
 * @version: 1.0
 * Main Class File: ADO_01.java
 * File: ADO_01.java
 * Date: DD/MM/YYYY
 */
public class ADO_01 {
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("0.00");
        
        // nome do arquivo
        String pib = "pib.txt";
        String regioes = "regioes.txt";
        
        List<Estado> estados = lerPIB(pib);
        
        for(Estado estado : estados) {
            Estado.percentual(estados);
            System.out.println(estado.nome + ": " + df.format(estado.pib) + "%");
        }
        
        
/*      ------------------------------------- */
/*      Exemplo de escrita em arquivo         */
/*      ------------------------------------- */

        String arquivoDeSaida = "saida.txt";
        
        try {
            
            FileWriter fileWriter = new FileWriter(arquivoDeSaida);
            
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            
            bufferedWriter.write("pib da região x = $$$$");
            bufferedWriter.newLine();
            bufferedWriter.write("pib da região Y = $$$$");
            
            // feche o arquivo
            bufferedWriter.close();
        } catch(IOException ex) {
            System.out.println("Erro lendo o arquivo '" + arquivoDeSaida + "'");
        }
    }
    
}
