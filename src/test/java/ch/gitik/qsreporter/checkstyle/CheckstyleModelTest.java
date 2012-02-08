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
package ch.gitik.qsreporter.checkstyle;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Roland Gisler
 * @version $Revision$
 */
public class CheckstyleModelTest {

   @Test
   public void testCheckstyleModel() {
      CheckstyleModel model = new CheckstyleModel(null, null, null);
      assertNotNull(model);
   }

   @Test
   public void testGetter() {
      final CheckstyleSensor s1 = new CheckstyleSensor(1);
      final CheckstyleSensor s2 = new CheckstyleSensor(2);
      final CheckstyleSensor s3 = new CheckstyleSensor(3);
      CheckstyleModel model = new CheckstyleModel(s1, s2, s3);
      assertEquals(s1, model.getError());
      assertEquals(s2, model.getWarning());
      assertEquals(s3, model.getInfo());
   }

   @Test
   public void testToString() {
      CheckstyleModel model = new CheckstyleModel(null, null, null);
      assertNotNull(model.toString());
   }
}
