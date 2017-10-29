
package proyectofinal;

/*
 * Clase para generar información aleatoria
 * Similar a clase In , tiene métodos estáticos, los que se pueden usar
 * hacoendo referencia al nombre de la clase, sin necesidad de instanciar
 * un objeto de clase RandomData
 */

public class RandomData
{
    private static String NombresH[] = {"Juan", "José", "Pablo", "Marcelo", "Mario", "Pedro", "Fabián", "Marcos", "Julio", "Roberto"};
    private static String NombresM[] = {"María", "Silvana", "Mónica", "Natalia", "Valentina", "Cecilia", "Sofía", "Eugenia", "Florencia", "Bárbara"};
    private static String Apellidos[] = {"Pérez", "Rodriguez", "López", "Marquez", "Rivadero", "Maldonado", "Alvarez", "Navas", "Zanin", "Bratti"};
    private static String Articulos[] = {"Cinta", "Pinza", "Tenaza", "Alicate", "Clavos", "Cable", "Llave", "Ruleta", "Nivel", "Calibre"};

    public RandomData() {}
    
    public static String getNombreMujer()
    {
        int pos = (int)(Math.random()*10);
        return NombresM[pos];
    }

    public static String getNombreHombre()
    {
        int pos = (int)(Math.random()*10);
        return NombresH[pos];
    }

    public static String getNombre()
    {
        int n = (int)(Math.random()*2);
        if (n==0)
            return getNombreMujer();
        else
            return getNombreHombre();
    }

    public static String getApellido()
    {
        int pos = (int)(Math.random()*10);
        return Apellidos[pos];
    }

    public static String getNombreCompletoMujer()
    {
        return (getApellido() + ", " + getNombreMujer());
    }

    public static String getNombreCompletoHombre()
    {
        return (getApellido() + ", " + getNombreHombre());
    }

    public static String getNombreCompleto()
    {
        int n = (int)(Math.random()*2);
        if (n==0)
            return getNombreCompletoMujer();
        else
            return getNombreCompletoHombre();
    }

    public static float getRandom()
    {
        float n;
        n = (float) Math.random();
        return n;
    }

    public static int getEnteroEntre(int desde, int hasta)
    {
        int aux;
        if (desde > hasta)
        {
            aux = desde;
            desde = hasta;
            hasta = aux;
        }
        int n;
        n = (int) (Math.random()*((hasta+1)-desde)+desde);
        return n;
    }

    public static String getArticulo()
    {
        int pos = (int)(Math.random()*10);
        return Articulos[pos];
    }

}
