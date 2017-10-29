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
public class Personaje implements Serializable{
    private float HP;
    private float ATQ;
    private float DEF;
    private float PRE;
    private float EVA;
    private String nombre;
    private Skill vectorSkills[];
    private int posicionSkillUtilizado;
    
    public Personaje(){
        HP=0;
        ATQ=0;
        DEF=0;
        PRE=0;
        EVA=0;
        nombre="";
        vectorSkills= new Skill [3];
        posicionSkillUtilizado=0;

        
    }
    
    public Personaje(float HP, float ATQ, float DEF, 
            float EVA, float PRE, String nombre, 
            Skill S1, Skill S2, Skill S3){
        this.HP=HP;
        this.ATQ=ATQ;
        this.DEF=DEF;
        this.PRE=PRE;
        this.EVA=EVA;
        this.nombre=nombre;
        vectorSkills= new Skill [3];
        vectorSkills[0]=S1;
        vectorSkills[1]=S2;
        vectorSkills[2]=S3;
        posicionSkillUtilizado=0;
        
    }
    //metodo que realiza un ataque, pasa por parametro def y eva enemiga
    // y devuelve el HP infligido al enemigo.
    public float realizarAtaque(float def, float eva){
        
        int n=RandomData.getEnteroEntre(0, 2);
        Skill S=vectorSkills[n];
        float dañoRealizado;
        if (S.getPP()>0){
            float daño=S.getDaño();
            dañoRealizado= daño+(daño/100*ATQ)-(daño/100*def);
            if (dañoRealizado < 0)
                dañoRealizado=0;
            if (S.lePega(PRE, eva)== false)
                dañoRealizado= 0;
            posicionSkillUtilizado=n;
            
        }
        else{
           
            float daño=vectorSkills[0].getDaño();
            dañoRealizado= daño+(daño/100*ATQ)-(daño/100*def);
            if (dañoRealizado < 0)
                dañoRealizado=0;
            if (vectorSkills[0].lePega(PRE, eva)== false)
                dañoRealizado= 0;
            posicionSkillUtilizado=0;
        }
        
            
        return dañoRealizado;
       
        
        
    }
    
    
    
    public boolean estaMuerto(){
        boolean flag=false;
        if (HP<=0)
            flag=true;
        return flag;
    }

    /**
     * @return the HP
     */
    public float getHP() {
        return HP;
    }

    /**
     * @param HP the HP to set
     */
    public void setHP(float HP) {
        this.HP = HP;
    }

    /**
     * @return the ATQ
     */
    public float getATQ() {
        return ATQ;
    }

    
    

    /**
     * @return the DEF
     */
    public float getDEF() {
        return DEF;
    }


    /**
     * @return the PRE
     */
    public float getPRE() {
        return PRE;
    }


    /**
     * @return the EVA
     */
    public float getEVA() {
        return EVA;
    }



    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }
    public Skill getSkill(int n){
        if (n>2)
            n=2;
        if (n<0)
            n=0;
        return vectorSkills[n];
    }

    public String toString(){ 
        
        
        StringBuilder SB= new StringBuilder("Nombre: ");
        SB.append(nombre);
        SB.append("\tHP: ");
        SB.append(HP);
        SB.append("\tAtaque: ");
        SB.append(ATQ);
        SB.append("\tDefensa: ");
        SB.append(DEF);
        SB.append("\tPresición: ");
        SB.append(PRE);
        SB.append("\tEvación: ");
        SB.append(EVA);
        for (int i=0; i<vectorSkills.length; i++){
            SB.append("\n");
            SB.append(vectorSkills[i].toString());

        }
        
        return SB.toString();
                
        
    }
    
    public int getPosicionSkillUtilizada(){
        return posicionSkillUtilizado;
    }
    
  
}
