package poo_ado_01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
    
    Regiao(Double pib) {
        //this.getNome();
        this.pib = pib;
    }
    
    //public static List<Estado> estadoPorRegiao(String arquivo) {
    //}
    
    
    
}
