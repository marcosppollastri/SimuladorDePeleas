/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal;

/**
 *
 * @author Marcos J. Peña Pollastri "Markuz Cífer"
 *          Stefano Tagliaferri
 */
public class Batalla {
    private ListadePersonajes LP ;
    
    public Batalla(){
        LP=new ListadePersonajes();
        
    }
    
    public Batalla(ListadePersonajes Lista){
        LP=new ListadePersonajes();
        int tamaño = Lista.getTamaño();
        for (int i=0; i< tamaño; i++)
            LP.agregarPersonaje(Lista.getPersonajePorNumero(i));
    }
    
    public String desarrolloBatalla(){
        
        StringBuilder SB=new StringBuilder("");
        Personaje P1=new Personaje();
        Personaje P2=new Personaje();

        while(LP.contadorPersonajesVivos()>1){
        
            int n= RandomData.getEnteroEntre(0, LP.getTamaño()-1);
            int n2;
            do
                n2=RandomData.getEnteroEntre(0, LP.getTamaño()-1);
            while (n==n2);
            P1=LP.getPersonajePorNumero(n);
            P2=LP.getPersonajePorNumero(n2);
        
            float viejoHP=P2.getHP();
            float nuevoHP, HPreducido;
            HPreducido = P1.realizarAtaque(P2.getDEF(), P2.getEVA());
            nuevoHP= viejoHP-HPreducido;
            P2.setHP(nuevoHP);
        
        
            SB.append("\n");
            SB.append(P1.getNombre());
            SB.append(" Ataca a ");
            SB.append(P2.getNombre());
            SB.append(" con ");
            SB.append(P1.getSkill(P1.getPosicionSkillUtilizada()).getNombre());
            SB.append("\n");
            SB.append(viejoHP);
            SB.append("HP -----> ");
            SB.append(nuevoHP);
            SB.append("HP \nDaño realizado: ");
            SB.append(HPreducido);
            
            if(HPreducido==0)
                SB.append("\nEl ataque ha fallado.");
            
            if(P2.estaMuerto()==true){
                SB.append("\n");
                SB.append(P2.getNombre());
                SB.append(" ha muerto.");
        }
            
          
    }
    
    return SB.toString();
}
    
}
