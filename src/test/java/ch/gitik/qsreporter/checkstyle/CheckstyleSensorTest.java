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
 * 
 * $Id: AbstractBpmsTask.java 38 2007-02-12 12:50:46Z rog $
 */
package ch.gitik.qsreporter.checkstyle;

import static org.junit.Assert.*;

import org.junit.Test;

public class CheckstyleSensorTest {

   @Test
   public void testCheckstyleSensor() {
      assertNotNull(new CheckstyleSensor(10));
   }

   @Test
   public void testGetCount() {
      CheckstyleSensor sensor = new CheckstyleSensor(20);
      assertEquals(20, sensor.getCount());
   }

   @Test
   public void testToString() {
      assertNotNull(new CheckstyleSensor(30).toString());
   }
}
