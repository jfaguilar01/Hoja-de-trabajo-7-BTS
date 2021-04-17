/**
 * @author Javier Aguilar 
 * @version 12/04/21
 */



public class Association implements Comparable< Association>{

    String ingles;
    String frances;
    String español;
    String unico;

    public Association(String e, String s, String f){
        ingles=e;frances=f;español=s;
    }

    public Association(String u){
        unico = u;
    }

    public String getWord(String k){
        if(unico == null) {
            if (k.equals("ingles")) {
                return ingles;
            } else if (k.equals("frances")) {
                return frances;
            } else if (k.equals("español")) {
                return español;
            } else return null;
        } else {
            return unico;
        }
    }

    @Override
    public int compareTo( Association o) {
        if(o.getunico() == null){
            return getWord(Main.Idioma).compareTo(o.getWord(Main.Idioma));
        } else {
            return getWord(Main.Idioma).compareTo(o.getunico());
        }

    }

    public String getunico(){
        return unico;
    }

    @Override
    public String toString() {
        return "( " +
                ingles + ", " +
                frances + ", " +
                español+
                " )\n";
    }
}
