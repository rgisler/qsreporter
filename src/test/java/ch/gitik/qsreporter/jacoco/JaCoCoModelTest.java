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
 */
package ch.gitik.qsreporter.jacoco;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

/**
 * Testfälle für {@link JaCoCoModel}.
 */
public final class JaCoCoModelTest {

   /**
    * Testfälle für
    * {@link JaCoCoModel#JaCoCoModel(JaCoCoSensor, JaCoCoSensor, JaCoCoSensor, JaCoCoSensor, JaCoCoSensor)}
    * .
    */
   @Test
   public void testJaCoCoModel() {
      final JaCoCoModel model = new JaCoCoModel(null, null, null, null, null);
      assertNotNull(model);
   }

   /**
    * Testfälle für {@link JaCoCoModel}.
    */
   @Test
   public void testGetter() {
      final JaCoCoSensor sensor1 = new JaCoCoSensor(1, 6);
      final JaCoCoSensor sensor2 = new JaCoCoSensor(2, 6);
      final JaCoCoSensor sensor3 = new JaCoCoSensor(3, 7);
      final JaCoCoSensor sensor4 = new JaCoCoSensor(4, 8);
      final JaCoCoSensor sensor5 = new JaCoCoSensor(5, 9);
      final JaCoCoModel model = new JaCoCoModel(sensor1, sensor2, sensor3, sensor4, sensor5);
      assertEquals(sensor1, model.getClazz());
      assertEquals(sensor2, model.getMethode());
      assertEquals(sensor3, model.getBranch());
      assertEquals(sensor4, model.getLine());
      assertEquals(sensor5, model.getInstruction());
   }

   /**
    * Testfälle für {@link JaCoCoModel#toString()}.
    */
   @Test
   public void testToString() {
      final JaCoCoModel model = new JaCoCoModel(null, null, null, null, null);
      assertNotNull(model.toString());
   }
}
