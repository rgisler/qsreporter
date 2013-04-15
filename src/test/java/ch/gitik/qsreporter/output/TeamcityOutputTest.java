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
package ch.gitik.qsreporter.output;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import ch.gitik.qsreporter.checkstyle.CheckstyleModel;
import ch.gitik.qsreporter.classycle.ClassycleModel;
import ch.gitik.qsreporter.jacoco.JaCoCoModel;
import ch.gitik.qsreporter.jacoco.JaCoCoSensor;
import ch.gitik.qsreporter.pmd.PmdModel;

/**
 * @author Roland Gisler
 * @version $Revision$
 */
public class TeamcityOutputTest {

   /**
    * Test method for
    * {@link ch.gitik.qsreporter.output.TeamcityOutput#checkstyleOut(ch.gitik.qsreporter.checkstyle.CheckstyleModel)}
    * .
    */
   @Test
   public final void testCheckstyleOut() {
      CheckstyleModel model = new CheckstyleModel(111, 222, 333);
      String message = TeamcityOutput.checkstyleOut(model);
      assertTrue(message.toString().indexOf("'111'") > 0);
      assertTrue(message.toString().indexOf("'222'") > 0);
      assertTrue(message.toString().indexOf("'333'") > 0);
   }

   /**
    * Test method for
    * {@link ch.gitik.qsreporter.output.TeamcityOutput#jacocoOut(ch.gitik.qsreporter.jacoco.JaCoCoModel)}
    * .
    */
   @Test
   public final void testJacocoOut() {
      JaCoCoModel model = new JaCoCoModel(new JaCoCoSensor(10, 90), new JaCoCoSensor(20, 80), new JaCoCoSensor(30, 70),
            new JaCoCoSensor(40, 60), new JaCoCoSensor(50, 50));
      String message = TeamcityOutput.jacocoOut(model);
      assertTrue(message.toString().indexOf("'10'") > 0);
      assertTrue(message.toString().indexOf("'20'") > 0);
      assertTrue(message.toString().indexOf("'30'") > 0);
      assertTrue(message.toString().indexOf("'40'") > 0);
      assertTrue(message.toString().indexOf("'50'") > 0);
   }

   /**
    * Test method for
    * {@link ch.gitik.qsreporter.output.TeamcityOutput#pmdOut(ch.gitik.qsreporter.pmd.PmdModel)}
    * .
    */
   @Test
   public final void testPmdOut() {
      PmdModel model = new PmdModel(111, 222, 333, 444, 555);
      String message = TeamcityOutput.pmdOut(model);
      assertTrue(message.toString().indexOf("'111'") > 0);
      assertTrue(message.toString().indexOf("'222'") > 0);
      assertTrue(message.toString().indexOf("'333'") > 0);
      assertTrue(message.toString().indexOf("'444'") > 0);
      assertTrue(message.toString().indexOf("'555'") > 0);
   }

   /**
    * Test method for
    * {@link ch.gitik.qsreporter.output.TeamcityOutput#classycle(ch.gitik.qsreporter.classycle.ClassycleModel)}
    * .
    */
   @Test
   public final void testClassycleOut() {
      ClassycleModel model = new ClassycleModel(111, 222, 333, 444);
      String message = TeamcityOutput.classycleOut(model);
      assertTrue(message.toString().indexOf("'111'") > 0);
      assertTrue(message.toString().indexOf("'222'") > 0);
      assertTrue(message.toString().indexOf("'333'") > 0);
      assertTrue(message.toString().indexOf("'444'") > 0);
   }

   @Test
   public void testServiceMessageValid() {
      TeamcityOutput.ServiceMessage sm = new TeamcityOutput.ServiceMessage("key", 1);
      assertTrue(sm.toString().indexOf("key") > 0);
   }

   @Test
   public void testServiceMessageInValid() {
      TeamcityOutput.ServiceMessage sm = new TeamcityOutput.ServiceMessage(null, 1);
      assertTrue(sm.toString().indexOf("unknown.key") > 0);
   }
}
