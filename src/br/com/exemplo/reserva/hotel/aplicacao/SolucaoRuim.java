package br.com.exemplo.reserva.hotel.aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import br.com.exemplo.reserva.hotel.modelo.entidades.ReservaMuitoRuim;
import br.com.exemplo.reserva.hotel.modelo.entidades.ReservaRuim;
import br.com.exemplo.reserva.hotel.modelo.excessoes.ExcessaoDominio;

public class SolucaoRuim {
	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Numero do quarto: ");
		int numero = sc.nextInt();

		System.out.print("Data de check-in (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());

		System.out.print("Data de check-out (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());

		if (!checkOut.after(checkIn)) {
			System.out.println("Erro na reserva: A data de check-out deve ser posterior à data de check-in.");
		} else {
			ReservaRuim reserva = new ReservaRuim(numero, checkIn, checkOut);
			System.out.println(reserva);

			System.out.println();
			System.out.println();

			System.out.println("Insira a data para atualizar a reserva: ");

			System.out.print("Data de check-in (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Data de check-out (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());

			String erro = reserva.datasAtualizadas(checkIn, checkOut);

			if (erro != null) {
				System.out.println("Erro na reserva: " + erro);
			} else {
				System.out.println(reserva);
			}

			sc.close();
		}
	}
}
