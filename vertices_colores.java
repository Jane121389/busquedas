import java.io.*;
import java.util.Scanner;
class vertices_colores
{
    public static void main(String [] args)
    {
        String  colores[] ={
            "rojo   ", "verde  ", "azul   ", "amarillo", "morado ", "rosa   ", "naranja"
        };
        int     guarda_colores[]=new int[7]; //0-rojo,1-verde,2-azul,3-amarillo,4-morado,5-rosa,6-naranja
        int     matriz_vertices[][];         //matriz que contiene los vertices y sus adyacencias
        int     i =0, j=0;                   //indices
        int     aristas        =0;           //número de aristas del grafo
        int     numero_vertices=0;           //numero de vertices
        int     s              =0;
        int     indice_color   =0;
        Scanner sc             =new Scanner(System.in);
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
        s                    =0;
        matriz_vertices[0][0]=0; //el primer vertice tendrá el primer color
        for (i=0; i < 7; i++)    //inicializamos el vector que guarda si hay un color
            guarda_colores[i]=-1;
        for (i=1; i < numero_vertices; i++)      //recorre el arreglo matriz_vertices
        {
            for (j=0; j < numero_vertices; j++)
                if (matriz_vertices[i][j] != -1)     //nos indica que hay vertices adyacentes
                    if (matriz_vertices[j][j] != -1) //nos indica que tiene un color
                        guarda_colores[matriz_vertices[j][j]]=1;
            //nos dice que ese color esta ocupado
            for (int l=0; l < 7; l++)
                if (guarda_colores[l] == -1)   //si no esta marcado algún color del arreglo colocamos ese color al vertice
                {
                    indice_color=l; //guardamos el indice que nos indica el color
                    l           =7; //colocamos l=7 para salir del arreglo
                }
            for (int l=0; l < 7; l++) //inicializamos el vector que guarda si hay un color
                guarda_colores[l]=-1;
            //	System.out.println("s"+s-1+"ic"+indice_color);
            matriz_vertices[i][i]=indice_color; //asignamos en el vertice de la matriz el indice del color
            //	s++;
        }
        for (i=0; i < numero_vertices; i++)
            System.out.println("vertice " + (i + 1) + " " + colores[matriz_vertices[i][i]]);  //imprimimos en pantalla
    }
}