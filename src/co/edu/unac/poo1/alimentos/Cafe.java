package co.edu.unac.poo1.alimentos;import co.edu.unac.poo1.procesos.Madurado;public class Cafe extends Alimentos {    private String variedad;    private Integer altura;    private Integer edad;    public Cafe() {        super();    }    public Cafe(String nombre, Float tamaho, String sabor, Float precio, String serial, String variedad, Integer altura, Integer edad) {        super(nombre, tamaho, sabor, precio, serial);        this.variedad = variedad;        this.altura = altura;        this.edad = edad;    }    public String  getVariedad() {        return variedad;    }    public void setVariedad(String variedad) {        this.variedad = variedad;    }    public Integer getAltura() {        return altura;    }    public void setAltura(Integer altura) {        this.altura = altura;    }    public Integer getEdad() {        return edad;    }    public void setEdad(Integer edad) {        this.edad = edad;    }    public static Cafe procesarLineaArchivoPlano(String linea){        Cafe cafe = new Cafe();        String []lineaCafe = linea.split("\\|");        String []lineaTexto = lineaCafe[0].split("SERIAL:");        cafe.serial = lineaTexto[1];        lineaTexto = lineaCafe[1].split("NOMBRE:");        cafe.nombre = lineaTexto[1];        lineaTexto = lineaCafe[2].split("ALTURA:");        cafe.altura = Integer.valueOf(lineaTexto[1]);        lineaTexto = lineaCafe[3].split("EDAD:");        cafe.edad = Integer.valueOf(lineaTexto[1]);        lineaTexto = lineaCafe[4].split("VARIEDAD:");        cafe.variedad = lineaTexto[1];        lineaTexto = lineaCafe[5].split("SABOR:");        cafe.sabor = lineaTexto[1];        lineaTexto = lineaCafe[6].split("TAMAÑO:");        cafe.tamaho = Float.valueOf(lineaTexto[1]);        return cafe;    }    @Override    public String toString() {        return   "NOMBRE='" + nombre + '\'' +                ", SERIAL='" + serial + '\'' +                ", ALTURA=" + altura +                ", EDAD=" + edad +                ", VARIEDAD='" + variedad + '\'' +                ", TAMAHO=" + tamaho +                ", SABOR='" + sabor + '\'' ;    }    @Override    public boolean tostar() {        return false;    }    @Override    public String getSerialProductos() {        return this.serial;    }    @Override    public boolean hornear() {        return false;    }    @Override    public void verInformacion(){        System.out.println("-----------------------");        System.out.println("Nombre Cafe: " + this.nombre);        System.out.println("precio Cafe: " + this.precio);        System.out.println(" Serial Cafe: " + this.serial);        System.out.println("-----------------------");    }}