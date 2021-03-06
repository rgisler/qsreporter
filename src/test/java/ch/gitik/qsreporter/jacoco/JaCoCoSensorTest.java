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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

/**
 * Testfälle für {@link JaCoCoSensor}.
 */
public final class JaCoCoSensorTest {

   /**
    * Testfälle für {@link JaCoCoSensor#JaCoCoSensor(int, int)}.
    */
   @Test
   public void testJaCoCoSensor() {
      assertNotNull(new JaCoCoSensor(0, 0));
   }

   /**
    * Testfälle für {@link JaCoCoSensor#getCoverage()}.
    */
   @Test
   public void testGetCovered() {
      final JaCoCoSensor sensor = new JaCoCoSensor(10, 20);
      assertEquals(10, sensor.getCoverage(), 0.01);
   }

   /**
    * Testfälle für {@link JaCoCoSensor#getMissed()}.
    */
   @Test
   public void testGetMissed() {
      final JaCoCoSensor sensor = new JaCoCoSensor(10, 20);
      assertEquals(20, sensor.getMissed(), 0.01);
   }

   /**
    * Testfälle für {@link JaCoCoSensor#getTotal()}.
    */
   @Test
   public void testGetTotal() {
      final JaCoCoSensor sensor = new JaCoCoSensor(10, 20);
      assertEquals(30, sensor.getTotal(), 0.01);
   }

   /**
    * Testfälle für {@link JaCoCoSensor#getPercent()}.
    */
   @Test
   public void testGetPercent() {
      final JaCoCoSensor sensor = new JaCoCoSensor(10, 20);
      assertEquals(33.33, sensor.getPercent(), 0.01);
   }

   /**
    * Testfälle für {@link JaCoCoSensor#getPercent()}.
    */
   @Test
   public void testGetPercentZero() {
      final JaCoCoSensor sensor = new JaCoCoSensor(0, 0);
      assertEquals(0, sensor.getPercent(), 0.01);
   }

   /**
    * Testfälle für {@link JaCoCoSensor#toString()}.
    */
   @Test
   public void testToString() {
      final JaCoCoSensor sensor = new JaCoCoSensor(10, 20);
      assertNotNull(sensor.toString());
   }
}
