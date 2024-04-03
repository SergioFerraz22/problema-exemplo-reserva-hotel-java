package br.com.exemplo.reserva.hotel.aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import br.com.exemplo.reserva.hotel.modelo.entidades.ReservaBoa;
import br.com.exemplo.reserva.hotel.modelo.excessoes.ExcessaoDominio;

public class SolucaoBoa {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			System.out.print("Numero do quarto: ");
			int numero = sc.nextInt();

			System.out.print("Data de check-in (dd/MM/yyyy): ");
			Date checkIn = sdf.parse(sc.next());

			System.out.print("Data de check-out (dd/MM/yyyy): ");
			Date checkOut = sdf.parse(sc.next());

			ReservaBoa reserva = new ReservaBoa(numero, checkIn, checkOut);
			System.out.println(reserva);

			System.out.println();
			System.out.println();

			System.out.println("Insira a data para atualizar a reserva: ");

			System.out.print("Data de check-in (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Data de check-out (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());

			reserva.datasAtualizadas(checkIn, checkOut);
			System.out.println(reserva);
		} catch (ParseException e) {
			System.out.println("Formato de data invalido");
		} catch (ExcessaoDominio e) {
			System.out.println("Erro na reserva: " + e.getMessage());
		} catch (RuntimeException e) {
			System.out.println("Erro inesperado");
		}

	}

}
