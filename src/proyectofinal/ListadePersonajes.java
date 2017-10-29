/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal;
import java.util.*;
import java.io.*;
/**
 *
 * @author Marcos J. Peña Pollastri "Markuz Cífer"
 *          Stefano Tagliaferri
 */
public class ListadePersonajes implements Serializable{
    private LinkedList<Personaje> ListaPersonajes;
    
    public ListadePersonajes(){
        ListaPersonajes = new LinkedList<Personaje>();
    }
    public void agregarPersonaje(Personaje P){
        ListaPersonajes.add(P);
    }
    public void eliminarPersonajePorNombre(String nombre){
        Iterator I = ListaPersonajes.iterator();
        Personaje aux = null;
        while(I.hasNext()){
            aux=(Personaje) I.next();
            if (aux.getNombre().equalsIgnoreCase(nombre))
                I.remove();
        }
    }
    public Personaje getPersonajePorNombre(String nombre){
         Iterator I = ListaPersonajes.iterator();
        Personaje aux = null;
        Personaje aux2=null;
        while(I.hasNext()){
            aux=(Personaje) I.next();
            if (aux.getNombre().equalsIgnoreCase(nombre))
                aux2=aux;
        
        }
        
        return aux2;
    
    }
    
    public Personaje getPersonajePorNumero(int n){ //retorna el personaje en el numero del orden q se pasa por parametro, suponiendo que el primer elemento es "0"
         Iterator I = ListaPersonajes.iterator();
        Personaje aux = new Personaje();
        int pivot=0;
        while(pivot<=n){
            aux=(Personaje) I.next();
            pivot++;
        
        }
        
        return aux;
    
    }
    
    public int getTamaño(){
        return ListaPersonajes.size();
    }
    
    public String toString(){
        Iterator I= ListaPersonajes.iterator();
        Personaje aux;
        StringBuilder SB= new StringBuilder("");
        while(I.hasNext()){
            aux=(Personaje) I.next();
            SB.append(aux.toString());
            SB.append("\n \n");
        }
        
        return SB.toString();
        
    }
    
    public int contadorPersonajesVivos(){
        int contador=ListaPersonajes.size();
        Iterator I= ListaPersonajes.iterator();
        Personaje aux;
        while(I.hasNext()){
            aux=(Personaje)I.next();
            if(aux.estaMuerto())
                contador--;
        }
        return contador;
    }
    
    public void borrarLista(){
        ListaPersonajes.removeAll(ListaPersonajes);
    }
    
 
    
}