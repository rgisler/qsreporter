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
package ch.gitik.qsreporter.jacoco;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Roland Gisler
 * @version $Revision$
 */
public class JaCoCoModelTest {

   @Test
   public void testJaCoCoModel() {
      JaCoCoModel model = new JaCoCoModel(null, null, null, null, null);
      assertNotNull(model);
   }

   @Test
   public void testGetter() {
      final JaCoCoSensor s1 = new JaCoCoSensor(1, 6);
      final JaCoCoSensor s2 = new JaCoCoSensor(2, 6);
      final JaCoCoSensor s3 = new JaCoCoSensor(3, 7);
      final JaCoCoSensor s4 = new JaCoCoSensor(4, 8);
      final JaCoCoSensor s5 = new JaCoCoSensor(5, 9);
      JaCoCoModel model = new JaCoCoModel(s1, s2, s3, s4, s5);
      assertEquals(s1, model.getClazz());
      assertEquals(s2, model.getMethode());
      assertEquals(s3, model.getBranch());
      assertEquals(s4, model.getLine());
      assertEquals(s5, model.getInstruction());
   }

   @Test
   public void testToString() {
      JaCoCoModel model = new JaCoCoModel(null, null, null, null, null);
      assertNotNull(model.toString());
   }
}
