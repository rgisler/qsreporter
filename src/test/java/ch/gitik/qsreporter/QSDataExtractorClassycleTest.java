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

import ch.gitik.qsreporter.classycle.ClassycleModel;
import ch.gitik.qsreporter.classycle.QSDataExtractorClassycle;

/**
 * Testfälle für {@link ch.gitik.qsreporter.classycle.QSDataExtractorClassycle}.
 */
public final class QSDataExtractorClassycleTest {

   /**
    * Test method for {@link ch.gitik.qsreporter.classycle.QSDataExtractorClassycle#extract(File)}.
    */
   @Test
   public void testGetDataValid() {
      final File file = new File("config/testdata/classycle.xml");
      final QSDataExtractorClassycle extractor = new QSDataExtractorClassycle();
      final ClassycleModel data = extractor.extract(file);
      assertNotNull(data);
      assertEquals(5, data.getPackage());
      assertEquals(19, data.getClazz());
      assertEquals(0, data.getClassCycle());
   }

   /**
    * Test method for {@link ch.gitik.qsreporter.classycle.QSDataExtractorClassycle#extract(File)}.
    */
   public void testGetDataInvalid() {
      final File file = new File("config/testdata/invalid.xml");
      final QSDataExtractorClassycle extractor = new QSDataExtractorClassycle();
      final ClassycleModel data = extractor.extract(file);
      assertNull(data);
   }
}
