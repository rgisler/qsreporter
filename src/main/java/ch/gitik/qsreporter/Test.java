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

import ch.gitik.qsreporter.jacoco.JaCoCoModel;

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

      final File file = new File("cfg/testdata/coverage.xml");
      final QSDataExtractorJaCoCo extractor = new QSDataExtractorJaCoCo();
      final JaCoCoModel data = extractor.extract(file);
      System.out.println(data);
   }
   
   /**
    * Konstruktor.
    */
   private Test() {
   }
}