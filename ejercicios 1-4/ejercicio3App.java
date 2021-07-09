package Tarea07;

import java.util.Hashtable;

import javax.swing.JOptionPane;

public class ejercicio3App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Hashtable<String, Double> aPrecio = new Hashtable<>();
		Hashtable<String, Integer> aCantidad = new Hashtable<>();
		String texto;
		int num = 0;
		
		// Se ejecuta al principo del programa para cargarlos en los hashtables
		baseDatos(aPrecio, aCantidad);
		
		
		
		do {
			texto = JOptionPane.showInputDialog("Que quieres hacer?\n1 --> Añadir productos\n2 --> Ver info de 1 solo producto"
					+ "\n3 --> Ver info entera\n4 --> Salir");
			num = Integer.parseInt(texto);
			
			switch (num) {
				case 1:
					añadirArticulo(aPrecio, aCantidad);
					break;
				case 2:
					mostrarProducto(aPrecio, aCantidad);
					break;
				case 3:
					mostrarTodo(aPrecio, aCantidad);
					break;
				case 4:
					// No hace nada pero es para que no entre en el defual
					break;
				default:
					System.out.println("Numero incorrecto");
			}
		} while (num != 4);
	}

	// Para crear la base de datos (solo se ejecuta al inicio)
	public static void baseDatos (Hashtable<String,Double> aPrecio, Hashtable<String, Integer> aCantidad) {
		// Para el precio de los productos
		aPrecio.put("pan", 1.0);
		aPrecio.put("pizza", 3.5);
		aPrecio.put("leche", 2.25);
		aPrecio.put("aceite", 3.35);
		aPrecio.put("helado", 4.49);
		aPrecio.put("galleta", 1.28);
		aPrecio.put("patatas", 2.86);
		aPrecio.put("queso", 5.95);
		aPrecio.put("actimel", 3.19);
		aPrecio.put("guacamole", 1.85);
		
		// Para la cantidad de los productos
		aCantidad.put("pan", 10);
		aCantidad.put("pizza", 35);
		aCantidad.put("leche", 25);
		aCantidad.put("aceite", 35);
		aCantidad.put("helado", 49);
		aCantidad.put("galleta", 28);
		aCantidad.put("patatas", 86);
		aCantidad.put("queso", 95);
		aCantidad.put("actimel", 19);
		aCantidad.put("guacamole", 85);
	}
	
	// Para añadir un producto a los hashtable
	public static void añadirArticulo (Hashtable<String,Double> aPrecio, Hashtable<String, Integer> aCantidad) {
		String nombre;
		int cantidad;
		double precio;
		
		nombre = JOptionPane.showInputDialog("Di el nombre del producto").toLowerCase();
		cantidad = Integer.parseInt(JOptionPane.showInputDialog("Di la cantidad del producto"));
		precio = Double.parseDouble(JOptionPane.showInputDialog("Di la cantidad del producto"));
		
		aPrecio.put(nombre, precio);
		aCantidad.put(nombre, cantidad);
	}
	
	// Para consultar solo un producto
	public static void mostrarProducto (Hashtable<String,Double> aPrecio, Hashtable<String, Integer> aCantidad) {
		String nombre;
		
		nombre = JOptionPane.showInputDialog("Di el nombre del producto");
		
		System.out.println("Precio de " + nombre + ": " + aPrecio.get(nombre));
		System.out.println("Cantidad de " + nombre + ": " + aPrecio.get(nombre));
		
	}
	
	// Para mostrar todos los productos
	public static void mostrarTodo (Hashtable<String,Double> aPrecio, Hashtable<String, Integer> aCantidad) {
		System.out.println("Producto con precio " + aPrecio.toString());
		System.out.println("Producto con cantidad " + aCantidad.toString());
	}
}
