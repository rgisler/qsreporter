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
package ch.gitik.qsreporter.teamcity;

import ch.gitik.qsreporter.checkstyle.CheckstyleModel;
import ch.gitik.qsreporter.jacoco.JaCoCoModel;
import ch.gitik.qsreporter.pmd.PmdModel;

/**
 * Erzeugt eine Servicemessage fuer TeamCity.
 * @author Roland Gisler
 */
public final class ServiceMessage {

   /**
    * Erzeugt eine Servicemessage fuer TeamCity.
    * @param key
    *           Key.
    * @param value
    *           Wert.
    */
   public static void buildStatistic(final String key, final String value) {
      if ((key == null) || (value == null)) {
         return;
      }
      System.out.println("##teamcity[buildStatisticValue key='" + key + "' value='" + value + "']");
   }

   /**
    * Konstruktor.
    */
   private ServiceMessage() {
   }

   /**
    * Erzeugt Checkstyle ServiceMessages fuer TeamCity.
    * @param data
    *           Checkstyledaten.
    */
   public static void serviceMessagesCheckstyle(final CheckstyleModel data) {
      ServiceMessage.buildStatistic("checkstyle.error", Integer.toString(data.getError().getCount()));
      ServiceMessage.buildStatistic("checkstyle.warning", Integer.toString(data.getWarning().getCount()));
      ServiceMessage.buildStatistic("checkstyle.info", Integer.toString(data.getInfo().getCount()));
   }

   /**
    * Erzeugt JaCoCo ServiceMessages fuer TeamCity.
    * @param data
    *           Coveragedaten.
    */
   public static void serviceMessagesJaCoCo(final JaCoCoModel data) {
      ServiceMessage.buildStatistic("coverage.class", Integer.toString(data.getClazz().getPercent()));
      ServiceMessage.buildStatistic("coverage.methode", Integer.toString(data.getMethode().getPercent()));
      ServiceMessage.buildStatistic("coverage.branch", Integer.toString(data.getBranch().getPercent()));
      ServiceMessage.buildStatistic("coverage.line", Integer.toString(data.getLine().getPercent()));
      ServiceMessage.buildStatistic("coverage.statement",
            Integer.toString(data.getInstruction().getPercent()));
   }

   /**
    * Erzeugt PMD ServiceMessages fuer TeamCity.
    * @param data
    *           PMD-Daten.
    */
   public static void serviceMessagesPmd(final PmdModel data) {
      ServiceMessage.buildStatistic("pmd.level1", Integer.toString(data.getLevel1().getCount()));
      ServiceMessage.buildStatistic("pmd.level2", Integer.toString(data.getLevel2().getCount()));
      ServiceMessage.buildStatistic("pmd.level3", Integer.toString(data.getLevel3().getCount()));
      ServiceMessage.buildStatistic("pmd.level4", Integer.toString(data.getLevel4().getCount()));
      ServiceMessage.buildStatistic("pmd.level5", Integer.toString(data.getLevel5().getCount()));
   }
}
