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
 * @author Roland Gisler
 * @version $Revision$
 */
public class ClassycleModelTest {

   @Test
   public void testClassycleModel() {
      ClassycleModel model = new ClassycleModel(null, null, null);
      assertNotNull(model);
   }

   @Test
   public void testGetter() {
      final ClassycleSensor s1 = new ClassycleSensor(1);
      final ClassycleSensor s2 = new ClassycleSensor(2);
      final ClassycleSensor s3 = new ClassycleSensor(3);
      ClassycleModel model = new ClassycleModel(s1, s2, s3);
      assertEquals(s1, model.getPackage());
      assertEquals(s2, model.getClazz());
      assertEquals(s3, model.getCycle());
   }

   @Test
   public void testToString() {
      ClassycleModel model = new ClassycleModel(null, null, null);
      assertNotNull(model.toString());
   }
}
