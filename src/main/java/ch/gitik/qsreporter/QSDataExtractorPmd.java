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

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import ch.gitik.qsreporter.pmd.PmdModel;
import ch.gitik.qsreporter.pmd.PmdSensor;

/**
 * @author Roland Gisler
 */
public class QSDataExtractorPmd extends AbstractDataExtractor {

   /**
    * Extrahiert Daten aus PMD XML-Report.
    * @param pFile
    *           XML-Report von PMD.
    * @return PMD Daten.
    */
   public final PmdModel extract(final File pFile) {
      PmdModel data = null;
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
    * Extrahiert PMD-Werte aus XML.
    * @param xmlDoc
    *           XML-Datei.
    * @return Pmd Daten.
    * @throws ParserConfigurationException
    *            Bla.
    * @throws SAXException
    *            Bla.
    * @throws IOException
    *            Bla.
    * @throws XPathExpressionException
    *            Bla.
    */
   public final PmdModel getData(final Document xmlDoc) throws ParserConfigurationException, SAXException, IOException,
         XPathExpressionException {

      final XPathFactory factory = XPathFactory.newInstance();
      final XPath xpath = factory.newXPath();
      XPathExpression expression;
      Object resultNumber;

      expression = xpath.compile("count(//file/violation[@priority='1'])");
      resultNumber = expression.evaluate(xmlDoc, XPathConstants.NUMBER);
      PmdSensor level1 = new PmdSensor(((Double) resultNumber).intValue());

      expression = xpath.compile("count(//file/violation[@priority='2'])");
      resultNumber = expression.evaluate(xmlDoc, XPathConstants.NUMBER);
      PmdSensor level2 = new PmdSensor(((Double) resultNumber).intValue());

      expression = xpath.compile("count(//file/violation[@priority='3'])");
      resultNumber = expression.evaluate(xmlDoc, XPathConstants.NUMBER);
      PmdSensor level3 = new PmdSensor(((Double) resultNumber).intValue());

      expression = xpath.compile("count(//file/violation[@priority='4'])");
      resultNumber = expression.evaluate(xmlDoc, XPathConstants.NUMBER);
      PmdSensor level4 = new PmdSensor(((Double) resultNumber).intValue());

      expression = xpath.compile("count(//file/violation[@priority='5'])");
      resultNumber = expression.evaluate(xmlDoc, XPathConstants.NUMBER);
      PmdSensor level5 = new PmdSensor(((Double) resultNumber).intValue());

      return new PmdModel(level1, level2, level3, level4, level5);
   }
}
