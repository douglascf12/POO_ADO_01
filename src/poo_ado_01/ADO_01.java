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
        
        ArrayList<Regiao> regiao = new ArrayList<Regiao>();
        
        Regiao norte = new Regiao("Norte", 0.0);
        Regiao nordeste = new Regiao("Nordeste", 0.0);
        Regiao sudeste = new Regiao("Sudeste", 0.0);
        Regiao sul = new Regiao("Sul", 0.0);
        Regiao centroOeste = new Regiao("Centro-Oeste", 0.0);
        regiao.add(norte);
        regiao.add(nordeste);
        regiao.add(sudeste);
        regiao.add(sul);
        regiao.add(centroOeste);
        
        Regiao.somaPIBPorRegiao(regiao, pib, regioes);
        
        for(Regiao regiao1 : regiao) {
            //Estado.percentual(estados);
            System.out.println(regiao1.nome + ": " + df.format(regiao1.pib));
        }
        
        
        //System.out.println(regiao.size());
        
        
        //Regiao nome1 = new Regiao("Norte", 0.0);
        //test.add(nome1);
        
        System.out.println(regiao.get(0).nome);
        System.out.println(regiao.get(0).pib);
        
        
        
        
        
        
        
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
