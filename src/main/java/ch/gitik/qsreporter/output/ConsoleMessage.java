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
 * 
 * @author Roland Gisler
 */
public class ConsoleMessage {

   /**
    * Erzeugt Checkstyle ServiceMessages fuer TeamCity.
    * @param data
    *           Checkstyle Daten.
    * @return String mit ServiceMessages.
    */
   public static String consoleCheckstyle(final CheckstyleModel data) {
      final StringBuffer message = new StringBuffer(BUFFER_SIZE);
      message.append("+----------------------------------------------------------------------+");
      message.append('\n');
      message.append("| Checkstyle: ");
      message.append(data.getError());
      message.append(" Error(s), ");
      message.append(data.getWarning());
      message.append(" Warning(s), ");
      message.append(data.getInfo());
      message.append(" Warning(s)");
      message.append('\n');
      message.append("+----------------------------------------------------------------------+");
      return message.toString();
   }

   /**
    * Erzeugt Classycle ServiceMessages fuer TeamCity.
    * @param data
    *           Classycle Daten.
    * @return String mit ServiceMessages.
    */
   public static String serviceMessagesClassycle(final ClassycleModel data) {
      final StringBuffer message = new StringBuffer(BUFFER_SIZE);
      message.append(new TeamcityServiceMessage("classycle.package", data.getPackage()));
      message.append('\n');
      message.append(new TeamcityServiceMessage("classycle.class", data.getClazz()));
      message.append('\n');
      message.append(new TeamcityServiceMessage("classycle.cycle", data.getCycle()));
      return message.toString();
   }

   /**
    * Erzeugt JaCoCo ServiceMessages fuer TeamCity.
    * @param data
    *           Coveragedaten.
    * @return String mit ServiceMessages.
    */
   public static String serviceMessagesJaCoCo(final JaCoCoModel data) {
      final StringBuffer message = new StringBuffer(BUFFER_SIZE);
      message.append(new TeamcityServiceMessage("coverage.class", data.getClazz().getPercent()));
      message.append('\n');
      message.append(new TeamcityServiceMessage("coverage.methode", data.getMethode().getPercent()));
      message.append('\n');
      message.append(new TeamcityServiceMessage("coverage.branch", data.getBranch().getPercent()));
      message.append('\n');
      message.append(new TeamcityServiceMessage("coverage.line", data.getLine().getPercent()));
      message.append('\n');
      message.append(new TeamcityServiceMessage("coverage.statement", data.getInstruction().getPercent()));
      return message.toString();
   }

   /**
    * Erzeugt PMD ServiceMessages fuer TeamCity.
    * @param data
    *           PMD-Daten.
    * @return String mit ServiceMessages.
    */
   public static String serviceMessagesPmd(final PmdModel data) {
      final StringBuffer message = new StringBuffer(BUFFER_SIZE);
      message.append(new TeamcityServiceMessage("pmd.level1", data.getLevel1().getCount()));
      message.append('\n');
      message.append(new TeamcityServiceMessage("pmd.level2", data.getLevel2().getCount()));
      message.append('\n');
      message.append(new TeamcityServiceMessage("pmd.level3", data.getLevel3().getCount()));
      message.append('\n');
      message.append(new TeamcityServiceMessage("pmd.level4", data.getLevel4().getCount()));
      message.append('\n');
      message.append(new TeamcityServiceMessage("pmd.level5", data.getLevel5().getCount()));
      return message.toString();
   }

   private static final int BUFFER_SIZE = 200;

}
