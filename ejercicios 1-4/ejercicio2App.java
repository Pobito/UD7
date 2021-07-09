package Tarea07;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class ejercicio2App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/* Este ejercicio no estab bien explicado y no he entendido muy bien como habia que hacerlo
		 * aqui solo he hecho que me diga cuantos productos diferentes tiene y los añado a un arraylist
		 * todo el tema del precio y tal esta en el ejercicio 4 bien implementado y funcional 100%
		 */
		ArrayList<Integer> lista = new ArrayList<>();
		
		numProductos(lista);
	}

	// Para añadir una cantidad de un producto
	public static void numProductos (ArrayList<Integer> lista) {
		int i, productos;
		String texto;
		
		texto = JOptionPane.showInputDialog("Cuantos productos diferentes compra?");
		productos = Integer.parseInt(texto);
		
		for (i = 0; i < productos; i++) {
			texto = JOptionPane.showInputDialog("Cantidad del producto " + (i + 1));
			lista.add(Integer.parseInt(texto));
		}
	}
}
