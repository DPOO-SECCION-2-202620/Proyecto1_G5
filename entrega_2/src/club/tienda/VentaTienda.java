package club.tienda;

public class VentaTienda extends Venta{
	
	//atributos
	private final static double IVA = 0.19;
	//private CodigoDescuento codigo;
	
	//metodos
	public double calcularIVA() {
		
		return subtotal*IVA;
	}
	
	public double aplicarCodigo(CodigoDescuento codigo) {
		
		return subtotal*codigo; //codigo esta mal deifnido
	}
	

}
