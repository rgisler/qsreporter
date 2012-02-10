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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;

import org.junit.Test;

import ch.gitik.qsreporter.pmd.PmdModel;

/**
 * @author Roland Gisler
 * @version $Revision$
 */
public class QSDataExtractorPmdTest {

   /**
    * Test method for
    * {@link ch.gitik.qsreporter.QSDataExtractorPmd#getData(org.w3c.dom.Document)}
    * .
    */
   @Test
   public void testGetDataValid() {
      final File file = new File("cfg/testdata/pmd.xml");
      final QSDataExtractorPmd extractor = new QSDataExtractorPmd();
      final PmdModel data = extractor.extract(file);
      assertNotNull(data);
      
      assertEquals(0,data.getLevel1().getCount());
      assertEquals(0,data.getLevel2().getCount());
      assertEquals(12,data.getLevel3().getCount());
      assertEquals(6,data.getLevel4().getCount());
      assertEquals(0,data.getLevel5().getCount());
   }

}