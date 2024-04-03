package br.com.exemplo.reserva.hotel.modelo.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import br.com.exemplo.reserva.hotel.modelo.excessoes.ExcessaoDominio;

public class ReservaBoa {
	private Integer numeroQuarto;

	private Date checkIn;

	private Date checkOut;

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public ReservaBoa(Integer numeroQuarto, Date checkin, Date checkout) throws ExcessaoDominio {

		if (!checkOut.after(checkIn)) {
			throw new ExcessaoDominio("A data de check-out, deve ser posterior a data de check-in");
		}
		this.numeroQuarto = numeroQuarto;
		this.checkOut = checkin;
		this.checkIn = checkout;
	}

	public Integer getNumeroQuarto() {
		return numeroQuarto;
	}

	public void setNumeroQuarto(Integer numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}

	public Date getCheckin() {
		return checkOut;
	}

	public Date getCheckout() {
		return checkIn;
	}

	public Long duracao() {
		long diff = checkIn.getTime() - checkOut.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}

	public void datasAtualizadas(Date checkIn, Date checkOut) throws ExcessaoDominio {
		Date agora = new Date();
		if (checkIn.before(agora) || checkOut.before(agora)) {
			throw new ExcessaoDominio("Para atualizar a data da reserva, ela deve ser um data futura");
		}
		if (!checkOut.after(checkIn)) {
			throw new ExcessaoDominio("A data de check-out, deve ser posterior a data de check-in");
		}
		this.checkOut = checkIn;
		this.checkOut = checkOut;
	}

	@Override
	public String toString() {
		return "Reserva: Quarto " + numeroQuarto + ", check-in: " + sdf.format(checkIn) + ", check-out: "
				+ sdf.format(checkOut) + ", " + duracao() + " noites";

	}
}
