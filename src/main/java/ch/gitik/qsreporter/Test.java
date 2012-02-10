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
 */
package ch.gitik.qsreporter;

import java.io.File;

import ch.gitik.qsreporter.checkstyle.CheckstyleModel;
import ch.gitik.qsreporter.jacoco.JaCoCoModel;
import ch.gitik.qsreporter.pmd.PmdModel;

/**
 * Test-Klasse.
 * @author Roland Gisler
 */
public final class Test {

   /**
    * Main-Methode.
    * @param args
    *           Argumente.
    */
   public static void main(final String[] args) {

      File file; 
      file = new File("build/coverage/coverage.xml");
      final QSDataExtractorJaCoCo extractorJaCoCo = new QSDataExtractorJaCoCo();
      final JaCoCoModel data = extractorJaCoCo.extract(file);
      System.out.println(data);
      
      file = new File("build/checkstyle/checkstyle.xml");
      final QSDataExtractorCheckstyle extractorCheckstyle = new QSDataExtractorCheckstyle();
      final CheckstyleModel dataCheckstyle = extractorCheckstyle.extract(file);
      System.out.println(dataCheckstyle);

      file = new File("build/pmd/pmd.xml");
      final QSDataExtractorPmd extractorPmd = new QSDataExtractorPmd();
      final PmdModel dataPmd = extractorPmd.extract(file);
      System.out.println(dataPmd);
   }
   
   /**
    * Konstruktor.
    */
   private Test() {
   }
}
