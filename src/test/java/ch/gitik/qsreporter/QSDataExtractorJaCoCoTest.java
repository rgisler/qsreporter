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

import ch.gitik.qsreporter.jacoco.JaCoCoModel;

/**
 * 
 * @author Roland Gisler
 */
public class QSDataExtractorJaCoCoTest {

   @Test
   public void testGetDataValid() {
      final File file = new File("cfg/testdata/coverage.xml");
      final QSDataExtractorJaCoCo extractor = new QSDataExtractorJaCoCo();
      final JaCoCoModel data = extractor.extract(file);
      assertNotNull(data);

      assertEquals(4, data.getClazz().getCoverage());
      assertEquals(19, data.getMethode().getCoverage());
      assertEquals(21, data.getBranch().getCoverage());
      assertEquals(81, data.getLine().getCoverage());
      assertEquals(411, data.getInstruction().getCoverage());

      assertEquals(1, data.getClazz().getMissed());
      assertEquals(2, data.getMethode().getMissed());
      assertEquals(5, data.getBranch().getMissed());
      assertEquals(18, data.getLine().getMissed());
      assertEquals(64, data.getInstruction().getMissed());

      assertEquals(5, data.getClazz().getTotal());
      assertEquals(21, data.getMethode().getTotal());
      assertEquals(26, data.getBranch().getTotal());
      assertEquals(99, data.getLine().getTotal());
      assertEquals(475, data.getInstruction().getTotal());

      assertEquals(80, data.getClazz().getPercent());
      assertEquals(90, data.getMethode().getPercent());
      assertEquals(80, data.getBranch().getPercent());
      assertEquals(81, data.getLine().getPercent());
      assertEquals(86, data.getInstruction().getPercent());
   }

   @Test
   public void testGetDataInvalid() {
      final File file = new File("cfg/testdata/invalid.xml");
      final QSDataExtractorJaCoCo extractor = new QSDataExtractorJaCoCo();
      final JaCoCoModel data = extractor.extract(file);
      assertNull(data);
   }
}
