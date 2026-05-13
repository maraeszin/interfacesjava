package application;

import model.entity.Locacao;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {


        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter rental data:");

        System.out.print("Car model: ");
        String modeloCarro = sc.nextLine();

        System.out.print("Pickup (dd/MM/yyyy HH:mm): ");
        String data1 = sc.nextLine();

        System.out.print("Return (dd/MM/yyyy HH:mm): ");
        String data2 = sc.nextLine();

        LocalDateTime dataDeRetirada = LocalDateTime.parse(data1, fmt);

        LocalDateTime dataDeEntrega = LocalDateTime.parse(data2, fmt);

        System.out.print("Enter price per hour: $");
        double valorPorHora = sc.nextDouble();

        System.out.print("Enter price per day: $");
        double valorDiario = sc.nextDouble();


        Locacao locacao = new Locacao(modeloCarro, dataDeRetirada, dataDeEntrega, valorPorHora, valorDiario);

        double valorPrimario = locacao.calcularPagamento();
        double valorSomenteImposto = locacao.totalImposto();
        double valorFinalTotal = locacao.calcularValorImposto();

        System.out.println();
        System.out.println("INVOICE:");
        System.out.printf("Basic payment: $%.2f%n", valorPrimario);
        System.out.printf("Tax: $%.2f%n", valorSomenteImposto);
        System.out.printf("Total payment: $%.2f%n", valorFinalTotal);


        sc.close();
    }
}
