package sistemadetestes.pageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProdutoPO extends BasePO {

	@FindBy(id = "campo_codigo")
	public WebElement campoCodigo;

	@FindBy(id = "campo_nome")
	public WebElement campoNome;

	@FindBy(id = "campo_quantidade")
	public WebElement campoQuantidade;

	@FindBy(id = "campo_valor")
	public WebElement campoValue;

	@FindBy(id = "botao_cadastrar")
	public WebElement botaoCadastrar;

	@FindBy(id = "botao_cancelar")
	public WebElement botaoCancelar;

	@FindBy(id = "mensagem_erro_preco")
	public WebElement mensagemErroPreco;

	@FindBy(id = "mensagem_erro_nome")
	public WebElement mensagemErroNome;

	public ProdutoPO(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void preencherCampoCodigo(String codigo) {
		campoCodigo.clear();
		campoCodigo.sendKeys(codigo + Keys.TAB);
	}

	public void preencherCampoNome(String nome) {
		campoNome.clear();
		campoNome.sendKeys(nome + Keys.TAB);
	}

	public void preencherCampoQuantidade(String quantidade) {
		campoQuantidade.clear();
		campoQuantidade.sendKeys(quantidade + Keys.TAB);
	}

	public void preencherCampoValor(String valor) {
		campoValue.clear();
		campoValue.sendKeys(valor + Keys.TAB);
	}

	public void clicarCadastrar() {
		botaoCadastrar.click();
	}

	public void clicarCancelar() {
		botaoCancelar.click();
	}

	public String obterMensagemErroPreco() {
		return mensagemErroPreco.getText();
	}

	public String obterMensagemErroNome() {
		return mensagemErroNome.getText();
	}

	public String obterTituloPagina() {
		return driver.getTitle();
	}

}
