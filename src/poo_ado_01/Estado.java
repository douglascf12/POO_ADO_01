package poo_ado_01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Class Description...
 * 
 * @author Douglas Cardoso Ferreira
 * @version: 1.0
 * Main Class File: ADO_01.java
 * File: Estado.java
 * Date: 03/09/2020
 */
public class Estado {
    
    
    
    String nome;
    double pib;
    
    public Estado(String nome, Double pib) {
        this.nome = nome;
        this.pib = pib;
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
    
    public static List<Estado> lerPIB(String arquivo) {
        
        List<Estado> estados = new ArrayList<>();
        // linha temporaria
        String linha = null;
        
        // Abertura do arquivo e loop de leitura
        try {
            FileReader fr = new FileReader(arquivo);
            BufferedReader br = new BufferedReader(fr);
            
            // loop por cada linha do arquivo
            while((linha = br.readLine()) != null) {
                String[] estadoEPib = linha.split(";");
                String nome = estadoEPib[0];
                Double pib = Double.parseDouble(estadoEPib[1]);
                Estado estado = new Estado(nome, pib);
                estados.add(estado);
            }
            br.close();
        } catch(IOException ex) {
            System.out.println("Erro na leitura do arquivo '" + arquivo + "'");
        }
        return estados;
    }
    
    public static double totalPIB(List<Estado> estados) {
        double totalPIB = 0;
        for(Estado estado : estados) {
            totalPIB += estado.getPIB();
        }
        return totalPIB;
    }
    
    public static List<Estado> percentual(List<Estado> estados) {
        double totalPIB = totalPIB(estados);
        for(Estado estado: estados) {
            Double porcetagem = (estado.getPIB() / totalPIB) * 100;
            estado.setPIB(porcetagem);
        }
        return estados;
    }
    
    public static void imprime(List<Estado> estados) {
        
        DecimalFormat df = new DecimalFormat("0.00");
        
        // é chamado o método que faz a soma dos percentuais de cada estados
        Estado.percentual(estados);
        
        // for para correr cada estado do array e imprimir
        for(Estado estado : estados) {
            System.out.println(estado.nome + ": " + df.format(estado.pib) + "%");
        }
    }
    
}
