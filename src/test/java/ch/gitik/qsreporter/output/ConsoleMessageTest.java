/*
 * Copyright 2015 Roland Gisler, GISLER iNFORMATiK, Switzerland.
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
 *
 * $Id: AbstractBpmsTask.java 38 2007-02-12 12:50:46Z rog $
 */
package ch.gitik.qsreporter.output;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import ch.gitik.qsreporter.checkstyle.CheckstyleModel;
import ch.gitik.qsreporter.classycle.ClassycleModel;
import ch.gitik.qsreporter.jacoco.JaCoCoModel;
import ch.gitik.qsreporter.jacoco.JaCoCoSensor;
import ch.gitik.qsreporter.pmd.PmdModel;

/**
 * Testfälle für {@link ConsoleMessage}.
 */
public final class ConsoleMessageTest {

   /**
    * Testfälle für {@link ConsoleMessage#checkstyleOut(CheckstyleModel)}.
    */
   @Test
   public void testCheckstyleOut() {
      final CheckstyleModel model = new CheckstyleModel(10, 20, 30);
      final String console = ConsoleMessage.checkstyleOut(model);
      assertNotNull(console);
   }

   /**
    * Testfälle für {@link ConsoleMessage#pmdOut(PmdModel)}.
    */
   @Test
   public void testPmdOut() {
      final PmdModel model = new PmdModel(10, 20, 30, 40, 50);
      final String console = ConsoleMessage.pmdOut(model);
      assertNotNull(console);
   }

   /**
    * Testfälle für {@link ConsoleMessage#jaCoCoOut(JaCoCoModel)}.
    */
   @Test
   public void testJaCoCoOut() {
      final JaCoCoModel model = new JaCoCoModel(new JaCoCoSensor(10, 90), new JaCoCoSensor(20, 80), new JaCoCoSensor(
            30, 70), new JaCoCoSensor(40, 60), new JaCoCoSensor(50, 50));
      final String console = ConsoleMessage.jaCoCoOut(model);
      assertNotNull(console);
   }

   /**
    * Testfälle für {@link ConsoleMessage#classycleOut(ClassycleModel)}.
    */
   @Test
   public void testClassycleOut() {
      final ClassycleModel model = new ClassycleModel(10, 60, 2, 1);
      final String console = ConsoleMessage.classycleOut(model);
      assertNotNull(console);
   }
}
