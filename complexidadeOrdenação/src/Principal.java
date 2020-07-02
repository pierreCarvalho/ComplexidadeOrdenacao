
import java.util.ArrayList;
import java.util.Collections;
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
    
    static int NUMEXECUCOES=10;
    //vetores como atributos da classe
    int[] vetA, vetB, vetR;
    
    /**
     */
    
	
    /**
     * Retorna o número de instruções conforme o polinômio da complexidade
     * do método "somaVetores"
     * @param tamanho - (representa o N) é mesmo do método "somaVetores"
     * @return 2N+3
     */
    public static Long numInstrucoes(int tamanho,String escolha) {
        long valor = 0;
        if(escolha.equals("bolha")){
            //calcular o num de instruções do bolha
            valor = (7*(tamanho*tamanho)) + (9*(tamanho )) + 3;
            return valor ;
        }
        else if(escolha.equals("seleção")){
            valor = (2*(tamanho*tamanho))+ (8*tamanho) + 2 ;
            return valor;
        }
        else if(escolha.equals("shell")){
            valor = (3*(tamanho*tamanho*tamanho)) + (8*(tamanho*tamanho)) + (11*(tamanho)) + 9;
            return valor;
        }
        else if(escolha.equals("agitacao")){
            valor = (14*(tamanho*tamanho)) + (19*(tamanho)) + 8;
            return valor;
        }
        else if(escolha.equals("pente")){
            valor = (7*(tamanho*tamanho))+ (4*(tamanho)) + 13;
            return valor;
        }
        return valor;
    }
    
    public static void calcularComplexidade(String escolha){
        
        // TODO code application logic here
        Ordenacao ord = new Ordenacao();
        
        
        ArrayList<Long> listaMediaTempo = new ArrayList();
        ArrayList<Long> listanumInstrucoes = new ArrayList();
        ArrayList<Long> listamemoriaUtilizada = new ArrayList();
        
        //Vetor para armazenar o tempo de execução nas "NUMEXECUCOES" vezes
        long[] temposExecucao = new long[NUMEXECUCOES];
        int tamanhoVetores = 10;

        Runtime run = Runtime.getRuntime();
        //memória usada pelo processo atual
        long memoriaUsada = run.totalMemory();
        //Toda a memória disponível para a VM do Java
        long memoriaLivre = run.freeMemory();

        //dentro do for
        int x=0;
        long somaTempos=0;
        long memoriaUtilizada;
        for(int i = 100; i <= 500 ; i++){
            memoriaUsada = run.totalMemory();
            //Toda a memória disponível para a VM do Java
            memoriaLivre = run.freeMemory();
            
            ArrayList<Integer> lista = new ArrayList<Integer>();          
            ord.popularLista(lista,i);
            
            for(int exec=0;exec<NUMEXECUCOES;exec++) {
                long inicio = System.nanoTime();
                if(escolha.equals("bolha")){
                    ord.bolha(lista);
                }              
                long fim = System.nanoTime();
                long tempoExec = fim -inicio;
                temposExecucao[exec] = tempoExec;
            }

            memoriaUtilizada = memoriaUsada - memoriaLivre;                 
            while(x<temposExecucao.length) {
                somaTempos = somaTempos + temposExecucao[x];
                x++;
            }
            long mediaTempos = somaTempos / NUMEXECUCOES;
            listaMediaTempo.add(mediaTempos);
            listanumInstrucoes.add(numInstrucoes(i,escolha));
            listamemoriaUtilizada.add(memoriaUtilizada);
            x = 0;
            somaTempos=0;
            memoriaUtilizada = 0;
            memoriaUsada = 0;
            memoriaLivre = 0;
        }
        
        System.out.println("lista media do tempo do "+escolha);
        System.out.print("[");
        for (int i = 0; i < listaMediaTempo.size(); i++) {
            System.out.print(""+listaMediaTempo.get(i)+",");
        }
        System.out.println("]");
        
        System.out.println("lista numero instrucoes do "+escolha);
        System.out.print("[");
        for (int i = 0; i < listanumInstrucoes.size(); i++) {
            System.out.print(""+listanumInstrucoes.get(i)+",");
        }
        System.out.println("]");
        
        System.out.println("lista memoria utilizada do"+escolha);
        System.out.print("[");
        for (int i = 0; i < listamemoriaUtilizada.size(); i++) {
            System.out.print(""+listamemoriaUtilizada.get(i)+",");
        }
        System.out.print("]");
        System.out.println("---------------------------------------");
    }

    public static void main(String[] args) {
        
        
        calcularComplexidade("bolha");
        //calcularComplexidade("bolha");
        //calcularComplexidade("bolha");
        //calcularComplexidade("bolha");
        //calcularComplexidade("bolha");

    }
    
}
