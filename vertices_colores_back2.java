import java.io.*;
import java.util.Scanner;
class vertices_colores_back2
{
    static int numero_vertices=0;    //numero de vertices
    static int matriz_vertices[][];  //matriz que contiene los vertices y sus adyacencias
    static Pila color=new Pila();
    public static void main(String [] args)
    {
        String  colores[] ={
            "rojo   ", "verde  ", "azul   ", "amarillo", "morado ", "rosa   ", "naranja"
        };
        int     i =0, j=0;           //indices
        int     aristas     =0;      //número de aristas del grafo
        int     s           =0;
        int     indice_color=0;
        Scanner sc          =new Scanner(System.in);
        System.out.println("¿Cuantos vértices tiene su grafo?");    //Imprime en pantalla
        numero_vertices=sc.nextInt();
        matriz_vertices=new int[numero_vertices][numero_vertices];  //define el número de elementos de la matriz vectores
        System.out.println("Escriba un 1 si los vertices estan relacionados mediante una arista de caso contrario escriba -1:");
        for (i=0; i < numero_vertices; i++)      //recorre el arreglo matriz_vertices
        {
            matriz_vertices[s][s]=-1;
            s++;
            for (j=s; j < numero_vertices; j++)
            {
                System.out.println("Vértice " + (i + 1) + " vértice " + (j + 1)); //Imprime en pantalla
                aristas              =sc.nextInt();                               //-1 no hay arista, 1 si hay arista
                matriz_vertices[i][j]=aristas;
                matriz_vertices[j][i]=aristas;
            }
        }
        s                    =1;
        matriz_vertices[0][0]=0;
        for (i=1; i < numero_vertices; i++)      //recorre el arreglo matriz_vertices
        {
            color.push(6); //color
            color.push(5); //color
            color.push(4); //color
            color.push(3); //color
            color.push(2); //color
            color.push(1); //color
            color.push(0); //color
            indice_color         =verifica(color.actual(), i);
            matriz_vertices[i][i]=indice_color;
        }
        for (i=0; i < numero_vertices; i++)
            System.out.println("vertice " + (i + 1) + " " + colores[matriz_vertices[i][i]]);  //imprimimos en pantalla
    }

    static int verifica(int indice_color, int i)
    {
        for (int j=0; j < numero_vertices; j++)
            if (matriz_vertices[i][j] != -1 && i != j) //nos indica que hay vertices adyacentes

                if (matriz_vertices[j][j] == indice_color)  //nos indica que tiene un color
                    indice_color=verifica(color.pop(), i);

        return indice_color;
    }
}
class Pila  //Clase que simula una pila
{
    int indice;                  //índice del arreglo
    int arreglo[]=new int[1000]; //arreglo de enteros
    public Pila()
    {
        indice=0;   //indice del arreglo de la pila
    }

    public int pop() //elimina un elemento de la pila
    {
        indice--;               //decrementa el indice en uno
        int regresa=arreglo[1]; //toma el valor del elemento actual
        if (indice < 0)         //si no hay mas elementos en la pila devuelve -1
            return -1;
        for (int k=0; k < indice; k++) //recorre el arreglo
            arreglo[k]=arreglo[k + 1];
        return regresa; //regresa el elemento actual (después del eliminado)
    }

    public int actual() //da el elemento actual de la pila
    {
        return arreglo[0];
    }

    public void push(int numero)    //introduce un elemento a la pila
    {
        for (int k=indice; k > 0; k--) //recorre la pila
            arreglo[k]=arreglo[k - 1];
        arreglo[0]=numero;
        indice++;
    }

    public void imprime_pila()  //imprime la pila en pantalla
    {
        System.out.println("");
        for (int k=0; k < indice; k++)
            System.out.print(arreglo[k]);
    }
}
