import java.util.ArrayList;

public class comprobarAlg {
    //Clase: Algoritmo de Dijkstra
    private static algDijkstra algoritmo;
    private static ArrayList<vertices> listaVertices;
    private static ArrayList<String> listaEstacion; //Nombre de la estación representada en cada vertice
    private static ArrayList<aristas> listaAristas;

    public static void main(String[] args) throws Exception {
        creacionVertices();
        creacionAristas();
        algoritmo = new algDijkstra(listaVertices, listaAristas);


        // Ejecutar Algoritmo
        algoritmo.setVerticeInicial("BB");
        algoritmo.ejecutar();
        System.out.println("\n\n\n" + algoritmo.caronte("EE") + "\n\n\n");
    }

    public static void creacionVertices(){
        //Instanciamiento
        listaVertices = new ArrayList<vertices>();
        listaEstacion = new ArrayList<String>();
        vertices vertAA = new vertices();
        vertices vertAB = new vertices();
        vertices vertBA = new vertices();
        vertices vertBB = new vertices();
        vertices vertBC = new vertices();
        vertices vertBD = new vertices();
        vertices vertBE = new vertices();
        vertices vertBF = new vertices();
        vertices vertCA = new vertices();
        vertices vertCB = new vertices();
        vertices vertCC = new vertices();
        vertices vertCD = new vertices();
        vertices vertDA = new vertices();
        vertices vertDB = new vertices();
        vertices vertDC = new vertices();
        vertices vertEA = new vertices();
        vertices vertEB = new vertices();
        vertices vertEC = new vertices();
        vertices vertED = new vertices();
        vertices vertEE = new vertices();

        //Valoración
        vertAA.setNombre("AA");
        vertAB.setNombre("AB");
        vertBA.setNombre("BA");
        vertBB.setNombre("BB");
        vertBC.setNombre("BC"); //5
        vertBD.setNombre("BD");
        vertBE.setNombre("BE");
        vertBF.setNombre("BF");
        vertCA.setNombre("CA");
        vertCB.setNombre("CB"); //10
        vertCC.setNombre("CC");
        vertCD.setNombre("CD");
        vertDA.setNombre("DA");
        vertDB.setNombre("DB");
        vertDC.setNombre("DC"); //15
        vertEA.setNombre("EA");
        vertEB.setNombre("EB");
        vertEC.setNombre("EC");
        vertED.setNombre("ED");
        vertEE.setNombre("EE"); //20

        //Listado
        listaVertices.add(vertAA);
        listaEstacion.add("Guro");
        listaVertices.add(vertAB);
        listaEstacion.add("Gasan Digital Complex");
        listaVertices.add(vertBA);
        listaEstacion.add("Hongik Univ");
        listaVertices.add(vertBB);
        listaEstacion.add("Hapjeong");
        listaVertices.add(vertBC);
        listaEstacion.add("Dangsan");
        listaVertices.add(vertBD);
        listaEstacion.add("Yengdungpo-gu Office");
        listaVertices.add(vertBE);
        listaEstacion.add("Sindorim");
        listaVertices.add(vertBF);
        listaEstacion.add("Sinpung");
        listaVertices.add(vertCA);
        listaEstacion.add("Chungjeongno");
        listaVertices.add(vertCB);
        listaEstacion.add("Gongdeok");
        listaVertices.add(vertCC);
        listaEstacion.add("Yeouido");
        listaVertices.add(vertCD);
        listaEstacion.add("Singi");
        listaVertices.add(vertDA);
        listaEstacion.add("");
        listaVertices.add(vertDB);
        listaEstacion.add("");
        listaVertices.add(vertDC);
        listaEstacion.add("");
        listaVertices.add(vertEA);
        listaEstacion.add("");
        listaVertices.add(vertEB);
        listaEstacion.add("");
        listaVertices.add(vertEC);
        listaEstacion.add("");
        listaVertices.add(vertED);
        listaEstacion.add("");
        listaVertices.add(vertEE);
        listaEstacion.add("");
    }

    public static void creacionAristas(){
        //Instanciamiento
        listaAristas = new ArrayList<aristas>();
        aristas arista1 = new aristas("1", 2, "AA", "AB");
        aristas arista2 = new aristas("2", 2, "AA", "BE");
        aristas arista3 = new aristas("3", 4, "AB", "BF");
        aristas arista4 = new aristas("4", 8, "BA", "CA");
        aristas arista5 = new aristas("5", 2, "BA", "BB");
        aristas arista6 = new aristas("6", 3, "BB", "BC");
        aristas arista7 = new aristas("7", 2, "BC", "BD");
        aristas arista8 = new aristas("8", 4, "BD", "BE");
        aristas arista9 = new aristas("9", 8, "BB", "CB");
        aristas arista10 = new aristas("10", 6, "BC", "CC");
        aristas arista11 = new aristas("11", 4, "BD", "CD");
        aristas arista12 = new aristas("12", 2, "BE", "CD");
        aristas arista13 = new aristas("13", 2, "BE", "BF");
        aristas arista14 = new aristas("14", 16, "BF", "ED");
        aristas arista15 = new aristas("15", 12, "BF", "EE");
        aristas arista16 = new aristas("16", 4, "CA", "CB");
        aristas arista17 = new aristas("17", 7, "CB", "CC");
        aristas arista18 = new aristas("18", 1, "CC", "CD");
        aristas arista19 = new aristas("19", 7, "DA", "DB");
        aristas arista20 = new aristas("20", 5, "CB", "EA");
        aristas arista21 = new aristas("21", 3, "DB", "DC");
        aristas arista22 = new aristas("22", 4, "CC", "DC");
        aristas arista23 = new aristas("23", 4, "CD", "DC");
        aristas arista24 = new aristas("24", 3, "DB", "EB");
        aristas arista25 = new aristas("25", 6, "DC", "EC");
        aristas arista26 = new aristas("26", 4, "DA", "EA");
        aristas arista27 = new aristas("27", 4, "EA", "EB");
        aristas arista28 = new aristas("28", 2, "EB", "EC");
        aristas arista29 = new aristas("29", 4, "EC", "ED");
        aristas arista30 = new aristas("30", 2, "ED", "EE");

        //Listado
        listaAristas.add(arista1);
        listaAristas.add(arista2);
        listaAristas.add(arista3);
        listaAristas.add(arista4);
        listaAristas.add(arista5); //5
        listaAristas.add(arista6);
        listaAristas.add(arista7);
        listaAristas.add(arista8);
        listaAristas.add(arista9);
        listaAristas.add(arista10); //10
        listaAristas.add(arista11);
        listaAristas.add(arista12);
        listaAristas.add(arista13);
        listaAristas.add(arista14);
        listaAristas.add(arista15); //15
        listaAristas.add(arista16);
        listaAristas.add(arista17);
        listaAristas.add(arista18);
        listaAristas.add(arista19);
        listaAristas.add(arista20); //20
        listaAristas.add(arista21);
        listaAristas.add(arista22);
        listaAristas.add(arista23);
        listaAristas.add(arista24);
        listaAristas.add(arista25); //25
        listaAristas.add(arista26);
        listaAristas.add(arista27);
        listaAristas.add(arista28);
        listaAristas.add(arista29);
        listaAristas.add(arista30); //30
    }
}
