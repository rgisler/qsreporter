/*
 * Copyright 2012 Roland Gisler, GISLER iNFORMATiK, Switzerland.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ch.gitik.qsreporter;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import ch.gitik.qsreporter.checkstyle.CheckstyleModel;
import ch.gitik.qsreporter.checkstyle.CheckstyleSensor;

/**
 * @author Roland Gisler
 */
public class QSDataExtractorCheckstyle {

   /**
    * Extrahiert Daten aus Checkstyle XML-Report.
    * @param pFile
    *           XML-Report von Checkstyle.
    * @return Checkstyle Daten.
    */
   public final CheckstyleModel extract(final File pFile) {
      CheckstyleModel data = null;
      try {
         final Document doc = getDocument(pFile);
         data = this.getData(doc);
      } catch (SAXParseException err) {
         System.out.println("** Parsing error" + ", line " + err.getLineNumber() + ", uri " + err.getSystemId());
         System.out.println(" " + err.getMessage());
      } catch (SAXException e) {
         e.printStackTrace();
      } catch (XPathExpressionException e) {
         e.printStackTrace();
      } catch (ParserConfigurationException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      }
      return data;
   }

   /**
    * Extrahiert Daten aus Document.
    * @param xmlDoc
    *           Document.
    * @return Coveragedaten.
    * @throws ParserConfigurationException
    *            Bla.
    * @throws SAXException
    *            Bla.
    * @throws IOException
    *            Bla.
    * @throws XPathExpressionException
    *            Bla.
    */
   public final CheckstyleModel getData(final Document xmlDoc) throws ParserConfigurationException, SAXException,
         IOException, XPathExpressionException {

      final XPathFactory factory = XPathFactory.newInstance();
      final XPath xpath = factory.newXPath();
      XPathExpression expression;
      Object resultNumber;
      
      expression = xpath.compile("count(//file/error)");
      resultNumber = expression.evaluate(xmlDoc, XPathConstants.NUMBER);
      CheckstyleSensor errors = new CheckstyleSensor(((Double) resultNumber).intValue());

      expression = xpath.compile("count(//file/warning)");
      resultNumber = expression.evaluate(xmlDoc, XPathConstants.NUMBER);
      CheckstyleSensor warnings = new CheckstyleSensor(((Double) resultNumber).intValue());

      expression = xpath.compile("count(//file/info)");
      resultNumber = expression.evaluate(xmlDoc, XPathConstants.NUMBER);
      CheckstyleSensor infos = new CheckstyleSensor(((Double) resultNumber).intValue());


      return new CheckstyleModel(errors, warnings, infos);
   }

   /**
    * Liefert das XML-Dokument.
    * @param pFile
    *           XML-Report.
    * @return Coveragedaten.
    * @throws ParserConfigurationException
    *            Bla.
    * @throws SAXException
    *            Bla.
    * @throws IOException
    *            Bla.
    */
   private static Document getDocument(final File pFile) throws ParserConfigurationException, SAXException, IOException {
      final DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
      domFactory.setNamespaceAware(true);
      domFactory.setIgnoringComments(true);
      final DocumentBuilder builder = domFactory.newDocumentBuilder();
      builder.setEntityResolver(new EntityResolver() {
         @Override
         public InputSource resolveEntity(final String publicId, final String systemId) throws SAXException,
               IOException {
            return new InputSource(new StringReader(""));
         }
      });
      return builder.parse(pFile);
   }
}
