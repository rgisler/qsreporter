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
 *
 * $Id: AbstractBpmsTask.java 38 2007-02-12 12:50:46Z rog $
 */
package ch.gitik.qsreporter.output;

import ch.gitik.qsreporter.checkstyle.CheckstyleModel;
import ch.gitik.qsreporter.classycle.ClassycleModel;
import ch.gitik.qsreporter.jacoco.JaCoCoModel;
import ch.gitik.qsreporter.pmd.PmdModel;

/**
 * Erzeugt eine Servicemessage fuer TeamCity.
 * @author Roland Gisler
 */
public final class TeamcityOutput {

   private static final int BUFFER_SIZE = 200;

   /**
    * Hilfsklasse fuer ServiceMessage mit integer.
    */
   public static class ServiceMessageInt {

      private final String key;

      private final int intValue;

      /**
       * Erzeugt eine Servicemessage fuer TeamCity.
       * @param pKey Key.
       * @param pValue Wert als Integer.
       */
      public ServiceMessageInt(final String pKey, final int pValue) {
         if (pKey == null) {
            this.key = "unknown.key";
            this.intValue = 0;
         } else {
            this.key = pKey;
            this.intValue = pValue;
         }
      }

      /*
       * @see java.lang.Object#toString()
       */
      @Override
      public final String toString() {
         return "##teamcity[buildStatisticValue key='" + key + "' value='" + intValue + "']";
      }
   }

   /**
    * Hilfsklasse fuer ServiceMessage mit float.
    */
   public static class ServiceMessageFloat {

      private final String key;

      private final float floatValue;

      /**
       * Erzeugt eine Servicemessage fuer TeamCity.
       * @param pKey Key.
       * @param pValue Wert als Integer.
       */
      public ServiceMessageFloat(final String pKey, final float pValue) {
         if (pKey == null) {
            this.key = "unknown.key";
            this.floatValue = 0;
         } else {
            this.key = pKey;
            this.floatValue = pValue;
         }
      }

      /*
       * @see java.lang.Object#toString()
       */
      @Override
      public final String toString() {
         return "##teamcity[buildStatisticValue key='" + key + "' value='" + String.format("%.1f", this.floatValue)
               + "']";
      }
   }

   /**
    * Privater Konstruktor.
    */
   private TeamcityOutput() {
   }

   /**
    * Erzeugt Checkstyle ServiceMessages fuer TeamCity.
    * @param data Checkstyle Daten.
    * @return String mit ServiceMessages.
    */
   public static String checkstyleOut(final CheckstyleModel data) {
      final StringBuffer message = new StringBuffer(BUFFER_SIZE)
            .append(new ServiceMessageInt("checkstyle.error", data.getError())).append('\n')
            .append(new ServiceMessageInt("checkstyle.warning", data.getWarning())).append('\n')
            .append(new ServiceMessageInt("checkstyle.info", data.getInfo()));
      return message.toString();
   }

   /**
    * Erzeugt Classycle ServiceMessages fuer TeamCity.
    * @param data Classycle Daten.
    * @return String mit ServiceMessages.
    */
   public static String classycleOut(final ClassycleModel data) {
      final StringBuffer message = new StringBuffer(BUFFER_SIZE)
            .append(new ServiceMessageInt("classycle.package", data.getPackage())).append('\n')
            .append(new ServiceMessageInt("classycle.class", data.getClazz())).append('\n')
            .append(new ServiceMessageInt("classycle.packagecycle", data.getPackageCycle())).append('\n')
            .append(new ServiceMessageInt("classycle.classcycle", data.getClassCycle()));
      return message.toString();
   }

   /**
    * Erzeugt JaCoCo ServiceMessages fuer TeamCity.
    * @param data Coveragedaten.
    * @return String mit ServiceMessages.
    */
   public static String jacocoOut(final JaCoCoModel data) {
      final StringBuffer message = new StringBuffer(BUFFER_SIZE)
            .append(new ServiceMessageFloat("coverage.class", data.getClazz().getPercent())).append('\n')
            .append(new ServiceMessageFloat("coverage.methode", data.getMethode().getPercent())).append('\n')
            .append(new ServiceMessageFloat("coverage.branch", data.getBranch().getPercent())).append('\n')
            .append(new ServiceMessageFloat("coverage.line", data.getLine().getPercent())).append('\n')
            .append(new ServiceMessageFloat("coverage.statement", data.getInstruction().getPercent()));
      return message.toString();
   }

   /**
    * Erzeugt PMD ServiceMessages fuer TeamCity.
    * @param data PMD-Daten.
    * @return String mit ServiceMessages.
    */
   public static String pmdOut(final PmdModel data) {
      final StringBuffer message = new StringBuffer(BUFFER_SIZE)
            .append(new ServiceMessageInt("pmd.level1", data.getLevel1())).append('\n')
            .append(new ServiceMessageInt("pmd.level2", data.getLevel2())).append('\n')
            .append(new ServiceMessageInt("pmd.level3", data.getLevel3())).append('\n')
            .append(new ServiceMessageInt("pmd.level4", data.getLevel4())).append('\n')
            .append(new ServiceMessageInt("pmd.level5", data.getLevel5()));
      return message.toString();
   }
}
