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
public class Skill implements Serializable{
    private String nombre;
    private float efectividad;
    private int PP;
    private float daño;
    
    public Skill(String nombre, float efectividad, int PP, float daño){
        this.nombre=nombre;
        this.efectividad=efectividad;
        this.PP=PP;
        this.daño=daño;
       
    }
    

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the efectividad
     */
    public float getEfectividad() {
        return efectividad;
    }

    /**
     * @param efectividad the efectividad to set
     */
    public void setEfectividad(float efectividad) {
        this.efectividad = efectividad;
    }

    /**
     * @return the PP
     */
    public int getPP() {
        return PP;
    }

    /**
     * @param PP the PP to set
     */
    public void setPP(int PP) {
        this.PP = PP;
    }

    /**
     * @return the daño
     */
    public float getDaño() {
        return daño;
    }

    /**
     * @param daño the daño to set
     */
    public void setDaño(int daño) {
        this.daño = daño;
    }
    
    public boolean lePega(float pre, float eva){
        boolean flag=false;
        float pivot= efectividad+(pre/100)-(eva/100);
        int n=RandomData.getEnteroEntre(0, 100);
        if (n<=pivot)
            flag=true;
        return flag;
    }
    
    public String toString(){
        StringBuilder SB= new StringBuilder(nombre);
        SB.append("\tDaño: ");
        SB.append(daño);
        SB.append("\tEfectividad: ");
        SB.append(efectividad);
        SB.append("\tPP: ");
        SB.append(PP);
        return SB.toString();
        
    }
   
    
}
