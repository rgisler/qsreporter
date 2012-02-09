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
package ch.gitik.qsreporter.pmd;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

/**
 * @author Roland Gisler
 * @version $Revision$
 */
public class PmdModelTest {

   @Test
   public void testPmdModel() {
      PmdModel model = new PmdModel(null, null, null, null, null);
      assertNotNull(model);
   }

   @Test
   public void testGetter() {
      final PmdSensor s1 = new PmdSensor(1);
      final PmdSensor s2 = new PmdSensor(2);
      final PmdSensor s3 = new PmdSensor(3);
      final PmdSensor s4 = new PmdSensor(4);
      final PmdSensor s5 = new PmdSensor(5);
      PmdModel model = new PmdModel(s1, s2, s3, s4, s5);
      assertEquals(s1, model.getLevel1());
      assertEquals(s2, model.getLevel2());
      assertEquals(s3, model.getLevel3());
      assertEquals(s4, model.getLevel4());
      assertEquals(s5, model.getLevel5());
   }

   @Test
   public void testToString() {
      PmdModel model = new PmdModel(null, null, null, null, null);
      assertNotNull(model.toString());
   }
}
