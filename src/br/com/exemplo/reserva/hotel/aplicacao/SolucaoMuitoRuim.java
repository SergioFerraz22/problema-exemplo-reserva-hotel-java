package br.com.exemplo.reserva.hotel.aplicacao;

import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import br.com.exemplo.reserva.hotel.modelo.entidades.ReservaMuitoRuim;

/*Implementando solução muito ruim para o problema, como é possivel ver toda a logica esta sendo feita na classe Principal.
O correto seria estar dentro da minha entidade Reserva.
também não esta sendo feito a estrutura de tratamento da maneira correta, utilizando o try catch*/

public class SolucaoMuitoRuim {

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
				ReservaMuitoRuim reserva = new ReservaMuitoRuim(numero,checkIn,checkOut);
				System.out.println(reserva);
				
				System.out.println();
				System.out.println();
				
				System.out.println("Insira a data para atualizar a reserva: ");
				
				System.out.print("Data de check-in (dd/MM/yyyy): ");
				checkIn = sdf.parse(sc.next());
				System.out.print("Data de check-out (dd/MM/yyyy): ");
				checkOut = sdf.parse(sc.next());
				
				Date agora = new Date();
				if (checkIn.before(agora) || checkOut.before(agora)) {
					System.out.println("Erro na reserva: As datas de reserva para atualização devem ser datas futuras.");
				} else if (!checkOut.after(checkIn)){
					System.out.println("Erro na reserva: A data de check-out deve ser posterior à data de check-in.");
				} else {
					reserva.datasAtualizadas(checkIn, checkOut);
					System.out.println(reserva);				
				}
				sc.close();
		}
			
	}

}
