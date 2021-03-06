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
import static org.junit.Assert.assertNull;

import java.io.File;

import org.junit.Test;

import ch.gitik.qsreporter.jacoco.JaCoCoModel;
import ch.gitik.qsreporter.jacoco.QSDataExtractorJaCoCo;

/**
 * Testfälle für {@link QSDataExtractorJaCoCo}.
 */
public final class QSDataExtractorJaCoCoTest {

   /**
    * Testfall für {@link QSDataExtractorJaCoCo#extract(File)}.
    */
   @Test
   public void testGetDataValid() {
      final File file = new File("config/testdata/coverage.xml");
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

      assertEquals(80, data.getClazz().getPercent(), 0.01);
      assertEquals(90.47, data.getMethode().getPercent(), 0.01);
      assertEquals(80.76, data.getBranch().getPercent(), 0.01);
      assertEquals(81.81, data.getLine().getPercent(), 0.01);
      assertEquals(86.52, data.getInstruction().getPercent(), 0.01);
   }

   /**
    * Testfall für {@link QSDataExtractorJaCoCo#extract(File)}.
    */
   @Test
   public void testGetDataInvalid() {
      final File file = new File("config/testdata/invalid.xml");
      final QSDataExtractorJaCoCo extractor = new QSDataExtractorJaCoCo();
      final JaCoCoModel data = extractor.extract(file);
      assertNull(data);
   }

   /**
    * Testfall für {@link QSDataExtractorJaCoCo#extract(File)}.
    */
   @Test
   public void testGetDataValidZero() {
      final File file = new File("config/testdata/coverage-empty.xml");
      final QSDataExtractorJaCoCo extractor = new QSDataExtractorJaCoCo();
      final JaCoCoModel data = extractor.extract(file);
      assertNotNull(data);
      assertEquals(0, data.getClazz().getCoverage());
      assertEquals(0, data.getMethode().getCoverage());
      assertEquals(0, data.getBranch().getCoverage());
      assertEquals(0, data.getLine().getCoverage());
      assertEquals(0, data.getInstruction().getCoverage());

      assertEquals(4, data.getClazz().getMissed());
      assertEquals(9, data.getMethode().getMissed());
      assertEquals(0, data.getBranch().getMissed());
      assertEquals(19, data.getLine().getMissed());
      assertEquals(111, data.getInstruction().getMissed());

      assertEquals(4, data.getClazz().getTotal());
      assertEquals(9, data.getMethode().getTotal());
      assertEquals(0, data.getBranch().getTotal());
      assertEquals(19, data.getLine().getTotal());
      assertEquals(111, data.getInstruction().getTotal());

      assertEquals(0, data.getClazz().getPercent(), 0.01);
      assertEquals(0, data.getMethode().getPercent(), 0.01);
      assertEquals(0, data.getBranch().getPercent(), 0.01);
      assertEquals(0, data.getLine().getPercent(), 0.01);
      assertEquals(0, data.getInstruction().getPercent(), 0.01);
   }
}
