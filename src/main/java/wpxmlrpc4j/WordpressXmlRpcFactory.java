package wpxmlrpc4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.UndeclaredThrowableException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.beanutils.DynaProperty;
import org.apache.commons.beanutils.WrapDynaBean;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;
import org.apache.xmlrpc.common.TypeFactory;
import org.apache.xmlrpc.common.TypeFactoryImpl;
import org.apache.xmlrpc.common.XmlRpcStreamConfig;
import org.apache.xmlrpc.serializer.TypeSerializer;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;

import com.fasterxml.jackson.databind.ObjectMapper;


public class WordpressXmlRpcFactory {

	public static Wordpress wordpress(String url) {
		return xmlrpcClient(url, Wordpress.class, "wp");
	}
	
//	public static <X> X newXmlRpc(String url, Class<X> clazz, String methodPrefix, boolean ignoreMissingFields) {
//		try {
//			if (!methodPrefix.endsWith(".")) {
//				methodPrefix = methodPrefix + ".";
//			}
//			XmlRpcClient client = new XmlRpcClient(new URL(url));
//			return (X)client.proxyObject(methodPrefix, clazz, ignoreMissingFields);
//		}
//		catch (Exception e) {
//			throw new RuntimeException("Unable to create XML-RPC Proxy", e);
//		}
//	}
	
	public static class PojoTypeSerializer implements TypeSerializer {
		private final TypeFactory typeFactory;
		private final XmlRpcStreamConfig config;
		public PojoTypeSerializer(TypeFactory typeFactory, XmlRpcStreamConfig config) {
			this.typeFactory = typeFactory;
			this.config = config;
		}
		public void write(ContentHandler pHandler, Object pObject) throws SAXException {
			WrapDynaBean d = new WrapDynaBean(pObject);
			Map<String, Object> map = new LinkedHashMap<String, Object>();
			for (DynaProperty prop : d.getDynaClass().getDynaProperties()) {
				String name = prop.getName();
				Object value = d.get(prop.getName());
				if (value != null && !name.equals("class")) { 
					map.put(name, value);
				}
			}
			typeFactory.getSerializer(config, map).write(pHandler, map);
		}
		
	}
	
	public static <X> X xmlrpcClient(String url, Class<X> clazz, String methodPrefix) {
    	XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();

    	try {
			config.setServerURL(new URL(url));
		} catch (MalformedURLException e) {
			throw new RuntimeException("Unable to parse url " + url);
		}
    	org.apache.xmlrpc.client.XmlRpcClient client = new org.apache.xmlrpc.client.XmlRpcClient();
    	client.setConfig(config);
    	
    	client.setTypeFactory(new TypeFactoryImpl(client) {
			public TypeSerializer getSerializer(final XmlRpcStreamConfig pConfig, Object pObject) throws SAXException {
				TypeSerializer serializer = super.getSerializer(pConfig, pObject);
				if (serializer == null) {
					serializer = new PojoTypeSerializer(this, pConfig);
				}
				return serializer;
				
			}
    	});
    	
//        final HttpClient httpClient = new HttpClient();
//        final XmlRpcCommonsTransportFactory transportFactory = new XmlRpcCommonsTransportFactory(client);
//        transportFactory.setHttpClient(httpClient);
//        client.setTransportFactory(transportFactory);

    	MyClientFactory factory = new MyClientFactory(client);
    	X rpc = (X) factory.newInstance(Thread.currentThread().getContextClassLoader(), clazz, methodPrefix);
    	return rpc;
	}
	

	public interface DriveNowXmlRpc {
		public int findPageIdByParentPageIdAndSlug(int parentPageId, String slug);
	}
	
