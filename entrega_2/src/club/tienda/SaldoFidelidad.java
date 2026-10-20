package club.tienda;

public class SaldoFidelidad {
	
	//atributos
	private int puntos;

	public SaldoFidelidad() {
		this.puntos = 0;
	}

	//metodos
	public int getPuntos() {
		return puntos;
	}
	
	public void agregarPuntos(int cantidad) {
		this.puntos += cantidad;
	}
	
	public void redimirPuntos(int cantidad) {
		this.puntos -= cantidad;
		this.puntos = this.puntos > 0 ? this.puntos : 0;
		
	}
	
	
	

}
