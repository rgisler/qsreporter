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
package ch.gitik.qsreporter.jacoco;

import static org.junit.Assert.*;

import org.junit.Test;

public class JaCoCoSensorTest {

   @Test
   public void testJaCoCoSensor() {
      assertNotNull(new JaCoCoSensor(0,0));
   }

   @Test
   public void testGetCovered() {
      JaCoCoSensor sensor = new JaCoCoSensor(10,20);
      assertEquals(10, sensor.getCoverage());
   }
   @Test
   public void testGetMissed() {
      JaCoCoSensor sensor = new JaCoCoSensor(10,20);
      assertEquals(20, sensor.getMissed());
   }

   @Test
   public void testGetTotal() {
      JaCoCoSensor sensor = new JaCoCoSensor(10,20);
      assertEquals(30, sensor.getTotal());
   }

   @Test
   public void testGetPercent() {
      JaCoCoSensor sensor = new JaCoCoSensor(10,20);
      assertEquals(33, sensor.getPercent());
   }
}
