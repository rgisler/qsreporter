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
package ch.gitik.qsreporter.classycle;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

/**
 * Testfälle für {@link ClassycleModel}.
 */
public final class ClassycleModelTest {

   /**
    * Testfall für {@link ClassycleModel#ClassycleModel(int, int, int, int)}.
    */
   @Test
   public void testClassycleModel() {
      final ClassycleModel model = new ClassycleModel(0, 0, 0, 0);
      assertNotNull(model);
   }

   /**
    * Testfall für {@link ClassycleModel}.
    */
   @Test
   public void testGetter() {
      final ClassycleModel model = new ClassycleModel(24, 25, 26, 27);
      assertEquals(24, model.getPackage());
      assertEquals(25, model.getClazz());
      assertEquals(26, model.getPackageCycle());
      assertEquals(27, model.getClassCycle());
   }

   /**
    * Testfall für {@link ClassycleModel#toString()}.
    */
   @Test
   public void testToString() {
      final ClassycleModel model = new ClassycleModel(0, 0, 0, 0);
      assertNotNull(model.toString());
   }
}
