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

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import ch.gitik.qsreporter.checkstyle.CheckstyleModel;
import ch.gitik.qsreporter.checkstyle.CheckstyleSensor;
import ch.gitik.qsreporter.jacoco.JaCoCoModel;
import ch.gitik.qsreporter.jacoco.JaCoCoSensor;
import ch.gitik.qsreporter.output.TeamcityServiceMessage;
import ch.gitik.qsreporter.pmd.PmdModel;
import ch.gitik.qsreporter.pmd.PmdSensor;

/**
 * @author Roland Gisler
 * @version $Revision$
 */
public class TeamcityServiceMessageTest {

   /**
    * Test method for
    * {@link ch.gitik.qsreporter.output.TeamcityServiceMessage#ServiceMessage(java.lang.String, int)}
    * .
    */
   @Test
   public final void testServiceMessage() {
      assertNotNull(new TeamcityServiceMessage("key", 100));
   }

   /**
    * Test method for
    * {@link ch.gitik.qsreporter.output.TeamcityServiceMessage#toString()}.
    */
   @Test
   public final void testToString() {
      TeamcityServiceMessage message = new TeamcityServiceMessage("key", 200);
      assertNotNull(message.toString());
      assertTrue(message.toString().indexOf("'key'") > 0);
      assertTrue(message.toString().indexOf("'200'") > 0);
   }

   /**
    * Test method for
    * {@link ch.gitik.qsreporter.output.TeamcityServiceMessage#toString()}.
    */
   @Test
   public final void testToStringWithNull() {
      TeamcityServiceMessage message = new TeamcityServiceMessage(null, 100);
      assertNotNull(message.toString());
      assertTrue(message.toString().indexOf("'unknown.key'") > 0);
      assertTrue(message.toString().indexOf("'0'") > 0);
   }

   /**
    * Test method for
    * {@link ch.gitik.qsreporter.output.TeamcityServiceMessage#serviceMessagesCheckstyle(ch.gitik.qsreporter.checkstyle.CheckstyleModel)}
    * .
    */
   @Test
   public final void testServiceMessagesCheckstyle() {
      CheckstyleModel model = new CheckstyleModel(new CheckstyleSensor(111), new CheckstyleSensor(222),
            new CheckstyleSensor(333));
      String message = TeamcityServiceMessage.serviceMessagesCheckstyle(model);
      assertTrue(message.toString().indexOf("'111'") > 0);
      assertTrue(message.toString().indexOf("'222'") > 0);
      assertTrue(message.toString().indexOf("'333'") > 0);
   }

   /**
    * Test method for
    * {@link ch.gitik.qsreporter.output.TeamcityServiceMessage#serviceMessagesJaCoCo(ch.gitik.qsreporter.jacoco.JaCoCoModel)}
    * .
    */
   @Test
   public final void testServiceMessagesJaCoCo() {
      JaCoCoModel model = new JaCoCoModel(new JaCoCoSensor(10, 90), new JaCoCoSensor(20, 80),
            new JaCoCoSensor(30, 70), new JaCoCoSensor(40, 60), new JaCoCoSensor(50, 50));
      String message = TeamcityServiceMessage.serviceMessagesJaCoCo(model);
      assertTrue(message.toString().indexOf("'10'") > 0);
      assertTrue(message.toString().indexOf("'20'") > 0);
      assertTrue(message.toString().indexOf("'30'") > 0);
      assertTrue(message.toString().indexOf("'40'") > 0);
      assertTrue(message.toString().indexOf("'50'") > 0);
   }

   /**
    * Test method for
    * {@link ch.gitik.qsreporter.output.TeamcityServiceMessage#serviceMessagesPmd(ch.gitik.qsreporter.pmd.PmdModel)}
    * .
    */
   @Test
   public final void testServiceMessagesPmd() {
      PmdModel model = new PmdModel(new PmdSensor(111), new PmdSensor(222), new PmdSensor(333),
            new PmdSensor(444), new PmdSensor(555));
      String message = TeamcityServiceMessage.serviceMessagesPmd(model);
      assertTrue(message.toString().indexOf("'111'") > 0);
      assertTrue(message.toString().indexOf("'222'") > 0);
      assertTrue(message.toString().indexOf("'333'") > 0);
      assertTrue(message.toString().indexOf("'444'") > 0);
      assertTrue(message.toString().indexOf("'555'") > 0);
   }

}
