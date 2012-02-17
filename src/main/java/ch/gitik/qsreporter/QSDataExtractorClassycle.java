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

import ch.gitik.qsreporter.classycle.ClassycleModel;

/**
 * @author Roland Gisler
 */
public class QSDataExtractorClassycle extends AbstractDataExtractor {

   /**
    * Extrahiert Daten aus Classycle XML-Report.
    * @param pFile
    *           XML-Report von Classycle.
    * @return Classycle Daten.
    */
   public final ClassycleModel extract(final File pFile) {
      ClassycleModel data = null;
      try {
         final Document doc = getDocument(pFile);
         data = this.getData(doc);
      } catch (SAXParseException e) {
         e.printStackTrace();
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
   public final ClassycleModel getData(final Document xmlDoc) throws ParserConfigurationException,
         SAXException, IOException, XPathExpressionException {

      final XPathFactory factory = XPathFactory.newInstance();
      final XPath xpath = factory.newXPath();
      XPathExpression expression;
      Object resultNumber;

      expression = xpath.compile("count(//packages/package)");
      resultNumber = expression.evaluate(xmlDoc, XPathConstants.NUMBER);
      final int packageSensor = ((Double) resultNumber).intValue();

      expression = xpath.compile("count(//classes/class)");
      resultNumber = expression.evaluate(xmlDoc, XPathConstants.NUMBER);
      final int classSensor = ((Double) resultNumber).intValue();

      expression = xpath.compile("count(//packages/packageCycle)");
      resultNumber = expression.evaluate(xmlDoc, XPathConstants.NUMBER);
      final int packageCycleSensor = ((Double) resultNumber).intValue();

      expression = xpath.compile("count(//cycles/cylcle)");
      resultNumber = expression.evaluate(xmlDoc, XPathConstants.NUMBER);
      final int classCycleSensor = ((Double) resultNumber).intValue();

      return new ClassycleModel(packageSensor, classSensor, packageCycleSensor, classCycleSensor);
   }
}
