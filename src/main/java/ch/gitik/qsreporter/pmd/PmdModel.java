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

   private final PmdSensor level1;

   private final PmdSensor level2;

   private final PmdSensor level3;

   private final PmdSensor level4;

   private final PmdSensor level5;

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
   public PmdModel(final PmdSensor pLevel1, final PmdSensor pLevel2, final PmdSensor pLevel3, final PmdSensor pLevel4,
         final PmdSensor pLevel5) {
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
   public PmdSensor getLevel1() {
      return this.level1;
   }

   /**
    * Liefert Level 2 zurueck.
    * @return Anzahl Level 2.
    */
   public PmdSensor getLevel2() {
      return this.level2;
   }

   /**
    * Liefert Level 3 zurueck.
    * @return Anzahl Level 3.
    */
   public PmdSensor getLevel3() {
      return this.level3;
   }

   /**
    * Liefert Level 4 zurueck.
    * @return Anzahl Level 4.
    */
   public PmdSensor getLevel4() {
      return this.level4;
   }

   /**
    * Liefert Level 5 zurueck.
    * @return Anzahl Level 5.
    */
   public PmdSensor getLevel5() {
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
