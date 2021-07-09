package Tarea07;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class ejercicio1App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Integer> lista = new ArrayList<>();
		int i, alumnos, examenes;
		
		String texto = JOptionPane.showInputDialog("Cuantos alumnos hay en el curso?");
		alumnos = Integer.parseInt(texto);
		texto = JOptionPane.showInputDialog("Cuantos examenes hay en el curso?");
		examenes = Integer.parseInt(texto);
		
		// Llamo a la funcion
		notaMedia(lista, alumnos, examenes);
		
		for (i = 0; i < lista.size(); i++) {
			System.out.println("Nota media del alumno " + (i + 1) + ": " + lista.get(i));;
		}
		
	}

	// Para calcular la nota media
	public static void notaMedia (ArrayList<Integer> lista, int alumnos, int examenes) {
		int i, j, nota = 0, media;
		String texto;
		
		// Primer for para controlar los alumnos
		for (i = 0; i < alumnos; i++) {
			nota = 0; // Nota a 0 porque cada vez que hay un alumno nuevo se tiene que reiniciar su valor
			JOptionPane.showMessageDialog(null,"Alumno numero " + (i+1));
			// Segundo for para controlar el num de examenes
			for (j = 0; j < examenes; j++) {
				texto = JOptionPane.showInputDialog("Nota del examen " + (i+1));
				nota += Integer.parseInt(texto);
			}
			media = nota / examenes; // Calculamos la media
			lista.add(media); // Lo añadimos al arraylist
		}
	}
}
