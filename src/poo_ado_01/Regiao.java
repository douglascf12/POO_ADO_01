package poo_ado_01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static jdk.nashorn.internal.objects.NativeRegExp.test;
import static poo_ado_01.Estado.lerPIB;

/**
 * Class Description...
 * 
 * @author Douglas Cardoso Ferreira
 * @version: 1.0
 * Main Class File: ADO_01.java
 * File: Regiao.java
 * Date: DD/MM/YYYY
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
    
    
    
    //System.out.println(test);
    
    
    
    public static boolean escreverEmArquivo(String arquivo) {

        try {
            FileWriter fw = new FileWriter(arquivo);
            //PrintWriter gravarArquivo = new PrintWriter(arquivo);
            ///gravarArquivo.println(texto);
            //gravarArquivo.close();
            return true;

        } catch(IOException ex) {
            System.out.println("Erro !");
            return false;
        }

    }
    
    public static List<Regiao> somaPIBPorRegiao(ArrayList<Regiao> regioes, String arquivoPIB, String arquivoRegioes) {
        
        int i = 0;
        int aux = 1;
        double soma = 0;
        double[] somaRegiao = new double[5];

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
                            break;
                        }
                    }

                    if (linha.isEmpty()) {//se a linha estiver vazia ele zera para calcular a proxima regiao
                        somaRegiao[i] = soma;
                        soma = 0;
                        i++;
                        aux = 1;
                    }
                    
                }
                
                
                
                if (aux == 1) {
                    aux = 0;
                } else if (linha != null) {
                    for (Estado estado : estados) {
                        if (linha.equals(estado.getNome())) {
                            soma += estado.getPIB();
                            break;
                        }
                    }

                    if (linha.isEmpty()) {//se a linha estiver vazia ele zera para calcular a proxima regiao
                        somaRegiao[i] = soma;
                        soma = 0;
                        i++;
                        aux = 1;
                    }
                } else {
                    somaRegiao[i] = soma;
                    soma = 0;
                    i++;
                    aux = 1;
                }
                linha = br.readLine();
            }
            br.close();

            return regioes;
            
        } catch (IOException e) {
            System.out.println("Erro ! , Não Foi Possivel Prosseguir");
            return null;
        }
    }

    
    
    
    
}
