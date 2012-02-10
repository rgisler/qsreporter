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

   final private String key;

   final private int value;

   /**
    * Erzeugt eine Servicemessage fuer TeamCity.
    * @param pKey
    *           Key.
    * @param pValue
    *           Wert als Integer.
    */
   public ServiceMessage(final String pKey, final int pValue) {
      if (pKey != null) {
         this.key = pKey;
         this.value = pValue;
      } else {
         this.key = "unknown.key";
         this.value = 0;
      }
   }

   /**
    * @see java.lang.Object#toString()
    */
   @Override
   public String toString() {
      return "##teamcity[buildStatisticValue key='" + key + "' value='" + value + "']";
   }

   /**
    * Erzeugt Checkstyle ServiceMessages fuer TeamCity.
    * @param data
    *           Checkstyle Daten.
    * @return String mit ServiceMessages.
    */
   public static String serviceMessagesCheckstyle(final CheckstyleModel data) {
      StringBuffer message = new StringBuffer(200);
      message.append(new ServiceMessage("checkstyle.error", data.getError().getCount()));
      message.append('\n');
      message.append(new ServiceMessage("checkstyle.warning", data.getWarning().getCount()));
      message.append('\n');
      message.append(new ServiceMessage("checkstyle.info", data.getInfo().getCount()));
      return message.toString();
   }

   /**
    * Erzeugt JaCoCo ServiceMessages fuer TeamCity.
    * @param data
    *           Coveragedaten.
    * @return String mit ServiceMessages.
    */
   public static String serviceMessagesJaCoCo(final JaCoCoModel data) {
      StringBuffer message = new StringBuffer(200);
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
   public static String serviceMessagesPmd(final PmdModel data) {
      StringBuffer message = new StringBuffer(200);
      message.append(new ServiceMessage("pmd.level1", data.getLevel1().getCount()));
      message.append('\n');
      message.append(new ServiceMessage("pmd.level2", data.getLevel2().getCount()));
      message.append('\n');
      message.append(new ServiceMessage("pmd.level3", data.getLevel3().getCount()));
      message.append('\n');
      message.append(new ServiceMessage("pmd.level4", data.getLevel4().getCount()));
      message.append('\n');
      message.append(new ServiceMessage("pmd.level5", data.getLevel5().getCount()));
      return message.toString();
   }
}
