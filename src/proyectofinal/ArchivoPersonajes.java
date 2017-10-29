/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal;

import java.io.*;

/**
 *
 * @author Marcos J. Peña Pollastri "Markuz Cífer"
 *          Stefano Tagliaferri
 */
public class ArchivoPersonajes 
{
    private FileOutputStream FO;
    private ObjectOutputStream OO;
    private FileInputStream FI;
    private ObjectInputStream OI;
    
    public ArchivoPersonajes()
    {
        
    }
    
    public boolean ExportarLista(ListadePersonajes LP)
    
        
    {
        /*boolean flag = true;
        Personaje Aux;
        try
        {
            FO = new FileOutputStream ("personajes.dat");
            OO = new ObjectOutputStream (FO);                                     
            for(int i = 0; i<LP.getTamaño()-1; i++)
            {
                Aux = LP.getPersonajePorNumero(i);
                OO.writeObject(Aux);                             
            }
            FO.close();
            OO.close();
        }
        catch(Exception E)
        {
            flag = false;
            System.out.println(E.toString());
        }
        return flag; */
        
        boolean flag = true;
        try{
        FO = new FileOutputStream ("personajes.dat");
        OO = new ObjectOutputStream (FO);   
        OO.writeObject(LP);
        OO.close();
        }
        catch(Exception E){
            flag=false;
        }
        
        return flag;
    }
    
    public ListadePersonajes ImportarLista()
    {
        Personaje Aux;
        ListadePersonajes AuxLP= new ListadePersonajes();;
        try
        {
            FI = new FileInputStream("personajes.dat");
            OI = new ObjectInputStream(FI);

            
           /* while(true)
            {
               Aux = (Personaje) OI.readObject();
               AuxLP.agregarPersonaje(Aux);
            }
            * */
            
            AuxLP=(ListadePersonajes)OI.readObject();
        }
        catch(Exception E)
        {
            
        }
        return AuxLP;
    }
            
    
    
}
