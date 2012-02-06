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
package ch.gitik.qsreporter.jacoco;

/**
 * Datenmodell fuer JaCoCo.
 * @author Roland Gisler
 */
public final class JaCoCoModel {

   private final JaCoCoSensor clazz;

   private final JaCoCoSensor methode;

   private final JaCoCoSensor branch;

   private final JaCoCoSensor line;

   private final JaCoCoSensor instruction;

   /**
    * Konstruktor.
    * @param pClass
    *           Klassen Coverage.
    * @param pMethode
    *           Methodene Coverage.
    * @param pBranch
    *           Branch Coverage.
    * @param pline
    *           Line Coverage.
    * @param pInstruction
    *           Statement Coverage.
    */
   public JaCoCoModel(final JaCoCoSensor pClass, final JaCoCoSensor pMethode, final JaCoCoSensor pBranch,
         final JaCoCoSensor pline, final JaCoCoSensor pInstruction) {
      this.clazz = pClass;
      this.methode = pMethode;
      this.branch = pBranch;
      this.line = pline;
      this.instruction = pInstruction;
   }

   /**
    * Getter fuer Class.
    * @return Liefert clazz.
    */
   public JaCoCoSensor getClazz() {
      return clazz;
   }

   /**
    * Getter fuer methode.
    * @return Liefert methode.
    */
   public JaCoCoSensor getMethode() {
      return methode;
   }

   /**
    * Getter fuer branch.
    * @return Liefert branch.
    */
   public JaCoCoSensor getBranch() {
      return branch;
   }

   /**
    * Getter fuer instruction.
    * @return Liefert instruction.
    */
   public JaCoCoSensor getInstruction() {
      return instruction;
   }

   /**
    * Getter fuer line.
    * @return Liefert line.
    */
   public JaCoCoSensor getLine() {
      return line;
   }

   /*
    * @see java.lang.Object#toString()
    */
   @Override
   public String toString() {
      final StringBuffer buffer = new StringBuffer(50);
      buffer.append("JaCoCoData[");
      buffer.append(this.clazz);
      buffer.append(", ");
      buffer.append(this.methode);
      buffer.append(", ");
      buffer.append(this.branch);
      buffer.append(", ");
      buffer.append(this.line);
      buffer.append(", ");
      buffer.append(this.instruction);
      buffer.append(']');
      return buffer.toString();
   }
}
