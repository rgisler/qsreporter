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
import ch.gitik.qsreporter.classycle.ClassycleModel;
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

   private String classycleXML = null;

   private String pmdXML = null;

   /*
    * @see org.apache.tools.ant.Task#execute()
    */
   @Override
   public final void execute() {
      if (this.verbose) {
         log("QSReporterTask is alive...");
      }
      this.processJaCoCoData();
      this.processCheckstyleData();
      this.processClassycleData();
      this.processPmdData();
   }

   /**
    * Extrahiert PMD Daten.
    */
   private void processPmdData() {
      if (this.pmdXML != null) {
         final File xmlFile = new File(pmdXML);
         if (xmlFile.exists()) {
            log("Evaluating PMD XML-Report: " + xmlFile.getName());
         }
         final QSDataExtractorPmd extractor = new QSDataExtractorPmd();
         final PmdModel data = extractor.extract(xmlFile);
         log(ServiceMessage.serviceMessagesPmd(data));
      }
   }

   /**
    * Extrahiert Checkstyle Daten.
    */
   private void processCheckstyleData() {
      if (this.checkstyleXML != null) {
         final File xmlFile = new File(this.checkstyleXML);
         if (xmlFile.exists()) {
            log("Evaluating Checkstyle XML-Report: " + xmlFile.getName());
         }
         final QSDataExtractorCheckstyle extractor = new QSDataExtractorCheckstyle();
         final CheckstyleModel data = extractor.extract(xmlFile);
         log(ServiceMessage.serviceMessagesCheckstyle(data));
      }
   }

   /**
    * Extrahiert Classycle Daten.
    */
   private void processClassycleData() {
      if (this.classycleXML != null) {
         final File xmlFile = new File(this.classycleXML);
         if (xmlFile.exists()) {
            log("Evaluating Classycle XML-Report: " + xmlFile.getName());
         }
         final QSDataExtractorClassycle extractor = new QSDataExtractorClassycle();
         final ClassycleModel data = extractor.extract(xmlFile);
         log(ServiceMessage.serviceMessagesClassycle(data));
      }
   }

   /**
    * Extrahiert JaCoCo Daten.
    */
   private void processJaCoCoData() {
      if (this.jaCoCoXML != null) {
         final File xmlFile = new File(this.jaCoCoXML);
         if (xmlFile.exists()) {
            log("Evaluating JaCoCo XML-Report: " + xmlFile.getName());
         }
         final QSDataExtractorJaCoCo extractor = new QSDataExtractorJaCoCo();
         final JaCoCoModel data = extractor.extract(xmlFile);
         log(ServiceMessage.serviceMessagesJaCoCo(data));
      }
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
    * @param pCheckstyleXML
    *           Setzt checkstyleXML.
    */
   public final void setCheckstyleXML(final String pCheckstyleXML) {
      this.checkstyleXML = pCheckstyleXML;
   }

   /**
    * Setter fuer classycleXML.
    * @param pClassycleXML
    *           Setzt classycleXML.
    */
   public final void setClassycleXML(final String pClassycleXML) {
      this.classycleXML = pClassycleXML;
   }

   /**
    * Setter fuer pmdXML.
    * @param pPmdXML
    *           Setzt pmdXML.
    */
   public final void setPmdXML(final String pPmdXML) {
      this.pmdXML = pPmdXML;
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
