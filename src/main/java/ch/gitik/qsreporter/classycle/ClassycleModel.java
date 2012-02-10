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

/**
 * Datenmodell fuer Checkstyle.
 * @author Roland Gisler
 */
public final class ClassycleModel {

   private final int packageCount;

   private final int classCount;

   private final int cylcleCount;

   /**
    * Konstruktor.
    * @param pPackage
    *           Anzahl Packages.
    * @param pClass
    *           Anzahl Klassen.
    * @param pCycle
    *           Anzahl Cycles.
    */
   public ClassycleModel(final int pPackage, final int pClass,
         final int pCycle) {
      this.packageCount = pPackage;
      this.classCount = pClass;
      this.cylcleCount = pCycle;
   }

   /**
    * Liefert Anzahl Packages zurueck.
    * @return Anzahl Packages.
    */
   public int getPackage() {
      return this.packageCount;
   }

   /**
    * Liefert Anzahl Klassen zurueck.
    * @return Anzahl Klassen.
    */
   public int getClazz() {
      return this.classCount;
   }

   /**
    * Liefert Anzahl Cylcles zurueck.
    * @return Anzahl Cylcles.
    */
   public int getCycle() {
      return this.cylcleCount;
   }

   /*
    * @see java.lang.Object#toString()
    */
   @Override
   public String toString() {
      final StringBuffer buffer = new StringBuffer(50);
      buffer.append("ClassycleData[");
      buffer.append(this.packageCount);
      buffer.append(',');
      buffer.append(this.classCount);
      buffer.append(',');
      buffer.append(this.cylcleCount);
      buffer.append(']');
      return buffer.toString();
   }
}
