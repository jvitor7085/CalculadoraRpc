import org.apache.xmlrpc.server.PropertyHandlerMapping;
import org.apache.xmlrpc.server.XmlRpcServer;
import org.apache.xmlrpc.webserver.WebServer;

public class ServidorRPC {

	public static void main(String[] args) {

		try {
			// Cria um servidor web na porta 12345
			WebServer webS = new WebServer(12345);

			XmlRpcServer servidor = webS.getXmlRpcServer();

			// Handler é um tratador de nomes cria o apelido Calc
			PropertyHandlerMapping phm = new PropertyHandlerMapping();
			phm.addHandler("Calc", Calculadora.class);

			// Define um handler no servidor
			servidor.setHandlerMapping(phm);
			
			// inicia o servidor
			webS.start();
			System.out.println("Servidor rodando!");

		} catch (Exception exception) {
			System.err.println("JavaServer: " + exception);
		}
	}
}
