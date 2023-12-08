package sistemadetestes.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import sistemadetestes.pageObject.ProdutoPO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProdutoTest extends BaseTest {
    
    private static ProdutoPO produtoPage;

    @BeforeClass
    public static void prepararTestes() {
        produtoPage = new ProdutoPO(driver);
    }

    /**
     * Teste para verificar se o sistema não cadastra um produto com campos obrigatórios vazios.
     */
    @Test
    public void TC001_naoDeveCadastrarProdutoComCamposObrigatoriosVazios() {
        produtoPage.preencherCampoNome("");
        produtoPage.preencherCampoValor("");
        produtoPage.preencherCampoQuantidade("");

        produtoPage.clicarCadastrar();

        String mensagemErroNome = produtoPage.obterMensagemErroNome();
        String mensagemErroValor = produtoPage.obterMensagemErroPreco();

        assertEquals("Campo obrigatório", mensagemErroNome);
        assertEquals("Campo obrigatório", mensagemErroValor);
    }

    /**
     * Teste para verificar se o sistema não cadastra um produto com preço inválido.
     */
    @Test
    public void TC002_naoDeveCadastrarProdutoComPrecoInvalido() {
        produtoPage.preencherCampoNome("Produto Teste");
        produtoPage.preencherCampoValor("1");
        produtoPage.preencherCampoQuantidade("2");

        produtoPage.clicarCadastrar();

        String mensagemErroValor = produtoPage.obterMensagemErroPreco();

        assertEquals("Formato de preço inválido", mensagemErroValor);
    }
}
