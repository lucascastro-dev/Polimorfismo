package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ProdutoUsado extends Produto{
	private Date dataFabricacao;
	SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy");
	
	public ProdutoUsado() {
		super();
	}

	public ProdutoUsado(String nome, Double preco, Date dataFabricacao) {
		super(nome, preco);
		this.dataFabricacao = dataFabricacao;
	}

	public Date getDataFabricacao() {
		return dataFabricacao;
	}

	public void setDataFabricacao(Date dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}
	
	@Override
	public String priceTag() {
		return getNome() + "(Usado) $ " + getPreco() + " (Data de fabrica��o: " +  sdf.format(dataFabricacao) + ")";
	}
}
