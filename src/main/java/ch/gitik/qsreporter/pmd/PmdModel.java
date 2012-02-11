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

/**
 * Datenmodell fuer Checkstyle.
 * @author Roland Gisler
 */
public final class PmdModel {

   private final int level1;

   private final int level2;

   private final int level3;

   private final int level4;

   private final int level5;

   /**
    * Konstruktor.
    * @param pLevel1
    *           Anzahl Level 1.
    * @param pLevel2
    *           Anzahl Level 2.
    * @param pLevel3
    *           Anzahl Level 3.
    * @param pLevel4
    *           Anzahl Level 4.
    * @param pLevel5
    *           Anzahl Level 5.
    */
   public PmdModel(final int pLevel1, final int pLevel2, final int pLevel3, final int pLevel4,
         final int pLevel5) {
      this.level1 = pLevel1;
      this.level2 = pLevel2;
      this.level3 = pLevel3;
      this.level4 = pLevel4;
      this.level5 = pLevel5;
   }

   /**
    * Liefert Level 1 zurueck.
    * @return Anzahl Level 1.
    */
   public int getLevel1() {
      return this.level1;
   }

   /**
    * Liefert Level 2 zurueck.
    * @return Anzahl Level 2.
    */
   public int getLevel2() {
      return this.level2;
   }

   /**
    * Liefert Level 3 zurueck.
    * @return Anzahl Level 3.
    */
   public int getLevel3() {
      return this.level3;
   }

   /**
    * Liefert Level 4 zurueck.
    * @return Anzahl Level 4.
    */
   public int getLevel4() {
      return this.level4;
   }

   /**
    * Liefert Level 5 zurueck.
    * @return Anzahl Level 5.
    */
   public int getLevel5() {
      return this.level5;
   }

   /*
    * @see java.lang.Object#toString()
    */
   @Override
   public String toString() {
      final StringBuffer buffer = new StringBuffer(50);
      buffer.append("PMDData[");
      buffer.append(this.level1);
      buffer.append(',');
      buffer.append(this.level2);
      buffer.append(',');
      buffer.append(this.level3);
      buffer.append(',');
      buffer.append(this.level4);
      buffer.append(',');
      buffer.append(this.level5);
      buffer.append(']');
      return buffer.toString();
   }
}
