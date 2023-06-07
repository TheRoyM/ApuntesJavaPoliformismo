package co.edu.unac.poo1.Unidad2;import co.edu.unac.poo1.alimentos.Arepa;import co.edu.unac.poo1.alimentos.Cafe;import co.edu.unac.poo1.alimentos.Mazorca;import co.edu.unac.poo1.alimentos.PandeBono;import co.edu.unac.poo1.procesos.Madurado;import java.io.IOException;import java.nio.file.Files;import java.nio.file.Path;import java.nio.file.Paths;import java.util.*;import java.util.stream.Stream;public class Unidad2 {    private static final String RUTA_ARCHIVO_CAFES = "C:\\Users\\RoyMR\\Documents\\FinalPooPractica\\src\\co\\edu\\unac\\poo1\\alimentos\\cafe.txt";    //PUNTO 1-------------    //Mostrar archivo plano y ordeno por Serial    public static void mostrarDatosPlano(){        List<Cafe> listadeCafes = leerArchivoPlanoCafes();        listadeCafes.sort(Comparator.comparing(Cafe::getSerial));        for (Cafe cafe: listadeCafes){            System.out.println(cafe);        }    }    //Archivo plano    public static List<Cafe> leerArchivoPlanoCafes() {        Stream<String> lines = null;        Path pathArchvioPlano = Paths.get(RUTA_ARCHIVO_CAFES);        ArrayList<Cafe> listaCafes = new ArrayList<>();        try {            lines = Files.lines(pathArchvioPlano);            List<String> datos = lines.toList();            for (String dato : datos) {                Cafe nuevoCafe = Cafe.procesarLineaArchivoPlano(dato);                listaCafes.add(nuevoCafe);            }        } catch (IOException ioex){            System.err.println("Error de IO al leer el archivo plano " + ioex.getMessage());        } finally {            assert lines != null;            lines.close();        }        return listaCafes;    }    //PUNTO NUMERO 3    public static void mapaProductos(){        Map<String, Madurado> mapaDeProductos = new HashMap<>();        //PandeBono pandeBono1 = new PandeBono("Rollo",45F, Sabor.Dulce,89,true);        PandeBono pandeBono1 = new PandeBono("Cascarita",45F,"Dulce",452F,"q1",55,"Cafecito");        PandeBono pandeBono2 = new PandeBono("Rollo",45F,"Salado",4872F,"q2",85,"Crema");        Cafe cafe1 = new Cafe("Sello Rojo",55F,"Estandar",458F,"w1","Arabiga",55,5);        Cafe cafe2 = new Cafe("ColCafe",55F,"Dulce",418F,"w2","Bourbon",51,2);        Mazorca mazorca1 = new Mazorca("Kello",45f,"Dulce",458F,"e1",100,789F,"Blanco");        Mazorca mazorca2 = new Mazorca("Blando",55f,"Dulce",488F,"e2",800,650F,"Morado");        Arepa arepa = new Arepa("Chocolo",45F,"Salada",5670f,"t1","Maiz y queso");        Arepa arepa2 = new Arepa("Paisa",45F,"Salada",70f,"t2",null);        mapaDeProductos.put(pandeBono1.getNombre(), pandeBono1);        mapaDeProductos.put(pandeBono2.getNombre(), pandeBono2);        mapaDeProductos.put(cafe1.getNombre(), cafe1);        mapaDeProductos.put(cafe2.getNombre(), cafe2);        mapaDeProductos.put(mazorca1.getNombre(), mazorca1);        mapaDeProductos.put(mazorca2.getNombre(), mazorca2);        List<Madurado> listaMadurado = new LinkedList<>(mapaDeProductos.values());        listaMadurado.sort(Comparator.comparing(Madurado::getSerialProductos));        for (Madurado orden: listaMadurado){            orden.verInformacion();        }        //COMPRAR SOLO 3 PRODUCTOS        float  precioTotal = 0F;        int elementosComprados = 0;        System.out.println("Ingrese la cantidad de productos,(Maximo3)");        Scanner entrada = new Scanner(System.in);        int cantidad = entrada.nextInt();        entrada.nextLine();        if (cantidad > 3){            cantidad = 3;            System.out.println();            System.out.println("Solo se permiten comprar 3 ");        }else if (cantidad <0){            cantidad = 0;            System.out.println("cantidad ingresada no valida");        }        Iterator<Map.Entry<String, Madurado>> iterator = mapaDeProductos.entrySet().iterator();        while (iterator.hasNext() && elementosComprados <cantidad){            Map.Entry<String, Madurado> entry = iterator.next();            float precioItem = Float.parseFloat(entry.getKey());            precioTotal += precioItem;            elementosComprados ++;        }        System.out.println("Precio Tota "+ precioTotal);    }}