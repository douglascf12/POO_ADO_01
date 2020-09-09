package ADO_01;

import java.util.ArrayList;
import java.util.List;
import static ADO_01.Estado.lerPIB;

/*
Deseja-se um aplicativo capaz de tomar os dados em um arquivo de textocontendo os PIBs 
por estado do Brasil (pib.txt) carregá-los na memória e executaros seguintes itens:

a) Imprimir na tela a lista de PIB por estado em percentual em relação ao total.
b) Gerar um arquivo de saída (saida.txt) sumarizando (somando) o PIB porregiões.
Será fornecida uma lista de estados por regiões que deve ser lida do arquivo regioes.txt
*/

/**
 * Class Description...
 * 
 * @author Douglas Cardoso Ferreira
 * @version: 1.0
 * Main Class File: ADO_01.java
 * File: ADO_01.java
 * Date: 03/09/2020
 */
public class ADO_01 {
    
    public static void main(String[] args) {
        // nome dos arquivos
        String arquivoPIB = "pib.txt";
        String arquivoRegioes = "regioes.txt";
        String arquivoSaida = "saida.txt";
        
        // array de "estados" criados e chamado método que lê linha por linha e salva 
        // cada linha com um objeto dentro de cada elemento do array "estados"
        List<Estado> estados = lerPIB(arquivoPIB);
        
        // método que imprime os estados
        Estado.imprime(estados);
        
        // array de regiao criado
        ArrayList<Regiao> regioes = new ArrayList<Regiao>();
        
        // método soma o PIB de cada região de acordo com seu respectivo estado
        Regiao.somaPIBPorRegiao(regioes, arquivoPIB, arquivoRegioes);
        
        // método que escreve o PIB de cada região em um arquivo txt
        Regiao.escreverArquivo(regioes, arquivoSaida);
    }
 
}