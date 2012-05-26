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

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

import ch.gitik.qsreporter.checkstyle.CheckstyleModel;

/**
 * @author Roland Gisler
 * @version $Revision$
 */
public class QSDataExtractorCheckstyleTest {

   /**
    * Test method for
    * {@link ch.gitik.qsreporter.QSDataExtractorCheckstyle#getData(org.w3c.dom.Document)}
    * .
    */
   @Test
   public void testGetDataValid() {
      final File file = new File("cfg/testdata/checkstyle.xml");
      final QSDataExtractorCheckstyle extractor = new QSDataExtractorCheckstyle();
      final CheckstyleModel data = extractor.extract(file);
      assertNotNull(data);
      assertEquals(3, data.getError());
      assertEquals(0, data.getWarning());
      assertEquals(0, data.getInfo());
   }

   @Test
   public void testGetDataInvalid() {
      final File file = new File("cfg/testdata/invalid.xml");
      final QSDataExtractorCheckstyle extractor = new QSDataExtractorCheckstyle();
      final CheckstyleModel data = extractor.extract(file);
      assertNull(data);
   }
}
