package ADO_01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import static ADO_01.Estado.lerPIB;

/**
 * Class Description...
 * 
 * @author Douglas Cardoso Ferreira
 * @version: 1.0
 * Main Class File: ADO_01.java
 * File: Regiao.java
 * Date: 03/09/2020
 */
public class Regiao {
    
    String nome;
    double pib;
    
    public Regiao(String nome, Double pib) {
        this.nome = nome;
        this.pib = pib;
    }
    
    public Regiao() {
        this.nome = "";
        this.pib = 0.0;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setPIB(double pib) {
        this.pib = pib;
    }
    
    public double getPIB() {
        return pib;
    }
    
    public static List<Regiao> somaPIBPorRegiao(ArrayList<Regiao> regioes, String arquivoPIB, String arquivoRegioes) {
        
        Regiao norte = new Regiao("Norte", 0.0);
        Regiao nordeste = new Regiao("Nordeste", 0.0);
        Regiao sudeste = new Regiao("Sudeste", 0.0);
        Regiao sul = new Regiao("Sul", 0.0);
        Regiao centroOeste = new Regiao("Centro-Oeste", 0.0);
        regioes.add(norte);
        regioes.add(nordeste);
        regioes.add(sudeste);
        regioes.add(sul);
        regioes.add(centroOeste);
        
        int i = 0;

        try {
            FileReader fr = new FileReader(arquivoRegioes);
            BufferedReader br = new BufferedReader(fr);
            List<Estado> estados = lerPIB(arquivoPIB);
            String linha = br.readLine();

            while(linha != null || i < regioes.size()) {
                if(linha != null) {
                    for(Estado estado : estados) {
                        if (linha.equals(estado.getNome())) {
                            regioes.get(i).pib += estado.getPIB();
                        }
                    }
                    if(linha.isEmpty()) {// verifico se a linha está vazia e pulo para próxima região
                        i++;
                    }
                } else {
                    i++;
                }
                linha = br.readLine();
            } 
            br.close();
        } catch (IOException e) {
            System.out.println("Erro na leitura do arquivo");
        }
        return regioes;
    }
    
    public static boolean escreverArquivo(ArrayList<Regiao> regioes, String arquivoSaida) {
        
        DecimalFormat df = new DecimalFormat("#.##");
        
        try {
            FileWriter fw = new FileWriter(arquivoSaida);
            BufferedWriter bw = new BufferedWriter(fw);
            
            for(Regiao regiao : regioes) {
                bw.write(regiao.nome + ": " + df.format(regiao.pib));
                bw.newLine();
            }
            
            // feche o arquivo
            bw.close();
            return true;
        } catch(IOException ex) {
            System.out.println("Erro lendo o arquivo '" + arquivoSaida + "'");
            return false;
        }
    }

}
