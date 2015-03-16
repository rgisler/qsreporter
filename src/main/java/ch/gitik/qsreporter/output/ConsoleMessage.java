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
public final class ConsoleMessage {

   private static final String DEZ_FORMAT = "%.1f";

   private static final String HORIZBAR = "+------------+----------------------------------------------------------------------+\n";

   private static final int BUFFER_SIZE = 200;

   /**
    * Privater Konstruktor.
    */
   private ConsoleMessage() {
   }

   /**
    * Erzeugt Checkstyle ServiceMessages fuer TeamCity.
    * @param data Checkstyle Daten.
    * @return String mit ServiceMessages.
    */
   public static String checkstyleOut(final CheckstyleModel data) {
      final StringBuffer message = new StringBuffer(BUFFER_SIZE);
      message.append(HORIZBAR).append("| Checkstyle | Errors: ").append(data.getError()).append(" - Warnings: ")
            .append(data.getWarning()).append(" - Infos: ").append(data.getInfo()).append('\n').append(HORIZBAR);
      return message.toString();
   }

   /**
    * Erzeugt Classycle ServiceMessages fuer TeamCity.
    * @param data Classycle Daten.
    * @return String mit ServiceMessages.
    */
   public static String classycleOut(final ClassycleModel data) {
      final StringBuffer message = new StringBuffer(BUFFER_SIZE);
      message.append(HORIZBAR).append("| Classycle  | Packages: ").append(data.getPackage()).append(" - Classes: ")
            .append(data.getClazz()).append(" - Package Cycles: ").append(data.getPackageCycle())
            .append(" - Class Cycles: ").append(data.getClassCycle()).append('\n').append(HORIZBAR);
      return message.toString();
   }

   /**
    * Erzeugt JaCoCo ServiceMessages fuer TeamCity.
    * @param data Coveragedaten.
    * @return String mit ServiceMessages.
    */
   public static String jaCoCoOut(final JaCoCoModel data) {
      final StringBuffer message = new StringBuffer(BUFFER_SIZE);
      message.append(HORIZBAR).append("| Jacoco     | Statement: ")
            .append(String.format(DEZ_FORMAT, data.getInstruction().getPercent())).append("% - Branches: ")
            .append(String.format(DEZ_FORMAT, data.getBranch().getPercent())).append("% - Methods: ")
            .append(String.format(DEZ_FORMAT, data.getMethode().getPercent())).append("% - Classes: ")
            .append(String.format(DEZ_FORMAT, data.getClazz().getPercent())).append("%\n").append(HORIZBAR);
      return message.toString();
   }

   /**
    * Erzeugt PMD ServiceMessages fuer TeamCity.
    * @param data PMD-Daten.
    * @return String mit ServiceMessages.
    */
   public static String pmdOut(final PmdModel data) {
      final StringBuffer message = new StringBuffer(BUFFER_SIZE);
      message.append(HORIZBAR).append("| PMD        | Level1: ").append(data.getLevel1()).append(" - Level2: ")
            .append(data.getLevel2()).append(" - Level3: ").append(data.getLevel3()).append(" - Level4: ")
            .append(data.getLevel4()).append(" - Level5: ").append(data.getLevel5()).append('\n').append(HORIZBAR);
      return message.toString();
   }
}
