package Tarea07;

import java.util.Hashtable;

import javax.swing.JOptionPane;

public class ejercicio4App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Hashtable<String, Double> aPrecio = new Hashtable<>();
		Hashtable<String, Integer> aCantidad = new Hashtable<>();
		String texto;
		int num;

		// Se ejecuta al principo del programa para cargarlos en los hashtables
		baseDatos(aPrecio, aCantidad);

		// Bucle para preguntar si es un nuevo cliente o quiere informacion sobre el stock
		do {
			texto = JOptionPane
					.showInputDialog("Que deseas hacer?\n1 --> Nuevo cliente\n2 --> Información\n3 --> Apagar");
			num = Integer.parseInt(texto);

			switch (num) {
			case 1:
				// Para todo el tema del cliente
				numProductos(aPrecio, aCantidad);
				
				break;
			// Informacion del stock
			case 2:
				// Bucle para saber que es lo que quiere
				do {
					texto = JOptionPane.showInputDialog(
							"Que quieres hacer?\n1 --> Añadir productos\n2 --> Ver info de 1 solo producto"
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
				break;
			case 3:
				// No hace nada pero es para que no lo pille el default
				break;
			default:
				System.out.println("Numero incorrecto");
			}
		} while (num != 3);

	}

	// Para crear la base de datos (solo se ejecuta al inicio)
	public static void baseDatos(Hashtable<String, Double> aPrecio, Hashtable<String, Integer> aCantidad) {
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
	public static void añadirArticulo(Hashtable<String, Double> aPrecio, Hashtable<String, Integer> aCantidad) {
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
	public static void mostrarProducto(Hashtable<String, Double> aPrecio, Hashtable<String, Integer> aCantidad) {
		String nombre;

		nombre = JOptionPane.showInputDialog("Di el nombre del producto");

		System.out.println("Precio de " + nombre + ": " + aPrecio.get(nombre));
		System.out.println("Cantidad de " + nombre + ": " + aPrecio.get(nombre));

	}

	// Para mostrar todos los productos
	public static void mostrarTodo(Hashtable<String, Double> aPrecio, Hashtable<String, Integer> aCantidad) {
		System.out.println("Producto con precio " + aPrecio.toString());
		System.out.println("Producto con cantidad " + aCantidad.toString());
	}

	// Para añadir una cantidad de un producto
	public static void numProductos(Hashtable<String, Double> aPrecio, Hashtable<String, Integer> aCantidad) {
		int i, productos;
		String texto;

		texto = JOptionPane.showInputDialog("Cuantos productos diferentes compra?");
		productos = Integer.parseInt(texto);
		String[][] cliente = new String[productos][2]; // He usado una matriz porque no sabia como sacar solo la key
		// Uno de los sergios ha descubierto como sacar la key y se hace con lo de enumeration y tal, pero esto funciona
		// Y no quiero tocar nada por si la lio HAHA

		for (i = 0; i < productos; i++) {
			cliente[i][0] = JOptionPane.showInputDialog("Como se llama el producto").toLowerCase();
			cliente[i][1] = JOptionPane.showInputDialog("Cantidad del producto " + (i + 1));
		}
		
		pago (cliente, aPrecio, aCantidad);
	}
	
	// Para hacer el metodo de pago, precio y tal
	public static void pago (String[][] cliente, Hashtable<String, Double> aPrecio, Hashtable<String, Integer> aCantidad) {
		double pBruto = 0, pTotal = 0;
		final double IVA = 0.21;
		int i, cantidad, cantidadAux;
		String nombre;
		
		// Aqui sumamos el precio de todos los productos en funcion de la cantidad de productos
		for (i = 0; i < cliente.length; i++) {
			nombre = cliente[i][0]; // Guardamos el nombre del producto
			cantidad = Integer.parseInt(cliente[i][1]); // Pasamos el string de cantidad a int
			pBruto += cantidad * aPrecio.get(nombre); // Vamos sumando todo
			cantidadAux = aCantidad.get(nombre); // Cogemos la cantidad del producto que teniamos hasta ahora
			aCantidad.remove(nombre); // Eliminamos el producto
			aCantidad.put(nombre, (cantidadAux - cantidad)); // Lo añadimos pero cambiando la cantidad (no he sabido hacerlo de otra forma)
		}
		pTotal = pBruto + (pBruto * IVA); // Calculamos el precio con el iva
		System.out.println("Precio bruto: " + pBruto);
		System.out.println("Precio total (con iva): " + pTotal);
		System.out.println("Numero de articulos " + cliente.length);
		nombre = JOptionPane.showInputDialog("Cantidad pagada"); // Preguntamos con que cantidad va a pagar
		cantidad = Integer.parseInt(nombre);
		System.out.println("Cambio a devolver: " + (cantidad - pTotal)); // Mostramos el cambio
	}
}
