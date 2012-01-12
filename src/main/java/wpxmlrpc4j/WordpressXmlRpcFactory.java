package wpxmlrpc4j;

import java.net.URL;


import com.flat502.rox.client.XmlRpcClient;

public class WordpressXmlRpcFactory {

	public static WordpressXmlRpc newWordpressXmlRpc(String url, boolean ignoreMissingFields) {
		try {
			XmlRpcClient client = new XmlRpcClient(new URL(url));
			return (WordpressXmlRpc)client.proxyObject("wp.", WordpressXmlRpc.class, ignoreMissingFields);
		}
		catch (Exception e) {
			throw new RuntimeException("Unable to create XML-RPC Proxy", e);
		}
	}
}