	public static void main2(String[] args) throws Exception {
		
		
		String username = "server";
		String password = "!drivenow-1910";
		String url = "http://campervanhirenow.wordpress.beast.braid.com.au/xmlrpc.php";
    	XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
		config.setServerURL(new URL(url));
    	final XmlRpcClient client = new XmlRpcClient();
    	client.setTypeFactory(new TypeFactoryImpl(client) {
			public TypeSerializer getSerializer(final XmlRpcStreamConfig pConfig, Object pObject) throws SAXException {
				TypeSerializer serializer = super.getSerializer(pConfig, pObject);
				if (serializer == null) {
					serializer = new TypeSerializer() {
						public void write(ContentHandler pHandler, Object pObject) throws SAXException {
							WrapDynaBean d = new WrapDynaBean(pObject);
							Map<String, Object> map = new LinkedHashMap<String, Object>();
							for (DynaProperty prop : d.getDynaClass().getDynaProperties()) {
								String name = prop.getName();
								Object value = d.get(prop.getName());
								if (value != null && !name.equals("class")) { 
									map.put(name, value);
								}
							}
							getSerializer(pConfig, map).write(pHandler, map);
						}
					};
				}
				return serializer;
				
			}
    	});
//			
//			public TypeParser getParser(XmlRpcStreamConfig pConfig, NamespaceContextImpl pContext, String pURI, String pLocalName) {
//				// TODO Auto-generated method stub
//				return null;
//			}
//		})
    	
    	client.setConfig(config);
    	Object result = client.execute("wp.getPages", new Object[]{0, username, password, 1});
    	ObjectMapper mapper = new ObjectMapper();
//    	String s = mapper.writeValueAsString(result);
//    	System.out.println(s);
//    	Page[] pages = (Page[]) mapper.readValue(s, new TypeReference<Page[]>(){});
    	Page[] pages = mapper.convertValue(result,  Page[].class);
    	CustomField field = new CustomField();
    	field.setKey("hello");
    	field.setValue("world");
		pages[0].setCustom_fields(new CustomField[]{ field });
    	result = client.execute("wp.editPage", new Object[]{0, pages[0].getPage_id(), username, password, pages[0], true});
    	System.out.println(pages[0].getCustom_fields()[0].getKey());
    	
    	

//		Wordpress wp = newWordpressXmlRpc(url);
//		wp.getPages(0, username, password, 10);
//		DriveNowXmlRpc xml = WordpressXmlRpcFactory.newXmlRpc("http://campervanhirenow.wordpress.beast.braid.com.au/xmlrpc.php", DriveNowXmlRpc.class, "drivenow", true);
//		System.out.println(xml.findPageIdByParentPageIdAndSlug(0, "test"));
//
//		xml = WordpressXmlRpcFactory.newXmlRpc2("http://campervanhirenow.wordpress.beast.braid.com.au/xmlrpc.php", DriveNowXmlRpc.class, "drivenow");
//		System.out.println(xml.findPageIdByParentPageIdAndSlug(0, "test"));
	}
	
	public static void main(String[] args) {
		SSLUtilities.trustAllHostnames();
		SSLUtilities.trustAllHttpsCertificates();
		String username = "server";
		String password = "!drivenow-1910";
		String url = "https://melbournecarhire.com.au/xmlrpc.php";

		Wordpress wp = wordpress(url);
		Page page = wp.getPage(0,  9, username, password);
		System.out.println(page);
//		Page[] pages = wp.getPages(0, username, password, 1);
//		Page page = pages[0];
//		boolean editPage = wp.editPage(0, page.getPage_id(), username, password, page, true);
//		System.out.println(editPage);
		
//		DriveNowXmlRpc xml = WordpressXmlRpcFactory.xmlrpcClient("http://campervanhirenow.wordpress.beast.braid.com.au/xmlrpc.php", DriveNowXmlRpc.class, "drivenow");
//		System.out.println(xml.findPageIdByParentPageIdAndSlug(0, "about-us"));
//		System.out.println(xml.findPageIdByParentPageIdAndSlug(27, "about-us"));


	}

	public static class MyClientFactory {
	    private final XmlRpcClient client;
	    private boolean objectMethodLocal;
	    private ObjectMapper objectMapper = new ObjectMapper();

	    /** Creates a new instance. Shortcut for
	     * <pre>
	     *   new ClientFactory(pClient);
	     * </pre>
	     * @param pClient A fully configured XML-RPC client, which is
	     *   used internally to perform XML-RPC calls.
	     */
	    public MyClientFactory(XmlRpcClient pClient) {
	        this.client = pClient;
	    }

