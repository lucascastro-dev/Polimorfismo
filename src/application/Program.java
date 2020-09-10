package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Produto;
import entities.ProdutoImportado;
import entities.ProdutoUsado;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy");
		
		List<Produto> list = new ArrayList<>();
		
		System.out.print("Entre com o número de produtos: ");
		int n = sc.nextInt();
		
		for (int i=1; i<=n; i++) {
			System.out.println("Produto #" +i);
			System.out.print("Produto COMUM, USADO OU IMPORTADO? (C/U/I) : ");		
			char tipo = sc.next().charAt(0);
			sc.nextLine();	
			System.out.print("Nome: ");
			String nome = sc.nextLine();
			System.out.print("Preço: ");
			double preco = sc.nextDouble();
			if (tipo == 'c' || tipo == 'C') {
				list.add(new Produto(nome,preco));
			}
			else if(tipo == 'u' || tipo == 'U') {
				System.out.print("Data de fabricação: ");
				Date date = sdf.parse(sc.next());
				list.add(new ProdutoUsado(nome,preco,date));
			}
			
			else {
				System.out.print("Taxação: ");
				double taxaAlfandega = sc.nextDouble();
				list.add(new ProdutoImportado(nome,preco,taxaAlfandega));
			}
			
		}
		
		System.out.println();
		System.out.println("Etiqueta de Preços:");
		for (Produto prod : list) {
			System.out.println(prod.priceTag());
		}
		
		sc.close();
	}

}
