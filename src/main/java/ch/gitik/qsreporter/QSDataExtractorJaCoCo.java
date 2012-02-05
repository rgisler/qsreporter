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

/**
 * 
 * @author Roland Gisler
 */
public class QSDataExtractorJaCoCo {

   /**
    * @param args
    */
   public static void main(String[] args) {
      try {

         getData();

      } catch (SAXParseException err) {
         System.out.println("** Parsing error" + ", line " + err.getLineNumber() + ", uri " + err.getSystemId());
         System.out.println(" " + err.getMessage());

      } catch (SAXException e) {
         Exception x = e.getException();
         ((x == null) ? e : x).printStackTrace();

      } catch (Throwable t) {
         t.printStackTrace();
      }
   }

   /**
    * Extrahiert Daten aus dem XML.
    * @throws ParserConfigurationException
    * @throws IOException
    * @throws SAXException
    * @throws XPathExpressionException
    */
   private static void getData() throws ParserConfigurationException, SAXException, IOException,
         XPathExpressionException {

      DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
      domFactory.setNamespaceAware(true); // never forget this!
      domFactory.setIgnoringComments(true);
      DocumentBuilder builder = domFactory.newDocumentBuilder();
      builder.setEntityResolver(new EntityResolver() {

         @Override
         public InputSource resolveEntity(String publicId, String systemId) throws SAXException, IOException {
            System.out.println("Ignoring " + publicId + ", " + systemId);
            return new InputSource(new StringReader(""));
         }
      });
      Document doc = builder.parse(new File("cfg/testdata/coverage.xml"));

      XPathFactory factory = XPathFactory.newInstance();
      XPath xpath = factory.newXPath();

      XPathExpression exprType = xpath.compile("//report/counter/@type");
      Object resultType = exprType.evaluate(doc, XPathConstants.NODESET);
      NodeList nodesType = (NodeList) resultType;

      XPathExpression exprCovered = xpath.compile("//report/counter/@covered");
      Object resultCovered = exprCovered.evaluate(doc, XPathConstants.NODESET);
      NodeList nodesCovered = (NodeList) resultCovered;

      XPathExpression exprMissed = xpath.compile("//report/counter/@missed");
      Object resultMissed = exprMissed.evaluate(doc, XPathConstants.NODESET);
      NodeList nodesMissed = (NodeList) resultMissed;

      Node typeNode;
      Node coveredNode;
      Node missedNode;
      for (int i = 0; i < nodesType.getLength(); i++) {
         typeNode = nodesType.item(i);
         coveredNode = nodesCovered.item(i);
         missedNode = nodesMissed.item(i);
         System.out.println(typeNode.getNodeValue() + ":" + coveredNode.getNodeValue() + ":"
               + missedNode.getNodeValue());
      }
   }
}
