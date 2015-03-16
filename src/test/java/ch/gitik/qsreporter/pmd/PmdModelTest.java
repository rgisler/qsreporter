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
package ch.gitik.qsreporter.pmd;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * Testfälle für {@link PmdModel}.
 */
public final class PmdModelTest {

   /**
    * Testfall für {@link PmdModel#PmdModel(int, int, int, int, int)}.
    */
   @Test
   public void testPmdModel() {
      final PmdModel model = new PmdModel(0, 0, 0, 0, 0);
      assertNotNull(model);
   }

   /**
    * Testfall für {@link PmdModel#getLevel1()}.
    */
   @Test
   public void testGetterLevel1() {
      final PmdModel model = new PmdModel(11, 22, 33, 44, 55);
      assertThat(model.getLevel1(), equalTo(11));
   }

   /**
    * Testfall für {@link PmdModel#getLevel2()}.
    */
   @Test
   public void testGetterLevel2() {
      final PmdModel model = new PmdModel(11, 22, 33, 44, 55);
      assertThat(model.getLevel2(), equalTo(22));
   }

   /**
    * Testfall für {@link PmdModel#getLevel3()}.
    */
   @Test
   public void testGetterLevel3() {
      final PmdModel model = new PmdModel(11, 22, 33, 44, 55);
      assertThat(model.getLevel3(), equalTo(33));
   }

   /**
    * Testfall für {@link PmdModel#getLevel4()}.
    */
   @Test
   public void testGetterLevel4() {
      final PmdModel model = new PmdModel(11, 22, 33, 44, 55);
      assertThat(model.getLevel4(), equalTo(44));
   }

   /**
    * Testfall für {@link PmdModel#getLevel5()}.
    */
   @Test
   public void testGetterLevel5() {
      final PmdModel model = new PmdModel(11, 22, 33, 44, 55);
      assertThat(model.getLevel5(), equalTo(55));
   }

   /**
    * Testfall für {@link PmdModel#toString()}.
    */
   @Test
   public void testToString() {
      final PmdModel model = new PmdModel(1, 1, 1, 1, 1);
      assertNotNull(model.toString());
   }
}
