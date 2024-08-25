package Coordinador;

import Clases.*;

import java.util.*;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escriba el numero del punto para ejecutar ej; punto 1=1, punto 2=2, etc");
        int x= sc.nextInt();

        if(x==1){
            ejecutarPunto1();
        }else if(x==2){
            ejecutarPunto2();
        } else if (x==3) {
            ejecutarPunto3();
        } else if (x==4) {
            ejecutarPunto4();
        } else if (x==5) {
            ejecutarPunto5();
        }else if (x==6) {
            ejecutarPunto6();
        }else if (x==7) {
            ejecutarPunto7();
        }else if (x==8) {
            ejecutarPunto8();
        }else if (x==9) {
            ejecutarPunto9();
        }else if (x==10) {
            ejecutarPunto10();
        }else if (x==11) {
            ejecutarPunto11();
        }else if (x==12) {

        }else if (x==13) {
            ejecutarPunto13();
        }else if (x==14) {
            ejecutarPunto14();
        }else if (x==15) {
            ejecutarPunto15();
        }else if (x==16) {
            ejecutarPunto16();
        }else if (x==17) {
            ejecutarPunto17();
        }
        sc.close();
    }

    public static void ejecutarPunto1() {
        List<Persona> listaPersonas = new ArrayList<Persona>();
        listaPersonas.add(new Persona("Natalia","Femenino",19));
        listaPersonas.add(new Persona("Daniel","Masculino",20));
        listaPersonas.add(new Persona("Londoño","Femenino",20));
        listaPersonas.add(new Persona("Pacho","Femenino",19));

        Collections.sort(listaPersonas);

        for (Persona persona : listaPersonas) {
            System.out.println("Comparable");
            System.out.println(persona.toString() + '\n');
        }

        Collections.sort(listaPersonas, new ComparadorPersonaNombre());

        for (Persona persona : listaPersonas) {
            System.out.println("Por comparator");
            System.out.println(persona.toString() + '\n');
        }
    }

    public static void ejecutarPunto2() {
        Empresa miEmpresa = new Empresa();

        miEmpresa.agregarProducto(new Producto("Leche","001",1800));
        miEmpresa.agregarProducto(new Producto("Pan","002",2000));
        miEmpresa.agregarProducto(new Producto("Yogurt","003",4000));
        miEmpresa.agregarProducto(new Producto("Gaseosa","004",4000));

        System.out.println("Lista de productos");
        miEmpresa.mostrarProductos();
        System.out.println("Escribir el codigo que desea buscar; ej 001,002,003, etc;");
        Scanner sc = new Scanner(System.in);
        String codigo= sc.nextLine();
        Producto producto = miEmpresa.buscarProductoCodigo(codigo);

        if(producto!= null){
            System.out.println("Producto encontrado " + producto);
        }else{
            System.out.println("Producto no encontrado con el codigo " + codigo);
        }

    }

    public static void ejecutarPunto3(){

        Scanner scanner = new Scanner(System.in);
        Map<Integer, Estudiante> estudianteMap = new HashMap<>();


        System.out.println("Escriba la cantidad de estudiantes que desea añadir: ");
        int a = scanner.nextInt();
        for (int i = 0; i < a; i++) {
            System.out.println("Escriba el nombre del estudiante: ");
            String nombre = scanner.nextLine();
            scanner.nextLine();


            System.out.println("Escriba el generp del estudiante: ");
            String genero = scanner.nextLine();
            scanner.nextLine();


            System.out.println("Escriba la edad del estudiante: ");
            int edad = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Escriba el número de matricula del estudiante: ");
            int matricula = scanner.nextInt();

            scanner.nextLine();

            Estudiante estudiante = new Estudiante(nombre,genero,edad,matricula);
            estudianteMap.put(estudiante.getMatricula(), estudiante);
        }

        estudianteMap.forEach((key, value)  -> System.out.println(key + " Estudiante " + value));
    }

    public static void ejecutarPunto4(){
        Scanner scanner = new Scanner(System.in);
        PilaTipos p1 = new PilaTipos();
    }

    public static void ejecutarPunto5(){
        Set<String> elementos = new HashSet<>();
        elementos.add("Dylan");
        elementos.add("Luis");

        for (String elemento : elementos) {
            System.out.println(elemento);
        }
    }

    public static void ejecutarPunto6(){
        Queue<Tarea> cola = new PriorityQueue<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escriba la cantidad de Tareas que desea agregar: ");
        int a = scanner.nextInt();
        for (int i = 0; i < a; i++) {
            System.out.println("nombre materia");
            String nombre = scanner.nextLine();
            scanner.nextLine();

            int importancia = 0;

            boolean valido = false;
            while (!valido) {
                System.out.println("Escriba la importancia de la materia: ");
                try {
                    importancia = scanner.nextInt();
                    valido = true;
                }catch (Exception e) {
                    System.out.println("Escriba un número valido");
                    scanner.next();
                }
            }
            scanner.nextLine();

            Tarea tarea = new Tarea(nombre,importancia);
            cola.add(tarea);
        }
        while (!cola.isEmpty()) {
            System.out.println(cola.poll());
        }
    }

    public static void ejecutarPunto7(){
        Scanner scanner = new Scanner(System.in);
        List<Persona> listaPersonas = new ArrayList<Persona>();
        System.out.println("Escriba la cantidad de personas que desea agregar: ");
        int tam = scanner.nextInt();
        for (int i = 0; i < tam; i++) {
            System.out.println("Escribir nombre de la persona");
            String nombre = scanner.nextLine();
            scanner.nextLine();

            System.out.println("Escribir la edad de la persona");
            int edad = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Escriba el genero de la persona");
            String genero = scanner.nextLine();
            scanner.nextLine();

            Persona np= new Persona(nombre,genero,edad);
            listaPersonas.add(np);
        }

        List<Persona> ordenadosMayor = filtrarMayoresEdad(listaPersonas);

        for (Persona persona : ordenadosMayor) {
            System.out.println(persona.toString());
        }
    }

    public static List<Persona> filtrarMayoresEdad(List<Persona> x){
        if (x.isEmpty()){
            return new ArrayList<>();
        }
        Persona p = x.get(0);

        List<Persona> restoDePersonas = filtrarMayoresEdad(x.subList(1, x.size()));

        if (p.getEdad()>=18){
            restoDePersonas.add(p);
        }
        return restoDePersonas;
    }

    public static void ejecutarPunto8(){
        Scanner scanner = new Scanner(System.in);
        Map<Integer,String> mapa= new HashMap<>();
        mapa.put(1,"ZZ");
        mapa.put(2,"Luis");
        mapa.put(3,"Daniel");
        mapa.put(4,"Dylan");
        mapa.put(5,"Londoño");


        Map<Integer,String> mapaPares= filtrarPorPares(mapa);

        for (Map.Entry<Integer,String> entry : mapaPares.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    public static Map<Integer,String> filtrarPorPares(Map<Integer,String> mapa){
        if (mapa.isEmpty()){
            return new HashMap<>();
        }
        Integer key = mapa.keySet().iterator().next();
        String primerValor = mapa.get(key);

        Map<Integer,String> restoMapa= new HashMap<>(mapa);
        restoMapa.remove(primerValor);

        Map<Integer, String> mapaFiltrado = filtrarPorPares(restoMapa);
        if (key % 2 == 0){
            mapaFiltrado.put(key,primerValor);
        }
        return mapaFiltrado;
    }

    public static void ejecutarPunto9(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Elija un número para comparar");
        int a = scanner.nextInt();
        Stack<Integer> pila = new Stack<>();
        pila.push(1);
        pila.push(2);
        pila.push(3);
        pila.push(4);
        pila.push(5);

        Stack<Integer> pilaFiltradaMAyoresX= filtrarFilaPorMayoresAX(a, pila);
        System.out.println("Elementos en la nueva pila que son mayores que :" + a);
        while (!pilaFiltradaMAyoresX.isEmpty()) {
            System.out.println(pilaFiltradaMAyoresX.pop());
        }
    }

    public static Stack<Integer> filtrarFilaPorMayoresAX(int numero, Stack<Integer> pila){
        if (pila.isEmpty()){
            new Stack<>();
        }

        Integer elemento = pila.pop();

        Stack<Integer> nuevaPila = filtrarFilaPorMayoresAX(numero, pila);
        if (elemento>numero){
            nuevaPila.push(elemento);
        }
        return nuevaPila;
    }

    public static void ejecutarPunto10(){
        Scanner scanner = new Scanner(System.in);
        Queue<Producto> cola = new LinkedList<>();
        System.out.println("Escriba la cantidad de productos que desea agregar: ");
        int x = scanner.nextInt();
        for (int i = 0; i < x; i++) {
            System.out.println("Escriba el nombre del producto");
            String nombre = scanner.nextLine();
            scanner.nextLine();

            System.out.println("Escriba el codigo del producto");
            String codigo = scanner.nextLine();
            scanner.nextLine();

            System.out.println("Escriba el precio del producto");
            int precio = scanner.nextInt();

            Producto p = new Producto(nombre,codigo,precio);
            cola.add(p);
        }

        Queue<Producto> colaPrecioMenores10K = filtrarPrecioMenores10K(cola);
        for (Producto producto : colaPrecioMenores10K) {
            System.out.println(producto.toString());
        }
    }

    public static Queue<Producto> filtrarPrecioMenores10K(Queue<Producto> cola){
        if (cola.isEmpty()){
            return new LinkedList<>();
        }
        Producto producto= cola.poll();

        Queue<Producto> menores10K= filtrarPrecioMenores10K(cola);

        if (producto.getValor()<10000){
            menores10K.add(producto);
        }
        return menores10K;
    }

    public static void ejecutarPunto11(){
        Scanner scanner = new Scanner(System.in);
        List<Producto> listaProductos = new ArrayList<>();
        System.out.println("Escriba la cantidad de productos que quiera agregar; ");
        int x = scanner.nextInt();
        for (int i = 0; i < x; i++) {
            System.out.println("Escriba el nombre del producto");
            String nombre = scanner.nextLine();
            scanner.nextLine();

            System.out.println("Escriba el codigo del producto");
            String codigo = scanner.nextLine();
            scanner.nextLine();

            System.out.println("Escriba el precio del producto");
            int precio = scanner.nextInt();

            Producto p = new Producto(nombre,codigo,precio);
            listaProductos.add(p);
        }

        List<Producto> listaProductosOrdenadosQckSort = ordenamientoQuckSort(listaProductos);

        for (Producto producto : listaProductosOrdenadosQckSort) {
            System.out.println(producto.toString());
        }
    }

    public static List<Producto> ordenamientoQuckSort(List<Producto> listaProductos){
        if (listaProductos.size()<=1){
            return listaProductos;
        }

        Producto pivote = listaProductos.get(0);
        List<Producto> menores = new ArrayList<>();
        List<Producto> iguales = new ArrayList<>();
        List<Producto> mayores = new ArrayList<>();
        for (Producto producto : listaProductos) {
            if (producto.getValor()<pivote.getValor()){
                menores.add(producto);
            }else if (producto.getValor()>pivote.getValor()){
                mayores.add(producto);
            }else if (producto.getValor()==pivote.getValor()){
                iguales.add(producto);
            }
        }
        menores = ordenamientoQuckSort(menores);
        mayores = ordenamientoQuckSort(mayores);

        List<Producto> ordenado = new ArrayList<>();
        ordenado.addAll(menores);
        ordenado.addAll(iguales);
        ordenado.addAll(mayores);
        return ordenado;
    }

    public static void ejecutarPunto13(){
        Scanner scanner = new Scanner(System.in);
        List<Integer> listaNum = new ArrayList<>();
        System.out.println("Escriba la cantidad de números que desea agregar: ");
        int x = scanner.nextInt();
        scanner.nextLine();

        int cont= 1;
        for (int i = 0; i < x; i++) {
            System.out.println("Escriba el número de posición " + cont++);
            int num = scanner.nextInt();
            scanner.nextLine();

            listaNum.add(num);
        }

        List<Integer> listaNumPares = filtrarNumPares(listaNum);
        for (Integer num : listaNumPares) {
            System.out.println(num);
        }
    }

    public static List<Integer> filtrarNumPares(List<Integer> lista){
        if (lista.isEmpty()){
            return new ArrayList<>();
        }

        Iterator<Integer> iterator = lista.iterator();
        Integer numero = iterator.next();
        lista.remove(numero);
        List<Integer> filtrarNumPares = filtrarNumPares(lista);

        if (numero % 2 == 0){
            filtrarNumPares.add(numero);
        }
        return filtrarNumPares;
    }

    public static void ejecutarPunto14(){
        Scanner scanner = new Scanner(System.in);
        List<String> lista = new ArrayList<>();
        System.out.println("Escriba la cantidad de palabras que desea agregar: ");
        int x = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < x; i++) {
            System.out.println("Escriba la palabra de la lista " + ++x);
            String palabra = scanner.nextLine();
            lista.add(palabra);
        }

        List<String> listaMayores = filtrarCadenasMAyuscula(lista);
        for (String palabra : listaMayores) {
            System.out.println(palabra);
        }
    }

    public static List<String> filtrarCadenasMAyuscula(List<String> lista){
        if (lista.isEmpty()){
            return new ArrayList<>();
        }
        String cadena = lista.get(0);
        List<String> sublista = lista.subList(1, lista.size());
        List<String> filtrarCadenas = filtrarCadenasMAyuscula(sublista);

        if (!cadena.isEmpty() && Character.isUpperCase(cadena.charAt(0))) {
            filtrarCadenas.add(0, cadena);
        }
        return filtrarCadenas;
    }

    public static void ejecutarPunto15(){
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> mapa = new HashMap<>();
        mapa.put("tango",1);
        mapa.put("Plastic",2);
        mapa.put("Krampus",3);
        Map<String, Integer> mapaOrdenado = filtrarMapaMinuscula(mapa);
    }

    public static Map<String, Integer> filtrarMapaMinuscula(Map<String, Integer> mapa){
        if (mapa.isEmpty()){
            return new HashMap<>();
        }

        Iterator<Map.Entry<String, Integer>> iterator = mapa.entrySet().iterator();
        Map.Entry<String, Integer> entrada = iterator.next();

        mapa.remove(entrada.getKey());
        Map<String, Integer> mapaConMinusculas = filtrarMapaMinuscula(mapa);

        if (!entrada.getKey().isEmpty() && Character.isLowerCase(entrada.getKey().charAt(0))) {
            mapaConMinusculas.put(entrada.getKey(), entrada.getValue());
        }
        return mapaConMinusculas;
    }

    public static void ejecutarPunto16(){
        Stack<Integer> pila = new Stack<>();
        pila.push(1);
        pila.push(10);
        pila.push(3);
        pila.push(2);
        pila.push(7);
        pila.push(4);

        Predicate<Integer> condicion = x -> x > 4;
        Stack<Integer> pilaFiltrada = filtrarPila(pila, condicion);

    }

    public static <T> Stack<T> filtrarPila(Stack<T> pila, Predicate<T> condicion) {
        if (pila.isEmpty()){
            return new Stack<>();
        }
        T elemento = pila.pop();
        Stack<T> pilaFiltrada = filtrarPila(pila, condicion);

        if (condicion.test(elemento)) {
            pilaFiltrada.push(elemento);
        }
        return pilaFiltrada;
    }

    public static void ejecutarPunto17() {
        //HashMap
        Map<String, Producto> hashMapa = new HashMap<>();
        Producto p1  = new Producto("Leche","001",8000);
        Producto p2  = new Producto("Queso","002",5000);
        Producto p3  = new Producto("Yogurt","003",4000);
        hashMapa.put(p1.getCodigo(),p1);
        hashMapa.put(p2.getCodigo(),p2);
        hashMapa.put(p3.getCodigo(),p3);

        //LinkedHashMap
        Map<String, Producto> linkedHashMap = new LinkedHashMap<>();
        Producto p4  = new Producto("Leche","001",8000);
        Producto p5  = new Producto("Queso","002",5000);
        Producto p6  = new Producto("Yogurt","003",4000);
        linkedHashMap.put(p4.getCodigo(),p4);
        linkedHashMap.put(p5.getCodigo(),p5);
        linkedHashMap.put(p6.getCodigo(),p6);

        //TreeMap
        Map<String, Producto> treeMap = new TreeMap<>();
        Producto p7  = new Producto("Leche","001",8000);
        Producto p8  = new Producto("Leche","001",8000);
        Producto p9  = new Producto("Leche","001",8000);
        treeMap.put(p5.getCodigo(),p7);
        treeMap.put(p6.getCodigo(),p8);
        treeMap.put(p7.getCodigo(),p9);

        System.out.println("HashMap:");
        hashMapa.forEach((key, value) -> System.out.println(key + ": " + value));

        System.out.println("LinkedHashMap:");
        linkedHashMap.forEach((key, value) -> System.out.println(key + ": " + value));

        System.out.println("TreeMap");
        treeMap.forEach((key, value) -> System.out.println(key + ": " + value));
    }



}




