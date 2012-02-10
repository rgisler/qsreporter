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

/**
 * Datenmodell fuer JaCoCo-Summary.
 * @author Roland Gisler
 */
public final class JaCoCoSensor {

   private static final int PERCENT_100 = 100;

   private final int coverage;

   private final int missed;

   /**
    * Konstruktor.
    * @param pCoverage
    *           Abgedeckte Zeilen.
    * @param pMissed
    *           Nicht abgedeckte Zeilen.
    */
   public JaCoCoSensor(final int pCoverage, final int pMissed) {
      this.coverage = pCoverage;
      this.missed = pMissed;
   }

   /**
    * Getter fuer abgedeckte Zeilen.
    * @return Abgedeckte Zeilen.
    */
   public int getCoverage() {
      return this.coverage;
   }

   /**
    * Getter fuer nicht abgedeckte Zeilen.
    * @return Nicht abgedeckte Zeilen.
    */
   public int getMissed() {
      return this.missed;
   }

   /**
    * Getter fuer Anzahl Zeilen.
    * @return Anzahl Zeilen.
    */
   public int getTotal() {
      return this.coverage + this.missed;
   }

   /**
    * Getter fuer Abdeckung in Prozent.
    * @return Anzahl Zeilen.
    */
   public int getPercent() {
      int percent = 0;
      if (this.getTotal() > 0) {
         percent = (this.getCoverage() * PERCENT_100 / this.getTotal());
      }
      return percent;
   }

   /*
    * @see java.lang.Object#toString()
    */
   @Override
   public String toString() {
      return "Sensor[C:" + this.coverage + ",M:" + this.missed + ",T:" + this.getTotal() + ",P:"
            + this.getPercent() + "%]";
   }
}
