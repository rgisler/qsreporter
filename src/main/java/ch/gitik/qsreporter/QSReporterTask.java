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

import ch.gitik.qsreporter.jacoco.JaCoCoModel;
import ch.gitik.qsreporter.teamcity.ServiceMessage;

/**
 * QSReporter Ant Task.
 * @author Roland Gisler
 */
public class QSReporterTask extends Task {

   private boolean verbose = false;

   private String jaCoCoXML = null;

   /**
    * Konstruktur.
    */
   public QSReporterTask() {
   }

   /*
    * @see org.apache.tools.ant.Task#execute()
    */
   @Override
   public void execute() {
      if (this.verbose) {
         System.out.println("QSReporterTask is alive...");
      }
      File xmlFile;
      if (this.jaCoCoXML != null) {
         xmlFile = new File(jaCoCoXML);
         if (xmlFile.exists()) {
            System.out.println("Using JaCoCo XML-Report: " + xmlFile.getName());
         }
         final QSDataExtractorJaCoCo extractor = new QSDataExtractorJaCoCo();
         final JaCoCoModel data = extractor.extract(xmlFile);

         serviceMessages(data);
      }
   }

   /**
    * Erzeugt ServiceMessages fuer TeamCity.
    * @param data
    *           Coveragedaten.
    */
   private void serviceMessages(final JaCoCoModel data) {
      ServiceMessage.buildStatistic("coverage.class", Integer.toString(data.getClazz().getPercent()));
      ServiceMessage.buildStatistic("coverage.methode", Integer.toString(data.getMethode().getPercent()));
      ServiceMessage.buildStatistic("coverage.branch", Integer.toString(data.getBranch().getPercent()));
      ServiceMessage.buildStatistic("coverage.line", Integer.toString(data.getLine().getPercent()));
      ServiceMessage.buildStatistic("coverage.statement", Integer.toString(data.getInstruction().getPercent()));
   }

   /**
    * Setzt jaCoCoXML.
    * @param jaCoCoXML
    *           Setzt jaCoCoXML.
    */
   public void setJaCoCoXML(String jaCoCoXML) {
      this.jaCoCoXML = jaCoCoXML;
   }

   /**
    * Setzt verbose.
    * @param verbose
    *           Setzt verbose.
    */
   public void setVerbose(boolean pVerbose) {
      this.verbose = pVerbose;
   }
}
