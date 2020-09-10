package entities;

public class ProdutoImportado extends Produto {
	private Double taxaAlfandega;
	
	public ProdutoImportado() {
		super();
	}

	public ProdutoImportado(String nome, Double preco, Double taxaAlfandega) {
		super(nome, preco);
		this.taxaAlfandega = taxaAlfandega;
	}

	public Double getTaxaAlfandega() {
		return taxaAlfandega;
	}

	public void setTaxaAlfandega(Double taxaAlfandega) {
		this.taxaAlfandega = taxaAlfandega;
	}
	
	public Double totalPrice() {
		return getPreco() + taxaAlfandega;
	}
	
	@Override
	public String priceTag() {
		return getNome() + " $ " + String.format("%.2f", totalPrice())
		+ " (Taxação: $ " 
		+ String.format("%.2f", taxaAlfandega)
		+ ")";
	}
	
	}
