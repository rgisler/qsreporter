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

/**
 * Datenmodell fuer Checkstyle.
 * @author Roland Gisler
 */
public final class CheckstyleModel {

   private final int error;

   private final int warning;

   private final int info;

   /**
    * Konstruktor.
    * @param pError Anzahl Errors.
    * @param pWarning Anzahl Warnings.
    * @param pInfo Anzahl Infos.
    */
   public CheckstyleModel(final int pError, final int pWarning, final int pInfo) {
      this.error = pError;
      this.warning = pWarning;
      this.info = pInfo;
   }

   /**
    * Liefert error zurück.
    * @return error Error-Sensor.
    */
   public int getError() {
      return this.error;
   }

   /**
    * Liefert warning zurück.
    * @return warning Warnings-Sensor.
    */
   public int getWarning() {
      return this.warning;
   }

   /**
    * Liefert info zurück.
    * @return info Info-Sensor.
    */
   public int getInfo() {
      return this.info;
   }

   /*
    * @see java.lang.Object#toString()
    */
   @Override
   public String toString() {
      final StringBuffer buffer = new StringBuffer(50).append("CheckstyleData[").append(this.error).append(',')
            .append(this.warning).append(',').append(this.info).append(']');
      return buffer.toString();
   }
}
