import java.util.ArrayList;
import java.util.Random;

public class Ordenacao {

    public static void popularLista(ArrayList<Integer> lista, int qtd) {
        Random gerador = new Random();
        for (int i = 0; i < qtd; i++) {
            lista.add(gerador.nextInt(1000));
        }
    }

    public static void exibirLista(ArrayList<Integer> lista) {
        for (int i = 0; i < lista.size(); i++) {
            System.out.println("" + i + " - " + lista.get(i));
        }
    }

    public static void bolha(ArrayList<Integer> lista) {
        boolean houveTroca;
        int tmp = 0;

        do {
            houveTroca = false;
            for (int i = 0; i < lista.size() - 1; i++) {
                if (lista.get(i) > lista.get(i + 1)) {
                    tmp = lista.get(i);
                    lista.set(i, lista.get(i + 1));
                    lista.set(i + 1, tmp);
                    houveTroca = true;
                }
            }
        } while (houveTroca);
    }

    public static void selecao(ArrayList<Integer> lista) {
        int i, j, posMenor;
        int tmp = 0; //para as trocas

        for (i = 0; i < lista.size(); i++) {
            posMenor = i;
            for (j = i + 1; j < lista.size(); j++) {

                if (lista.get(j) < lista.get(posMenor)) {
                    posMenor = j;
                }
            }
            if (i != posMenor) {
                tmp = lista.get(i);
                lista.set(i, lista.get(posMenor));
                lista.set(i, tmp);
            }
        }
    }

    public static void insercao(ArrayList<Integer> lista) {
        int i, j;
        int tmp = 0; //para as trocas

        for (i = 1; i < lista.size(); i++) {
            tmp = lista.get(i);

            for (j = i - 1; j >= 0 && tmp < lista.get(j); j--) {
                lista.set(j + 1, lista.get(j));
            }
            lista.set(j + 1, tmp);
        }
    }

    public static void agitacao(ArrayList<Integer> lista) {
        int i, ini = 0, fim = lista.size();
        boolean houveTroca;
        int tmp = 0;

        do {
            //da esquerda para direita
            houveTroca = false; //marca que nao houveTroca
            for (i = 0; i < fim - 1; i++) {
                if (lista.get(i) > lista.get(i + 1)) {
                    tmp = lista.get(i);
                    lista.set(i, lista.get(i + 1));
                    lista.set(i + 1, tmp);
                    houveTroca = true;
                }
            }
            fim--;
            if (!houveTroca) {
                break;
            }

            //da direita para esquerda
            houveTroca = false; //marca que nao houveTroca
            for (i = fim; i > ini; i--) {
                if (lista.get(ini) < lista.get(i - 1)) {
                    tmp = lista.get(i);
                    lista.set(i, lista.get(i - 1));
                    lista.set(i - 1, tmp);
                    houveTroca = true;
                }
            }
            ini++;
        } while (houveTroca && ini <= fim);
    }

    public static void pente(ArrayList<Integer> lista) {
	int i, distancia = lista.size();
        boolean houveTroca;
        int tmp = 0;

        do {
            distancia /= 1.3;
            if (distancia < 1) {
                distancia = 1;
            }

            houveTroca = false; //marca que nao houveTroca
            for (i = 0; i + distancia < lista.size(); i++) {
                if (lista.get(i) > lista.get(i + distancia)) {
                    tmp = lista.get(i);
                    lista.set(i, lista.get(i + distancia));
                    lista.set(i + distancia, tmp);
                    houveTroca = true;
                }
            }
        } while (distancia != 1 || houveTroca);
    }
    
    public static void shell(ArrayList<Integer> lista) {
        int i, j, distancia = 1;
        do {
            distancia = distancia * 3 + 1;
        } while (distancia < lista.size());
        
        int tmp = 0; //para as trocas
        
        do {
            distancia = distancia / 3;
            for (i = distancia; i < lista.size(); i++) {
                tmp = lista.get(i);

                for (j = i - distancia; j >= 0 && tmp < lista.get(j); j--) {
                    lista.set(j + distancia, lista.get(j));
                }
                lista.set(j + distancia, tmp);
            }
        }while (distancia > 1);
    }
}
