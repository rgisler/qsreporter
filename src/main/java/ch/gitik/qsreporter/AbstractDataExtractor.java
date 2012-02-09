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

import org.w3c.dom.Document;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import ch.gitik.qsreporter.checkstyle.CheckstyleModel;

/**
 * Abstrakte Basisklasse für Datenextraktor.
 * @author Roland Gisler
 */
public abstract class AbstractDataExtractor {

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
   protected static Document getDocument(final File pFile) throws ParserConfigurationException, SAXException, IOException {
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

   /**
    * Konstruktor.
    */
   public AbstractDataExtractor() {
      super();
   }

}