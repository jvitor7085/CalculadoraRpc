package Cliente;
import java.net.URL;
import java.util.Scanner;

import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

public class ClienteRPC {

	// DEFINE A URL DO SERVIDOR
	private static final String URL_SERVIDOR = "http://localhost:12345";
	private XmlRpcClient cliente;

	public ClienteRPC() {
		try {
			// configuração do cliente para que ele possa se conectar ao servidor
			XmlRpcClientConfigImpl configuracaoCliente = new XmlRpcClientConfigImpl();
			configuracaoCliente.setServerURL(new URL(URL_SERVIDOR));
			// seta a configuração no cliente
			cliente = new XmlRpcClient();
			cliente.setConfig(configuracaoCliente);
		} catch (Exception exception) {
			System.err.println("JavaServer: " + exception);
		}
	}

    //Métodos que fazem ligação com a classe calculadora
	//----------------------------------------------------------------------------------
	public int soma(int x, int y) throws Exception {
		Object[] parametros = new Object[] { x, y };
		Integer resultado = (Integer) cliente.execute("Calc.adicao", parametros);
		return resultado;
	}

	public int subtracao(int x, int y) throws Exception {
		Object[] parametros = new Object[] { x, y };
		Integer resultado = (Integer) cliente.execute("Calc.subtracao", parametros);
		return resultado;
	}

	public int multiplicacao(int x, int y) throws Exception {
		Object[] parametros = new Object[] { x, y };
		Integer resultado = (Integer) cliente.execute("Calc.multiplicacao", parametros);
		return resultado;
	}

	public double divisao(int x, int y) throws Exception {
		Object[] parametros = new Object[] { x, y };
		Double resultado = (Double) cliente.execute("Calc.divisao", parametros);
		return resultado;
	}
	//-----------------------------------------------------------------------------------
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) throws Exception {
		ClienteRPC conta = new ClienteRPC();

		//Peço a opção de operação e após a operação ter sido concluída ela para
		while (true) {
			println("Bem vindo a calculadora");
			println("Qual operacao voce quer fazer?");
			println("Para soma escolha (1)");
			println("Para subtracao escolha (2)");
			println("Para multiplicacao escolha (3)");
			println("Para divisao escolha (4)");
			int resp = sc.nextInt();

			if (resp == 1) {
				println("Informe o primeiro numero da soma:");
				int num1 = sc.nextInt();
				println("Informe o segundo numero da soma:");
				int num2 = sc.nextInt();
				println("O resultado de " + num1 + "+" + num2 + "=" + conta.soma(num1, num2));
				break;
			}
			if (resp == 2) {
				println("Informe o primeiro numero da subtracao:");
				int num1 = sc.nextInt();
				println("Informe o segundo numero da subtracao:");
				int num2 = sc.nextInt();
				println("O resultado de " + num1 + "-" + num2 + "=" + conta.subtracao(num1, num2));
				break;
			}

			if (resp == 3) {
				println("Informe o primeiro numero da multiplicacao:");
				int num1 = sc.nextInt();
				println("Informe o segundo numero da multiplicacao:");
				int num2 = sc.nextInt();
				println("O resultado de " + num1 + "x" + num2 + "=" + conta.multiplicacao(num1, num2));
				break;
			}

			if (resp == 4) {
				println("Informe o primeiro numero da divisao:");
				int num1 = sc.nextInt();
				println("Informe o segundo numero da divisao:");
				int num2 = sc.nextInt();
				println("O resultado de " + num1 + "/" + num2 + "=" + conta.divisao(num1, num2));
				break;
			} else {
				println("escolha uma opcao valida");
			}

		}

	}
	
//Esse método é só pra ficar mais fácil imprimir
	public static void println(String content) {
		System.out.println(content);
	}
}
