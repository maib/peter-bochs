package peter.osdebuginformation;

import java.io.ByteArrayInputStream;
import java.util.Date;
import java.util.Vector;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import peter.CommonLib;

/*
 * Please read/write the os debug information using this class,
 * If you want to extends the functions, please add your functions here, thanks
 */
public class OSDebugInfoHelper {
	static Vector<OSDebugInfo> list = new Vector<OSDebugInfo>();
	public static JOSDebugInformationPanel jOSDebugInformationPanel;

	public Vector<OSDebugInfo> getList() {
		return list;
	}

	public static void addData(String magicByte, long size, String xml) {
		OSDebugInfo info = new OSDebugInfo();
		info.setDate(new Date());
		info.setMagicByte(magicByte);
		info.setSize(size);

		xml = xml.trim();
		info.setXml(xml);

		// parse xml
		jOSDebugInformationPanel.getOsInfoTableModel().getData().clear();
		jOSDebugInformationPanel.getOsInfoTableModel().addRow("OS name", getXPath(xml, "//xml/os/name/text()"));
		jOSDebugInformationPanel.getOsInfoTableModel().addRow("uptime", getXPath(xml, "//xml/os/uptime/text()"));
		jOSDebugInformationPanel.getOsInfoTableModel().addRow("notes", getXPath(xml, "//xml/os/notes/text()"));

		jOSDebugInformationPanel.getKernelInfoTableModel().getData().clear();
		jOSDebugInformationPanel.getKernelInfoTableModel().addRow("name", getXPath(xml, "//xml/kernel/name/text()"));
		jOSDebugInformationPanel.getKernelInfoTableModel().addRow("version", getXPath(xml, "//xml/kernel/version/text()"));
		jOSDebugInformationPanel.getKernelInfoTableModel().addRow("address", getXPath(xml, "//xml/kernel/address/text()"));

		// modules
		{
			NodeList list = OSDebugInfoHelper.getXPathNodeList(xml, "//xml/kernel/modules/module");
			for (int x = 0; x < list.getLength(); x++) {
				String name = OSDebugInfoHelper.getXPath(xml, "//xml/kernel/modules/module[" + (x + 1) + "]/name/text()");
				String address = OSDebugInfoHelper.getXPath(xml, "//xml/kernel/modules/module[" + (x + 1) + "]/address/text()");
				jOSDebugInformationPanel.getKernelModuleInfoTableModel().addRow(name, address);
			}
		}
		// end modules
		// end parse xml
		list.add(info);
	}

	public static String getXPath(String xml, String xpathStr) {
		String str = null;
		ByteArrayInputStream is;
		if (xml.toLowerCase().startsWith("<?xml version=\"1.0\" encoding=\"UTF-8\"?>")) {
			is = new ByteArrayInputStream(xml.getBytes());
		} else {
			is = new ByteArrayInputStream(("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + xml).getBytes());
		}
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			factory.setNamespaceAware(true); // never forget this!
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(is);
			XPathFactory xPathfactory = XPathFactory.newInstance();
			XPath xpath = xPathfactory.newXPath();
			XPathExpression expr = xpath.compile(xpathStr);
			Object result = expr.evaluate(doc, XPathConstants.NODESET);
			NodeList nodes = (NodeList) result;
			if (nodes.getLength() > 0) {
				str = nodes.item(0).getNodeValue();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}

	public static NodeList getXPathNodeList(String xml, String xpathStr) {
		String str = null;
		ByteArrayInputStream is;
		if (xml.toLowerCase().startsWith("<?xml version=\"1.0\" encoding=\"UTF-8\"?>")) {
			is = new ByteArrayInputStream(xml.getBytes());
		} else {
			is = new ByteArrayInputStream(("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + xml).getBytes());
		}
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			factory.setNamespaceAware(true); // never forget this!
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(is);
			XPathFactory xPathfactory = XPathFactory.newInstance();
			XPath xpath = xPathfactory.newXPath();
			XPathExpression expr = xpath.compile(xpathStr);
			Object result = expr.evaluate(doc, XPathConstants.NODESET);
			return (NodeList) result;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
