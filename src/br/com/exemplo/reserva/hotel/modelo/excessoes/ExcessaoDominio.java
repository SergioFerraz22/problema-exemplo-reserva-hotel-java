package br.com.exemplo.reserva.hotel.modelo.excessoes;

public class ExcessaoDominio extends Exception{
	private static final long serialVersionUID = 1L;

	
	public ExcessaoDominio(String msg) {
		super(msg);
	}
	
}
