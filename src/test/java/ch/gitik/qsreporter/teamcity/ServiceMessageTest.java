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
package ch.gitik.qsreporter.teamcity;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 
 * @author Roland Gisler
 * @version $Revision$ 
 */
public class ServiceMessageTest {

   /**
    * Test method for {@link ch.gitik.qsreporter.teamcity.ServiceMessage#ServiceMessage(java.lang.String, int)}.
    */
   @Test
   public final void testServiceMessage() {
      assertNotNull(new ServiceMessage("key", 100));
   }

   /**
    * Test method for {@link ch.gitik.qsreporter.teamcity.ServiceMessage#toString()}.
    */
   @Test
   public final void testToString() {
      ServiceMessage message = new ServiceMessage("key", 200);
      assertNotNull(message.toString());
      assertTrue(message.toString().indexOf("key") > 0);
      assertTrue(message.toString().indexOf("200") > 0);
   }

   /**
    * Test method for {@link ch.gitik.qsreporter.teamcity.ServiceMessage#serviceMessagesCheckstyle(ch.gitik.qsreporter.checkstyle.CheckstyleModel)}.
    */
   @Test
   public final void testServiceMessagesCheckstyle() {
      //fail("Not yet implemented"); // TODO
   }

   /**
    * Test method for {@link ch.gitik.qsreporter.teamcity.ServiceMessage#serviceMessagesJaCoCo(ch.gitik.qsreporter.jacoco.JaCoCoModel)}.
    */
   @Test
   public final void testServiceMessagesJaCoCo() {
      //fail("Not yet implemented"); // TODO
   }

   /**
    * Test method for {@link ch.gitik.qsreporter.teamcity.ServiceMessage#serviceMessagesPmd(ch.gitik.qsreporter.pmd.PmdModel)}.
    */
   @Test
   public final void testServiceMessagesPmd() {
      //fail("Not yet implemented"); // TODO
   }

}