	    /** Returns the factories client.
	     */
	    public XmlRpcClient getClient() {
	        return client;
	    }

	    /** Returns, whether a method declared by the {@link Object
	     * Object class} is performed by the local object, rather than
	     * by the server. Defaults to true.
	     */
	    public boolean isObjectMethodLocal() {
	        return objectMethodLocal;
	    }

	    /** Sets, whether a method declared by the {@link Object
	     * Object class} is performed by the local object, rather than
	     * by the server. Defaults to true.
	     */
	    public void setObjectMethodLocal(boolean pObjectMethodLocal) {
	        objectMethodLocal = pObjectMethodLocal;
	    }

	    /**
	     * Creates an object, which is implementing the given interface.
	     * The objects methods are internally calling an XML-RPC server
	     * by using the factories client; shortcut for
	     * <pre>
	     *   newInstance(Thread.currentThread().getContextClassLoader(),
	     *     pClass)
	     * </pre>
	     */
	    public Object newInstance(Class pClass) {
	        return newInstance(Thread.currentThread().getContextClassLoader(), pClass);
	    }

	    /** Creates an object, which is implementing the given interface.
	     * The objects methods are internally calling an XML-RPC server
	     * by using the factories client; shortcut for
	     * <pre>
	     *   newInstance(pClassLoader, pClass, pClass.getName())
	     * </pre>
	     */
	    public Object newInstance(ClassLoader pClassLoader, Class pClass) {
	        return newInstance(pClassLoader, pClass, pClass.getName());
	    }

	    /** Creates an object, which is implementing the given interface.
	     * The objects methods are internally calling an XML-RPC server
	     * by using the factories client.
	     * @param pClassLoader The class loader, which is being used for
	     *   loading classes, if required.
	     * @param pClass Interface, which is being implemented.
	     * @param pRemoteName Handler name, which is being used when
	     *   calling the server. This is used for composing the
	     *   method name. For example, if <code>pRemoteName</code>
	     *   is "Foo" and you want to invoke the method "bar" in
	     *   the handler, then the full method name would be "Foo.bar".
	     */
	    public Object newInstance(ClassLoader pClassLoader, final Class pClass, final String pRemoteName) {
	       return Proxy.newProxyInstance(pClassLoader, new Class[]{pClass}, new InvocationHandler(){
	            public Object invoke(Object pProxy, Method pMethod, Object[] pArgs) throws Throwable {
	                if (isObjectMethodLocal()  &&  pMethod.getDeclaringClass().equals(Object.class)) {
	                    return pMethod.invoke(pProxy, pArgs);
	                }
	                final String methodName;
	                if (pRemoteName == null  ||  pRemoteName.length() == 0) {
	                	methodName = pMethod.getName();
	                } else {
	                	methodName = pRemoteName + "." + pMethod.getName();
	                }
	                Object result;
	                try {
	                    result = client.execute(methodName, pArgs);
//	                } catch (XmlRpcInvocationException e) {
//	                    Throwable t = e.linkedException;
//	                    if (t instanceof RuntimeException) {
//	                        throw t;
//	                    }
//	                    Class[] exceptionTypes = pMethod.getExceptionTypes();
//	                    for (int i = 0;  i < exceptionTypes.length;  i++) {
//	                        Class c = exceptionTypes[i];
//	                        if (c.isAssignableFrom(t.getClass())) {
//	                            throw t;
//	                        }
//	                    }
//	                    throw new UndeclaredThrowableException(t);
	                } catch (Exception e) {
	                    Class[] exceptionTypes = pMethod.getExceptionTypes();
	                    for (int i = 0;  i < exceptionTypes.length;  i++) {
	                        Class c = exceptionTypes[i];
	                        if (c.isAssignableFrom(e.getClass())) {
	                            throw e;
	                        }
	                    }
	                    throw new UndeclaredThrowableException(e);
	                }
	            	return objectMapper.convertValue(result,  pMethod.getReturnType());
	            }
	        });
	    }
	}
}
