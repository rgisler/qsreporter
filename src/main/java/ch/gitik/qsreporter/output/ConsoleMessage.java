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
 * @author Roland Gisler
 */
public class ConsoleMessage {

   private static final int BUFFER_SIZE = 200;

   /**
    * Erzeugt Checkstyle ServiceMessages fuer TeamCity.
    * @param data
    *           Checkstyle Daten.
    * @return String mit ServiceMessages.
    */
   public static String checkstyleOut(final CheckstyleModel data) {
      final StringBuffer message = new StringBuffer(BUFFER_SIZE);
      message.append("+----------------------------------------------------------------------+\n");
      message.append("| Checkstyle: ");
      message.append(data.getError());
      message.append(" Error(s), ");
      message.append(data.getWarning());
      message.append(" Warning(s), ");
      message.append(data.getInfo());
      message.append(" Warning(s)\n");
      message.append("+----------------------------------------------------------------------+");
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
      message.append("+----------------------------------------------------------------------+\n");
      message.append("| Classycle: ");
      message.append(data.getPackage());
      message.append(" Package(s), ");
      message.append(data.getClazz());
      message.append(" Class(es), ");
      message.append(data.getCycle());
      message.append(" Cycle(s)\n");
      message.append("+----------------------------------------------------------------------+");
      return message.toString();
   }

   /**
    * Erzeugt JaCoCo ServiceMessages fuer TeamCity.
    * @param data
    *           Coveragedaten.
    * @return String mit ServiceMessages.
    */
   public static String jaCoCoOut(final JaCoCoModel data) {
      final StringBuffer message = new StringBuffer(BUFFER_SIZE);
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
      message.append("+----------------------------------------------------------------------+\n");
      message.append("| PMD: ");
      message.append(data.getLevel1());
      message.append(" Level 1, ");
      message.append(data.getLevel2());
      message.append(" Level 2, ");
      message.append(data.getLevel3());
      message.append(" Level 3, ");
      message.append(data.getLevel4());
      message.append(" Level 4, ");
      message.append(data.getLevel5());
      message.append(" Level 5\n");
      message.append("+----------------------------------------------------------------------+");
      return message.toString();
   }
}
