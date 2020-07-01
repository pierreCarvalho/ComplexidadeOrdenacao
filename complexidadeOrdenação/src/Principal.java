
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author pierr
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Ordenacao ord = new Ordenacao();
        ArrayList<Integer> lista = new ArrayList<Integer>();
        
        ord.popularLista(lista,40);
        ord.exibirLista(lista);
        ord.bolha(lista);
        ord.exibirLista(lista);
    }
    
}
