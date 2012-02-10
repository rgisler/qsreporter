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
package ch.gitik.qsreporter;

import java.io.File;

import org.apache.tools.ant.Task;

import ch.gitik.qsreporter.checkstyle.CheckstyleModel;
import ch.gitik.qsreporter.jacoco.JaCoCoModel;
import ch.gitik.qsreporter.pmd.PmdModel;
import ch.gitik.qsreporter.teamcity.ServiceMessage;

/**
 * QSReporter Ant Task.
 * @author Roland Gisler
 */
public class QSReporterTask extends Task {

   private boolean verbose = false;

   private String jaCoCoXML = null;

   private String checkstyleXML = null;

   private String pmdXML = null;

   /**
    * Konstruktur.
    */
   public QSReporterTask() {
   }

   /*
    * @see org.apache.tools.ant.Task#execute()
    */
   @Override
   public final void execute() {
      if (this.verbose) {
         System.out.println("QSReporterTask is alive...");
      }
      File xmlFile;

      if (this.jaCoCoXML != null) {
         xmlFile = new File(jaCoCoXML);
         if (xmlFile.exists()) {
            System.out.println("Evaluating JaCoCo XML-Report: " + xmlFile.getName());
         }
         final QSDataExtractorJaCoCo extractor = new QSDataExtractorJaCoCo();
         final JaCoCoModel data = extractor.extract(xmlFile);
         serviceMessagesJaCoCo(data);
      }

      if (this.checkstyleXML != null) {
         xmlFile = new File(checkstyleXML);
         if (xmlFile.exists()) {
            System.out.println("Evaluating Checkstyle XML-Report: " + xmlFile.getName());
         }
         final QSDataExtractorCheckstyle extractor = new QSDataExtractorCheckstyle();
         final CheckstyleModel data = extractor.extract(xmlFile);
         serviceMessagesCheckstyle(data);
      }

      if (this.pmdXML != null) {
         xmlFile = new File(pmdXML);
         if (xmlFile.exists()) {
            System.out.println("Evaluating PMD XML-Report: " + xmlFile.getName());
         }
         final QSDataExtractorPmd extractor = new QSDataExtractorPmd();
         final PmdModel data = extractor.extract(xmlFile);
         serviceMessagesPmd(data);
      }
   }

   /**
    * Erzeugt JaCoCo ServiceMessages fuer TeamCity.
    * @param data
    *           Coveragedaten.
    */
   private void serviceMessagesJaCoCo(final JaCoCoModel data) {
      ServiceMessage.buildStatistic("coverage.class", Integer.toString(data.getClazz().getPercent()));
      ServiceMessage.buildStatistic("coverage.methode", Integer.toString(data.getMethode().getPercent()));
      ServiceMessage.buildStatistic("coverage.branch", Integer.toString(data.getBranch().getPercent()));
      ServiceMessage.buildStatistic("coverage.line", Integer.toString(data.getLine().getPercent()));
      ServiceMessage.buildStatistic("coverage.statement", Integer.toString(data.getInstruction().getPercent()));
   }

   /**
    * Erzeugt Checkstyle ServiceMessages fuer TeamCity.
    * @param data
    *           Checkstyledaten.
    */
   private void serviceMessagesCheckstyle(final CheckstyleModel data) {
      ServiceMessage.buildStatistic("checkstyle.error", Integer.toString(data.getError().getCount()));
      ServiceMessage.buildStatistic("checkstyle.warning", Integer.toString(data.getWarning().getCount()));
      ServiceMessage.buildStatistic("checkstyle.info", Integer.toString(data.getInfo().getCount()));
   }

   /**
    * Erzeugt PMD ServiceMessages fuer TeamCity.
    * @param data
    *           PMD-Daten.
    */
   private void serviceMessagesPmd(final PmdModel data) {
      ServiceMessage.buildStatistic("pmd.level1", Integer.toString(data.getLevel1().getCount()));
      ServiceMessage.buildStatistic("pmd.level2", Integer.toString(data.getLevel2().getCount()));
      ServiceMessage.buildStatistic("pmd.level3", Integer.toString(data.getLevel3().getCount()));
      ServiceMessage.buildStatistic("pmd.level4", Integer.toString(data.getLevel4().getCount()));
      ServiceMessage.buildStatistic("pmd.level5", Integer.toString(data.getLevel5().getCount()));
   }

   /**
    * Setzt jaCoCoXML.
    * @param pJaCoCoXML
    *           Setzt jaCoCoXML.
    */
   public final void setJaCoCoXML(final String pJaCoCoXML) {
      this.jaCoCoXML = pJaCoCoXML;
   }

   /**
    * Setter fuer checkstyleXML.
    * @param checkstyleXML
    *           Setzt checkstyleXML.
    */
   public void setCheckstyleXML(String checkstyleXML) {
      this.checkstyleXML = checkstyleXML;
   }

   /**
    * Setter fuer pmdXML.
    * @param pmdXML
    *           Setzt pmdXML.
    */
   public void setPmdXML(String pmdXML) {
      this.pmdXML = pmdXML;
   }

   /**
    * Setzt verbose.
    * @param pVerbose
    *           Setzt verbose.
    */
   public final void setVerbose(final boolean pVerbose) {
      this.verbose = pVerbose;
   }
}
