package XML;

import dao.DataBase;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/*Парсинг XML*/
public class XmlHandler extends DefaultHandler {

    private String currentElement = null;
    DataBase db =  new DataBase();
    boolean isEntered;


    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
//        super.startElement(uri, localName, qName, attributes);
        currentElement = qName;
        isEntered = true;
//        currentElement ="<"+qName+">";
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
//        super.characters(ch, start, length);
        if (isEntered) {
            String valueOfXML = new String(ch, start, length).trim();
            String fromDB = db.getFromDB(currentElement);
            System.out.print(fromDB + " : " + valueOfXML+"\n");
            isEntered = false;
//        System.out.print(db.getFromDB(currentElement)+"["+currentElement+"] : "+ new String(ch,start,length));
//        currentElement="";
        }

    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
//        super.endElement(uri, localName, qName);
//        System.out.println();

    }
}

