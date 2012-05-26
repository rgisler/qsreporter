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
    * Hilfsklasse fuer ServiceMessage.
    */
   private static class ServiceMessage {

      private final String key;

      private final int value;

      /**
       * Erzeugt eine Servicemessage fuer TeamCity.
       * @param pKey
       *           Key.
       * @param pValue
       *           Wert als Integer.
       */
      public ServiceMessage(final String pKey, final int pValue) {
         if (pKey == null) {
            this.key = "unknown.key";
            this.value = 0;
         } else {
            this.key = pKey;
            this.value = pValue;
         }
      }

      /*
       * @see java.lang.Object#toString()
       */
      @Override
      public String toString() {
         return "##teamcity[buildStatisticValue key='" + key + "' value='" + value + "']";
      }
   }

   /**
    * Privater Konstruktor.
    */
   private TeamcityOutput() {
   }

   /**
    * Erzeugt Checkstyle ServiceMessages fuer TeamCity.
    * @param data
    *           Checkstyle Daten.
    * @return String mit ServiceMessages.
    */
   public static String checkstyleOut(final CheckstyleModel data) {
      final StringBuffer message = new StringBuffer(BUFFER_SIZE);
      message.append(new ServiceMessage("checkstyle.error", data.getError()));
      message.append('\n');
      message.append(new ServiceMessage("checkstyle.warning", data.getWarning()));
      message.append('\n');
      message.append(new ServiceMessage("checkstyle.info", data.getInfo()));
      return message.toString();
   }

   /**
    * Erzeugt Classycle ServiceMessages fuer TeamCity.
    * @param data
    *           Classycle Daten.
    * @return String mit ServiceMessages.
    */
   public static String classycleOut(final ClassycleModel data) {
      final StringBuffer message = new StringBuffer(BUFFER_SIZE);
      message.append(new ServiceMessage("classycle.package", data.getPackage()));
      message.append('\n');
      message.append(new ServiceMessage("classycle.class", data.getClazz()));
      message.append('\n');
      message.append(new ServiceMessage("classycle.packagecycle", data.getPackageCycle()));
      message.append('\n');
      message.append(new ServiceMessage("classycle.classcycle", data.getClassCycle()));
      return message.toString();
   }

   /**
    * Erzeugt JaCoCo ServiceMessages fuer TeamCity.
    * @param data
    *           Coveragedaten.
    * @return String mit ServiceMessages.
    */
   public static String jacocoOut(final JaCoCoModel data) {
      final StringBuffer message = new StringBuffer(BUFFER_SIZE);
      message.append(new ServiceMessage("coverage.class", data.getClazz().getPercent()));
      message.append('\n');
      message.append(new ServiceMessage("coverage.methode", data.getMethode().getPercent()));
      message.append('\n');
      message.append(new ServiceMessage("coverage.branch", data.getBranch().getPercent()));
      message.append('\n');
      message.append(new ServiceMessage("coverage.line", data.getLine().getPercent()));
      message.append('\n');
      message.append(new ServiceMessage("coverage.statement", data.getInstruction().getPercent()));
      return message.toString();
   }

   /**
    * Erzeugt PMD ServiceMessages fuer TeamCity.
    * @param data
    *           PMD-Daten.
    * @return String mit ServiceMessages.
    */
   public static String pmdOut(final PmdModel data) {
      final StringBuffer message = new StringBuffer(BUFFER_SIZE);
      message.append(new ServiceMessage("pmd.level1", data.getLevel1()));
      message.append('\n');
      message.append(new ServiceMessage("pmd.level2", data.getLevel2()));
      message.append('\n');
      message.append(new ServiceMessage("pmd.level3", data.getLevel3()));
      message.append('\n');
      message.append(new ServiceMessage("pmd.level4", data.getLevel4()));
      message.append('\n');
      message.append(new ServiceMessage("pmd.level5", data.getLevel5()));
      return message.toString();
   }
}
