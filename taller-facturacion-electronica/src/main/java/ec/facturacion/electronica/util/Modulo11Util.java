package ec.facturacion.electronica.util;

/**
 * Clase que implementa el algoritmo del módulo 11
 * 
 * @author Tex
 *
 */
public class Modulo11Util {

	public String obtenerDigitoVerificador(String cadena) {
		int baseMultiplicador = 7;
		int[] resultados = new int[cadena.length()];
		int multiplicador = 2;
		int total = 0;
		int verificador = 0;
		for (int i = resultados.length - 1; i >= 0; i--) {
			resultados[i] = Integer.parseInt(Character.toString(cadena.charAt(i)));
			resultados[i] = resultados[i] * multiplicador;
			multiplicador++;
			if (multiplicador > baseMultiplicador) {
				multiplicador = 2;
			}
			total += resultados[i];
		}
		if (total == 0 || total == 1) {
			verificador = 0;
		} else {
			verificador = (11 - (total % 11)) == 11 ? 0 : (11 - (total % 11));
		}
		if (verificador == 10) {
			verificador = 1;
		}
		return String.valueOf(verificador);
	}

}
